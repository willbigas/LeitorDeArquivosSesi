
import javax.swing.JOptionPane;
import leitorderelatoriosesi.ControlArquivo;
import uteis.InterfaceJanela;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class Principal {
    
    public static void main(String[] args) {
        try {
            InterfaceJanela.MudaSwingParaPadraoDoSO();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Erro ao mudar para a interface padrão do sistema operacional , Entre em contato com o desenvolvedor");
        }
        ControlArquivo controlArquivo  = new ControlArquivo();
    }
    
}
