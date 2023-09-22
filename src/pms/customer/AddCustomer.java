package pms.customer;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pms.util.db;

public class AddCustomer extends javax.swing.JPanel {

    PreparedStatement pst;
    java.sql.Date dob;

    public AddCustomer() {
        initComponents();
        genarateCustomerId();
    }

    private void genarateCustomerId() {
        try {
            pst = db.get().prepareStatement("SELECT c_id FROM customer ORDER BY c_id DESC LIMIT 1");
            ResultSet re = pst.executeQuery();
            while (re.next()) {
                int productId = re.getInt(1) + 1;
                txfc_id.setText(String.valueOf(productId));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        txfc_credit_limit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txfc_ccontract = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txfc_location = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rbg_male = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        rbg_female = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        rbg_custom = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txfc_id = new javax.swing.JTextField();
        btnadd_customer = new javax.swing.JButton();
        txfc_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txdc_dob = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txfc_ccontract1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setText("Customer Registration");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Gender");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Date of Birth");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Location");

        rbg_male.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbg_male);
        rbg_male.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbg_male.setSelected(true);
        rbg_male.setText("Male");

        jButton2.setText("Reset");

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

        btnadd_customer.setText("Add Custyomer");
        btnadd_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadd_customerActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Credit Limit");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Name");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Added By:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txfc_credit_limit, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txfc_location, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txfc_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(rbg_male)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbg_female)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbg_custom))
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel9))
                        .addGap(151, 151, 151)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(txfc_name)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(txfc_ccontract)
                            .addComponent(txdc_dob, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(txfc_ccontract1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jButton2)
                        .addGap(86, 86, 86)
                        .addComponent(btnadd_customer)))
                .addGap(116, 116, 116))
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfc_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfc_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(txfc_ccontract1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd_customer)
                    .addComponent(jButton2))
                .addContainerGap(191, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnadd_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadd_customerActionPerformed
        // TODO add your handling code here:
        dob = new java.sql.Date(txdc_dob.getDate().getTime());

        try {
            pst = db.get().prepareStatement("INSERT INTO customer(c_id, c_name, c_gender, c_dob, c_location, c_contract, c_credit_limit) VALUES(?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, txfc_id.getText());
            pst.setString(2, txfc_name.getText());
            pst.setString(3, getGender());
            pst.setDate(4, dob);
            pst.setString(5, txfc_location.getText());
            pst.setString(6, txfc_ccontract.getText());
            pst.setString(7, txfc_credit_limit.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer Successfully added");
        } catch (HeadlessException | SQLException e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnadd_customerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd_customer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JTextField txfc_ccontract;
    private javax.swing.JTextField txfc_ccontract1;
    private javax.swing.JTextField txfc_credit_limit;
    private javax.swing.JTextField txfc_id;
    private javax.swing.JTextField txfc_location;
    private javax.swing.JTextField txfc_name;
    // End of variables declaration//GEN-END:variables
}
