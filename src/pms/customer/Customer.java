/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms.customer;

import java.awt.Color;
import pms.util.jPanelLoader;

/**
 *
 * @author Rakib
 */
public class Customer extends javax.swing.JPanel {

    /**
     * Creates new form Customer
     */
    jPanelLoader jpl;

    public Customer() {
        initComponents();
        jpl = new jPanelLoader();
        AddCustomer addCus = new AddCustomer();
        jpl.jPanelLoader(CustomerPanel, addCus);

        resetMenuBerColor();
        addCustomerPanel.setBackground(new Color(204, 204, 204));
        addCustomerLabel.setForeground(Color.BLACK);
    }

    private void resetMenuBerColor() {
        addCustomerPanel.setBackground(new Color(51, 51, 51));
        addCustomerLabel.setForeground(Color.WHITE);

        updateCustomerPanel.setBackground(new Color(51, 51, 51));
        updateCustomerLabel.setForeground(Color.WHITE);

        showCustomerPanel.setBackground(new Color(51, 51, 51));
        showCustomerLabel.setForeground(Color.WHITE);

        deleteCustomerPanel.setBackground(new Color(51, 51, 51));
        deleteCustomerLabel.setForeground(Color.WHITE);

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
        jPanel2 = new javax.swing.JPanel();
        addCustomerPanel = new javax.swing.JPanel();
        addCustomerLabel = new javax.swing.JLabel();
        updateCustomerPanel = new javax.swing.JPanel();
        updateCustomerLabel = new javax.swing.JLabel();
        showCustomerPanel = new javax.swing.JPanel();
        showCustomerLabel = new javax.swing.JLabel();
        deleteCustomerPanel = new javax.swing.JPanel();
        deleteCustomerLabel = new javax.swing.JLabel();
        CustomerPanel = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setLayout(new java.awt.GridLayout(0, 4));

        addCustomerPanel.setBackground(new java.awt.Color(51, 51, 51));
        addCustomerPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        addCustomerPanel.setForeground(new java.awt.Color(255, 255, 255));
        addCustomerPanel.setPreferredSize(new java.awt.Dimension(272, 50));
        addCustomerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCustomerPanelMouseClicked(evt);
            }
        });

        addCustomerLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addCustomerLabel.setForeground(new java.awt.Color(255, 255, 255));
        addCustomerLabel.setText("Add Customer");

        javax.swing.GroupLayout addCustomerPanelLayout = new javax.swing.GroupLayout(addCustomerPanel);
        addCustomerPanel.setLayout(addCustomerPanelLayout);
        addCustomerPanelLayout.setHorizontalGroup(
            addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCustomerPanelLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(addCustomerLabel)
                .addGap(69, 69, 69))
        );
        addCustomerPanelLayout.setVerticalGroup(
            addCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCustomerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(addCustomerPanel);

        updateCustomerPanel.setBackground(new java.awt.Color(51, 51, 51));
        updateCustomerPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        updateCustomerPanel.setForeground(new java.awt.Color(255, 255, 255));
        updateCustomerPanel.setPreferredSize(new java.awt.Dimension(272, 50));
        updateCustomerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateCustomerPanelMouseClicked(evt);
            }
        });

        updateCustomerLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateCustomerLabel.setForeground(new java.awt.Color(255, 255, 255));
        updateCustomerLabel.setText("Update Customer");

        javax.swing.GroupLayout updateCustomerPanelLayout = new javax.swing.GroupLayout(updateCustomerPanel);
        updateCustomerPanel.setLayout(updateCustomerPanelLayout);
        updateCustomerPanelLayout.setHorizontalGroup(
            updateCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateCustomerPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(updateCustomerLabel)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        updateCustomerPanelLayout.setVerticalGroup(
            updateCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateCustomerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(updateCustomerPanel);

        showCustomerPanel.setBackground(new java.awt.Color(51, 51, 51));
        showCustomerPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        showCustomerPanel.setForeground(new java.awt.Color(255, 255, 255));
        showCustomerPanel.setPreferredSize(new java.awt.Dimension(272, 50));
        showCustomerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showCustomerPanelMouseClicked(evt);
            }
        });

        showCustomerLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        showCustomerLabel.setForeground(new java.awt.Color(255, 255, 255));
        showCustomerLabel.setText("Show Customer");

        javax.swing.GroupLayout showCustomerPanelLayout = new javax.swing.GroupLayout(showCustomerPanel);
        showCustomerPanel.setLayout(showCustomerPanelLayout);
        showCustomerPanelLayout.setHorizontalGroup(
            showCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showCustomerPanelLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(showCustomerLabel)
                .addGap(64, 64, 64))
        );
        showCustomerPanelLayout.setVerticalGroup(
            showCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showCustomerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(showCustomerPanel);

        deleteCustomerPanel.setBackground(new java.awt.Color(51, 51, 51));
        deleteCustomerPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        deleteCustomerPanel.setForeground(new java.awt.Color(255, 255, 255));
        deleteCustomerPanel.setPreferredSize(new java.awt.Dimension(272, 50));
        deleteCustomerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteCustomerPanelMouseClicked(evt);
            }
        });

        deleteCustomerLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteCustomerLabel.setForeground(new java.awt.Color(255, 255, 255));
        deleteCustomerLabel.setText("Delete Customer");

        javax.swing.GroupLayout deleteCustomerPanelLayout = new javax.swing.GroupLayout(deleteCustomerPanel);
        deleteCustomerPanel.setLayout(deleteCustomerPanelLayout);
        deleteCustomerPanelLayout.setHorizontalGroup(
            deleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteCustomerPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(deleteCustomerLabel)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        deleteCustomerPanelLayout.setVerticalGroup(
            deleteCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteCustomerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(deleteCustomerPanel);

        CustomerPanel.setBackground(new java.awt.Color(204, 204, 204));
        CustomerPanel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout CustomerPanelLayout = new javax.swing.GroupLayout(CustomerPanel);
        CustomerPanel.setLayout(CustomerPanelLayout);
        CustomerPanelLayout.setHorizontalGroup(
            CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        CustomerPanelLayout.setVerticalGroup(
            CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CustomerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addCustomerPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCustomerPanelMouseClicked
        // TODO add your handling code here:
        resetMenuBerColor();
        addCustomerPanel.setBackground(new Color(204, 204, 204));
        addCustomerLabel.setForeground(Color.BLACK);

        AddCustomer addCus = new AddCustomer();
        jpl.jPanelLoader(CustomerPanel, addCus);
    }//GEN-LAST:event_addCustomerPanelMouseClicked

    private void updateCustomerPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateCustomerPanelMouseClicked
        // TODO add your handling code here:
        resetMenuBerColor();
        updateCustomerPanel.setBackground(new Color(204, 204, 204));
        updateCustomerLabel.setForeground(Color.BLACK);

        UpdateCustomer updateCus = new UpdateCustomer();
        jpl.jPanelLoader(CustomerPanel, updateCus);
    }//GEN-LAST:event_updateCustomerPanelMouseClicked

    private void showCustomerPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showCustomerPanelMouseClicked
        // TODO add your handling code here:
        resetMenuBerColor();
        showCustomerPanel.setBackground(new Color(204, 204, 204));
        showCustomerLabel.setForeground(Color.BLACK);

        ViewCustomer viewCus = new ViewCustomer();
        jpl.jPanelLoader(CustomerPanel, viewCus);
    }//GEN-LAST:event_showCustomerPanelMouseClicked

    private void deleteCustomerPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteCustomerPanelMouseClicked
        // TODO add your handling code here:
        resetMenuBerColor();
        deleteCustomerPanel.setBackground(new Color(204, 204, 204));
        deleteCustomerLabel.setForeground(Color.BLACK);

        DeleteCustomer deleteCus = new DeleteCustomer();
        jpl.jPanelLoader(CustomerPanel, deleteCus);
    }//GEN-LAST:event_deleteCustomerPanelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CustomerPanel;
    private javax.swing.JLabel addCustomerLabel;
    private javax.swing.JPanel addCustomerPanel;
    private javax.swing.JLabel deleteCustomerLabel;
    private javax.swing.JPanel deleteCustomerPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel showCustomerLabel;
    private javax.swing.JPanel showCustomerPanel;
    private javax.swing.JLabel updateCustomerLabel;
    private javax.swing.JPanel updateCustomerPanel;
    // End of variables declaration//GEN-END:variables
}