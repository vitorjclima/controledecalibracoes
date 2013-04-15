/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.view;

import br.com.vitorjclima.controledeintervencoes.core.controller.EmpresaJpaController;
import br.com.vitorjclima.controledeintervencoes.core.controller.EquipamentoJpaController;
import br.com.vitorjclima.controledeintervencoes.core.controller.IntervencaoJpaController;
import br.com.vitorjclima.controledeintervencoes.core.controller.IntervencaoTipoJpaController;
import br.com.vitorjclima.controledeintervencoes.core.controller.PessoaJpaController;
import br.com.vitorjclima.controledeintervencoes.db.Empresa;
import br.com.vitorjclima.controledeintervencoes.db.Equipamento;
import br.com.vitorjclima.controledeintervencoes.db.Intervencao;
import br.com.vitorjclima.controledeintervencoes.db.IntervencaoTipo;
import br.com.vitorjclima.controledeintervencoes.db.Pessoa;
import java.awt.Cursor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vitor
 */
public class IntervencaoView extends javax.swing.JFrame {

    private EquipamentoJpaController equipamentoController;
    private EmpresaJpaController empresaController;
    private IntervencaoTipoJpaController intervencaoTipoJpaController;
    private PessoaJpaController pessoaJpaController;
    private Equipamento equipamento;
    private Principal principal;
    private Intervencao intervencao;
    private IntervencaoJpaController intervencaoJpaController;
    private boolean editar;

    /**
     * Creates new form IntervencaoView
     */
    public IntervencaoView() {
        initComponents();
        this.equipamentoController = new EquipamentoJpaController();
        this.empresaController = new EmpresaJpaController();
        this.intervencaoTipoJpaController = new IntervencaoTipoJpaController();
        this.pessoaJpaController = new PessoaJpaController();
        this.intervencaoJpaController = new IntervencaoJpaController();
        carregaEquipamentos();
        carregaEmpresas();
        carregaTipoIntervencao();
        carregaPessoa();
    }

    public IntervencaoView(Principal principal) {
        initComponents();
        this.principal = principal;
        this.equipamentoController = new EquipamentoJpaController();
        this.empresaController = new EmpresaJpaController();
        this.intervencaoTipoJpaController = new IntervencaoTipoJpaController();
        this.pessoaJpaController = new PessoaJpaController();
        this.intervencaoJpaController = new IntervencaoJpaController();
        carregaEquipamentos();
        carregaEmpresas();
        carregaTipoIntervencao();
        carregaPessoa();
    }

    public boolean getEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    private void cursorWait() {
        Cursor ponteiroMouse = new Cursor(Cursor.WAIT_CURSOR);
        setCursor(ponteiroMouse);
    }

    private void cursorDefault() {
        Cursor ponteiroMouse = new Cursor(Cursor.DEFAULT_CURSOR);
        setCursor(ponteiroMouse);
    }

    private void carregaEquipamentos() {
        cursorWait();
        equipamentoComboBox.removeAllItems();

        List<Equipamento> lista = equipamentoController.findEquipamentoEntities();

        for (Iterator itr = lista.iterator(); itr.hasNext();) {
            Equipamento equip = (Equipamento) itr.next();

            equipamentoComboBox.addItem(equip.getEquipamentoId() + " - " + equip.getEquipamentoDescricao());
        }
        cursorDefault();
    }

    private void carregaEmpresas() {
        cursorWait();
        empresaComboBox.removeAllItems();

        List<Empresa> lista = empresaController.findEmpresaEntities();

        for (Iterator itr = lista.iterator(); itr.hasNext();) {
            Empresa contato = (Empresa) itr.next();

            empresaComboBox.addItem(contato.getEmpresaNomeFantasia());
        }
        cursorDefault();
    }

    private void carregaTipoIntervencao() {
        cursorWait();
        tipoIntervencaoComboBox.removeAllItems();

        List<IntervencaoTipo> lista = intervencaoTipoJpaController.findIntervencaoTipoEntities();

        for (Iterator itr = lista.iterator(); itr.hasNext();) {
            IntervencaoTipo contato = (IntervencaoTipo) itr.next();

            tipoIntervencaoComboBox.addItem(contato.getIntervencaoTipoId());
        }
        cursorDefault();
    }

