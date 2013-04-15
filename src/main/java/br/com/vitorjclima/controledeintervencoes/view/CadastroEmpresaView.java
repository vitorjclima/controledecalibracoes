/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.view;

import br.com.vitorjclima.controledeintervencoes.core.controller.EmpresaJpaController;
import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.NonexistentEntityException;
import br.com.vitorjclima.controledeintervencoes.db.Empresa;
import java.awt.Cursor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vitor
 */
public class CadastroEmpresaView extends javax.swing.JFrame {

    private EmpresaJpaController empresaController;
    private Empresa empresa;
    private Principal principal;
    private boolean editar;

    /**
     * Creates new form CadastroEmpresaView
     */
    public CadastroEmpresaView() {
        initComponents();
        this.empresaController = new EmpresaJpaController();
        this.principal = principal;
        botaoEditar.setEnabled(false);
        botaoExcluir.setEnabled(false);
        botaoSalvar.setEnabled(false);
        enableCampos(false);
    }

    CadastroEmpresaView(Principal principal) {
        initComponents();
        this.empresaController = new EmpresaJpaController();
        this.principal = principal;
        botaoEditar.setEnabled(false);
        botaoExcluir.setEnabled(false);
        botaoSalvar.setEnabled(false);
        enableCampos(false);
    }

    private void enableCampos(boolean x) {

        razaoSocial.setEnabled(x);
        nomeFantasia.setEnabled(x);
        cnpj.setEnabled(x);

    }

    public boolean getEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    private void apagaConteudo() {
        razaoSocial.setText(null);
        nomeFantasia.setText(null);
        cnpj.setText(null);
        pesquisar.setText(null);
    }

    private void cursorWait() {
        Cursor ponteiroMouse = new Cursor(Cursor.WAIT_CURSOR);
        setCursor(ponteiroMouse);
    }

    private void cursorDefault() {
        Cursor ponteiroMouse = new Cursor(Cursor.DEFAULT_CURSOR);
        setCursor(ponteiroMouse);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelRazaoSocial = new javax.swing.JLabel();
        labelNomeFantasia = new javax.swing.JLabel();
        labelCNPJ = new javax.swing.JLabel();
        razaoSocial = new javax.swing.JTextField();
        nomeFantasia = new javax.swing.JTextField();
        cnpj = new javax.swing.JFormattedTextField();
        panelBotoes = new java.awt.Panel();
        botaoNovo = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        pesquisar = new javax.swing.JFormattedTextField();
        botaoPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Empresa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        labelRazaoSocial.setText("Razão Social");

        labelNomeFantasia.setText("Nome Fantasia");

        labelCNPJ.setText("CNPJ");

        razaoSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                razaoSocialActionPerformed(evt);
            }
        });

        nomeFantasia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFantasiaActionPerformed(evt);
            }
        });

        try {
            cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cnpj.setToolTipText("");
        cnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnpjActionPerformed(evt);
            }
        });

        panelBotoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        botaoNovo.setText("Novo");
        botaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoActionPerformed(evt);
            }
        });

        botaoEditar.setText("Editar");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        try {
            pesquisar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pesquisar.setToolTipText("");

        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotoesLayout.createSequentialGroup()
                        .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPesquisar))
                    .addGroup(panelBotoesLayout.createSequentialGroup()
                        .addComponent(botaoNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExcluir)))
                .addGap(5, 5, 5))
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoNovo)
                    .addComponent(botaoEditar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoSalvar))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRazaoSocial)
                    .addComponent(labelNomeFantasia)
                    .addComponent(labelCNPJ))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nomeFantasia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cnpj)
                    .addComponent(razaoSocial))
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRazaoSocial)
                    .addComponent(razaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeFantasia)
                    .addComponent(nomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCNPJ)
                    .addComponent(cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void razaoSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_razaoSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_razaoSocialActionPerformed

    private void nomeFantasiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFantasiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFantasiaActionPerformed

    private void cnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnpjActionPerformed

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        cursorWait();
        enableCampos(false);
        this.empresa = new Empresa();

        try {
            empresa = empresaController.findEmpresa(pesquisar.getText());

            razaoSocial.setText(empresa.getEmpresaRazaoSocial());
            nomeFantasia.setText(empresa.getEmpresaNomeFantasia());
            cnpj.setText(empresa.getEmpresaCnpj());


            botaoEditar.setEnabled(true);
            botaoExcluir.setEnabled(true);
            botaoPesquisar.setEnabled(true);
            botaoNovo.setEnabled(true);
            botaoSalvar.setEnabled(true);
            cursorDefault();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Não existe nenhuma empresa cadastrada com este CNPJ");
            cursorDefault();
            apagaConteudo();
            pesquisar.requestFocusInWindow();
        }
    }//GEN-LAST:event_botaoPesquisarActionPerformed

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed
        apagaConteudo();
        enableCampos(true);
        razaoSocial.requestFocusInWindow();
        pesquisar.setEnabled(false);
        botaoEditar.setEnabled(false);
        botaoExcluir.setEnabled(false);
        botaoPesquisar.setEnabled(false);
        botaoNovo.setEnabled(false);
        botaoSalvar.setEnabled(true);
    }//GEN-LAST:event_botaoNovoActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        enableCampos(true);
        setEditar(true);
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed

        if (editar == false) {

            this.empresa = new Empresa();
            this.empresa.setEmpresaNomeFantasia(nomeFantasia.getText());
            this.empresa.setEmpresaRazaoSocial(razaoSocial.getText());
            this.empresa.setEmpresaCnpj(cnpj.getText());


            if (nomeFantasia.getText().equals("") || cnpj.getText().equals("  .   .   /    -  ") || razaoSocial.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos");
            } else {

                try {
                    cursorWait();
                    empresaController.findEmpresa(cnpj.getText());
                    JOptionPane.showMessageDialog(this, "Já existe uma empresa cadastrada com este CNPJ");
                    cursorDefault();
                } catch (Exception e) {
                    cursorWait();
                    this.empresaController.create(empresa);
                    JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso");
                    this.dispose();
                    this.principal.setEnabled(true);
                    cursorDefault();
                }
            }
        } else {

            this.empresa.setEmpresaNomeFantasia(nomeFantasia.getText());
            this.empresa.setEmpresaRazaoSocial(razaoSocial.getText());
            this.empresa.setEmpresaCnpj(cnpj.getText());

            if (nomeFantasia.getText().equals("") || cnpj.getText().equals("  .   .   /    -  ") || razaoSocial.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos");
            } else {
                try {
                    cursorWait();
                    this.empresaController.edit(empresa);
                    JOptionPane.showMessageDialog(this, "Cadastro alterado com sucesso");
                    this.dispose();
                    this.principal.setEnabled(true);
                    cursorDefault();
                } catch (Exception ex) {
                    Logger.getLogger(PessoaView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        cursorWait();
        try {
            empresaController.destroy(empresa.getEmpresaId());
            apagaConteudo();
            JOptionPane.showMessageDialog(this, "Registro removido com sucesso");
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PessoaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        cursorDefault();
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.setVisible(false);
        this.principal.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(CadastroEmpresaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroEmpresaView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JFormattedTextField cnpj;
    private javax.swing.JLabel labelCNPJ;
    private javax.swing.JLabel labelNomeFantasia;
    private javax.swing.JLabel labelRazaoSocial;
    private javax.swing.JTextField nomeFantasia;
    private java.awt.Panel panelBotoes;
    private javax.swing.JFormattedTextField pesquisar;
    private javax.swing.JTextField razaoSocial;
    // End of variables declaration//GEN-END:variables
}
