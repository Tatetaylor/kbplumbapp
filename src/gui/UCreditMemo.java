package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class UCreditMemo extends javax.swing.JFrame {
    
    Connection connObj = null;
    Statement stateObj = null;
    ResultSet resultObj = null;
    int memoid;
    
    public UCreditMemo() {
        initComponents();
        selectCreditMemo();
    }
    
    public UCreditMemo(int memoid) {
        this.memoid = memoid;
        initComponents();
        selectCreditMemo();
    }
    private void selectCreditMemo(){
        try{
            connObj = DriverManager.getConnection("jdbc:mysql://192.168.1.10:3306/kbellplumb?useSSL=false", "admin", "1qaz2wsx");
            stateObj = connObj.createStatement();
            stateObj = connObj.createStatement();
            resultObj = stateObj.executeQuery("select cmd.detailid,pd.productDescription, cmd.qty,cmd.cost,cmd.total from creditmemo cm\n" +
"inner join creditmemodetail cmd on cmd.creditmemoid=cm.memoid inner join product p on p.id=cmd.product \n" +
"inner join productdescription pd on pd.pdescID=p.description where cm.memoid="+memoid+";"); 
            itemTable.setModel(DbUtils.resultSetToTableModel(resultObj));
            itemTable.getColumn("detailid").setHeaderValue("ID");
            itemTable.getColumn("productDescription").setHeaderValue("Description");
            itemTable.getColumn("qty").setHeaderValue("Qty");
            itemTable.getColumn("cost").setHeaderValue("Unit Price");
            itemTable.getColumn("total").setHeaderValue("Total");
            itemTable.repaint();
            resultObj = stateObj.executeQuery("select cm.poid,s.companyname, j.name, cm.tax,cm.total ,u.name as 'user', cm.status, cm.created\n" +
"                from creditmemo cm inner join supplier s on s.supplierid=cm.supplier inner join user u on u.userid=cm.createdby\n" +
"                inner join job j on j.jobid=cm.job where cm.memoid="+memoid+";");
    
            Date d;
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            while (resultObj.next()){
                purchaseOrderTextField.setText(Integer.toString(resultObj.getInt("poid")));
                supplierTextField.setText(resultObj.getString("companyname"));
                createdByTextField.setText(resultObj.getString("user"));
                jobTextField.setText(resultObj.getString("name"));
                totalTextField.setText(Double.toString(resultObj.getDouble("total")));
                taxTextField.setText(Double.toString(resultObj.getDouble("tax")));
                d= resultObj.getDate("created");
                createdDateField.setText(df.format(d));
                commentsTextArea.setText("");
            }
                connObj.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void updateCreditMemo() {
        try {
            //use your own username and login for the second and third parameters..I'll change this in the future to be dynamic
            connObj = DriverManager.getConnection("jdbc:mysql://192.168.1.10:3306/kbellplumb?useSSL=false", "admin", "1qaz2wsx");
            String query = "UPDATE creditmemo set status=?, comments=? where memoid = " + memoid + ";";
            PreparedStatement preparedStmt =connObj.prepareStatement(query);
            String creditMemoStatus= null;
                for (Enumeration<AbstractButton> buttons = statusButtons.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        creditMemoStatus = button.getText();
                    }
                }
            preparedStmt.setString (1, creditMemoStatus);
            preparedStmt.setString (2, commentsTextArea.getText());
            preparedStmt.executeUpdate();
            connObj.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }                                              
    
    private void changeStatusToDeleted() {
        try {
            //use your own username and login for the second and third parameters..I'll change this in the future to be dynamic
            connObj = DriverManager.getConnection("jdbc:mysql://192.168.1.10:3306/kbellplumb?useSSL=false", "admin", "1qaz2wsx");
            String query = "UPDATE creditmemo SET status = 'Deleted' where memoid = " + memoid + ";";
            PreparedStatement preparedStmt =connObj.prepareStatement(query);
            preparedStmt.executeUpdate();
            connObj.close();
        } catch (SQLException ex) {    
            Logger.getLogger(NSupplier.class.getName()).log(Level.SEVERE, null, ex);
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

        statusButtons = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        purchaseOrderTextField = new javax.swing.JTextField();
        jobTextField = new javax.swing.JTextField();
        supplierTextField = new javax.swing.JTextField();
        taxTextField = new javax.swing.JTextField();
        puchaseOrderLabel = new javax.swing.JLabel();
        supplierLabel = new javax.swing.JLabel();
        jobLabel = new javax.swing.JLabel();
        taxLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        totalTextField = new javax.swing.JTextField();
        createdByLabel = new javax.swing.JLabel();
        createdByTextField = new javax.swing.JTextField();
        createdDateLabel = new javax.swing.JLabel();
        commentsLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        issuedStatusButton = new javax.swing.JRadioButton();
        completedStatusButton = new javax.swing.JRadioButton();
        createdDateField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentsTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        updateCreditMemoButton = new javax.swing.JButton();
        deleteCreditMemo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update Credit Memo");

        purchaseOrderTextField.setEditable(false);
        purchaseOrderTextField.setText("Purchase Order #");

        jobTextField.setEditable(false);
        jobTextField.setText("Job");

        supplierTextField.setEditable(false);
        supplierTextField.setText("Supplier");

        taxTextField.setEditable(false);
        taxTextField.setText("Tax");

        puchaseOrderLabel.setText("Purchase Order #:");

        supplierLabel.setText("Supplier:");

        jobLabel.setText("Job:");

        taxLabel.setText("Tax:");

        totalLabel.setText("Total:");

        totalTextField.setEditable(false);
        totalTextField.setText("Total");

        createdByLabel.setText("Created By: ");

        createdByTextField.setEditable(false);
        createdByTextField.setText("Created By");

        createdDateLabel.setText("Created Date:");

        commentsLabel.setText("Comments:");

        jLabel1.setText("Status:");

        statusButtons.add(issuedStatusButton);
        issuedStatusButton.setSelected(true);
        issuedStatusButton.setText("Issued");

        statusButtons.add(completedStatusButton);
        completedStatusButton.setText("Completed");

        createdDateField.setEditable(false);
        createdDateField.setText("Created Date");

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Description", "Ordered Qty", "Unit Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(itemTable);

        commentsTextArea.setColumns(20);
        commentsTextArea.setRows(5);
        jScrollPane1.setViewportView(commentsTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(commentsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(issuedStatusButton)
                                .addGap(18, 18, 18)
                                .addComponent(completedStatusButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(supplierLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(taxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jobTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(supplierTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                            .addComponent(taxTextField)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(createdDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(createdDateField))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(createdByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(createdByTextField))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(totalTextField))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(puchaseOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(purchaseOrderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchaseOrderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puchaseOrderLabel))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplierTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplierLabel))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobLabel))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taxLabel)
                    .addComponent(taxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalLabel))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createdByLabel)
                    .addComponent(createdByTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createdDateLabel)
                    .addComponent(createdDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(issuedStatusButton)
                    .addComponent(completedStatusButton))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commentsLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        updateCreditMemoButton.setText("Update Credit Memo");
        updateCreditMemoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCreditMemoButtonActionPerformed(evt);
            }
        });

        deleteCreditMemo.setText("Delete Credit Memo");
        deleteCreditMemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCreditMemoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteCreditMemo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateCreditMemoButton)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateCreditMemoButton)
                    .addComponent(deleteCreditMemo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateCreditMemoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCreditMemoButtonActionPerformed
        updateCreditMemo();
        JOptionPane.showMessageDialog(null, "Credit Memo # "+memoid+" was updated.");
        this.dispose();
    }//GEN-LAST:event_updateCreditMemoButtonActionPerformed

    private void deleteCreditMemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCreditMemoActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Do you want to delete this credit memo?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION) {
            changeStatusToDeleted();
            JOptionPane.showMessageDialog(null, "Credit Memo Deleted");
            this.dispose(); 
        } else if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "No action performed");
        }
    }//GEN-LAST:event_deleteCreditMemoActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UCreditMemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new UCreditMemo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel commentsLabel;
    private javax.swing.JTextArea commentsTextArea;
    private javax.swing.JRadioButton completedStatusButton;
    private javax.swing.JLabel createdByLabel;
    private javax.swing.JTextField createdByTextField;
    private javax.swing.JTextField createdDateField;
    private javax.swing.JLabel createdDateLabel;
    private javax.swing.JButton deleteCreditMemo;
    private javax.swing.JRadioButton issuedStatusButton;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jobLabel;
    private javax.swing.JTextField jobTextField;
    private javax.swing.JLabel puchaseOrderLabel;
    private javax.swing.JTextField purchaseOrderTextField;
    private javax.swing.ButtonGroup statusButtons;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JTextField supplierTextField;
    private javax.swing.JLabel taxLabel;
    private javax.swing.JTextField taxTextField;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalTextField;
    private javax.swing.JButton updateCreditMemoButton;
    // End of variables declaration//GEN-END:variables
}
