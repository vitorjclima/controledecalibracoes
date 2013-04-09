package br.com.vitorjclima.controledeintervencoes.view;

import br.com.vitorjclima.controledeintervencoes.db.BD;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author vitor
 */
public class Principal extends javax.swing.JFrame {

    private CadastroEmpresaView empresa = new CadastroEmpresaView();
    private CadastroEquipamentoView equipamento = new CadastroEquipamentoView();
    private CondicaoView condicao = new CondicaoView();
    private IntervencaoView intervencao = new IntervencaoView();
    private PessoaView pessoa = new PessoaView(this);
    FileWriter backup;
    private BD bd;

    public BD getBd() {
        return bd;
    }

    public void setBd(BD bd) {
        this.bd = bd;
    }

    public Principal() {
        this.bd = new BD();
        initComponents();
    }

    public String diretorio() {
        JFileChooser chooser = new JFileChooser();

        String caminho = "";
        int retorno = chooser.showSaveDialog(null); // showSaveDialog retorna um inteiro , e ele ira determinar que o chooser será para salvar.
        if (retorno == JFileChooser.APPROVE_OPTION) {
            return caminho = chooser.getSelectedFile().getAbsolutePath();  // o getSelectedFile pega o backup e o getAbsolutePath retorna uma string contendo o endereço.
        }
        return null;
    }

