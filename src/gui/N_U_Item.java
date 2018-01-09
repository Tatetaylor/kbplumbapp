/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ferrinsp
 */
public class N_U_Item extends javax.swing.JFrame {
    
    Connection connObj = null;
    Statement stateObj = null;
    ResultSet resultObj = null;
    String [][] supplier = null;
    String [][] category = null;
    
    private void getComboSupplier() {
        try {
            //use your own username and login for the second and third parameters..I'll change this in the future to be dynamic
            connObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbell?useSSL=false", "admin", "1qaz2wsx");
            stateObj = connObj.createStatement();
            resultObj = stateObj.executeQuery("select supplierid, companyname from supplier ORDER BY companyname;");
            //Dynamically set supplier list size
            resultObj.last();
            supplier = new String[resultObj.getRow()][2];
            resultObj.beforeFirst();
            int i=0;
            while (resultObj.next()){
                supplier[i][0] =Integer.toString(resultObj.getInt("supplierid"));
                supplier[i][1]=resultObj.getString("companyname");
                SupplierCombo.addItem(resultObj.getString("companyname"));
                i++;
            }
            connObj.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void getComboCategory() {
        try {
            //use your own username and login for the second and third parameters..I'll change this in the future to be dynamic
            connObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbell?useSSL=false", "admin", "1qaz2wsx");
            stateObj = connObj.createStatement();
            resultObj = stateObj.executeQuery("select category_ID, description from category ORDER BY description;");
            //Dynamically set supplier list size
            resultObj.last();
            category = new String[resultObj.getRow()][2];
            resultObj.first();
            int i=0;
            while (resultObj.next()){
                category[i][0] =Integer.toString(resultObj.getInt("category_ID"));
                category[i][1]=resultObj.getString("description");
                i++;
                CategoryCombo.addItem(resultObj.getString("description"));
            }
            connObj.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    public void insertProduct() {
        try {
        //use your own username and login for the second and third parameters..I'll change this in the future to be dynamic
        connObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbell?useSSL=false", "admin", "1qaz2wsx");
        String query = "INSERT into product (category_id,description,part_id,manufacturer,supplier,price,size)"
                + "values(?,?,?,?,?,?,?)";
        //Get Values to insert
        PreparedStatement preparedStmt =connObj.prepareStatement(query);
        //May want a drop down for this
        //preparedStmt.setInt    (1, Integer.parseInt(category.getText()));
        preparedStmt.setString (2, description.getText());
        preparedStmt.setString (3, partNumTextField.getText());
        preparedStmt.setString (4, mfcTextField.getText());
        //May need to update to have dropdown for this
        //preparedStmt.setInt    (5, Integer.parseInt(supplierTextField.getText()));
        preparedStmt.setInt    (6, Integer.parseInt(priceTextField.getText()));
        preparedStmt.setString (7, sizeTextField.getText());
        preparedStmt.execute();
      
        connObj.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates new form NewProduct
     */
    public N_U_Item() {
        this.setResizable(false);
        initComponents();
        getComboSupplier();
        getComboCategory();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        descriptionLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        supplierLabel = new javax.swing.JLabel();
        mfcLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        description = new javax.swing.JTextField();
        mfcTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        sizeTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        addNewItem = new javax.swing.JButton();
        cancelAdd = new javax.swing.JButton();
        partLabel = new javax.swing.JLabel();
        partNumTextField = new javax.swing.JTextField();
        SupplierCombo = new javax.swing.JComboBox<>();
        CategoryCombo = new javax.swing.JComboBox<>();
        sizeLabel1 = new javax.swing.JLabel();
        unitMeasure = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        descriptionLabel.setText("Description");

        categoryLabel.setText("Category");

        supplierLabel.setText("Supplier");

        mfcLabel.setText("Manufacturer");

        priceLabel.setText("Price");

        sizeLabel.setText("Size");

        description.setText("Description");

        mfcTextField.setText("Manufacturer");

        priceTextField.setText("Price");

        sizeTextField.setText("Size");

        addNewItem.setText("Add Item");
        addNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewItemActionPerformed(evt);
            }
        });

        cancelAdd.setText("Cancel");
        cancelAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(addNewItem)
                .addGap(45, 45, 45)
                .addComponent(cancelAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewItem)
                    .addComponent(cancelAdd))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        partLabel.setText("Part Number");

        partNumTextField.setText("Part Number");

        SupplierCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Supplier" }));

        CategoryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Category" }));

        sizeLabel1.setText("Unit of Measure");

        unitMeasure.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bndl", "Box", "Ea", "Ft", "Lift", "Roll" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(sizeLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sizeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mfcLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(descriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(categoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(partLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SupplierCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceTextField)
                    .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(mfcTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(partNumTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(sizeTextField)
                    .addComponent(CategoryCombo, 0, 299, Short.MAX_VALUE)
                    .addComponent(unitMeasure, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(178, 178, 178))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLabel)
                    .addComponent(CategoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionLabel)
                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(partLabel)
                    .addComponent(partNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mfcLabel)
                    .addComponent(mfcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(supplierLabel)
                    .addComponent(SupplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sizeLabel)
                    .addComponent(sizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeLabel1)
                    .addComponent(unitMeasure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Add New Item", jPanel1);

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane2.addTab("Current Items", jScrollPane1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelAddActionPerformed

    private void addNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewItemActionPerformed
        insertProduct();
        // TODO add your handling code here:
    }//GEN-LAST:event_addNewItemActionPerformed

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
            java.util.logging.Logger.getLogger(N_U_Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(N_U_Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(N_U_Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(N_U_Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new N_U_Item().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CategoryCombo;
    private javax.swing.JComboBox<String> SupplierCombo;
    private javax.swing.JButton addNewItem;
    private javax.swing.JButton cancelAdd;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JTextField description;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel mfcLabel;
    private javax.swing.JTextField mfcTextField;
    private javax.swing.JLabel partLabel;
    private javax.swing.JTextField partNumTextField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JLabel sizeLabel1;
    private javax.swing.JTextField sizeTextField;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JComboBox<String> unitMeasure;
    // End of variables declaration//GEN-END:variables
}
