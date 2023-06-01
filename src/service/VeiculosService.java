

package service;

import Db.ConnectionDb;
import javax.swing.JOptionPane;
import model.Veiculos;
import org.bson.Document;
import telas.CadastroVeiculo;

/**
 *
 * @author julio
 */
public class VeiculosService {
    
    private final CadastroVeiculo view;
    
    public VeiculosService(CadastroVeiculo view){
        this.view = view;
    }
    
    
    public boolean CadastroVeiculo(){
        Veiculos veiculo = new Veiculos();
        veiculo.setAnoVeiculo(Integer.parseInt(view.getAnoVeiculo().getText()));
        veiculo.setChassi(view.getChassi().getText());
        veiculo.setCor(view.getCor().getText());
        veiculo.setModelo(view.getModelo().getText());
        veiculo.setPlaca(view.getPlaca().getText());
        veiculo.setQuilometragem(Integer.parseInt(view.getQuilometragem().getText()));
        veiculo.setRenavam(view.getRenavam().getText());
        veiculo.setReservado(false);
        
        if(ValidarCampos(veiculo)){
            ConnectionDb db = new ConnectionDb();
            Document document = new Document(veiculo.toMap());
           try {
           
            db.Conexao("mongodb://localhost:27017", "DesafioProfissional", "veiculos");
            db.Insert(document);
           JOptionPane.showMessageDialog(view, "Veiculo cadastrado com Sucesso");
           return true;
           }catch(Exception e){
            JOptionPane.showMessageDialog(view, "Erro ao conectar ou inserir no banco: " + e.getMessage());
           }
            db.Close();           
            return false;
        }else{
            JOptionPane.showMessageDialog(view,"Favor verificar os campos preenchidos: placa e/ou chassi com qunatidade de números inválidos e/ou quilometragem negativa");
            return false;
        }
    }
    public boolean ValidarCampos(Veiculos veiculo){
            if(veiculo.getQuilometragem()>0 && veiculo.getChassi().length()==17 && veiculo.getPlaca().length()==7){
                return true;
            }
            else{
                return false;            
        }
    }
}
