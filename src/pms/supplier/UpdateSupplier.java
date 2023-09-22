package pms.supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pms.util.db;

public class UpdateSupplier extends javax.swing.JPanel {

    PreparedStatement pst;
    ResultSet rs;

    public UpdateSupplier() {
        initComponents();
        getSupplierName();
    }

    void getSupplierName() {
        try {
            pst = db.get().prepareStatement("SELECT s_id, s_name FROM supplier");
            rs = pst.executeQuery();
            while (rs.next()) {
                cmbSid.addItem(rs.getString(1));
                cmbName.addItem(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfContract = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txfLocation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txfCreditLimit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbStutas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbGroup = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        cmbName = new javax.swing.JComboBox<>();
        txfMpo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        cmbSid = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 204, 204));

        txfContract.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Update Supplier Information");

        txfLocation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Supplier Name");

        txfCreditLimit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Supplier ID");

        cmbStutas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbStutas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manufacturer", "Importer", "Agent", "Wholesaler" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Supplier Stutas");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Product Group");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("MPO's Nmae");

        cmbGroup.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AgroVet & Pesticides Product", "Pharma Product", "Herbal & Nutraceuticals Product" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Contract Number");

        btnAdd.setText("Update");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Location");

        btnReset.setText("Reset");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Credit Limit");

        btnDashboard.setText("Dashboard");

        cmbName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        txfMpo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        cmbSid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSidItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(197, 197, 197))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAdd)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(cmbName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4)
                                            .addComponent(cmbStutas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9)
                                            .addComponent(cmbGroup, 0, 350, Short.MAX_VALUE)
                                            .addComponent(cmbSid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(138, 138, 138)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(txfMpo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(txfContract, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)
                                            .addComponent(txfLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(txfCreditLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnDashboard)
                                        .addGap(305, 305, 305)
                                        .addComponent(btnReset)))
                                .addGap(120, 120, 120))))))
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
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfMpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfContract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCreditLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDashboard)
                    .addComponent(btnAdd)
                    .addComponent(btnReset))
                .addContainerGap(150, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSidItemStateChanged
        // TODO add your handling code here:
        try {
            pst = db.get().prepareStatement("SELECT * FROM supplier WHERE s_id = ?");
            pst.setString(1, cmbSid.getSelectedItem().toString());
            ResultSet re = pst.executeQuery();

            while (re.next()) {
                
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cmbSidItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cmbGroup;
    private javax.swing.JComboBox<String> cmbName;
    private javax.swing.JComboBox<String> cmbSid;
    private javax.swing.JComboBox<String> cmbStutas;
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
    private javax.swing.JTextField txfContract;
    private javax.swing.JTextField txfCreditLimit;
    private javax.swing.JTextField txfLocation;
    private javax.swing.JTextField txfMpo;
    // End of variables declaration//GEN-END:variables
}
