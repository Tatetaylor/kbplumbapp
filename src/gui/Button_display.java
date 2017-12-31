/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author ferrinsp
 */
public class Button_display extends javax.swing.JFrame {

    /**
     * Creates new form button_display
     */
    public Button_display() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        view_purchase_order = new javax.swing.JButton();
        new_purchase_order = new javax.swing.JButton();
        view_suppliers = new javax.swing.JButton();
        update_suppliers = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        view_purchase_order.setText("View Purchase Order");
        view_purchase_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_purchase_orderActionPerformed(evt);
            }
        });

        new_purchase_order.setText("New Purchase Order");
        new_purchase_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_purchase_orderActionPerformed(evt);
            }
        });

        view_suppliers.setText("View Suppliers");
        view_suppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_suppliersActionPerformed(evt);
            }
        });

        update_suppliers.setText("Update Suppliers");
        update_suppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_suppliersActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/KBellLogo.png"))); // NOI18N
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/KBellLogo.png")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(view_suppliers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update_suppliers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(new_purchase_order))
                    .addComponent(view_purchase_order))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(view_purchase_order)
                        .addGap(18, 18, 18)
                        .addComponent(new_purchase_order)
                        .addGap(18, 18, 18)
                        .addComponent(view_suppliers)
                        .addGap(18, 18, 18)
                        .addComponent(update_suppliers))
                    .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void view_purchase_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_purchase_orderActionPerformed
        View_purchase_order viewPurchaseOrders = new View_purchase_order();
        viewPurchaseOrders.setVisible(true);
    }//GEN-LAST:event_view_purchase_orderActionPerformed

    private void new_purchase_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_purchase_orderActionPerformed
        New_purchase_order newPurchaseOrder = new New_purchase_order();
        newPurchaseOrder.setVisible(true);
    }//GEN-LAST:event_new_purchase_orderActionPerformed

    private void view_suppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_suppliersActionPerformed
        View_suppliers viewSuppliers = new View_suppliers();
        viewSuppliers.setVisible(true);
    }//GEN-LAST:event_view_suppliersActionPerformed

    private void update_suppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_suppliersActionPerformed
        Add_supplier updateSuppliers = new Add_supplier();
        updateSuppliers.setVisible(true);
    }//GEN-LAST:event_update_suppliersActionPerformed

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
            java.util.logging.Logger.getLogger(Button_display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Button_display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Button_display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Button_display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Button_display().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel logo;
    private javax.swing.JButton new_purchase_order;
    private javax.swing.JButton update_suppliers;
    private javax.swing.JButton view_purchase_order;
    private javax.swing.JButton view_suppliers;
    // End of variables declaration//GEN-END:variables
}
