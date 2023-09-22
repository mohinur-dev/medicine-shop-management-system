package pms.supplier;

import java.sql.*;
import javax.swing.JOptionPane;
import pms.util.db;

public class AddSupplier extends javax.swing.JPanel {

    PreparedStatement pst;

    public AddSupplier() {
        initComponents();
        genarateSupplierId();
    }

    private void genarateSupplierId() {
        try {
            pst = db.get().prepareStatement("SELECT s_id FROM supplier ORDER BY s_id DESC LIMIT 1");
            ResultSet re = pst.executeQuery();
            while (re.next()) {
                int productId = re.getInt(1) + 1;
                txfs_id.setText(String.valueOf(productId));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txfs_id = new javax.swing.JTextField();
        txfs_mpo = new javax.swing.JTextField();
        txfs_contract = new javax.swing.JTextField();
        txfs_location = new javax.swing.JTextField();
        txfs_credit_limit = new javax.swing.JTextField();
        cmbs_type = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbs_group = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        cmbs_name = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Supplier Regestration");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Supplier Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Supplier ID :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Supplier Stutas");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("MPO's Nmae");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Contract Number");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Location");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Credit Limit");

        txfs_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txfs_mpo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txfs_contract.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txfs_location.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txfs_credit_limit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        cmbs_type.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbs_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manufacturer", "Importer", "Agent", "Wholesaler" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Product Group");

        cmbs_group.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbs_group.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AgroVet & Pesticides Product", "Pharma Product", "Herbal & Nutraceuticals Product" }));

        btnAdd.setText("Add Supplier");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        cmbs_name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbs_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACI Limited", "ACME Laboratories Ltd.", "Aristopharma Ltd.", "Beximco Pharmaceuticals Ltd.", "Drug International Ltd.", "Eskayef Pharmaceuticals Ltd.", "General Pharmaceuticals Ltd.", "Healthcare Pharmaceuticals Ltd.", "Incepta Pharmaceuticals Ltd.", "Popular Pharmaceuticals Ltd.", "Square Pharmaceuticals Ltd.", " " }));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txfs_location, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txfs_mpo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbs_type, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txfs_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2)
                            .addComponent(cmbs_group, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txfs_contract)
                            .addComponent(txfs_credit_limit)
                            .addComponent(cmbs_name, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(120, 120, 120)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnReset)
                .addGap(76, 76, 76)
                .addComponent(btnAdd)
                .addGap(340, 340, 340))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfs_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbs_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfs_mpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(4, 4, 4)
                        .addComponent(txfs_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbs_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbs_group, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfs_contract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(4, 4, 4)
                        .addComponent(txfs_credit_limit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset)
                    .addComponent(btnAdd))
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        genarateSupplierId();
        try {
            pst = db.get().prepareStatement("INSERT INTO supplier(s_id, s_name, s_type, product_group, mpo_name, mpo_contract, mpo_location, s_credit_limit) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, txfs_id.getText());
            pst.setString(2, cmbs_name.getSelectedItem().toString());
            pst.setString(3, cmbs_type.getSelectedItem().toString());
            pst.setString(4, cmbs_group.getSelectedItem().toString());
            pst.setString(5, txfs_mpo.getText());
            pst.setString(6, txfs_contract.getText());
            pst.setString(7, txfs_location.getText());
            pst.setString(8, txfs_credit_limit.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully added Supplier");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cmbs_group;
    private javax.swing.JComboBox<String> cmbs_name;
    private javax.swing.JComboBox<String> cmbs_type;
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
    private javax.swing.JTextField txfs_contract;
    private javax.swing.JTextField txfs_credit_limit;
    private javax.swing.JTextField txfs_id;
    private javax.swing.JTextField txfs_location;
    private javax.swing.JTextField txfs_mpo;
    // End of variables declaration//GEN-END:variables
}
