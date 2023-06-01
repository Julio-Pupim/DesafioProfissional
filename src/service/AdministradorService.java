package service;

import Db.ConnectionDb;

import model.Administrador;
import javax.swing.JOptionPane;
import java.util.Arrays;
import org.bson.Document;
import telas.CadastroAdmin;

public class AdministradorService {
        private final CadastroAdmin view;
    public AdministradorService(CadastroAdmin view){
        this.view = view;
    }
    public boolean CadastrarAdmin (){
        Administrador admin = new Administrador();
        admin.setNome(view.getNome().getText());
        admin.setEmail(view.getEmail().getText());
        admin.setSenha(String.valueOf(view.getSenha().getPassword()));
        admin.setNumeroRegistro(view.getNumeroRegistro().getText());
        admin.setSexo(view.getMasculino().isSelected() ? "masculino" : "feminino");
         if (validarCampos(admin)) {
            ConnectionDb db = new ConnectionDb();
            Document userAdmin = new Document(admin.toMap());
           try {
            db.Conexao("mongodb://localhost:27017", "DesafioProfissional", "administradores");
            db.Insert(userAdmin);
            JOptionPane.showMessageDialog(view, "Usuário cadastrado com sucesso!");
            return true;
           }catch(Exception e){
            JOptionPane.showMessageDialog(view, "Erro ao conectar ou inserir no banco: " + e.getMessage());
           }
            db.Close();
            return false;
         }else{
            JOptionPane.showMessageDialog(view, "Email inválido ou senhas não correspondem!");      
            return false;
         }
         
    }
    public void limparCampos() {
        view.getNome().setText("");
        view.getEmail().setText("");
        view.getSenha().setText("");
        view.getConfirmaSenha().setText("");
        view.getNumeroRegistro().setText("");
        view.getSexo().clearSelection();
    }
    
    private boolean validarCampos(Administrador admin) {
        return validarEmail(admin.getEmail()) && Arrays.equals(view.getSenha().getPassword(), view.getConfirmaSenha().getPassword());
    }

    private boolean validarEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

}
    
