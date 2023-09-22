/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms.product;

import java.awt.Color;
import pms.util.jPanelLoader;

/**
 *
 * @author Rakib
 */
public class Product extends javax.swing.JPanel {

    /**
     * Creates new form AddInventory
     */
    jPanelLoader jpl;

    public Product() {
        initComponents();
        jpl = new jPanelLoader();
        AddProduct addInv = new AddProduct();
        jpl.jPanelLoader(inventoryPanel, addInv);

        resetMenuBerColor();
        addProductPanel.setBackground(new Color(204, 204, 204));
        addProductLabel.setForeground(Color.BLACK);
    }

    private void resetMenuBerColor() {
        addProductPanel.setBackground(new Color(51, 51, 51));
        addProductLabel.setForeground(Color.WHITE);

        updateProductPanel.setBackground(new Color(51, 51, 51));
        updateProductLabel.setForeground(Color.WHITE);

        showProductPanel.setBackground(new Color(51, 51, 51));
        showProductLabel.setForeground(Color.WHITE);

        deleteProductPanel.setBackground(new Color(51, 51, 51));
        deleteProductLabel.setForeground(Color.WHITE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addProductPanel = new javax.swing.JPanel();
        addProductLabel = new javax.swing.JLabel();
        updateProductPanel = new javax.swing.JPanel();
        updateProductLabel = new javax.swing.JLabel();
        showProductPanel = new javax.swing.JPanel();
        showProductLabel = new javax.swing.JLabel();
        deleteProductPanel = new javax.swing.JPanel();
        deleteProductLabel = new javax.swing.JLabel();
        inventoryPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setLayout(new java.awt.GridLayout(0, 4));

        addProductPanel.setBackground(new java.awt.Color(51, 51, 51));
        addProductPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        addProductPanel.setPreferredSize(new java.awt.Dimension(272, 50));
        addProductPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addProductPanelMouseClicked(evt);
            }
        });

        addProductLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addProductLabel.setForeground(new java.awt.Color(255, 255, 255));
        addProductLabel.setText("Add Product");

        javax.swing.GroupLayout addProductPanelLayout = new javax.swing.GroupLayout(addProductPanel);
        addProductPanel.setLayout(addProductPanelLayout);
        addProductPanelLayout.setHorizontalGroup(
            addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductPanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(addProductLabel)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        addProductPanelLayout.setVerticalGroup(
            addProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addProductLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(addProductPanel);

        updateProductPanel.setBackground(new java.awt.Color(51, 51, 51));
        updateProductPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        updateProductPanel.setPreferredSize(new java.awt.Dimension(272, 50));
        updateProductPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateProductPanelMouseClicked(evt);
            }
        });

        updateProductLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateProductLabel.setForeground(new java.awt.Color(255, 255, 255));
        updateProductLabel.setText("Update Product");

        javax.swing.GroupLayout updateProductPanelLayout = new javax.swing.GroupLayout(updateProductPanel);
        updateProductPanel.setLayout(updateProductPanelLayout);
        updateProductPanelLayout.setHorizontalGroup(
            updateProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateProductPanelLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(updateProductLabel)
                .addGap(55, 55, 55))
        );
        updateProductPanelLayout.setVerticalGroup(
            updateProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateProductLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(updateProductPanel);

        showProductPanel.setBackground(new java.awt.Color(51, 51, 51));
        showProductPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        showProductPanel.setPreferredSize(new java.awt.Dimension(272, 50));
        showProductPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showProductPanelMouseClicked(evt);
            }
        });

        showProductLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        showProductLabel.setForeground(new java.awt.Color(255, 255, 255));
        showProductLabel.setText("Show Product");

        javax.swing.GroupLayout showProductPanelLayout = new javax.swing.GroupLayout(showProductPanel);
        showProductPanel.setLayout(showProductPanelLayout);
        showProductPanelLayout.setHorizontalGroup(
            showProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showProductPanelLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(showProductLabel)
                .addGap(61, 61, 61))
        );
        showProductPanelLayout.setVerticalGroup(
            showProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showProductLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(showProductPanel);

        deleteProductPanel.setBackground(new java.awt.Color(51, 51, 51));
        deleteProductPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        deleteProductPanel.setPreferredSize(new java.awt.Dimension(272, 50));
        deleteProductPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteProductPanelMouseClicked(evt);
            }
        });

        deleteProductLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteProductLabel.setForeground(new java.awt.Color(255, 255, 255));
        deleteProductLabel.setText("Delete Product");

        javax.swing.GroupLayout deleteProductPanelLayout = new javax.swing.GroupLayout(deleteProductPanel);
        deleteProductPanel.setLayout(deleteProductPanelLayout);
        deleteProductPanelLayout.setHorizontalGroup(
            deleteProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteProductPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(deleteProductLabel)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        deleteProductPanelLayout.setVerticalGroup(
            deleteProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteProductPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteProductLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(deleteProductPanel);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        inventoryPanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout inventoryPanelLayout = new javax.swing.GroupLayout(inventoryPanel);
        inventoryPanel.setLayout(inventoryPanelLayout);
        inventoryPanelLayout.setHorizontalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1088, Short.MAX_VALUE)
        );
        inventoryPanelLayout.setVerticalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );

        add(inventoryPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addProductPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductPanelMouseClicked
        // TODO add your handling code here:
        resetMenuBerColor();
        addProductPanel.setBackground(new Color(204, 204, 204));
        addProductLabel.setForeground(Color.BLACK);

        AddProduct addInv = new AddProduct();
        jpl.jPanelLoader(inventoryPanel, addInv);
    }//GEN-LAST:event_addProductPanelMouseClicked

    private void updateProductPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateProductPanelMouseClicked
        // TODO add your handling code here:
        resetMenuBerColor();
        updateProductPanel.setBackground(new Color(204, 204, 204));
        updateProductLabel.setForeground(Color.BLACK);

        UpdateProduct updateInv = new UpdateProduct();
        jpl.jPanelLoader(inventoryPanel, updateInv);

    }//GEN-LAST:event_updateProductPanelMouseClicked

    private void showProductPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showProductPanelMouseClicked
        // TODO add your handling code here:
        resetMenuBerColor();
        showProductPanel.setBackground(new Color(204, 204, 204));
        showProductLabel.setForeground(Color.BLACK);

        ViewProduct viewInv = new ViewProduct();
        jpl.jPanelLoader(inventoryPanel, viewInv);
    }//GEN-LAST:event_showProductPanelMouseClicked

    private void deleteProductPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteProductPanelMouseClicked
        // TODO add your handling code here:
        resetMenuBerColor();
        deleteProductPanel.setBackground(new Color(204, 204, 204));
        deleteProductLabel.setForeground(Color.BLACK);

        DeleteProduct deleteInv = new DeleteProduct();
        jpl.jPanelLoader(inventoryPanel, deleteInv);
    }//GEN-LAST:event_deleteProductPanelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addProductLabel;
    private javax.swing.JPanel addProductPanel;
    private javax.swing.JLabel deleteProductLabel;
    private javax.swing.JPanel deleteProductPanel;
    private javax.swing.JPanel inventoryPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel showProductLabel;
    private javax.swing.JPanel showProductPanel;
    private javax.swing.JLabel updateProductLabel;
    private javax.swing.JPanel updateProductPanel;
    // End of variables declaration//GEN-END:variables
}