    private void carregaPessoa() {
        cursorWait();
        pessoaComboBox.removeAllItems();

        List<Pessoa> lista = pessoaJpaController.findPessoaEntities();

        for (Iterator itr = lista.iterator(); itr.hasNext();) {
            Pessoa contato = (Pessoa) itr.next();

            pessoaComboBox.addItem(contato.getPessoaCpf() + " - " + contato.getPessoaNome());
        }
        cursorDefault();
    }

    public java.util.Date formataData(String dataRec) {
        if (dataRec == null || dataRec.equals("  /  /    ")) {
            return null;
        }

        java.util.Date date = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = formatter.parse(dataRec);
        } catch (ParseException ex) {
            Logger.getLogger(Intervencao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        equipamentoComboBox = new javax.swing.JComboBox();
        empresaComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        tipoIntervencaoComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        laudo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pessoaComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observacao = new javax.swing.JTextArea();
        botaoSalvar = new javax.swing.JButton();
        data = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Intervenções");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Equipamento");

        jLabel2.setText("Empresa Responsável");

        jLabel3.setText("Tipo");

        jLabel4.setText("Laudo");

        laudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laudoActionPerformed(evt);
            }
        });

        jLabel5.setText("Data");

        jLabel6.setText("Aceito por");

        jLabel7.setText("Observação");

        observacao.setColumns(20);
        observacao.setRows(5);
        jScrollPane1.setViewportView(observacao);

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        try {
            data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        data.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(equipamentoComboBox, 0, 267, Short.MAX_VALUE)
                            .addComponent(empresaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tipoIntervencaoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(laudo)
                            .addComponent(pessoaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSalvar)
                .addGap(179, 179, 179))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(equipamentoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(empresaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(tipoIntervencaoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(laudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(pessoaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void laudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laudoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laudoActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        this.intervencao = new Intervencao();
        String[] equipId = equipamentoComboBox.getModel().getSelectedItem().toString().split(" - ");
        String[] PessoaCpf = pessoaComboBox.getModel().getSelectedItem().toString().split(" - ");
        
        this.intervencao.setIntervencaoAceitaPor(PessoaCpf[0]);
        this.intervencao.setIntervencaoEmpresaCodigoLaudo(laudo.getText());
        this.intervencao.setIntervencaoTipoId(tipoIntervencaoComboBox.getModel().getSelectedItem().toString());
        this.intervencao.setIntervencaoObservacao(observacao.getText());
        this.intervencao.setEmpresaId(empresaController.findEmpresaNomeFantasia(empresaComboBox.getModel().getSelectedItem().toString()).getEmpresaId());
        this.intervencao.setEquipamentoId(Integer.parseInt(equipId[0]));
        this.intervencao.setIntervencaoData(formataData(data.getText()));


        if (laudo.getText().equals("") || data.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos");
        } else {

            try {
                this.intervencaoJpaController.create(intervencao);
                JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso");
                this.dispose();
                this.principal.setEnabled(true);
            } catch (Exception ex) {
                Logger.getLogger(CadastroEquipamentoView.class.getName()).log(Level.SEVERE, null, ex);
            }

            cursorDefault();
        }
    }

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.setVisible(false);
        this.principal.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataActionPerformed

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
            java.util.logging.Logger.getLogger(IntervencaoView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntervencaoView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntervencaoView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntervencaoView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntervencaoView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JFormattedTextField data;
    private javax.swing.JComboBox empresaComboBox;
    private javax.swing.JComboBox equipamentoComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField laudo;
    private javax.swing.JTextArea observacao;
    private javax.swing.JComboBox pessoaComboBox;
    private javax.swing.JComboBox tipoIntervencaoComboBox;
    // End of variables declaration//GEN-END:variables
}
