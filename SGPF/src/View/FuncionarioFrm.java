/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.FuncionarioDAO;
import Model.Funcionario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author akina
 */
public class FuncionarioFrm extends javax.swing.JFrame {
    
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    /**
     * Creates new form ClienteFrm
     */
    public FuncionarioFrm() {
        initComponents();
        this.preencheTabela();
    }
    
    public void preencheTabela(){
        List<Funcionario> listFuncionario = funcionarioDAO.obterFuncionarios();
        DefaultTableModel dtm = new DefaultTableModel();
        this.listaFuncionarioTbl.setModel(dtm);
        dtm.addColumn("Id");
        dtm.addColumn("CPF");
        dtm.addColumn("Nome do Funcionário");
        dtm.addColumn("Custo por hora");
        dtm.addColumn("Ativo");
        
        for(Funcionario fn : listFuncionario){
                dtm.addRow(new Object[] {fn.getIdFuncionario() , fn.getCpfFuncionario(), fn.getNomeFuncionario(), fn.getCustoHora().toString()});
            }
    }
    
    public void fieldRefresh(){
        this.idFuncionarioTxtFld.setText("");
        this.cpfFuncionarioTxtFld.setText("");
        this.nomeFuncionarioTxtFld.setText("");
        this.custoHoraFuncionarioTxtFld.setText("");           
    }
    
