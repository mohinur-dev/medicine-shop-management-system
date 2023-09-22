package pms.product;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pms.dashboard.HomePage;
import pms.util.db;
import pms.util.jPanelLoader;

public class AddProduct extends javax.swing.JPanel {

    String id, dogesFrom, pName, strength, pGeneric, manufecturedBy, pGroup, order, mpp, mrp, quantity, addedBy;
    java.sql.Date mfgDate;
    java.sql.Date expDate;
    jPanelLoader jpl;
    PreparedStatement pst;
    ResultSet rs;

    public AddProduct() {
        initComponents();
        genarateProductId();
        getManufectureartem();
    }

    private void getProductInfo() {
        id = txfP_id.getText();
        dogesFrom = cmbP_dogesfrom.getSelectedItem().toString();
        pName = txfP_name.getText();
        strength = txfP_strength.getText();
        pGeneric = txfP_generic.getText();
        manufecturedBy = cmbP_manufecturer.getSelectedItem().toString();
        pGroup = cmbP_group.getSelectedItem().toString();
        order = txfP_order.getText();
        mpp = txfP_mpp.getText();
        mrp = txfP_mrp.getText();
        mfgDate = new java.sql.Date(dateP_mfg.getDate().getTime());
        expDate = new java.sql.Date(dateP_exp.getDate().getTime());
        quantity = txfP_quantity.getText();
        addedBy = txfP_addedby.getText();
    }

    private void genarateProductId() {
        try {
            pst = db.get().prepareStatement("SELECT p_id FROM product ORDER BY p_id DESC LIMIT 1");
            ResultSet re = pst.executeQuery();
            while (re.next()) {
                int productId = re.getInt(1) + 1;
                txfP_id.setText(String.valueOf(productId));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void getManufectureartem() {
        try {
            pst = db.get().prepareStatement("SELECT s_name FROM supplier");
            rs = pst.executeQuery();
            while (rs.next()) {
                cmbP_manufecturer.addItem(rs.getString(1));
            }
        } catch (SQLException e) {

        }

    }

    private void resetField() {
        genarateProductId();
        cmbP_dogesfrom.setSelectedIndex(0);
        txfP_name.setText("");
        txfP_strength.setText("");
        txfP_generic.setText("");
        cmbP_manufecturer.setSelectedIndex(0);
        cmbP_group.setSelectedIndex(0);
        txfP_order.setText("");
        txfP_mpp.setText("");
        txfP_mrp.setText("");
        dateP_mfg.setDate(null);
        dateP_exp.setDate(null);
        txfP_quantity.setText("");
        txfP_addedby.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txfP_mrp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAddProduct = new javax.swing.JButton();
        txfP_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfP_name = new javax.swing.JTextField();
        txfP_strength = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txfP_mpp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txfP_generic = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnProductReset = new javax.swing.JButton();
        dateP_mfg = new com.toedter.calendar.JDateChooser();
        dateP_exp = new com.toedter.calendar.JDateChooser();
        cmbP_dogesfrom = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txfP_quantity = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmbP_group = new javax.swing.JComboBox<>();
        txfP_addedby = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txfP_order = new javax.swing.JTextField();
        cmbP_manufecturer = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txfP_Manufacturer = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Add Product");

        txfP_mrp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txfP_mrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfP_mrpActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("MRP(Units) :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("MFG. Date :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("EXP. Date :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Product ID :");

        btnAddProduct.setText("AddProduct");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        txfP_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Doges From :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Brand Nmae :");

        txfP_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txfP_strength.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Strength :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Generic Name :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Manufactured By :");

        txfP_mpp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("MPP(Units) :");

        txfP_generic.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnProductReset.setText("Reset");
        btnProductReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductResetActionPerformed(evt);
            }
        });

        dateP_mfg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        dateP_exp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        cmbP_dogesfrom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbP_dogesfrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cap. ", "Cream. ", "EarD. ", "EyeD. ", "Gel. ", "Inhr. ", "IM Inj. ", "IV Inj. ", "SC Inj. ", "Nebu. ", "Syp. ", "Tab. " }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Product Group :");

        txfP_quantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Quantity :");

        cmbP_group.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbP_group.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Human", "AgroVet", "Harbal", "Unani" }));

        txfP_addedby.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Added By :");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Order No. :");

        txfP_order.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        cmbP_manufecturer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Manufacturer ID :");

        txfP_Manufacturer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(txfP_generic, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(txfP_id, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(cmbP_dogesfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txfP_name, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txfP_strength, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(cmbP_group, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cmbP_manufecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(txfP_mpp, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txfP_order, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txfP_mrp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(163, 163, 163))))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateP_mfg, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(80, 80, 80))
                    .addComponent(txfP_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txfP_addedby, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel11)
                    .addComponent(dateP_exp, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfP_Manufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(383, 383, 383)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(495, 495, 495)
                                .addComponent(btnProductReset)
                                .addGap(213, 213, 213)
                                .addComponent(btnAddProduct)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfP_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateP_mfg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbP_group, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txfP_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txfP_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateP_exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfP_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txfP_strength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txfP_mpp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfP_Manufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(cmbP_dogesfrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbP_manufecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txfP_generic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txfP_addedby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfP_mrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddProduct)
                    .addComponent(btnProductReset))
                .addGap(82, 82, 82))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        // TODO add your handling code here:
        genarateProductId();
        
        getProductInfo();
        try {
            pst = db.get().prepareStatement("INSERT INTO product(p_id, p_doges, p_name, p_strength, p_generic, p_manufecturer, p_group, order_no, p_mpp, p_mrp, mfg_date, exp_date, p_stock, added_by, full_name) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
            pst.setString(1, id);
            pst.setString(2, dogesFrom);
            pst.setString(3, pName);
            pst.setString(4, strength);
            pst.setString(5, pGeneric);
            pst.setString(6, manufecturedBy);
            pst.setString(7, pGroup);
            pst.setString(8, order);
            pst.setString(9, mpp);
            pst.setString(10, mrp);
            pst.setDate(11, mfgDate);
            pst.setDate(12, expDate);
            pst.setString(13, quantity);
            pst.setString(14, addedBy);
            pst.setString(15, dogesFrom + " " + pName + " " + strength);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product Succesfully added in dataabase");
            resetField();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Sorry this product doesnot add ");
        }
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnProductResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductResetActionPerformed
        // TODO add your handling code here:
        resetField();

    }//GEN-LAST:event_btnProductResetActionPerformed

    private void txfP_mrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfP_mrpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfP_mrpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnProductReset;
    private javax.swing.JComboBox<String> cmbP_dogesfrom;
    private javax.swing.JComboBox<String> cmbP_group;
    private javax.swing.JComboBox<String> cmbP_manufecturer;
    private com.toedter.calendar.JDateChooser dateP_exp;
    private com.toedter.calendar.JDateChooser dateP_mfg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txfP_Manufacturer;
    private javax.swing.JTextField txfP_addedby;
    private javax.swing.JTextField txfP_generic;
    private javax.swing.JTextField txfP_id;
    private javax.swing.JTextField txfP_mpp;
    private javax.swing.JTextField txfP_mrp;
    private javax.swing.JTextField txfP_name;
    private javax.swing.JTextField txfP_order;
    private javax.swing.JTextField txfP_quantity;
    private javax.swing.JTextField txfP_strength;
    // End of variables declaration//GEN-END:variables
}
