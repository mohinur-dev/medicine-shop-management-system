/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms.supplier;

import java.awt.Color;
import pms.util.jPanelLoader;

/**
 *
 * @author Rakib
 */
public class Supplier extends javax.swing.JPanel {

    /**
     * Creates new form AddInventory
     */
    jPanelLoader jpl;

    public Supplier() {
        initComponents();
        jpl = new jPanelLoader();
        AddSupplier addsupplier = new AddSupplier();
        jpl.jPanelLoader(supplierPane, addsupplier);

        resetMenuBerColor();
        addSupplierPanel.setBackground(new Color(204, 204, 204));
        addSupplierLabel.setForeground(Color.BLACK);
    }

    private void resetMenuBerColor() {
        addSupplierPanel.setBackground(new Color(51, 51, 51));
        addSupplierLabel.setForeground(Color.WHITE);

        updateSupplierPanel.setBackground(new Color(51, 51, 51));
        updateSupplierLabel.setForeground(Color.WHITE);

        showSupplierPanel.setBackground(new Color(51, 51, 51));
        showSupplierLabel.setForeground(Color.WHITE);

        deleteSupplierPanel.setBackground(new Color(51, 51, 51));
        deleteSupplierLabel.setForeground(Color.WHITE);

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
        addSupplierPanel = new javax.swing.JPanel();
        addSupplierLabel = new javax.swing.JLabel();
        updateSupplierPanel = new javax.swing.JPanel();
        updateSupplierLabel = new javax.swing.JLabel();
        showSupplierPanel = new javax.swing.JPanel();
        showSupplierLabel = new javax.swing.JLabel();
        deleteSupplierPanel = new javax.swing.JPanel();
        deleteSupplierLabel = new javax.swing.JLabel();
        supplierPane = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new java.awt.GridLayout(0, 4));

