package gui;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReprintReports extends javax.swing.JFrame {

    Connection connObj = null;
    Statement stateObj = null;
    ResultSet resultObj = null;
    
    public ReprintReports() {
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

        jPanel1 = new javax.swing.JPanel();
        poPrintButton = new javax.swing.JButton();
        cmPrintButton = new javax.swing.JButton();
        poNumberTextField = new javax.swing.JTextField();
        cmNumberTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reprint Reports");

        poPrintButton.setText("Print Purchase Order");
        poPrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poPrintButtonActionPerformed(evt);
            }
        });

        cmPrintButton.setText("Print Credit Memo");
        cmPrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmPrintButtonActionPerformed(evt);
            }
        });

        poNumberTextField.setText("Purchase Order #");
        poNumberTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                poNumberTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                poNumberTextFieldFocusLost(evt);
            }
        });

        cmNumberTextField.setText("Credit Memo #");
        cmNumberTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmNumberTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmNumberTextFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmNumberTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(poNumberTextField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(poPrintButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmPrintButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poPrintButton)
                    .addComponent(poNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmPrintButton)
                    .addComponent(cmNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void poPrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poPrintButtonActionPerformed
        String poid = poNumberTextField.getText();
        try {
            //Generate Report
            InputStream is = getClass().getResourceAsStream("/Reports/PO.jrxml");
            JasperDesign jd= JRXmlLoader.load(is);
            connObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbell?useSSL=false", "admin", "1qaz2wsx");

            //set parameters
            Map map = new HashMap();
            map.put("orderid", Integer.parseInt(poid));
            //compile report
            JasperReport jasperReport = JasperCompileManager.compileReport(jd);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, connObj);
            //view report to UI
            JasperViewer.viewReport(jasperPrint, false);                   
        } catch (SQLException | JRException ex) {
            Logger.getLogger(PreviewPurchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose();
    }//GEN-LAST:event_poPrintButtonActionPerformed

    private void cmPrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmPrintButtonActionPerformed
        String memoid = cmNumberTextField.getText();
        try {
            //Generate Report
            InputStream is = getClass().getResourceAsStream("/Reports/CreditMemo.jrxml");
            JasperDesign jd= JRXmlLoader.load(is);
            connObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbell?useSSL=false", "admin", "1qaz2wsx");

            //set parameters
            Map map = new HashMap();
            map.put("memoid", Integer.parseInt(memoid));
            //compile report
            JasperReport jasperReport = JasperCompileManager.compileReport(jd);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, connObj);
            //view report to UI
            JasperViewer.viewReport(jasperPrint, false);                   
        } catch (SQLException | JRException ex) {
            Logger.getLogger(PreviewPurchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_cmPrintButtonActionPerformed

    private void poNumberTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_poNumberTextFieldFocusGained
        poNumberTextField.setText("");
    }//GEN-LAST:event_poNumberTextFieldFocusGained

    private void cmNumberTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmNumberTextFieldFocusGained
        cmNumberTextField.setText("");
    }//GEN-LAST:event_cmNumberTextFieldFocusGained

    private void poNumberTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_poNumberTextFieldFocusLost
        if(poNumberTextField.getText().equals(""))
            poNumberTextField.setText("Purchase Order #");
    }//GEN-LAST:event_poNumberTextFieldFocusLost

    private void cmNumberTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmNumberTextFieldFocusLost
        if(cmNumberTextField.getText().equals(""))
            cmNumberTextField.setText("Credit Memo #");
    }//GEN-LAST:event_cmNumberTextFieldFocusLost

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
            java.util.logging.Logger.getLogger(ReprintReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new ReprintReports().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cmNumberTextField;
    private javax.swing.JButton cmPrintButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField poNumberTextField;
    private javax.swing.JButton poPrintButton;
    // End of variables declaration//GEN-END:variables
}
