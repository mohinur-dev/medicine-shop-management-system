package pms.dashboard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import pms.customer.ViewCustomer;
import pms.product.ViewProduct;
import pms.supplier.ViewSupplier;
import pms.util.db;
import pms.util.jPanelLoader;

/**
 *
 * @author Student
 */
public class ShortDateStock extends javax.swing.JPanel {

    /**
     * Creates new form ShortDateStock
     */
    jPanelLoader jpl;
    
    PreparedStatement pst;
    DefaultTableModel dtmShortDate;
    DefaultTableModel dtmShortStock;

    public ShortDateStock() {
        initComponents();
        jpl = new jPanelLoader();
        getProductCount();
        getSupplierCount();
        getCustomerCount();
        getTotalSaleCount();
        getSaleAmountCount();

        dtmShortDate = new DefaultTableModel(new String[]{"Name", "Generic", "Stock", "Validity"}, 0);
        jTshortDate.setModel(dtmShortDate);
        jTshortDate.setShowGrid(true);

        dtmShortStock = new DefaultTableModel(new String[]{"Name", "Genetic", "Stock", "Supplier"}, 0);
        jTshortStock.setModel(dtmShortStock);
        jTshortStock.setShowGrid(true);

        getProductGenericFromDB();
        getProductSupplierFromDB();

        getShortDateProduct();
        getShortStockProduct();

    }

