/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

//Os imports de pacotes necessário para a classe funcionar
import Db.ConnectionDb;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Motorista;
import org.bson.Document;
import telas.CadastroMotorista;

public class MotoristaService {
    private  CadastroMotorista view;

    public MotoristaService(CadastroMotorista view){
        this.view = view;
    }
        
    public void AtualizarMotorista(Motorista motorista){
        
    }
    
    public boolean CadastrarMotorista(){
        //Conversão de Data, modelo antigo do java, para LocalDate, forma mais atual de trabalhar com esse tipo de dado.    
        Date date = view.getDataVencimento().getDate();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        //Instanciando um novo motorista e preenchendo seus atributos conforme a view  
        Motorista motorista = new Motorista();
        motorista.setNome(view.getNome().getText());
        motorista.setEmail(view.getEmail().getText());
        motorista.setQuantidadeViagens(0);
        motorista.setNumeroCarteira(view.getNumeroCarteira().getText());
        motorista.setTipoCnh(view.getTipoCnh().getText());
        motorista.setSenha(String.valueOf(view.getSenha().getPassword()));
        motorista.setDataVencimentoCarteira(localDate);
        motorista.setNumeroRegistro(view.getNumeroRegistro().getText());
       if(validarAutorizacao(localDate)){
            motorista.setAutorizacaoReserva(view.getAutorizado().isSelected());
       }else{
           JOptionPane.showMessageDialog(view, "Carteira Vencida, o motorista não pode realizar reservas!");
          motorista.setAutorizacaoReserva(false); 
       }
        if (validarCampos(motorista)) {
            ConnectionDb db = new ConnectionDb();
            Document userMotorista = new Document(motorista.toMap());
           try {
            db.Conexao("mongodb://localhost:27017", "DesafioProfissional", "motoristas");
            db.Insert(userMotorista);
           JOptionPane.showMessageDialog(view, "Motorista cadastrado com sucesso!");
           return true;
           }catch(Exception e){
            JOptionPane.showMessageDialog(view, "Erro ao conectar ou inserir no banco: " + e.getMessage());
           }
            db.Close();           
            return false;
        }else{
            JOptionPane.showMessageDialog(view, "Email inválido ou Número Carteira inválido ou senhas não correspondem!");             
            return false;
        }
    }
    //Função para validar todos os campos para cadastrar um novo motorista; Ele também será um usuário e utilizará a mesma tela de login.
    private boolean validarCampos(Motorista motorista) {
        return validarNumerosCnh(motorista.getNumeroCarteira()) && validarEmail(motorista.getEmail()) && Arrays.equals(view.getSenha().getPassword(), view.getConfirmaSenha().getPassword());
    }
    
    private boolean validarEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
    //Caso a data de vencimento da Carteira não seja maior que a data atual, ele não estará autorizado a fazer reservas de veículos até a atualização da data,
    public boolean validarAutorizacao(LocalDate vencimentoCarteira){
        LocalDate hoje = LocalDate.now();
        return vencimentoCarteira.isAfter(hoje);
    }
    
    private boolean validarNumerosCnh(String numeroCarteira){
        for(char c : numeroCarteira.toCharArray()){
            if(!Character.isDigit(c)){
            return false;
            }
        }
        return true;
    }
}
