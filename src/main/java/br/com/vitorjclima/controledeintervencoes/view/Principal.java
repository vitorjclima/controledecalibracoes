package br.com.vitorjclima.controledeintervencoes.view;

import br.com.vitorjclima.controledeintervencoes.db.BD;
import br.com.vitorjclima.controledeintervencoes.db.SistemaMedicao;
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

    private CadastroEmpresaView empresa;;
    private CadastroEquipamentoView equipamento;
    private CadastroCondicaoView condicao;
    private CadastroIntervencaoTipoView intervencaoTipo;
    private IntervencaoView intervencao;
    private CadastroSistemaMedicaoView sistemaMedicao;
    private PessoaView pessoa;
    private CadastroToleranciaView tolerancia;
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
        System.getProperty("os.name");
        
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

    private void restauraBackup() throws FileNotFoundException, IOException {
        
        System.getProperty("os.name");
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
        MenuCadastroPessoa = new javax.swing.JMenuItem();
        MenuCadastroEmpresa = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        MenuCadastroEquipamentoCadastro = new javax.swing.JMenuItem();
        MenuCadastroEquipamentoCondicao = new javax.swing.JMenuItem();
        MenuCadastroEquipamentoTolerancia = new javax.swing.JMenuItem();
        MenuCadastroPessoaSistemaMedicao = new javax.swing.JMenuItem();
        MenuCadastroTipoIntervencao = new javax.swing.JMenuItem();
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

        MenuCadastroPessoa.setText("Pessoa");
        MenuCadastroPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroPessoaActionPerformed(evt);
            }
        });
        menuCadastro.add(MenuCadastroPessoa);

        MenuCadastroEmpresa.setText("Empresa");
        MenuCadastroEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroEmpresaActionPerformed(evt);
            }
        });
        menuCadastro.add(MenuCadastroEmpresa);

        jMenu1.setText("Equipamento");

        MenuCadastroEquipamentoCadastro.setText("Cadastro");
        MenuCadastroEquipamentoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroEquipamentoCadastroActionPerformed(evt);
            }
        });
        jMenu1.add(MenuCadastroEquipamentoCadastro);

        MenuCadastroEquipamentoCondicao.setText("Condição");
        MenuCadastroEquipamentoCondicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroEquipamentoCondicaoActionPerformed(evt);
            }
        });
        jMenu1.add(MenuCadastroEquipamentoCondicao);

        MenuCadastroEquipamentoTolerancia.setText("Tolerância");
        MenuCadastroEquipamentoTolerancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroEquipamentoToleranciaActionPerformed(evt);
            }
        });
        jMenu1.add(MenuCadastroEquipamentoTolerancia);

        menuCadastro.add(jMenu1);

        MenuCadastroPessoaSistemaMedicao.setText("Sistema de Medição");
        MenuCadastroPessoaSistemaMedicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroPessoaSistemaMedicaoActionPerformed(evt);
            }
        });
        menuCadastro.add(MenuCadastroPessoaSistemaMedicao);

        MenuCadastroTipoIntervencao.setText("Tipo de Intervenção");
        MenuCadastroTipoIntervencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastroTipoIntervencaoActionPerformed(evt);
            }
        });
        menuCadastro.add(MenuCadastroTipoIntervencao);

        jMenuBar1.add(menuCadastro);

        jMenuIntervencoes.setText("Intervenções");

        jMenuIntervencoesNovo.setText("Nova");
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
            .addGap(0, 581, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jMenuBackupCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBackupCriarActionPerformed

        realizarBackup();

    }//GEN-LAST:event_jMenuBackupCriarActionPerformed

    private void jMenuIntervencoesNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIntervencoesNovoActionPerformed
        this.setEnabled(false);
        intervencao = new IntervencaoView(this);
        intervencao.setVisible(true);
    }//GEN-LAST:event_jMenuIntervencoesNovoActionPerformed

    private void MenuCadastroTipoIntervencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroTipoIntervencaoActionPerformed
        this.setEnabled(false);
        intervencaoTipo = new CadastroIntervencaoTipoView(this);
        intervencaoTipo.setVisible(true);
    }//GEN-LAST:event_MenuCadastroTipoIntervencaoActionPerformed

    private void MenuCadastroEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroEmpresaActionPerformed
        this.setEnabled(false);
        empresa = new CadastroEmpresaView(this);
        empresa.setVisible(true);
    }//GEN-LAST:event_MenuCadastroEmpresaActionPerformed

    private void MenuCadastroPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroPessoaActionPerformed
        this.setEnabled(false);
        pessoa = new PessoaView(this);
        pessoa.setVisible(true);
    }//GEN-LAST:event_MenuCadastroPessoaActionPerformed

    private void MenuCadastroEquipamentoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroEquipamentoCadastroActionPerformed
        this.setEnabled(false);
        equipamento = new CadastroEquipamentoView(this);
        equipamento.setVisible(true);
    }//GEN-LAST:event_MenuCadastroEquipamentoCadastroActionPerformed

    private void MenuCadastroEquipamentoCondicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroEquipamentoCondicaoActionPerformed
        this.setEnabled(false);
        condicao = new CadastroCondicaoView(this);
        condicao.setVisible(true); 
    }//GEN-LAST:event_MenuCadastroEquipamentoCondicaoActionPerformed

    private void MenuCadastroPessoaSistemaMedicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroPessoaSistemaMedicaoActionPerformed
        this.setEnabled(false);
        sistemaMedicao = new CadastroSistemaMedicaoView(this);
        sistemaMedicao.setVisible(true); 
    }//GEN-LAST:event_MenuCadastroPessoaSistemaMedicaoActionPerformed

    private void MenuCadastroEquipamentoToleranciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastroEquipamentoToleranciaActionPerformed
        this.setEnabled(false);
        tolerancia = new CadastroToleranciaView(this);
        tolerancia.setVisible(true); 
    }//GEN-LAST:event_MenuCadastroEquipamentoToleranciaActionPerformed

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
    private javax.swing.JMenuItem MenuCadastroEmpresa;
    private javax.swing.JMenuItem MenuCadastroEquipamentoCadastro;
    private javax.swing.JMenuItem MenuCadastroEquipamentoCondicao;
    private javax.swing.JMenuItem MenuCadastroEquipamentoTolerancia;
    private javax.swing.JMenuItem MenuCadastroPessoa;
    private javax.swing.JMenuItem MenuCadastroPessoaSistemaMedicao;
    private javax.swing.JMenuItem MenuCadastroTipoIntervencao;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuBackup;
    private javax.swing.JMenuItem jMenuBackupCriar;
    private javax.swing.JMenuItem jMenuBackupRestaurar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuIntervencoes;
    private javax.swing.JMenuItem jMenuIntervencoesEditar;
    private javax.swing.JMenuItem jMenuIntervencoesExcluir;
    private javax.swing.JMenuItem jMenuIntervencoesNovo;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jMenuRelatorio;
    private javax.swing.JMenuItem jMenuRelatorioEquipamentosEmUso;
    private javax.swing.JMenuItem jMenuRelatorioEquipamentosForaDeUso;
    private javax.swing.JMenuItem jMenuRelatorioProximasIntervencoes;
    private javax.swing.JMenu menuCadastro;
    // End of variables declaration//GEN-END:variables
}