    public boolean verificaConexao() {
        try {
            bd.conecta_BD();
        } catch (SQLException ex) {
            cursorDefault();


            //Excessão para conexão com Internet/BD
            if (ex.getErrorCode() == 0) {
                JOptionPane.showMessageDialog(this, "Falha na conexão com o banco de dados,\nVerifique sua conexão com a internet");
                return false;
            } //Excessão para Usuário e/ou Senha Inválidos
            else if (ex.getErrorCode() == 1045) {
                JOptionPane.showMessageDialog(this, "Usuario e/ou Senha Inválidos");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Falha ao Inicializar");
            return false;
        }
        return true;
    }

    private void cursorWait() {
        Cursor ponteiroMouse = new Cursor(Cursor.WAIT_CURSOR);
        setCursor(ponteiroMouse);
    }

    private void cursorDefault() {
        Cursor ponteiroMouse = new Cursor(Cursor.DEFAULT_CURSOR);
        setCursor(ponteiroMouse);
    }

    public void realizarBackup() {
        if (verificaConexao() == true) {
            String caminho;
            String dir = diretorio();
            if (dir == null) {
                JOptionPane.showMessageDialog(this, "Nenhum Arquivo de Backup Foi Criado");
            } else {
                caminho = dir + ".sql";
                cursorWait();

                try {

                    String comando = "mysqldump -h maxses.com.br -u natura_ContrCal -pdrr_2017-X natura_controle_calibracao";

                    Runtime r = Runtime.getRuntime();

                    Process p = r.exec(comando);

                    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

                    String line;

                    backup = new FileWriter(new File(caminho), true);

                    while ((line = in.readLine()) != null) {
                        if (line != null && !line.trim().equals("")) {
                            backup.write(line + "\n");
                            backup.flush();
                        }

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                new JOptionPane().showMessageDialog(this, "Backup criado com sucesso.");
            }
            cursorDefault();
        }
    }

    public void restauraBackup() throws FileNotFoundException, IOException {
        if (verificaConexao() == true) {

            JOptionPane tela = new JOptionPane();
            /*
             * mysql -u <usuario> -p<senha> < mysql.sql
             */
            String comando = "mysql -h maxses.com.br -u natura_ContrCal -pdrr_2017-X natura_controle_calibracao";
            String dir = diretorio();

            if (dir == null) {
                JOptionPane.showMessageDialog(this, "Nenhum Arquivo de Backup Selecionado");
            } else {


                Runtime r = Runtime.getRuntime();

                Process p = r.exec(comando);

                OutputStream out = p.getOutputStream();

                out.write(("source " + dir).getBytes());
                cursorWait();

                out.flush();

                out.close();
                try {
                    while (p.waitFor() == 1) {
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                tela.showMessageDialog(this, "Backup Restaurado com sucesso.");
                p.destroy();
            }

        }


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        MenuCadastroNovo = new javax.swing.JMenu();
        MenuCadastroNovoPessoa = new javax.swing.JMenuItem();
        MenuCadastroNovoEmpresa = new javax.swing.JMenuItem();
        MenuCadastroNovoCondicao = new javax.swing.JMenuItem();
        MenuCadastroNovoEquipamento = new javax.swing.JMenuItem();
        MenuCadastroNovoFrequencia = new javax.swing.JMenuItem();
        MenuCadastroNovoPessoaSistemaMedicao = new javax.swing.JMenuItem();
        MenuCadastroNovoTipoIntervencao = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuIntervencoes = new javax.swing.JMenu();
        jMenuIntervencoesNovo = new javax.swing.JMenuItem();
        jMenuIntervencoesEditar = new javax.swing.JMenuItem();
        jMenuIntervencoesExcluir = new javax.swing.JMenuItem();
        jMenuRelatorio = new javax.swing.JMenu();
        jMenuRelatorioProximasIntervencoes = new javax.swing.JMenuItem();
        jMenuRelatorioEquipamentosEmUso = new javax.swing.JMenuItem();
        jMenuRelatorioEquipamentosForaDeUso = new javax.swing.JMenuItem();
        jMenuBackup = new javax.swing.JMenu();
        jMenuBackupCriar = new javax.swing.JMenuItem();
        jMenuBackupRestaurar = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de Intervenções de Equipamentos");
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);

        menuCadastro.setText("Cadastros");

        MenuCadastroNovo.setText("Novo");

        MenuCadastroNovoPessoa.setText("Pessoa");
        MenuCadastroNovoPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroNovoPessoaActionPerformed(evt);
            }
        });
        MenuCadastroNovo.add(MenuCadastroNovoPessoa);

        MenuCadastroNovoEmpresa.setText("Empresa");
        MenuCadastroNovoEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroNovoEmpresaActionPerformed(evt);
            }
        });
        MenuCadastroNovo.add(MenuCadastroNovoEmpresa);

        MenuCadastroNovoCondicao.setText("Condição");
        MenuCadastroNovoCondicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroNovoCondicaoActionPerformed(evt);
            }
        });
        MenuCadastroNovo.add(MenuCadastroNovoCondicao);

        MenuCadastroNovoEquipamento.setText("Equipamento");
        MenuCadastroNovoEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroNovoEquipamentoActionPerformed(evt);
            }
        });
        MenuCadastroNovo.add(MenuCadastroNovoEquipamento);

        MenuCadastroNovoFrequencia.setText("Frequência");
        MenuCadastroNovoFrequencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroNovoFrequenciaActionPerformed(evt);
            }
        });
        MenuCadastroNovo.add(MenuCadastroNovoFrequencia);

        MenuCadastroNovoPessoaSistemaMedicao.setText("Sistema de Medição");
        MenuCadastroNovo.add(MenuCadastroNovoPessoaSistemaMedicao);

        MenuCadastroNovoTipoIntervencao.setText("Tipo de Intervenção");
        MenuCadastroNovoTipoIntervencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroNovoTipoIntervencaoActionPerformed(evt);
            }
        });
        MenuCadastroNovo.add(MenuCadastroNovoTipoIntervencao);

        menuCadastro.add(MenuCadastroNovo);
        menuCadastro.add(jSeparator1);

        jMenu5.setText("Editar");

        jMenuItem10.setText("Pessoa");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuItem11.setText("Empresa");
        jMenu5.add(jMenuItem11);

        jMenuItem12.setText("Equipamento");
        jMenu5.add(jMenuItem12);

        jMenuItem13.setText("Condição");
        jMenu5.add(jMenuItem13);

        jMenuItem14.setText("Frequência");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuItem15.setText("Sistema de Medição");
        jMenu5.add(jMenuItem15);

        jMenuItem16.setText("Tipo de Intervenção");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem16);

        menuCadastro.add(jMenu5);
        menuCadastro.add(jSeparator2);

        jMenu6.setText("Excluir");

        jMenuItem17.setText("Pessoa");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem17);

        jMenuItem18.setText("Empresa");
        jMenu6.add(jMenuItem18);

        jMenuItem19.setText("Equipamento");
        jMenu6.add(jMenuItem19);

        jMenuItem20.setText("Condição");
        jMenu6.add(jMenuItem20);

        jMenuItem21.setText("Frequência");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem21);

        jMenuItem22.setText("Sistema de Medição");
        jMenu6.add(jMenuItem22);

        jMenuItem23.setText("Tipo de Intervenção");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem23);

        menuCadastro.add(jMenu6);

        jMenuBar1.add(menuCadastro);

        jMenuIntervencoes.setText("Intervenções");

        jMenuIntervencoesNovo.setText("Novo");
        jMenuIntervencoesNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIntervencoesNovoActionPerformed(evt);
            }
        });
        jMenuIntervencoes.add(jMenuIntervencoesNovo);

        jMenuIntervencoesEditar.setText("Editar");
        jMenuIntervencoesEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIntervencoesEditarActionPerformed(evt);
            }
        });
        jMenuIntervencoes.add(jMenuIntervencoesEditar);

        jMenuIntervencoesExcluir.setText("Excluir");
        jMenuIntervencoes.add(jMenuIntervencoesExcluir);

        jMenuBar1.add(jMenuIntervencoes);

        jMenuRelatorio.setText("Relatório");

        jMenuRelatorioProximasIntervencoes.setText("Próximas Intervenções");
        jMenuRelatorioProximasIntervencoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatorioProximasIntervencoesActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuRelatorioProximasIntervencoes);

        jMenuRelatorioEquipamentosEmUso.setText("Equipamentos Em Uso");
        jMenuRelatorioEquipamentosEmUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatorioEquipamentosEmUsoActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuRelatorioEquipamentosEmUso);

        jMenuRelatorioEquipamentosForaDeUso.setText("Equipamentos Fora de Uso");
        jMenuRelatorioEquipamentosForaDeUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatorioEquipamentosForaDeUsoActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuRelatorioEquipamentosForaDeUso);

        jMenuBar1.add(jMenuRelatorio);

        jMenuBackup.setText("Backup");

        jMenuBackupCriar.setText("Criar");
        jMenuBackupCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBackupCriarActionPerformed(evt);
            }
        });
        jMenuBackup.add(jMenuBackupCriar);

        jMenuBackupRestaurar.setText("Restaurar");
        jMenuBackupRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBackupRestaurarActionPerformed(evt);
            }
        });
        jMenuBackup.add(jMenuBackupRestaurar);

        jMenuBar1.add(jMenuBackup);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuCadastroNovoPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroNovoPessoaActionPerformed
        this.setEnabled(false);
        pessoa.setVisible(true);
    }//GEN-LAST:event_MenuCadastroNovoPessoaActionPerformed

    private void MenuCadastroNovoFrequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroNovoFrequenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuCadastroNovoFrequenciaActionPerformed

    private void MenuCadastroNovoTipoIntervencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroNovoTipoIntervencaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuCadastroNovoTipoIntervencaoActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuIntervencoesEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIntervencoesEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuIntervencoesEditarActionPerformed

    private void jMenuRelatorioProximasIntervencoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatorioProximasIntervencoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuRelatorioProximasIntervencoesActionPerformed

    private void jMenuRelatorioEquipamentosForaDeUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatorioEquipamentosForaDeUsoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuRelatorioEquipamentosForaDeUsoActionPerformed

    private void jMenuRelatorioEquipamentosEmUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatorioEquipamentosEmUsoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuRelatorioEquipamentosEmUsoActionPerformed

    private void MenuCadastroNovoEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroNovoEmpresaActionPerformed
        this.setEnabled(false);
        empresa.setVisible(true);
    }//GEN-LAST:event_MenuCadastroNovoEmpresaActionPerformed

    private void jMenuBackupRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBackupRestaurarActionPerformed
        try {
            restauraBackup();
            cursorDefault();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jMenuBackupRestaurarActionPerformed
    private void MenuCadastroNovoCondicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroNovoCondicaoActionPerformed
        this.setEnabled(false);
        condicao.setVisible(true);
    }//GEN-LAST:event_MenuCadastroNovoCondicaoActionPerformed

    private void MenuCadastroNovoEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroNovoEquipamentoActionPerformed
        this.setEnabled(false);
        equipamento.setVisible(true);
    }//GEN-LAST:event_MenuCadastroNovoEquipamentoActionPerformed

    private void jMenuBackupCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBackupCriarActionPerformed

        realizarBackup();

    }//GEN-LAST:event_jMenuBackupCriarActionPerformed

    private void jMenuIntervencoesNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIntervencoesNovoActionPerformed
    }//GEN-LAST:event_jMenuIntervencoesNovoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;


                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuCadastroNovo;
    private javax.swing.JMenuItem MenuCadastroNovoCondicao;
    private javax.swing.JMenuItem MenuCadastroNovoEmpresa;
    private javax.swing.JMenuItem MenuCadastroNovoEquipamento;
    private javax.swing.JMenuItem MenuCadastroNovoFrequencia;
    private javax.swing.JMenuItem MenuCadastroNovoPessoa;
    private javax.swing.JMenuItem MenuCadastroNovoPessoaSistemaMedicao;
    private javax.swing.JMenuItem MenuCadastroNovoTipoIntervencao;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenuBackup;
    private javax.swing.JMenuItem jMenuBackupCriar;
    private javax.swing.JMenuItem jMenuBackupRestaurar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuIntervencoes;
    private javax.swing.JMenuItem jMenuIntervencoesEditar;
    private javax.swing.JMenuItem jMenuIntervencoesExcluir;
    private javax.swing.JMenuItem jMenuIntervencoesNovo;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenu jMenuRelatorio;
    private javax.swing.JMenuItem jMenuRelatorioEquipamentosEmUso;
    private javax.swing.JMenuItem jMenuRelatorioEquipamentosForaDeUso;
    private javax.swing.JMenuItem jMenuRelatorioProximasIntervencoes;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu menuCadastro;
    // End of variables declaration//GEN-END:variables
}