    private void getProductCount() {
        try {
            pst = db.get().prepareStatement("SELECT COUNT(p_id) FROM product");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                lblTotalProduct.setText(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("A");
        }
    }

    private void getSupplierCount() {
        try {
            pst = db.get().prepareStatement("SELECT COUNT(s_id) FROM supplier");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                lblTotalSupplier.setText(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("B");
        }
    }

    private void getCustomerCount() {
        try {
            pst = db.get().prepareStatement("SELECT COUNT(c_id) FROM customer");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                lblTotalCustomer.setText(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("C");
        }
    }

    private void getTotalSaleCount() {
        try {
            pst = db.get().prepareStatement("SELECT COUNT(DISTINCT invoice_no) FROM sales");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                lblTotalSaleCount.setText(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("d");
        }
    }

    private void getSaleAmountCount() {
        try {
            pst = db.get().prepareStatement("SELECT ROUND(SUM(n_sale)) FROM sales");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                lblTotalSaleAmount.setText(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("E");
        }
    }

    private void getProductGenericFromDB() {
        try {
            pst = db.get().prepareStatement("SELECT DISTINCT p_generic FROM product");
            ResultSet rs = pst.executeQuery();
            filterGeneric.removeAllItems();
            while (rs.next()) {
                filterGeneric.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("F");

        }

    }

    private void getProductSupplierFromDB() {
        try {
            pst = db.get().prepareStatement("SELECT DISTINCT p_manufecturer FROM product");
            ResultSet rs = pst.executeQuery();
            filterManufecturer.removeAllItems();
            while (rs.next()) {
                filterManufecturer.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("G");
        }
    }

    void getShortDateProduct() {
        try {
            pst = db.get().prepareStatement("SELECT full_name, p_generic, p_stock, DATEDIFF(exp_date, curdate()) AS validity FROM product WHERE DATEDIFF(exp_date, curdate()) < 100");
            ResultSet rs = pst.executeQuery();

            dtmShortDate.setRowCount(0);
            while (rs.next()) {
                Object[] shortDateProduct = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                dtmShortDate.addRow(shortDateProduct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    void filterShortDateProduct() {
        try {

            pst = db.get().prepareStatement("SELECT full_name, p_generic, p_stock, DATEDIFF(exp_date, curdate()) AS validity FROM product WHERE DATEDIFF(exp_date, curdate()) < 100 AND p_generic = ?");
            pst.setString(1, filterGeneric.getSelectedItem().toString());
            ResultSet rs = pst.executeQuery();

            dtmShortDate.setRowCount(0);
            while (rs.next()) {
                Object[] shortDateProduct = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                dtmShortDate.addRow(shortDateProduct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    void getShortStockProduct() {
        try {
            pst = db.get().prepareStatement("SELECT full_name, p_generic, p_stock, p_manufecturer FROM product WHERE p_stock < 10");
            ResultSet rs = pst.executeQuery();

            dtmShortStock.setRowCount(0);
            while (rs.next()) {
                Object[] shortDateProduct = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                dtmShortStock.addRow(shortDateProduct);
            }
        } catch (Exception e) {
            System.out.println("getshortStockProduct");
        }
    }
    
        void filterShortStockProduct() {
        try {
            pst = db.get().prepareStatement("SELECT full_name, p_generic, p_stock, p_manufecturer FROM product WHERE p_stock < 10 AND p_manufecturer = ?");
            pst.setString(1, filterManufecturer.getSelectedItem().toString());
            ResultSet rs = pst.executeQuery();
            dtmShortStock.setRowCount(0);
            while (rs.next()) {
                Object[] shortDateProduct = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                dtmShortStock.addRow(shortDateProduct);
            }
        } catch (Exception e) {
            System.out.println("getshortStockProduct");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        totalProduct = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTotalProduct = new javax.swing.JLabel();
        totalSupplier = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblTotalSupplier = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblTotalCustomer = new javax.swing.JLabel();
        totalSaleCount = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblTotalSaleCount = new javax.swing.JLabel();
        totalSaleAmount = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblTotalSaleAmount = new javax.swing.JLabel();
        homePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTshortDate = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTshortStock = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        filterManufecturer = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        filterGeneric = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        totalProduct.setBackground(new java.awt.Color(255, 255, 255));
        totalProduct.setPreferredSize(new java.awt.Dimension(190, 100));
        totalProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalProductMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Products");

        lblTotalProduct.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTotalProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout totalProductLayout = new javax.swing.GroupLayout(totalProduct);
        totalProduct.setLayout(totalProductLayout);
        totalProductLayout.setHorizontalGroup(
            totalProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addContainerGap())
        );
        totalProductLayout.setVerticalGroup(
            totalProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalProductLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTotalProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        totalSupplier.setBackground(new java.awt.Color(255, 255, 255));
        totalSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalSupplierMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Suppliers");

        lblTotalSupplier.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTotalSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout totalSupplierLayout = new javax.swing.GroupLayout(totalSupplier);
        totalSupplier.setLayout(totalSupplierLayout);
        totalSupplierLayout.setHorizontalGroup(
            totalSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(lblTotalSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        totalSupplierLayout.setVerticalGroup(
            totalSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalSupplierLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTotalSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Customers");

        lblTotalCustomer.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTotalCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(lblTotalCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTotalCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        totalSaleCount.setBackground(new java.awt.Color(255, 255, 255));
        totalSaleCount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalSaleCountMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sales Count");

        lblTotalSaleCount.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTotalSaleCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout totalSaleCountLayout = new javax.swing.GroupLayout(totalSaleCount);
        totalSaleCount.setLayout(totalSaleCountLayout);
        totalSaleCountLayout.setHorizontalGroup(
            totalSaleCountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalSaleCountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalSaleCountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(lblTotalSaleCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        totalSaleCountLayout.setVerticalGroup(
            totalSaleCountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalSaleCountLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTotalSaleCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        totalSaleAmount.setBackground(new java.awt.Color(255, 255, 255));
        totalSaleAmount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalSaleAmountMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sales Amount");

        lblTotalSaleAmount.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTotalSaleAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout totalSaleAmountLayout = new javax.swing.GroupLayout(totalSaleAmount);
        totalSaleAmount.setLayout(totalSaleAmountLayout);
        totalSaleAmountLayout.setHorizontalGroup(
            totalSaleAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalSaleAmountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalSaleAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(lblTotalSaleAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        totalSaleAmountLayout.setVerticalGroup(
            totalSaleAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalSaleAmountLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTotalSaleAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(totalProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(totalSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(totalSaleCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(totalSaleAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalSaleCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalSaleAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        homePanel.setBackground(new java.awt.Color(204, 204, 204));
        homePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTshortDate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTshortDate);

        homePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 500, 400));

        jTshortStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTshortStock);

        homePanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 500, 400));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Short Stock Product");
        homePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Short Date Product");
        homePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Filter :");
        homePanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 60, -1));

        filterManufecturer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        filterManufecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterManufecturerActionPerformed(evt);
            }
        });
        homePanel.add(filterManufecturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 410, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Filter :");
        homePanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 60, -1));

        filterGeneric.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        filterGeneric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterGenericActionPerformed(evt);
            }
        });
        homePanel.add(filterGeneric, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 410, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(homePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterManufecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterManufecturerActionPerformed
        filterShortStockProduct();
    }//GEN-LAST:event_filterManufecturerActionPerformed

    private void filterGenericActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterGenericActionPerformed
        filterShortDateProduct();
    }//GEN-LAST:event_filterGenericActionPerformed

    private void totalSaleCountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalSaleCountMouseClicked
        // TODO add your handling code here:
        InvoiceList invoiceList = new InvoiceList();
        jpl.jPanelLoader(homePanel, invoiceList);
        
        
    }//GEN-LAST:event_totalSaleCountMouseClicked

    private void totalProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalProductMouseClicked
        // TODO add your handling code here:
        ViewProduct viewProduct = new ViewProduct();
        jpl.jPanelLoader(homePanel, viewProduct);
    }//GEN-LAST:event_totalProductMouseClicked

    private void totalSaleAmountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalSaleAmountMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_totalSaleAmountMouseClicked

    private void totalSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalSupplierMouseClicked
        // TODO add your handling code here:
        ViewSupplier viewSupplier = new ViewSupplier();
        jpl.jPanelLoader(homePanel, viewSupplier);
    }//GEN-LAST:event_totalSupplierMouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        ViewCustomer viewCustomer = new ViewCustomer();
        jpl.jPanelLoader(homePanel, viewCustomer);
    }//GEN-LAST:event_jPanel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> filterGeneric;
    private javax.swing.JComboBox<String> filterManufecturer;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTshortDate;
    private javax.swing.JTable jTshortStock;
    private javax.swing.JLabel lblTotalCustomer;
    private javax.swing.JLabel lblTotalProduct;
    private javax.swing.JLabel lblTotalSaleAmount;
    private javax.swing.JLabel lblTotalSaleCount;
    private javax.swing.JLabel lblTotalSupplier;
    private javax.swing.JPanel totalProduct;
    private javax.swing.JPanel totalSaleAmount;
    private javax.swing.JPanel totalSaleCount;
    private javax.swing.JPanel totalSupplier;
    // End of variables declaration//GEN-END:variables
}
