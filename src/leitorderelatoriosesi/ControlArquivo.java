package leitorderelatoriosesi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import uteis.Arquivo;
import view.TelaPrincipal;

/**
 *
 * @author William
 */
public class ControlArquivo {

    TelaPrincipal telaPrincipal;

    public static String enderecoOrigem = "";
    public static String enderecoDestino = "";

    public ControlArquivo() {
        telaPrincipal = new TelaPrincipal(this);
        telaPrincipal.setLocationRelativeTo(null);
        telaPrincipal.setVisible(true);
    }

    public void executaProcesso() {

        List<String> linhas = null;
        String linhaSemTracoEEspaços;
        List<String> novasLinhas = new ArrayList<>();

        try {
            linhas = Arquivo.lerArqArrayList(enderecoOrigem);
        } catch (Exception exception) {
        }
        for (String linha : linhas) {
            String linhasemTraco = linha.replaceAll("-", ";");
            System.out.println(linhasemTraco);
            novasLinhas.add(linhasemTraco.replace("   ", ";").replace(";;", ";").replace(";;", ";").replace(";;", ";").replace(";;", ";"));

        }
        for (String novasLinha : novasLinhas) {
            System.out.println(novasLinha);
        }
        
        
        try {
            for (String novasLinha : novasLinhas) {
                Arquivo.escreverArqConcat(enderecoDestino + ".csv", novasLinha);
            }
            JOptionPane.showMessageDialog(null, "Conversão executada com sucesso!");

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Erro na converão , chame o desenvolvedor!");
        }
    }

    public void acionaAberturaDeArquivo() {
        /**
         * Janela de Abrir - JFileChooser - Para abrir arquivos em geral.
         */

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Arquivo txt - Documentos de Texto", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(telaPrincipal);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String nomeArquivo = chooser.getSelectedFile().getName();
            enderecoOrigem = chooser.getSelectedFile().getPath();
            System.out.println("Endereco de Arquivo Origem : " + enderecoOrigem);
        }
    }

    public void acionaSalvamentoDeArquivo() {
        /**
         * Janela de Salvar - JFileChooser - Para salvar arquivos em geral.
         */

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Arquivo Csv - Excel 2007 ou Inferior", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(telaPrincipal);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String nomeArquivo = chooser.getSelectedFile().getName();
            enderecoDestino = chooser.getSelectedFile().getPath();
            System.out.println("EnderecoArquivo de Destino :" + enderecoDestino);
        }

    }
}
