/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desafio.profissional;


import javax.swing.SwingUtilities;
import telas.CadastroAdmin;
import telas.Login;
/**
 *
 * @author julio
 */
public class DesafioProfissional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login login = new Login();
                login.setVisible(true);
            }
        });
    }
    
}
