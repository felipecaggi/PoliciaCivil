/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.entity.Delegado;

/**
 *
 * @author Asus
 */
public class AdicionarDelegado extends javax.swing.JFrame {

    private Delegado initPoliciais;

    /**
     * Creates new form AdicionarDelegado
     */
    public AdicionarDelegado() {

        initComponents();

        initPoliciais = CadastrarOcorrencia.delegados;

        Object[] row = new Object[3];
        DefaultTableModel model2 = (DefaultTableModel) TableAdicionados.getModel();
        row[0] = initPoliciais.getIdPolicial();
        row[1] = initPoliciais.getNome();
        row[2] = initPoliciais.getCargo();
        model2.addRow(row);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        policiaPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("policiaPU").createEntityManager();
        delegadoQuery = java.beans.Beans.isDesignTime() ? null : policiaPUEntityManager.createQuery("SELECT d FROM Delegado d");
        delegadoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : delegadoQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaResultados = new javax.swing.JTable();
        PesquisarTextField = new javax.swing.JTextField();
        PesquisarButton = new javax.swing.JButton();
        CadastrarDelegadoButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableAdicionados = new javax.swing.JTable();
        AdicionarButton = new javax.swing.JButton();
        VoltarButton = new javax.swing.JButton();
        SalvarButton = new javax.swing.JButton();
        RemoverButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, delegadoList, TabelaResultados);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idPolicial}"));
        columnBinding.setColumnName("Matricula");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${delegacia.nome}"));
        columnBinding.setColumnName("Delegacia");
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(TabelaResultados);

        PesquisarTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PesquisarTextFieldKeyPressed(evt);
            }
        });

        PesquisarButton.setText("Pesquisar");
        PesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarButtonActionPerformed(evt);
            }
        });

        CadastrarDelegadoButton.setText("Cadastrar Delegado");
        CadastrarDelegadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarDelegadoButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Resultados da pesquisa");

        jLabel2.setText("Delegados adicionados");

        TableAdicionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nome", "Delegacia"
            }
        ));
        TableAdicionados.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(TableAdicionados);
        TableAdicionados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        AdicionarButton.setText("Adicionar Linhas Selecionadas");
        AdicionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarButtonActionPerformed(evt);
            }
        });

        VoltarButton.setText("Voltar");
        VoltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarButtonActionPerformed(evt);
            }
        });

        SalvarButton.setText("Salvar");
        SalvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarButtonActionPerformed(evt);
            }
        });

        RemoverButton.setText("Remover Linhas Selecionadas");
        RemoverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverButtonRemoverButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PesquisarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PesquisarButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                                .addComponent(CadastrarDelegadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(AdicionarButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(VoltarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SalvarButton)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(RemoverButton)
                .addGap(288, 288, 288))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PesquisarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PesquisarButton)
                    .addComponent(CadastrarDelegadoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AdicionarButton)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RemoverButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarButton)
                    .addComponent(SalvarButton))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Pesquisa a vítima no Banco de Dados
     *
     * @param evt
     */
    private void PesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarButtonActionPerformed
        String pesquisa = PesquisarTextField.getText().toLowerCase();
        List<Delegado> collect = delegadoList.stream()
                .filter(x -> x.getNome().toLowerCase().contains(pesquisa) || x.getDelegacia().getNome().toLowerCase().contains(pesquisa))
                .collect(toList());

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, collect, TabelaResultados);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idPolicial}"));
        columnBinding.setColumnName("Matricula");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${delegacia.nome}"));
        columnBinding.setColumnName("Delegacia");
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(TabelaResultados);
    }//GEN-LAST:event_PesquisarButtonActionPerformed

    /**
     * Cadastra uma nova vítima no Banco de Dados
     *
     * @param evt
     */
    private void CadastrarDelegadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarDelegadoButtonActionPerformed

    }//GEN-LAST:event_CadastrarDelegadoButtonActionPerformed

    /**
     * Transfere a pessoa resultado da pesquisa para a tabela de vítimas
     *
     * @param evt
     */
    private void AdicionarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarButtonActionPerformed

        TableModel model1 = TabelaResultados.getModel();

        int index = TabelaResultados.getSelectedRow();

        Object[] row = new Object[3];

        DefaultTableModel model2 = (DefaultTableModel) TableAdicionados.getModel();

        model2.removeRow(0);
        row[0] = model1.getValueAt(index, 0);
        row[1] = model1.getValueAt(index, 1);
        row[2] = model1.getValueAt(index, 2);
        model2.addRow(row);

        Integer matricula = Integer.parseInt(model1.getValueAt(index, 0).toString());

        Delegado collect = delegadoList.stream().filter(x -> {
            return x.getIdPolicial().equals(matricula);
        }).findFirst().get();
        CadastrarOcorrencia.delegados = collect;

    }//GEN-LAST:event_AdicionarButtonActionPerformed

    /**
     * Salva as vítimas selecionadas
     *
     * @param evt
     */
    private void SalvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_SalvarButtonActionPerformed

    /**
     * Volta para a tela anterior
     *
     * @param evt
     */
    private void VoltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarButtonActionPerformed
        CadastrarOcorrencia.delegados = initPoliciais;
        this.dispose();
    }//GEN-LAST:event_VoltarButtonActionPerformed

    private void RemoverButtonRemoverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverButtonRemoverButtonActionPerformed
        DefaultTableModel model2 = (DefaultTableModel) TableAdicionados.getModel();
        int[] index = TableAdicionados.getSelectedRows();

        for (int i = 0; i < index.length; i++) {
            model2.removeRow(index[i]);

            CadastrarOcorrencia.delegados = new Delegado();
            model2.addRow(new Object[3]);
        }
    }//GEN-LAST:event_RemoverButtonRemoverButtonActionPerformed

    private void PesquisarTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PesquisarTextFieldKeyPressed
        PesquisarButtonActionPerformed(null);
    }//GEN-LAST:event_PesquisarTextFieldKeyPressed

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
            java.util.logging.Logger.getLogger(AdicionarDelegado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarDelegado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarDelegado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarDelegado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarDelegado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarButton;
    private javax.swing.JButton CadastrarDelegadoButton;
    private javax.swing.JButton PesquisarButton;
    private javax.swing.JTextField PesquisarTextField;
    private javax.swing.JButton RemoverButton;
    private javax.swing.JButton SalvarButton;
    private javax.swing.JTable TabelaResultados;
    private javax.swing.JTable TableAdicionados;
    private javax.swing.JButton VoltarButton;
    private java.util.List<model.entity.Delegado> delegadoList;
    private javax.persistence.Query delegadoQuery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.persistence.EntityManager policiaPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
