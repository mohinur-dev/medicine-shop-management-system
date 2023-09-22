package pms.dashboard;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import pms.customer.Customer;
import pms.empolyee.Employee;
import pms.util.jPanelLoader;
import pms.product.Product;
import pms.salesPurchase.SalesMedicine;
import pms.summary.Summary;
import pms.supplier.Supplier;
import pms.user.User;

public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    jPanelLoader jpl;

    public HomePage() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Image image = new ImageIcon(getClass().getResource("logo.png")).getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(image));

        jpl = new jPanelLoader();
//        WelcomeMassage wcMassage = new WelcomeMassage();
        ShortDateStock shortDateStock = new ShortDateStock();
        jpl.jPanelLoader(workspacePanel, shortDateStock);

        resetMenuColor();
        HomeMenu.setBackground(new Color(204, 204, 204));
        jLhome.setForeground(Color.BLACK);

    }

    private void resetMenuColor() {
        HomeMenu.setBackground(new Color(102, 102, 102));
        jLhome.setForeground(Color.white);

        SalesMenu.setBackground(new Color(102, 102, 102));
        jLSales.setForeground(Color.white);

        ProductMenu.setBackground(new Color(102, 102, 102));
        jLProduct.setForeground(Color.white);

        CustomerMenu.setBackground(new Color(102, 102, 102));
        jLCustomer.setForeground(Color.white);

        EmployeeMenu.setBackground(new Color(102, 102, 102));
        jLEmployee.setForeground(Color.white);

        SupplierMenu.setBackground(new Color(102, 102, 102));
        jLSupplier.setForeground(Color.white);

        UserMenu.setBackground(new Color(102, 102, 102));
        jLUser.setForeground(Color.white);

        ExitMenu.setBackground(new Color(102, 102, 102));
        jLSummary.setForeground(Color.white);

//        ProductMenu.setBackground(new Color(102, 102, 102));
//        jLProduct.setForeground(Color.white);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        manuPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        ProductMenu = new javax.swing.JPanel();
        jLProduct = new javax.swing.JLabel();
        CustomerMenu = new javax.swing.JPanel();
        jLCustomer = new javax.swing.JLabel();
        EmployeeMenu = new javax.swing.JPanel();
        jLEmployee = new javax.swing.JLabel();
        SupplierMenu = new javax.swing.JPanel();
        jLSupplier = new javax.swing.JLabel();
        HomeMenu = new javax.swing.JPanel();
        jLhome = new javax.swing.JLabel();
        SalesMenu = new javax.swing.JPanel();
        jLSales = new javax.swing.JLabel();
        UserMenu = new javax.swing.JPanel();
        jLUser = new javax.swing.JLabel();
        ExitMenu = new javax.swing.JPanel();
        jLSummary = new javax.swing.JLabel();
        workspacePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pharmacy Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Name : Mohinur Rahman || Id : 1272077");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        manuPanel.setBackground(new java.awt.Color(255, 255, 255));

        logo.setBackground(new java.awt.Color(51, 51, 51));

        ProductMenu.setBackground(new java.awt.Color(102, 102, 102));
        ProductMenu.setPreferredSize(new java.awt.Dimension(65, 35));
        ProductMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductMenuMouseClicked(evt);
            }
        });

        jLProduct.setBackground(new java.awt.Color(204, 204, 255));
        jLProduct.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLProduct.setForeground(new java.awt.Color(255, 255, 255));
        jLProduct.setText("Product");

        javax.swing.GroupLayout ProductMenuLayout = new javax.swing.GroupLayout(ProductMenu);
        ProductMenu.setLayout(ProductMenuLayout);
        ProductMenuLayout.setHorizontalGroup(
            ProductMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLProduct)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProductMenuLayout.setVerticalGroup(
            ProductMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        CustomerMenu.setBackground(new java.awt.Color(102, 102, 102));
        CustomerMenu.setPreferredSize(new java.awt.Dimension(65, 35));
        CustomerMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerMenuMouseClicked(evt);
            }
        });

        jLCustomer.setBackground(new java.awt.Color(204, 204, 255));
        jLCustomer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLCustomer.setForeground(new java.awt.Color(255, 255, 255));
        jLCustomer.setText("Customer");

        javax.swing.GroupLayout CustomerMenuLayout = new javax.swing.GroupLayout(CustomerMenu);
        CustomerMenu.setLayout(CustomerMenuLayout);
        CustomerMenuLayout.setHorizontalGroup(
            CustomerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLCustomer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CustomerMenuLayout.setVerticalGroup(
            CustomerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        EmployeeMenu.setBackground(new java.awt.Color(102, 102, 102));
        EmployeeMenu.setPreferredSize(new java.awt.Dimension(65, 35));
        EmployeeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeMenuMouseClicked(evt);
            }
        });

        jLEmployee.setBackground(new java.awt.Color(204, 204, 255));
        jLEmployee.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLEmployee.setForeground(new java.awt.Color(255, 255, 255));
        jLEmployee.setText("Employee");

        javax.swing.GroupLayout EmployeeMenuLayout = new javax.swing.GroupLayout(EmployeeMenu);
        EmployeeMenu.setLayout(EmployeeMenuLayout);
        EmployeeMenuLayout.setHorizontalGroup(
            EmployeeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployeeMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLEmployee)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        EmployeeMenuLayout.setVerticalGroup(
            EmployeeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        SupplierMenu.setBackground(new java.awt.Color(102, 102, 102));
        SupplierMenu.setPreferredSize(new java.awt.Dimension(65, 35));
        SupplierMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupplierMenuMouseClicked(evt);
            }
        });

        jLSupplier.setBackground(new java.awt.Color(204, 204, 255));
        jLSupplier.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jLSupplier.setText("Supplier");

        javax.swing.GroupLayout SupplierMenuLayout = new javax.swing.GroupLayout(SupplierMenu);
        SupplierMenu.setLayout(SupplierMenuLayout);
        SupplierMenuLayout.setHorizontalGroup(
            SupplierMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SupplierMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLSupplier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SupplierMenuLayout.setVerticalGroup(
            SupplierMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        HomeMenu.setBackground(new java.awt.Color(102, 102, 102));
        HomeMenu.setPreferredSize(new java.awt.Dimension(65, 35));
        HomeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMenuMouseClicked(evt);
            }
        });

        jLhome.setBackground(new java.awt.Color(204, 204, 255));
        jLhome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLhome.setForeground(new java.awt.Color(255, 255, 255));
        jLhome.setText("Home");

        javax.swing.GroupLayout HomeMenuLayout = new javax.swing.GroupLayout(HomeMenu);
        HomeMenu.setLayout(HomeMenuLayout);
        HomeMenuLayout.setHorizontalGroup(
            HomeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLhome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomeMenuLayout.setVerticalGroup(
            HomeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLhome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        SalesMenu.setBackground(new java.awt.Color(102, 102, 102));
        SalesMenu.setPreferredSize(new java.awt.Dimension(65, 35));
        SalesMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalesMenuMouseClicked(evt);
            }
        });

        jLSales.setBackground(new java.awt.Color(204, 204, 255));
        jLSales.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLSales.setForeground(new java.awt.Color(255, 255, 255));
        jLSales.setText("Sales");

        javax.swing.GroupLayout SalesMenuLayout = new javax.swing.GroupLayout(SalesMenu);
        SalesMenu.setLayout(SalesMenuLayout);
        SalesMenuLayout.setHorizontalGroup(
            SalesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalesMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLSales)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SalesMenuLayout.setVerticalGroup(
            SalesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLSales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        UserMenu.setBackground(new java.awt.Color(102, 102, 102));
        UserMenu.setPreferredSize(new java.awt.Dimension(65, 35));
        UserMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserMenuMouseClicked(evt);
            }
        });

        jLUser.setBackground(new java.awt.Color(204, 204, 255));
        jLUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLUser.setForeground(new java.awt.Color(255, 255, 255));
        jLUser.setText("User");

        javax.swing.GroupLayout UserMenuLayout = new javax.swing.GroupLayout(UserMenu);
        UserMenu.setLayout(UserMenuLayout);
        UserMenuLayout.setHorizontalGroup(
            UserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UserMenuLayout.setVerticalGroup(
            UserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        ExitMenu.setBackground(new java.awt.Color(102, 102, 102));
        ExitMenu.setPreferredSize(new java.awt.Dimension(65, 35));
        ExitMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMenuMouseClicked(evt);
            }
        });

        jLSummary.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLSummary.setForeground(new java.awt.Color(255, 255, 255));
        jLSummary.setText("Exit");

        javax.swing.GroupLayout ExitMenuLayout = new javax.swing.GroupLayout(ExitMenu);
        ExitMenu.setLayout(ExitMenuLayout);
        ExitMenuLayout.setHorizontalGroup(
            ExitMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExitMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLSummary)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ExitMenuLayout.setVerticalGroup(
            ExitMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLSummary, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout manuPanelLayout = new javax.swing.GroupLayout(manuPanel);
        manuPanel.setLayout(manuPanelLayout);
        manuPanelLayout.setHorizontalGroup(
            manuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manuPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(manuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ExitMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(UserMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(SupplierMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(EmployeeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(CustomerMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(ProductMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(SalesMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(HomeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        manuPanelLayout.setVerticalGroup(
            manuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manuPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(HomeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SalesMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CustomerMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmployeeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SupplierMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        getContentPane().add(manuPanel, java.awt.BorderLayout.LINE_START);

        workspacePanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout workspacePanelLayout = new javax.swing.GroupLayout(workspacePanel);
        workspacePanel.setLayout(workspacePanelLayout);
        workspacePanelLayout.setHorizontalGroup(
            workspacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1113, Short.MAX_VALUE)
        );
        workspacePanelLayout.setVerticalGroup(
            workspacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );

        getContentPane().add(workspacePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProductMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductMenuMouseClicked
        // TODO add your handling code here:
        resetMenuColor();

        ProductMenu.setBackground(new Color(204, 204, 204));
        jLProduct.setForeground(Color.BLACK);

        Product inventory = new Product();
        jpl.jPanelLoader(workspacePanel, inventory);

    }//GEN-LAST:event_ProductMenuMouseClicked

    private void CustomerMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerMenuMouseClicked
        // TODO add your handling code here:
        resetMenuColor();

        CustomerMenu.setBackground(new Color(204, 204, 204));
        jLCustomer.setForeground(Color.BLACK);

        Customer customer = new Customer();
        jpl.jPanelLoader(workspacePanel, customer);
    }//GEN-LAST:event_CustomerMenuMouseClicked

    private void SupplierMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierMenuMouseClicked
        // TODO add your handling code here:

        resetMenuColor();
        SupplierMenu.setBackground(new Color(204, 204, 204));
        jLSupplier.setForeground(Color.BLACK);

        Supplier supplier = new Supplier();
        jpl.jPanelLoader(workspacePanel, supplier);
    }//GEN-LAST:event_SupplierMenuMouseClicked

    private void UserMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserMenuMouseClicked
        // TODO add your handling code here:
        resetMenuColor();

        UserMenu.setBackground(new Color(204, 204, 204));
        jLUser.setForeground(Color.BLACK);

        User user = new User();
        jpl.jPanelLoader(workspacePanel, user);
    }//GEN-LAST:event_UserMenuMouseClicked

    private void EmployeeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeMenuMouseClicked
        // TODO add your handling code here:
        resetMenuColor();
        EmployeeMenu.setBackground(new Color(204, 204, 204));
        jLEmployee.setForeground(Color.BLACK);

        Employee employee = new Employee();
        jpl.jPanelLoader(workspacePanel, employee);
    }//GEN-LAST:event_EmployeeMenuMouseClicked

    private void HomeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMenuMouseClicked
        // TODO add your handling code here:

        resetMenuColor();
        HomeMenu.setBackground(new Color(204, 204, 204));
        jLhome.setForeground(Color.BLACK);

//        WelcomeMassage wcMassage = new WelcomeMassage();
//        jpl.jPanelLoader(workspacePanel, wcMassage);
        ShortDateStock shortDateStock = new ShortDateStock();
        jpl.jPanelLoader(workspacePanel, shortDateStock);


    }//GEN-LAST:event_HomeMenuMouseClicked

    private void ExitMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMenuMouseClicked
        // TODO add your handling code here:
        resetMenuColor();
        ExitMenu.setBackground(new Color(204, 204, 204));
        jLSummary.setForeground(Color.BLACK);

        UserSignIn signin = new UserSignIn();
        signin.setVisible(true);
        dispose();

    }//GEN-LAST:event_ExitMenuMouseClicked

    private void SalesMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesMenuMouseClicked
        // TODO add your handling code here:
        resetMenuColor();
        SalesMenu.setBackground(new Color(204, 204, 204));
        jLSales.setForeground(Color.BLACK);

        SalesMedicine mediSale = new SalesMedicine();
        jpl.jPanelLoader(workspacePanel, mediSale);

    }//GEN-LAST:event_SalesMenuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CustomerMenu;
    private javax.swing.JPanel EmployeeMenu;
    private javax.swing.JPanel ExitMenu;
    private javax.swing.JPanel HomeMenu;
    private javax.swing.JPanel ProductMenu;
    private javax.swing.JPanel SalesMenu;
    private javax.swing.JPanel SupplierMenu;
    private javax.swing.JPanel UserMenu;
    private javax.swing.JLabel jLCustomer;
    private javax.swing.JLabel jLEmployee;
    private javax.swing.JLabel jLProduct;
    private javax.swing.JLabel jLSales;
    private javax.swing.JLabel jLSummary;
    private javax.swing.JLabel jLSupplier;
    private javax.swing.JLabel jLUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLhome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel manuPanel;
    private javax.swing.JPanel workspacePanel;
    // End of variables declaration//GEN-END:variables
}