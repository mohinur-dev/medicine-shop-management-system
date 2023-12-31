/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms.dashboard;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import pms.util.db;

/**
 *
 * @author Student
 */
public class InvoiceList extends javax.swing.JPanel {

    /**
     * Creates new form invoiceList
     */
    DefaultTableModel dtm;
    PreparedStatement pst;

    public InvoiceList() {
        initComponents();
        dtm = new DefaultTableModel(new String[]{"InvoiceNumber", "Date", "CustomerName", "Amount", "Invoice"}, 0);
        customersInvoice.setModel(dtm);
        customersInvoice.setShowGrid(true);
        getCustomerName();
        getInfoFromDatabase();
    }

    private void getCustomerName() {
        try {
            pst = db.get().prepareStatement("SELECT DISTINCT c_name FROM sales");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cmbCustomersList.addItem(rs.getString(1));
            }

        } catch (Exception e) {
            System.out.println("Can not get customer from database");
        }
    }

    private void getInfoFromDatabase() {
        try {
            pst = db.get().prepareStatement("SELECT invoice_no, s_date, c_name, payable, invoice FROM sales");
            ResultSet rs = pst.executeQuery();
            dtm.setRowCount(0);
            while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
                dtm.addRow(data);
            }

        } catch (Exception e) {
            System.out.println("Can not get informaton fro database");
        }
    }

    void filterInvoiceListByCustomerName() {
        try {
            pst = db.get().prepareStatement("SELECT invoice_no, s_date, c_name, payable, invoice FROM sales WHERE c_name = ?");
            pst.setString(1, cmbCustomersList.getSelectedItem().toString());
            ResultSet rs = pst.executeQuery();
            dtm.setRowCount(0);
            while (rs.next()) {
                Object[] customerInfo = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
                dtm.addRow(customerInfo);
            }
        } catch (SQLException e) {
            System.out.println("Filter failed");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        customersInvoice = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbCustomersList = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaInvoice = new javax.swing.JTextArea();
        btnPrintInvoice = new javax.swing.JButton();

        customersInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        customersInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customersInvoiceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customersInvoice);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Filter By customer Name : ");

        cmbCustomersList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbCustomersList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomersListActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer's Invoices");

        txaInvoice.setColumns(20);
        txaInvoice.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txaInvoice.setRows(5);
        jScrollPane4.setViewportView(txaInvoice);

        btnPrintInvoice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrintInvoice.setText("Print Invoice");
        btnPrintInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintInvoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbCustomersList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnPrintInvoice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCustomersList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrintInvoice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCustomersListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomersListActionPerformed
        // TODO add your handling code here:
        filterInvoiceListByCustomerName();
    }//GEN-LAST:event_cmbCustomersListActionPerformed

    private void btnPrintInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintInvoiceActionPerformed
        // TODO add your handling code here:
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");

        job.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                pf.setOrientation(PageFormat.LANDSCAPE);
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.47, 0.47);

                txaInvoice.print(g2);

                return Printable.PAGE_EXISTS;

            }
        });
        boolean ok = job.printDialog();
        if (ok) {
            try {

                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnPrintInvoiceActionPerformed

    private void customersInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customersInvoiceMouseClicked
        // TODO add your handling code here:

        txaInvoice.setText(dtm.getValueAt(customersInvoice.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_customersInvoiceMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrintInvoice;
    private javax.swing.JComboBox<String> cmbCustomersList;
    private javax.swing.JTable customersInvoice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea txaInvoice;
    // End of variables declaration//GEN-END:variables
}