        addSupplierPanel.setBackground(new java.awt.Color(51, 51, 51));
        addSupplierPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        addSupplierPanel.setPreferredSize(new java.awt.Dimension(272, 50));
        addSupplierPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addSupplierPanelMouseClicked(evt);
            }
        });

        addSupplierLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addSupplierLabel.setForeground(new java.awt.Color(255, 255, 255));
        addSupplierLabel.setText("Add Supplier");

        javax.swing.GroupLayout addSupplierPanelLayout = new javax.swing.GroupLayout(addSupplierPanel);
        addSupplierPanel.setLayout(addSupplierPanelLayout);
        addSupplierPanelLayout.setHorizontalGroup(
            addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSupplierPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(addSupplierLabel)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        addSupplierPanelLayout.setVerticalGroup(
            addSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSupplierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addSupplierLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(addSupplierPanel);

        updateSupplierPanel.setBackground(new java.awt.Color(51, 51, 51));
        updateSupplierPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        updateSupplierPanel.setPreferredSize(new java.awt.Dimension(272, 50));
        updateSupplierPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateSupplierPanelMouseClicked(evt);
            }
        });

        updateSupplierLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateSupplierLabel.setForeground(new java.awt.Color(255, 255, 255));
        updateSupplierLabel.setText("Update Supplier");

        javax.swing.GroupLayout updateSupplierPanelLayout = new javax.swing.GroupLayout(updateSupplierPanel);
        updateSupplierPanel.setLayout(updateSupplierPanelLayout);
        updateSupplierPanelLayout.setHorizontalGroup(
            updateSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateSupplierPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(updateSupplierLabel)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        updateSupplierPanelLayout.setVerticalGroup(
            updateSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateSupplierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateSupplierLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(updateSupplierPanel);

        showSupplierPanel.setBackground(new java.awt.Color(51, 51, 51));
        showSupplierPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        showSupplierPanel.setPreferredSize(new java.awt.Dimension(272, 50));
        showSupplierPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showSupplierPanelMouseClicked(evt);
            }
        });

        showSupplierLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        showSupplierLabel.setForeground(new java.awt.Color(255, 255, 255));
        showSupplierLabel.setText("Show Supplier");

        javax.swing.GroupLayout showSupplierPanelLayout = new javax.swing.GroupLayout(showSupplierPanel);
        showSupplierPanel.setLayout(showSupplierPanelLayout);
        showSupplierPanelLayout.setHorizontalGroup(
            showSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showSupplierPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(showSupplierLabel)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        showSupplierPanelLayout.setVerticalGroup(
            showSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showSupplierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showSupplierLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(showSupplierPanel);

        deleteSupplierPanel.setBackground(new java.awt.Color(51, 51, 51));
        deleteSupplierPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        deleteSupplierPanel.setPreferredSize(new java.awt.Dimension(272, 50));
        deleteSupplierPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteSupplierPanelMouseClicked(evt);
            }
        });

        deleteSupplierLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteSupplierLabel.setForeground(new java.awt.Color(255, 255, 255));
        deleteSupplierLabel.setText("Delete Supplier");

        javax.swing.GroupLayout deleteSupplierPanelLayout = new javax.swing.GroupLayout(deleteSupplierPanel);
        deleteSupplierPanel.setLayout(deleteSupplierPanelLayout);
        deleteSupplierPanelLayout.setHorizontalGroup(
            deleteSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteSupplierPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(deleteSupplierLabel)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        deleteSupplierPanelLayout.setVerticalGroup(
            deleteSupplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteSupplierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteSupplierLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(deleteSupplierPanel);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        supplierPane.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout supplierPaneLayout = new javax.swing.GroupLayout(supplierPane);
        supplierPane.setLayout(supplierPaneLayout);
        supplierPaneLayout.setHorizontalGroup(
            supplierPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1088, Short.MAX_VALUE)
        );
        supplierPaneLayout.setVerticalGroup(
            supplierPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        add(supplierPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addSupplierPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSupplierPanelMouseClicked
        // TODO add your handling code here:
        resetMenuBerColor();
        addSupplierPanel.setBackground(new Color(204, 204, 204));
        addSupplierLabel.setForeground(Color.BLACK);

        AddSupplier addsupplier = new AddSupplier();
        jpl.jPanelLoader(supplierPane, addsupplier);

    }//GEN-LAST:event_addSupplierPanelMouseClicked

    private void updateSupplierPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateSupplierPanelMouseClicked
        // TODO add your handling code here:
        resetMenuBerColor();
        updateSupplierPanel.setBackground(new Color(204, 204, 204));
        updateSupplierLabel.setForeground(Color.BLACK);

        UpdateSupplier updateSupplier = new UpdateSupplier();
        jpl.jPanelLoader(supplierPane, updateSupplier);
    }//GEN-LAST:event_updateSupplierPanelMouseClicked

    private void showSupplierPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showSupplierPanelMouseClicked
        // TODO add your handling code here:
        resetMenuBerColor();
        showSupplierPanel.setBackground(new Color(204, 204, 204));
        showSupplierLabel.setForeground(Color.BLACK);

        ViewSupplier showSupplier = new ViewSupplier();
        jpl.jPanelLoader(supplierPane, showSupplier);
    }//GEN-LAST:event_showSupplierPanelMouseClicked

    private void deleteSupplierPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteSupplierPanelMouseClicked
        // TODO add your handling code here:
        resetMenuBerColor();
        deleteSupplierPanel.setBackground(new Color(204, 204, 204));
        deleteSupplierLabel.setForeground(Color.BLACK);

        DeleteSupplier deleteSupplier = new DeleteSupplier();
        jpl.jPanelLoader(supplierPane, deleteSupplier);
    }//GEN-LAST:event_deleteSupplierPanelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addSupplierLabel;
    private javax.swing.JPanel addSupplierPanel;
    private javax.swing.JLabel deleteSupplierLabel;
    private javax.swing.JPanel deleteSupplierPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel showSupplierLabel;
    private javax.swing.JPanel showSupplierPanel;
    private javax.swing.JPanel supplierPane;
    private javax.swing.JLabel updateSupplierLabel;
    private javax.swing.JPanel updateSupplierPanel;
    // End of variables declaration//GEN-END:variables
}