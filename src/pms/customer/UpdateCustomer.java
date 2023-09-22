package pms.customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pms.util.db;

public class UpdateCustomer extends javax.swing.JPanel {

    PreparedStatement pst;
    ResultSet rs;

    public UpdateCustomer() {
        initComponents();
        getCutomerId();
    }

    String getGender() {
        String gender = "";
        if (rbg_male.isSelected()) {
            gender = "Male";
        } else if (rbg_female.isSelected()) {
            gender = "Female";
        } else if (rbg_custom.isSelected()) {
            gender = "Custom";
        }
        return gender;
    }

    private void getCutomerId() {
        try {
            pst = db.get().prepareStatement("SELECT c_id FROM customer");
            rs = pst.executeQuery();
            while (rs.next()) {
                cmbc_id.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfc_location = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rbg_male = new javax.swing.JRadioButton();
        rbg_female = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        rbg_custom = new javax.swing.JRadioButton();
        txfc_credit_limit = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfc_ccontract = new javax.swing.JTextField();
        btnupdate_customer = new javax.swing.JButton();
        txfc_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txdc_dob = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        txfc_UpdatedBy = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbc_id = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Update Customars Information");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Date of Birth");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Location");

        rbg_male.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbg_male);
        rbg_male.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbg_male.setText("Male");

        rbg_female.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbg_female);
        rbg_female.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbg_female.setText("Female");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Contract");

        rbg_custom.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbg_custom);
        rbg_custom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbg_custom.setText("Custom");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Customer ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Gender");

        btnupdate_customer.setText("Update Customer");
        btnupdate_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate_customerActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Credit Limit");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Name");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Updated by");

        cmbc_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbc_idItemStateChanged(evt);
            }
        });
        cmbc_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbc_idActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfc_credit_limit)
                            .addComponent(txfc_location)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbg_male)
                                .addGap(18, 18, 18)
                                .addComponent(rbg_female)
                                .addGap(18, 18, 18)
                                .addComponent(rbg_custom))
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(cmbc_id, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(148, 148, 148)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(txfc_name)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(txfc_ccontract)
                            .addComponent(txdc_dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(txfc_UpdatedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(526, 526, 526)
                        .addComponent(btnupdate_customer)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfc_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbc_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbg_male)
                        .addComponent(rbg_female)
                        .addComponent(rbg_custom))
                    .addComponent(txdc_dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfc_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfc_ccontract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfc_credit_limit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfc_UpdatedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(btnupdate_customer)
                .addContainerGap(191, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbc_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbc_idItemStateChanged
        // TODO add your handling code here:


    }//GEN-LAST:event_cmbc_idItemStateChanged

    private void cmbc_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbc_idActionPerformed
        // TODO add your handling code here:
        getCutomerId();
        try {
            pst = db.get().prepareStatement("SELECT * FROM customer WHERE c_id = ?");
            pst.setString(1, cmbc_id.getSelectedItem().toString());
            rs = pst.executeQuery();
            while (rs.next()) {

                txfc_name.setText(rs.getString(2));
                switch (rs.getString(3)) {
                    case "Male":
                        rbg_male.setSelected(true);
                        break;
                    case "Female":
                        rbg_female.setSelected(true);
                        break;
                    default:
                        rbg_custom.setSelected(true);
                        break;
                }
                txdc_dob.setDate(rs.getDate(4));
                txfc_location.setText(rs.getString(5));
                txfc_ccontract.setText(rs.getString(6));
                txfc_credit_limit.setText(rs.getString(7));
                txfc_UpdatedBy.setText(rs.getString(11));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cmbc_idActionPerformed

    private void btnupdate_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate_customerActionPerformed
        // TODO add your handling code here:
        java.sql.Date dob = new java.sql.Date(txdc_dob.getDate().getTime());
        try {
            pst = db.get().prepareStatement("UPDATE customer SET c_id = ?, c_name = ?, c_gender = ?, c_dob = ?, c_location = ?, c_contract = ?, c_credit_limit = ?, added_by = ? WHERE c_id = ?");
            pst.setString(1, cmbc_id.getSelectedItem().toString());
            pst.setString(2, txfc_name.getText());
            pst.setString(3, getGender());
            pst.setDate(4, dob);
            pst.setString(5, txfc_location.getText());
            pst.setString(6, txfc_ccontract.getText());
            pst.setString(7, txfc_credit_limit.getText());
            pst.setString(8, txfc_UpdatedBy.getText());
            pst.setString(9, cmbc_id.getSelectedItem().toString());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Successfully updated");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_btnupdate_customerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnupdate_customer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbc_id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbg_custom;
    private javax.swing.JRadioButton rbg_female;
    private javax.swing.JRadioButton rbg_male;
    private com.toedter.calendar.JDateChooser txdc_dob;
    private javax.swing.JTextField txfc_UpdatedBy;
    private javax.swing.JTextField txfc_ccontract;
    private javax.swing.JTextField txfc_credit_limit;
    private javax.swing.JTextField txfc_location;
    private javax.swing.JTextField txfc_name;
    // End of variables declaration//GEN-END:variables
}
