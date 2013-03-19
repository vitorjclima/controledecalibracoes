package br.com.vitorjclima.controledeintervencoes.view;

public class MainView extends javax.swing.JFrame {

    private CadastroEmpresaView empresa;
    private static CadastroEquipamentoView equipamento = new CadastroEquipamentoView();
    CondicaoView condicao;
    IntervencaoView intervencao;
    PessoaView pessoa;
    Principal principal;
    
    public static void teste(){
        
                 java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                equipamento.setVisible(true);
            }
        });
       
    }

    public static void main(String[] args) {
        

        teste();
      
    }
}