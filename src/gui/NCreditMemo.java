package gui;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class NCreditMemo extends javax.swing.JFrame {
    
    public Color genericColor = new Color(209, 220, 204);    
    private final AlternatingListCellRenderer cellRenderer;
    Connection connObj = null;
    Statement stateObj = null;
    ResultSet resultObj = null;

    public NCreditMemo() {
        this.cellRenderer = new AlternatingListCellRenderer();
        initComponents();
        getComboPO();
    }
    
    public void filter(){
        getPurchaseOrder(Integer.parseInt(ComboPO.getSelectedItem().toString()));
    }
    private void getComboPO() {
        try {
            //use your own username and login for the second and third parameters..I'll change this in the future to be dynamic
            connObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbell?useSSL=false", "admin", "1qaz2wsx");
            stateObj = connObj.createStatement();
            resultObj = stateObj.executeQuery("select orderid from purchaseorder where status not Like '%Completed%' ORDER BY orderid;");
            while (resultObj.next()){
                ComboPO.addItem(resultObj.getString("orderid"));
            }
            connObj.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void getPurchaseOrder(int id){
        try{
        //use your own username and login for the second and third parameters..I'll change this in the future to be dynamic
            connObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbell?useSSL=false", "admin", "1qaz2wsx");
            stateObj = connObj.createStatement();
            resultObj = stateObj.executeQuery("select pd.productDescription, s.companyname,  p.manufacturer, p.part_id, pod.orderqty,p.unitMeasure,p.price, po.total  from  purchaseorder po inner join purchaseorderdetails pod on po.orderid = pod.orderid "
                    + "inner join product p on p.id = pod.product inner join productdescription pd on pd.pdescID=p.description inner join supplier s on s.supplierid=p.supplier where po.orderid ="+id+";"); 
            purchaseOrderItemTable.setModel(DbUtils.resultSetToTableModel(resultObj));
            purchaseOrderItemTable.getColumn("productDescription").setHeaderValue("Product Description");
            purchaseOrderItemTable.getColumn("companyname").setHeaderValue("Supplier");
            purchaseOrderItemTable.getColumn("unitMeasure").setHeaderValue("Unit");
            purchaseOrderItemTable.getColumn("manufacturer").setHeaderValue("MFC");
            purchaseOrderItemTable.getColumn("part_id").setHeaderValue("Part Number");
            purchaseOrderItemTable.getColumn("orderqty").setHeaderValue("Qty Ordered");
            purchaseOrderItemTable.getColumn("price").setHeaderValue("Unit Price");
            purchaseOrderItemTable.getColumn("total").setHeaderValue("Total");
            purchaseOrderItemTable.repaint();
            connObj.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(NUItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void insertCreditMemo(){
        try {
            //use your own username and login for the second and third parameters..I'll change this in the future to be dynamic
            connObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbell?useSSL=false", "admin", "1qaz2wsx");
            String query = "INSERT into creditmemo (memoid, poid, supplier, job, tax, total, createdby, created, comments) values(?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStmt =connObj.prepareStatement(query);
            //Get items to insert here!!!!!
            System.out.println("I need data!!!");
            preparedStmt.execute();
        connObj.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
      
        //generate CreditMemo Report
        try { 
            int memoid = -1;
            stateObj = connObj.createStatement();
            resultObj = stateObj.executeQuery("select max(memoid) as 'id' from creditmemo;");
            while (resultObj.next()){
                memoid=resultObj.getInt("id");
            }
            
            //FileInputStream fis = new FileInputStream("C:\\Users\\ferrinsp\\Documents\\GitHub\\kbplumbapp\\src\\Reports\\PO.jrxml");            
            FileInputStream fis = new FileInputStream("C:/Users/tatewtaylor/Documents/NetbeansProjects/KBApp/src/Reports/CreditMemo.jrxml");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
            connObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbell?useSSL=false", "admin", "1qaz2wsx");

            //set parameters
            Map map = new HashMap();
            map.put("memoid", memoid);
            //compile report
            JasperReport jasperReport = (JasperReport) JasperCompileManager.compileReport(bufferedInputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, connObj);
            //view report to UI
            JasperViewer.viewReport(jasperPrint, false);                   
        } catch (FileNotFoundException | SQLException | JRException ex) {
            Logger.getLogger(PreviewPurchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseOrderItemTable = new javax.swing.JTable();
        IssueCreditMemo = new javax.swing.JButton();
        ComboPO = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Credit Memo");

        purchaseOrderItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "Company Name", "Manufacturer", "Part ID", "Ordered Qty", "Unit Measure", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        purchaseOrderItemTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(purchaseOrderItemTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        IssueCreditMemo.setText("Issue Credit Memo");
        IssueCreditMemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IssueCreditMemoActionPerformed(evt);
            }
        });

        ComboPO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active Purchase Orders" }));
        ComboPO.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboPOItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IssueCreditMemo)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboPO, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ComboPO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(IssueCreditMemo)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void issueCreditMemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueCreditMemoActionPerformed
        if(purchaseOrderItemTable.getRowCount()==0) {
            JOptionPane.showMessageDialog(null, "No items added for Purchase Order."); 
        }
        else {
            insertCreditMemo(); 
        }
    }//GEN-LAST:event_issueCreditMemoActionPerformed

    private void ComboPOItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboPOItemStateChanged
        if (!(ComboPO.getSelectedItem().equals("Active Purchase Orders")))
            filter();
    }//GEN-LAST:event_ComboPOItemStateChanged

    private void IssueCreditMemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssueCreditMemoActionPerformed
        if(purchaseOrderItemTable.getRowCount()==0)
            JOptionPane.showMessageDialog(null, "No items added for Purchase Order.");
        else
            insertCreditMemo();
    }//GEN-LAST:event_IssueCreditMemoActionPerformed

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
            java.util.logging.Logger.getLogger(NCreditMemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new NCreditMemo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboPO;
    private javax.swing.JButton IssueCreditMemo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable purchaseOrderItemTable;
    // End of variables declaration//GEN-END:variables
}
