package pms.empolyee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pms.util.db;

public class UpdateEmployee extends javax.swing.JPanel {

    String empId;
    String empName;
    String empGender;
    java.sql.Date empDob;
    String empContract;
    String empLocation;
    String empStutas;
    String empSalary;
    java.sql.Date empJoin;
    String empRefarance;

    PreparedStatement pst;

    public UpdateEmployee() {
        initComponents();
        getEmployeeId();
        getEmployeeStutas();
    }

    private void getEmployeeId() {
        try {
            pst = db.get().prepareStatement("SELECT e_id FROM employee");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cmbEmpId.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Information does not get from db");
        }
    }

    private void getEmployeeStutas() {
        try {
            pst = db.get().prepareStatement("SELECT e_stutas FROM employee");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cmbEmpStutas.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Information does not get from db");
        }
    }

    String getGender() {
        String gen = "";
        if (rbgEmpMale.isSelected()) {
            gen = "Male";
        } else if (rbgEmpFemale.isSelected()) {
            gen = "Female";
        } else if (rbgEmpCustom.isSelected()) {
            gen = "Custom";
        }
        return gen;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txfEmpRefarance = new javax.swing.JTextField();
        txfEmpContract = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txfEmpLocation = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnUpdateEmp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txfEmpName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txfEmpSalary = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbEmpId = new javax.swing.JComboBox<>();
        rbgEmpMale = new javax.swing.JRadioButton();
        rbgEmpFemale = new javax.swing.JRadioButton();
        rbgEmpCustom = new javax.swing.JRadioButton();
        dateDobEmp = new com.toedter.calendar.JDateChooser();
        cmbEmpStutas = new javax.swing.JComboBox<>();
        dateEmpJoin = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(204, 204, 204));

        txfEmpRefarance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txfEmpContract.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Employee Contract No. :");

        txfEmpLocation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Update Employee");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Employee Location :");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jButton1.setText("Back to Dashboard");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Employee ID :");

        jButton2.setText("Reset");

        btnUpdateEmp.setText("Update Employee");
        btnUpdateEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateEmpActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Employee Name :");

        txfEmpName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Employee Gender :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Employee Stutas :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Employee Date of Birth :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Employee Salary :");

        txfEmpSalary.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Employee Join Date :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Refarance :");

        cmbEmpId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEmpIdItemStateChanged(evt);
            }
        });

        rbgEmpMale.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbgEmpMale);
        rbgEmpMale.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbgEmpMale.setSelected(true);
        rbgEmpMale.setText("Male");

        rbgEmpFemale.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbgEmpFemale);
        rbgEmpFemale.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbgEmpFemale.setText("Female");

        rbgEmpCustom.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbgEmpCustom);
        rbgEmpCustom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbgEmpCustom.setText("Custom");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(349, 349, 349))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(txfEmpName, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(txfEmpContract, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(cmbEmpId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbgEmpMale)
                                .addGap(39, 39, 39)
                                .addComponent(rbgEmpFemale)
                                .addGap(31, 31, 31)
                                .addComponent(rbgEmpCustom))
                            .addComponent(dateDobEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(txfEmpSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(txfEmpRefarance, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(txfEmpLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(jLabel11)
                            .addComponent(cmbEmpStutas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateEmpJoin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(261, 261, 261)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                        .addComponent(btnUpdateEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addComponent(cmbEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbgEmpMale)
                            .addComponent(rbgEmpFemale)
                            .addComponent(rbgEmpCustom))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateDobEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfEmpContract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfEmpLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEmpStutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfEmpSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateEmpJoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfEmpRefarance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnUpdateEmp))
                .addContainerGap(82, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEmpActionPerformed
        // TODO add your handling code here:
        empDob = new java.sql.Date(dateDobEmp.getDate().getTime());
        empJoin = new java.sql.Date(dateEmpJoin.getDate().getTime());
        try {
            pst = db.get().prepareStatement("UPDATE employee SET e_id = ?, e_name = ?, e_gender = ?, e_dob = ?, e_contract = ?, e_location = ?, e_stutas = ?, e_salary = ?, e_join_date = ?, e_refarance = ? WHERE e_id = ?");
            pst.setString(1, cmbEmpId.getSelectedItem().toString());
            pst.setString(2, txfEmpName.getText());
            pst.setString(3, getGender());
            pst.setString(4, empDob.toString());
            pst.setString(5, txfEmpContract.getText());
            pst.setString(6, txfEmpLocation.getText());
            pst.setString(7, cmbEmpStutas.getSelectedItem().toString());
            pst.setString(8, txfEmpSalary.getText());
            pst.setString(9, empJoin.toString());
            pst.setString(10, txfEmpRefarance.getText());
            pst.setString(11, cmbEmpId.getSelectedItem().toString());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_btnUpdateEmpActionPerformed

    private void cmbEmpIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEmpIdItemStateChanged
        // TODO add your handling code here:
        try {
            pst = db.get().prepareStatement("SELECT * FROM employee WHERE e_id = ?");
            pst.setString(1, cmbEmpId.getSelectedItem().toString());
            ResultSet re = pst.executeQuery();

            while (re.next()) {
                txfEmpName.setText(re.getString(2));
                
                dateDobEmp.setDate(re.getDate(4));
                txfEmpContract.setText(re.getString(5));
                txfEmpLocation.setText(re.getString(6));
                cmbEmpStutas.setSelectedItem(re.getString(7));
                txfEmpSalary.setText(re.getString(8));
                dateEmpJoin.setDate(re.getDate(9));
                txfEmpRefarance.setText(re.getString(10));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cmbEmpIdItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateEmp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbEmpId;
    private javax.swing.JComboBox<String> cmbEmpStutas;
    private com.toedter.calendar.JDateChooser dateDobEmp;
    private com.toedter.calendar.JDateChooser dateEmpJoin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbgEmpCustom;
    private javax.swing.JRadioButton rbgEmpFemale;
    private javax.swing.JRadioButton rbgEmpMale;
    private javax.swing.JTextField txfEmpContract;
    private javax.swing.JTextField txfEmpLocation;
    private javax.swing.JTextField txfEmpName;
    private javax.swing.JTextField txfEmpRefarance;
    private javax.swing.JTextField txfEmpSalary;
    // End of variables declaration//GEN-END:variables
}