     public boolean checaVazio(){
        if(
        this.cpfFuncionarioTxtFld.getText().equals("")||
        this.nomeFuncionarioTxtFld.getText().equals("") ||
        this.custoHoraFuncionarioTxtFld.getText().equals("")){
        return true;
    }
        return false;
    }
     
     
      public void preencheField(){
        this.fieldRefresh();
        Funcionario funcionario = funcionarioDAO.recuperaFuncionario((int) this.listaFuncionarioTbl.getValueAt(this.listaFuncionarioTbl.getSelectedRow(), 0));
        this.idFuncionarioTxtFld.setText(String.valueOf(funcionario.getIdFuncionario()));
        this.cpfFuncionarioTxtFld.setText(String.valueOf(funcionario.getCpfFuncionario()));
        this.nomeFuncionarioTxtFld.setText(funcionario.getNomeFuncionario());
        this.custoHoraFuncionarioTxtFld.setText(funcionario.getCustoHora().toString());        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        SGPFPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SGPFPU").createEntityManager();
        clienteQuery = java.beans.Beans.isDesignTime() ? null : SGPFPUEntityManager.createQuery("SELECT c FROM Cliente c");
        clienteList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : clienteQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        tituloFuncionarioLbl = new javax.swing.JLabel();
        nomeFuncionarioLbl = new javax.swing.JLabel();
        razaoSocialFuncionarioLbl = new javax.swing.JLabel();
        cpfFuncionarioLbl = new javax.swing.JLabel();
        nomeFuncionarioTxtFld = new javax.swing.JTextField();
        cpfFuncionarioTxtFld = new javax.swing.JFormattedTextField();
        custoHoraFuncionarioTxtFld = new javax.swing.JFormattedTextField();
        idFuncionarioTxtFld = new javax.swing.JTextField();
        ativoFuncionarioLbl = new javax.swing.JLabel();
        ativoFuncionarioCbx = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaFuncionarioTbl = new javax.swing.JTable();
        titulotabelaFuncionarioLbl = new javax.swing.JLabel();
        salvarFuncionarioButton = new javax.swing.JButton();
        excluirFuncionarioButton = new javax.swing.JButton();
        limparFuncionarioButton = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setMinimumSize(new java.awt.Dimension(800, 600));

        tituloFuncionarioLbl.setText("Funcionários");

        nomeFuncionarioLbl.setText("Nome");

        razaoSocialFuncionarioLbl.setText("Custo/Hora");

        cpfFuncionarioLbl.setText("CPF");

        custoHoraFuncionarioTxtFld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        custoHoraFuncionarioTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custoHoraFuncionarioTxtFldActionPerformed(evt);
            }
        });

        idFuncionarioTxtFld.setEnabled(false);
        idFuncionarioTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFuncionarioTxtFldActionPerformed(evt);
            }
        });

        ativoFuncionarioLbl.setText("Ativo");

        ativoFuncionarioCbx.setEnabled(false);

        listaFuncionarioTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        listaFuncionarioTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaFuncionarioTblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaFuncionarioTbl);

        titulotabelaFuncionarioLbl.setText("Lista de Funcionários");

        salvarFuncionarioButton.setText("Salvar");
        salvarFuncionarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarFuncionarioButtonActionPerformed(evt);
            }
        });

        excluirFuncionarioButton.setText("Excluir");
        excluirFuncionarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirFuncionarioButtonActionPerformed(evt);
            }
        });

        limparFuncionarioButton.setText("Limpar");
        limparFuncionarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparFuncionarioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addComponent(jSeparator1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(352, 352, 352)
                                .addComponent(tituloFuncionarioLbl)
                                .addGap(0, 156, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ativoFuncionarioLbl)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(razaoSocialFuncionarioLbl)
                                        .addComponent(nomeFuncionarioLbl)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(idFuncionarioTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomeFuncionarioTxtFld))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(custoHoraFuncionarioTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ativoFuncionarioCbx))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(42, 42, 42)
                        .addComponent(cpfFuncionarioLbl)
                        .addGap(18, 18, 18)
                        .addComponent(cpfFuncionarioTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(356, 356, 356)
                                .addComponent(titulotabelaFuncionarioLbl))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(salvarFuncionarioButton)
                                .addGap(18, 18, 18)
                                .addComponent(excluirFuncionarioButton)
                                .addGap(18, 18, 18)
                                .addComponent(limparFuncionarioButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloFuncionarioLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeFuncionarioLbl)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nomeFuncionarioTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cpfFuncionarioLbl)
                                .addComponent(cpfFuncionarioTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idFuncionarioTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(razaoSocialFuncionarioLbl)
                            .addComponent(custoHoraFuncionarioTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ativoFuncionarioLbl))
                    .addComponent(ativoFuncionarioCbx))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(excluirFuncionarioButton)
                    .addComponent(salvarFuncionarioButton)
                    .addComponent(limparFuncionarioButton))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulotabelaFuncionarioLbl)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void excluirFuncionarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirFuncionarioButtonActionPerformed
        // TODO add your handling code here:
        try{       
            funcionarioDAO.removerFuncionario(funcionarioDAO.recuperaFuncionario(Integer.parseInt(this.idFuncionarioTxtFld.getText())));
            this.fieldRefresh();
            this.preencheTabela();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, ("Selecione um funcionário da tabela " + e.getMessage()), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_excluirFuncionarioButtonActionPerformed

    private void idFuncionarioTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFuncionarioTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFuncionarioTxtFldActionPerformed

    private void limparFuncionarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparFuncionarioButtonActionPerformed
        // TODO add your handling code here:
        this.fieldRefresh();
    }//GEN-LAST:event_limparFuncionarioButtonActionPerformed

    private void custoHoraFuncionarioTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custoHoraFuncionarioTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custoHoraFuncionarioTxtFldActionPerformed

    private void salvarFuncionarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarFuncionarioButtonActionPerformed
        // TODO add your handling code here:
        if(this.checaVazio()){
            JOptionPane.showMessageDialog(null, "Erro, confira o preenchimento", "ERRO", JOptionPane.WARNING_MESSAGE);
        }else if(!this.idFuncionarioTxtFld.getText().toString().equals("")){
            funcionarioDAO.atualizarFuncionario(Integer.parseInt(this.idFuncionarioTxtFld.getText()), 
                    Integer.parseInt(this.cpfFuncionarioTxtFld.getText()),
                    this.nomeFuncionarioTxtFld.getText(),
                    Double.parseDouble(this.custoHoraFuncionarioTxtFld.getText()));
                    
                    
            this.preencheTabela();
        }else{
        try{
            Funcionario funcionario = new Funcionario();
            
            funcionario.setCpfFuncionario(Integer.parseInt(this.cpfFuncionarioTxtFld.getText()));
            funcionario.setNomeFuncionario(this.nomeFuncionarioTxtFld.getText());
            funcionario.setCustoHora(Double.parseDouble(this.custoHoraFuncionarioTxtFld.getText().replace(",", "."))); 
                    
            
            funcionarioDAO.salvarFuncionario(funcionario);
            
            this.fieldRefresh();
            this.preencheTabela();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO"  , JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_salvarFuncionarioButtonActionPerformed

    private void listaFuncionarioTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaFuncionarioTblMouseClicked
        // TODO add your handling code here:
        this.preencheField();
    }//GEN-LAST:event_listaFuncionarioTblMouseClicked

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
            java.util.logging.Logger.getLogger(FuncionarioFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager SGPFPUEntityManager;
    private javax.swing.JCheckBox ativoFuncionarioCbx;
    private javax.swing.JLabel ativoFuncionarioLbl;
    private java.util.List<Model.Cliente> clienteList;
    private javax.persistence.Query clienteQuery;
    private javax.swing.JLabel cpfFuncionarioLbl;
    private javax.swing.JFormattedTextField cpfFuncionarioTxtFld;
    private javax.swing.JFormattedTextField custoHoraFuncionarioTxtFld;
    private javax.swing.JButton excluirFuncionarioButton;
    private javax.swing.JTextField idFuncionarioTxtFld;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton limparFuncionarioButton;
    private javax.swing.JTable listaFuncionarioTbl;
    private javax.swing.JLabel nomeFuncionarioLbl;
    private javax.swing.JTextField nomeFuncionarioTxtFld;
    private javax.swing.JLabel razaoSocialFuncionarioLbl;
    private javax.swing.JButton salvarFuncionarioButton;
    private javax.swing.JLabel tituloFuncionarioLbl;
    private javax.swing.JLabel titulotabelaFuncionarioLbl;
    // End of variables declaration//GEN-END:variables
}
