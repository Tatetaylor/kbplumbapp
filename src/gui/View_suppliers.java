/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import kbapp.classes.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ferrinsp
 */
public class View_suppliers extends javax.swing.JFrame {
    
    private Supplier currentSupplier;
    public Color genericColor = new Color(209, 220, 204);    
    private AlternatingListCellRenderer cellRenderer = new AlternatingListCellRenderer();
    
    
    // Declare and initialize list models for JLists
    private DefaultListModel<Supplier> supplierModel = new DefaultListModel<>(); // Blessed be the diamond operator
    
    // Declare and initialize lists 
    private List<Supplier> supplierList = new ArrayList<>(); 

    /**
     * Creates new form view_suppliers
     */
    public View_suppliers() {
        initComponents();
    }
    
    private void populateContactList(List<Supplier> list){
        supplierModel.clear();
        for(Supplier s: list){
            supplierModel.addElement(s);
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

        Main_Panel = new javax.swing.JPanel();
        TabbedView = new javax.swing.JTabbedPane();
        view_supplier_list = new javax.swing.JScrollPane();
        supplier = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        addSupplierButton = new javax.swing.JButton();
        updateSupplierButton = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        File_List = new javax.swing.JMenu();
        Print = new javax.swing.JMenuItem();
        Input_New_User_Button = new javax.swing.JMenuItem();
        Logout_Option = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabbedView.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "VendorID", "Company", "Contact", "Address", "City", "State", "Postal Code", "Phone", "Fax", "Terms"
            }
        ));
        view_supplier_list.setViewportView(supplier);
        if (supplier.getColumnModel().getColumnCount() > 0) {
            supplier.getColumnModel().getColumn(0).setHeaderValue("VendorID");
            supplier.getColumnModel().getColumn(1).setHeaderValue("Company");
            supplier.getColumnModel().getColumn(2).setHeaderValue("Contact");
            supplier.getColumnModel().getColumn(3).setHeaderValue("Address");
            supplier.getColumnModel().getColumn(4).setHeaderValue("City");
            supplier.getColumnModel().getColumn(5).setHeaderValue("State");
            supplier.getColumnModel().getColumn(6).setHeaderValue("Postal Code");
            supplier.getColumnModel().getColumn(7).setHeaderValue("Phone");
            supplier.getColumnModel().getColumn(8).setHeaderValue("Fax");
            supplier.getColumnModel().getColumn(9).setHeaderValue("Terms");
        }

        TabbedView.addTab("Suppliers", view_supplier_list);

        addSupplierButton.setText("Add Supplier");
        addSupplierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSupplierButtonActionPerformed(evt);
            }
        });

        updateSupplierButton.setText("Update Supplier");
        updateSupplierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSupplierButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addComponent(addSupplierButton)
                .addGap(38, 38, 38)
                .addComponent(updateSupplierButton)
                .addGap(211, 211, 211))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addSupplierButton)
                    .addComponent(updateSupplierButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Main_PanelLayout = new javax.swing.GroupLayout(Main_Panel);
        Main_Panel.setLayout(Main_PanelLayout);
        Main_PanelLayout.setHorizontalGroup(
            Main_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Main_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Main_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabbedView, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Main_PanelLayout.setVerticalGroup(
            Main_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Main_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabbedView, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        File_List.setText("File");

        Print.setLabel("Print");
        File_List.add(Print);

        Input_New_User_Button.setLabel("New User");
        File_List.add(Input_New_User_Button);

        MenuBar.add(File_List);

        Logout_Option.setLabel("Logout");
        MenuBar.add(Logout_Option);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Main_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Main_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addSupplierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSupplierButtonActionPerformed
        New_supplier addSupplier = new New_supplier();
        addSupplier.setVisible(true);
    }//GEN-LAST:event_addSupplierButtonActionPerformed

    private void updateSupplierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSupplierButtonActionPerformed
        New_supplier addSupplier = new New_supplier();
        addSupplier.setVisible(true);
    }//GEN-LAST:event_updateSupplierButtonActionPerformed

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
            java.util.logging.Logger.getLogger(View_suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_suppliers().setVisible(true);
            }
        });
    }
    
    public void displayCurrent(){
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu File_List;
    private javax.swing.JMenuItem Input_New_User_Button;
    private javax.swing.JMenu Logout_Option;
    private javax.swing.JPanel Main_Panel;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem Print;
    private javax.swing.JTabbedPane TabbedView;
    private javax.swing.JButton addSupplierButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable supplier;
    private javax.swing.JButton updateSupplierButton;
    private javax.swing.JScrollPane view_supplier_list;
    // End of variables declaration//GEN-END:variables
}
