package pms.product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pms.util.db;

public class UpdateProduct extends javax.swing.JPanel {

    PreparedStatement pst;
    ResultSet rs;

    String id, dogesFrom, pName, strength, pGeneric, manufecturedBy, pGroup, order, mpp, mrp, quantity, addedBy;
    java.sql.Date mfgDate;
    java.sql.Date expDate;

    public UpdateProduct() {
        initComponents();
        getProductIdFromDb();
    }

    private void getProductIdFromDb() {
        try {
            pst = db.get().prepareStatement("SELECT p_id FROM product");
            rs = pst.executeQuery();
            while (rs.next()) {
                cmbP_id.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void getProductInfo() {
        id = cmbP_id.getSelectedItem().toString();
        dogesFrom = cmbP_dogesfrom.getSelectedItem().toString();
        pName = txfP_name.getText();
        strength = txfP_strength.getText();
        pGeneric = txfP_generic.getText();
        manufecturedBy = txfP_manufecturer.getText();
        pGroup = cmbP_group.getSelectedItem().toString();
        order = txfP_order.getText();
        mpp = txfP_mpp.getText();
        mrp = txfP_mrp.getText();
        mfgDate = new java.sql.Date(dateP_mfg.getDate().getTime());
        expDate = new java.sql.Date(dateP_exp.getDate().getTime());
        quantity = txfP_quantity.getText();
        addedBy = txfP_addedby.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txfP_mrp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txfP_mpp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txfP_generic = new javax.swing.JTextField();
        dateP_mfg = new com.toedter.calendar.JDateChooser();
        dateP_exp = new com.toedter.calendar.JDateChooser();
        cmbP_dogesfrom = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txfP_quantity = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmbP_group = new javax.swing.JComboBox<>();
        txfP_addedby = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfP_order = new javax.swing.JTextField();
        txfP_name = new javax.swing.JTextField();
        txfP_strength = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txfP_manufecturer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbP_id = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 204, 204));

        btnUpdate.setText("Update Product");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Update Product");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("MRP(Units)");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("MFG. Date");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("EXP. Date");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Product ID");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Manufactured By");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("MPP(Units)");

        cmbP_dogesfrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bolus", "Capsule", "Cream", "Ear Drop", "Eye Drop", "Gel", "Inhaler", "IM Injection", "IV Injection", "SC Injection", "Nebuliser", "Powder", "Suspension", "Syrup", "Suppository", "Tablet" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Group");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Quantity");

        cmbP_group.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Human", "AgroVet", "Harbal", "Unani" }));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Added By");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Doges From");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Order No.");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Brand Nmae");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Strength");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Generic Name");

        cmbP_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbP_idActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGap(98, 98, 98)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(18, 18, 18)
                                            .addComponent(cmbP_group, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(33, 33, 33)
                                            .addComponent(jLabel5)
                                            .addGap(18, 18, 18)
                                            .addComponent(txfP_strength))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(txfP_name))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(txfP_generic, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(12, 12, 12)
                                                    .addComponent(jLabel3))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(19, 19, 19)
                                                    .addComponent(jLabel2)))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cmbP_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmbP_dogesfrom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txfP_manufecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfP_order, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnUpdate)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txfP_addedby)
                                                .addComponent(txfP_quantity)
                                                .addComponent(txfP_mpp)
                                                .addComponent(txfP_mrp, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(dateP_mfg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(dateP_exp, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel11)))
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel15)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(8, 8, 8)))))))
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfP_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cmbP_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbP_dogesfrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txfP_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txfP_strength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txfP_generic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cmbP_group, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txfP_manufecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txfP_mrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addGap(80, 80, 80))
                                    .addComponent(jLabel11)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txfP_mpp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(dateP_mfg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(dateP_exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfP_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfP_addedby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(150, 150, 150))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        getProductIdFromDb();
        getProductInfo();
        try {
            pst = db.get().prepareStatement("UPDATE product SET p_id = ?, p_doges = ?, p_name = ?, p_strength = ?, p_generic = ?, p_manufecturer = ?, p_group = ?, order_no = ?, p_mpp = ?, p_mrp = ?, mfg_date = ?, exp_date = ?, p_stock = ?, added_by = ?, full_name = ? WHERE p_id = ?");
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
            pst.setString(16, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product Successfully updated");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cmbP_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbP_idActionPerformed
        // TODO add your handling code here:
        getProductIdFromDb();
        try {
            pst = db.get().prepareStatement("SELECT * FROM product WHERE p_id = ?");
            pst.setString(1, cmbP_id.getSelectedItem().toString());
            rs = pst.executeQuery();
            while (rs.next()) {
                cmbP_dogesfrom.addItem(rs.getString(2));
                txfP_name.setText(rs.getString(3));
                txfP_strength.setText(rs.getString(4));
                txfP_generic.setText(rs.getString(5));
                txfP_manufecturer.setText(rs.getString(6));
                cmbP_group.addItem(rs.getString(7));
                txfP_order.setText(rs.getString(8));
                txfP_mpp.setText(rs.getString(9));
                txfP_mrp.setText(rs.getString(10));
                dateP_mfg.setDate(rs.getDate(11));
                dateP_exp.setDate(rs.getDate(12));
                txfP_quantity.setText(rs.getString(13));
                txfP_addedby.setText(rs.getString(14));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cmbP_idActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbP_dogesfrom;
    private javax.swing.JComboBox<String> cmbP_group;
    private javax.swing.JComboBox<String> cmbP_id;
    private com.toedter.calendar.JDateChooser dateP_exp;
    private com.toedter.calendar.JDateChooser dateP_mfg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txfP_addedby;
    private javax.swing.JTextField txfP_generic;
    private javax.swing.JTextField txfP_manufecturer;
    private javax.swing.JTextField txfP_mpp;
    private javax.swing.JTextField txfP_mrp;
    private javax.swing.JTextField txfP_name;
    private javax.swing.JTextField txfP_order;
    private javax.swing.JTextField txfP_quantity;
    private javax.swing.JTextField txfP_strength;
    // End of variables declaration//GEN-END:variables
}
