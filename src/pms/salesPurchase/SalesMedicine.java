package pms.salesPurchase;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pms.util.db;

public class SalesMedicine extends javax.swing.JPanel {

    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel dtmSearch, dtmCart;

    //cart variable
    Double totalSaleAmount, discountRate, discountAmount, netSaleAmount, previousDue, totalPayable, paidAmount, dueAmount;
    int invoiceNo, cId, quantityOfSales;
    String cName, cContract, cLocation, sBy;
    java.sql.Date sDate;

    public SalesMedicine() {
        initComponents();
        genarateInvoiceNumber();
        jDateCurrent.setDate(new Date());
        dtmSearch = new DefaultTableModel(new String[]{"Product Id", "Product Name", "Unit Price", "Stock"}, 0);
        jTsearch.setModel(dtmSearch);
        
        searchProductForSale();
        
        dtmCart = new DefaultTableModel(new String[]{"Product Id", "Product Name", "Stock", "Unit Price", "Quantity", "Total Price"}, 0);
        jTableCart.setModel(dtmCart);
        jTableCart.setShowGrid(true);
    }

    private void genarateInvoiceNumber() {
        try {
            pst = db.get().prepareStatement("SELECT invoice_no FROM sales ORDER BY invoice_no DESC LIMIT 1");
            ResultSet re = pst.executeQuery();
            while (re.next()) {
                int invoiceNumber = re.getInt(1) + 1;
                txfInvoiceNo.setText(String.valueOf(invoiceNumber));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void getInfoFromSalesPane() {
        invoiceNo = Integer.parseInt(txfInvoiceNo.getText());
        sDate = new java.sql.Date(jDateCurrent.getDate().getTime());
        cId = Integer.parseInt(txfCustomerId.getText());
        cName = txfCustomerName.getText();
        cContract = txfCustomerContract.getText();
        cLocation = txfCustomerLocation.getText();
        quantityOfSales = Integer.parseInt(texProductQuantity.getText());
        totalSaleAmount = Double.parseDouble(txfTotalSale.getText());
        discountRate = Double.parseDouble(txfSaleDiscountPercentage.getText());
        discountAmount = Double.parseDouble(txfDiscountAmount.getText());
        netSaleAmount = Double.parseDouble(txfNetSale.getText());
        previousDue = Double.parseDouble(txfCustomerPreviousDue.getText());
        totalPayable = Double.parseDouble(txfTotalPayable.getText());
        paidAmount = Double.parseDouble(txfCustomerPaidAmount.getText());
        dueAmount = Double.parseDouble(txfCustomerDue.getText());

    }

    private void searchProductForSale() {
        try {
            pst = db.get().prepareStatement("SELECT p_id, full_name, p_mrp, p_stock FROM product WHERE full_name LIKE ? ");
            pst.setString(1, "%" + txfSearchProduct.getText() + "%");
            rs = pst.executeQuery();
            dtmSearch.setRowCount(0);
            boolean flag = true;
            while (rs.next()) {
                Object[] productInfo = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                dtmSearch.addRow(productInfo);
                txfSearchProduct.setText("");
                flag = false;
            }
            if (flag) {
                JOptionPane.showMessageDialog(this, "Product not found");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void resetProductInfo() {
        txtProductId.setText("");
        txfProductFullName.setText("");
        txfProductStock.setText("");
        txfProductUnitPrice.setText("");
        texProductQuantity.setText("");
        txfTotalPrice.setText("");
    }

    private void calculationOfCartTotal() {
        int rawCount = jTableCart.getRowCount();
        totalSaleAmount = 0.0;
        for (int i = 0; i < rawCount; i++) {
            double val = Double.valueOf(jTableCart.getValueAt(i, 5).toString());
            totalSaleAmount += val;
        }
        txfTotalSale.setText(Double.toString(totalSaleAmount));
    }

    void createInvoice() {
        txaInvoice.setText(
                " \tDate : " + jDateCurrent.getDate() + "\n"
                + "-----------------------------------------------------------------------------------------------\n"
                + "\t      Pharmacy Management Sysrem\t\n"
                + "\t          Mohammadpur, Dhaka-1207\t\n"
                + "\t                www.pms.com\t\n"
                + "-----------------------------------------------------------------------------------------------\n"
                + "  Invoice No : " + txfInvoiceNo.getText() + "\t\t\t" + "Customer ID : \t " + txfCustomerId.getText() + "\n"
                + "  CustomerName : " + txfCustomerName.getText() + "\t" + "Sold by : " + "" + "\n"
                + "-----------------------------------------------------------------------------------------------\n"
                + "  Name" + "\t\t" + "UnitPrice" + "\t" + "Quantity" + "\t" + "Price\n"
                + "-----------------------------------------------------------------------------------------------\n"
        //                + txfProductFullName.getText() + "\t" + txfProductUnitPrice.getText() + "\t" + texProductQuantity.getText() + "\t" + txfTotalPrice.getText() + "\n"
        );
        for (int i = 0; i < dtmCart.getRowCount(); i++) {
            String pName = jTableCart.getValueAt(i, 1).toString();
            String uPrice = jTableCart.getValueAt(i, 3).toString();
            String uQuantity = jTableCart.getValueAt(i, 4).toString();
            String tPrice = jTableCart.getValueAt(i, 5).toString();
            txaInvoice.append(pName + "\t" + uPrice + "\t" + uQuantity + "\t" + tPrice + "\n");
        }
        txaInvoice.append("-----------------------------------------------------------------------------------------------\n");
        txaInvoice.append("\t\tTotal Sales\t\t" + txfTotalSale.getText() + "\n");
        txaInvoice.append("\t\tLess: Discount\t\t" + txfDiscountAmount.getText() + "\n");
        txaInvoice.append("\t\t-----------------------------------------------------\n");
        txaInvoice.append("\t\tNet Sales\t\t" + txfNetSale.getText() + "\n");
        txaInvoice.append("\t\tAdd: Previous Due\t" + txfCustomerPreviousDue.getText() + "\n");
        txaInvoice.append("\t\t------------------------------------------------------\n");
        txaInvoice.append("\t\tTotal Payable\t\t" + txfTotalPayable.getText() + "\n");
        txaInvoice.append("\t\tLess: Paid Amount\t" + txfCustomerPaidAmount.getText() + "\n");
        txaInvoice.append("\t\t------------------------------------------------------\n");
        txaInvoice.append("\t\tDue Amount\t\t" + txfCustomerDue.getText() + "\n");
        txaInvoice.append("\t\t==============================\n");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txfInvoiceNo = new javax.swing.JTextField();
        txfSearchCustomer = new javax.swing.JTextField();
        btnSearchCustomer = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txfCustomerName = new javax.swing.JTextField();
        txfCustomerContract = new javax.swing.JTextField();
        txfCustomerLocation = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txfCustomerCredit = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txfTotalPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txfProductFullName = new javax.swing.JTextField();
        txfProductUnitPrice = new javax.swing.JTextField();
        texProductQuantity = new javax.swing.JTextField();
        txfSearchProduct = new javax.swing.JTextField();
        btnSearchProduct = new javax.swing.JButton();
        btnAddCart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCart = new javax.swing.JTable();
        txfCustomerId = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jDateCurrent = new com.toedter.calendar.JDateChooser();
        txtProductId = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTsearch = new javax.swing.JTable();
        btnResetProduct = new javax.swing.JButton();
        txfProductStock = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaInvoice = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txfTotalSale = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txfDiscountAmount = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txfNetSale = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txfSaleDiscountPercentage = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txfCustomerPreviousDue = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txfTotalPayable = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txfCustomerPaidAmount = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txfCustomerDue = new javax.swing.JTextField();
        btnConformSale = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnRemoveFromCart = new javax.swing.JButton();
        btnRemoveAllFromCart = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnPrintInvoice = new javax.swing.JButton();
        btnSaveInvoice = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Sales Medicine");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Invoice No. :");

        txfSearchCustomer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnSearchCustomer.setText("Search Customer");
        btnSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCustomerActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Customer Id :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Customer Name :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Customer Contract :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Customer Location :");

        txfCustomerName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txfCustomerContract.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txfCustomerLocation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Previous due");

        txfCustomerCredit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Total Price");

        txfTotalPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Product Id :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Product Name :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Unit Price :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Quantity");

        txfProductFullName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txfProductUnitPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        texProductQuantity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        texProductQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texProductQuantityKeyReleased(evt);
            }
        });

        txfSearchProduct.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnSearchProduct.setText("Search");
        btnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductActionPerformed(evt);
            }
        });

        btnAddCart.setText("Add to Cart");
        btnAddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCartActionPerformed(evt);
            }
        });

        jTableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableCart);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Date :");

        txtProductId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTsearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTsearchMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTsearch);

        btnResetProduct.setText("Reset");
        btnResetProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetProductActionPerformed(evt);
            }
        });

        txaInvoice.setColumns(20);
        txaInvoice.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        txaInvoice.setRows(5);
        jScrollPane4.setViewportView(txaInvoice);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Cart");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Invoice");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Total sales Amount ");

        txfTotalSale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txfTotalSale.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Less: Discount");

        txfDiscountAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txfDiscountAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Net sales amount");

        txfNetSale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txfNetSale.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Product Stock :");

        txfSaleDiscountPercentage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txfSaleDiscountPercentage.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfSaleDiscountPercentage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfSaleDiscountPercentageKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Add: Previous due");

        txfCustomerPreviousDue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txfCustomerPreviousDue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Total Payable");

        txfTotalPayable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txfTotalPayable.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Paid amount");

        txfCustomerPaidAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txfCustomerPaidAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfCustomerPaidAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCustomerPaidAmountKeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Due amount");

        txfCustomerDue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txfCustomerDue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnConformSale.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnConformSale.setText("Confarm Sale");
        btnConformSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConformSaleActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("%");

        btnRemoveFromCart.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRemoveFromCart.setText("Remove");
        btnRemoveFromCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromCartActionPerformed(evt);
            }
        });

        btnRemoveAllFromCart.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRemoveAllFromCart.setText("Remove All");
        btnRemoveAllFromCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAllFromCartActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("New Sales");

        btnPrintInvoice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPrintInvoice.setText("Print Invoice");
        btnPrintInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintInvoiceActionPerformed(evt);
            }
        });

        btnSaveInvoice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSaveInvoice.setText("Save Invoice");
        btnSaveInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveInvoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txfInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(txfSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnSearchCustomer)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addGap(89, 89, 89)
                        .addComponent(jLabel5)
                        .addGap(116, 116, 116)
                        .addComponent(jLabel6)
                        .addGap(103, 103, 103)
                        .addComponent(jLabel7)
                        .addGap(94, 94, 94)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txfCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txfCustomerContract, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txfCustomerLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txfCustomerCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(259, 259, 259))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfSaleDiscountPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfDiscountAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txfTotalSale, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(txfNetSale, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txfCustomerPreviousDue, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txfTotalPayable, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txfCustomerPaidAmount, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txfCustomerDue, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConformSale, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnRemoveFromCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemoveAllFromCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19)
                                .addComponent(jLabel17)
                                .addComponent(jLabel21)
                                .addComponent(jLabel22)
                                .addComponent(jLabel23)
                                .addComponent(jLabel24))
                            .addGap(189, 189, 189))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txfSearchProduct)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnResetProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddCart)
                        .addGap(111, 111, 111))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(txfProductFullName)
                            .addComponent(txtProductId, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jLabel20)
                            .addComponent(txfProductStock))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9)
                            .addComponent(txfTotalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(texProductQuantity)
                            .addComponent(txfProductUnitPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jLabel12))
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSaveInvoice)
                                .addGap(26, 26, 26)
                                .addComponent(btnPrintInvoice)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txfInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txfSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCustomer)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jDateCurrent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txfCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCustomerContract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCustomerLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCustomerCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchProduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(8, 8, 8)
                                .addComponent(txfProductUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(texProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfProductFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(8, 8, 8)
                                .addComponent(txfProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnResetProduct)
                            .addComponent(btnAddCart)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(txfTotalSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txfDiscountAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txfSaleDiscountPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnRemoveFromCart)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(txfNetSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(txfCustomerPreviousDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btnRemoveAllFromCart)))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txfTotalPayable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txfCustomerPaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txfCustomerDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConformSale)
                    .addComponent(jButton1)
                    .addComponent(btnPrintInvoice)
                    .addComponent(btnSaveInvoice))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCustomerActionPerformed
        // TODO add your handling code here:
        try {
            pst = db.get().prepareStatement("SELECT c_id, c_name, c_contract, c_location, c_credit FROM customer WHERE c_contract = ?");
            pst.setString(1, txfSearchCustomer.getText());
            rs = pst.executeQuery();

            if (rs.next() == false) {
                JOptionPane.showMessageDialog(this, "Sorry Mobile number does not match");
                txfSearchCustomer.setText("");
            } else {
                txfCustomerId.setText(rs.getString(1));
                txfCustomerName.setText(rs.getString(2));
                txfCustomerContract.setText(rs.getString(3));
                txfCustomerLocation.setText(rs.getString(4));
                txfCustomerCredit.setText(rs.getString(5));
                if (rs.getString(5) == null) {
                    txfCustomerCredit.setText("0.00");
                    txfCustomerPreviousDue.setText("0.00");
                } else {
                    txfCustomerCredit.setText(rs.getString(5));
                    txfCustomerPreviousDue.setText(rs.getString(5));

                    //(String.format("%.2f", rs.getString(5)));
                }

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_btnSearchCustomerActionPerformed

    private void btnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductActionPerformed
        // TODO add your handling code here:
//        if (txfSearchProduct.getText().equals("")) {
//            return;
//        }
//        try {
//            pst = db.get().prepareStatement("SELECT p_id, full_name, p_mrp, p_stock FROM product WHERE full_name LIKE ? ");
//            pst.setString(1, "%" + txfSearchProduct.getText() + "%");
//            rs = pst.executeQuery();
//            dtmSearch.setRowCount(0);
//            boolean flag = true;
//            while (rs.next()) {
//                Object[] productInfo = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
//                dtmSearch.addRow(productInfo);
//                txfSearchProduct.setText("");
//                flag = false;
//            }
//            if (flag) {
//                JOptionPane.showMessageDialog(this, "Product not found");
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
        searchProductForSale();
    }//GEN-LAST:event_btnSearchProductActionPerformed

    private void texProductQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texProductQuantityKeyReleased
        // TODO add your handling code here:
        double productUnitPrice = Double.parseDouble(txfProductUnitPrice.getText());
        int quantity = Integer.parseInt(texProductQuantity.getText());
        double totalPrice = productUnitPrice * quantity;

        txfTotalPrice.setText(String.valueOf(totalPrice));

    }//GEN-LAST:event_texProductQuantityKeyReleased

    private void jTsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTsearchMouseClicked
        // TODO add your handling code here:
        txtProductId.setText(dtmSearch.getValueAt(jTsearch.getSelectedRow(), 0).toString());
        txfProductFullName.setText(dtmSearch.getValueAt(jTsearch.getSelectedRow(), 1).toString());
        txfProductUnitPrice.setText(dtmSearch.getValueAt(jTsearch.getSelectedRow(), 2).toString());
        txfProductStock.setText(dtmSearch.getValueAt(jTsearch.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_jTsearchMouseClicked

    private void btnAddCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCartActionPerformed
        // TODO add your handling code here
        int stockBeforeSale = Integer.parseInt(txfProductStock.getText());
        int salesQuantity = Integer.parseInt(texProductQuantity.getText());
        int stockAfterSale = stockBeforeSale - salesQuantity;
        if (stockAfterSale < 0) {
            JOptionPane.showMessageDialog(null, "Product quantity not in stock");
        } else {
            Object[] cardData = {txtProductId.getText(), txfProductFullName.getText(), txfProductStock.getText(), txfProductUnitPrice.getText(), texProductQuantity.getText(), txfTotalPrice.getText()};
            dtmCart.addRow(cardData);

            calculationOfCartTotal();
            //calculate total sale amount
            resetProductInfo();
        }
    }//GEN-LAST:event_btnAddCartActionPerformed

    private void btnResetProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetProductActionPerformed
        // TODO add your handling code here:

        resetProductInfo();

    }//GEN-LAST:event_btnResetProductActionPerformed

    private void txfSaleDiscountPercentageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfSaleDiscountPercentageKeyReleased
        // TODO add your handling code here:
        totalSaleAmount = Double.parseDouble(txfTotalSale.getText());
        discountRate = Double.parseDouble(txfSaleDiscountPercentage.getText());
        discountAmount = totalSaleAmount * (discountRate / 100);

        txfDiscountAmount.setText(String.format("%.2f", discountAmount));

        netSaleAmount = totalSaleAmount - discountAmount;
        txfNetSale.setText(String.format("%.2f", netSaleAmount));

        previousDue = Double.parseDouble(txfCustomerPreviousDue.getText());
        totalPayable = netSaleAmount + previousDue;
        txfTotalPayable.setText(String.format("%.2f", totalPayable));

    }//GEN-LAST:event_txfSaleDiscountPercentageKeyReleased

    private void txfCustomerPaidAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCustomerPaidAmountKeyReleased
        // TODO add your handling code here:
        paidAmount = Double.parseDouble(txfCustomerPaidAmount.getText());
        dueAmount = totalPayable - paidAmount;
        txfCustomerDue.setText(String.format("%.2f", dueAmount));
    }//GEN-LAST:event_txfCustomerPaidAmountKeyReleased

    private void btnConformSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConformSaleActionPerformed
        // TODO add your handling code here:

        //Save sales Information
        int r = JOptionPane.showConfirmDialog(this, "Conform sale ?", "Conformation", JOptionPane.YES_NO_OPTION);
        if (r == 0) {

            invoiceNo = Integer.parseInt(txfInvoiceNo.getText());
            sDate = new java.sql.Date(jDateCurrent.getDate().getTime());
            cId = Integer.parseInt(txfCustomerId.getText());
            cName = txfCustomerName.getText();
            cContract = txfCustomerContract.getText();
            cLocation = txfCustomerLocation.getText();
            //quantityOfSales = Integer.parseInt(texProductQuantity.getText());
            totalSaleAmount = Double.parseDouble(txfTotalSale.getText());
            //discountRate = Double.parseDouble(txfSaleDiscountPercentage.getText());
            discountAmount = Double.parseDouble(txfDiscountAmount.getText());
            netSaleAmount = Double.parseDouble(txfNetSale.getText());
            previousDue = Double.parseDouble(txfCustomerPreviousDue.getText());
            totalPayable = Double.parseDouble(txfTotalPayable.getText());
            paidAmount = Double.parseDouble(txfCustomerPaidAmount.getText());
            dueAmount = Double.parseDouble(txfCustomerDue.getText());

            try {
                pst = db.get().prepareStatement("INSERT INTO sales(invoice_no, s_date, c_id, c_name, c_contract, c_location, t_sale, discount, n_sale, pre_due, payable, paid_amount, due) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
                pst.setString(1, String.valueOf(invoiceNo));
                pst.setString(2, String.valueOf(sDate));
                pst.setString(3, String.valueOf(cId));
                pst.setString(4, cName);
                pst.setString(5, cContract);
                pst.setString(6, cLocation);
                pst.setString(7, String.valueOf(totalSaleAmount));
                pst.setString(8, String.valueOf(discountAmount));
                pst.setString(9, String.valueOf(netSaleAmount));
                pst.setString(10, String.valueOf(previousDue));
                pst.setString(11, String.valueOf(totalPayable));
                pst.setString(12, String.valueOf(paidAmount));
                pst.setString(13, String.valueOf(dueAmount));
                pst.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Exception in conform sale");
            }
            //save invoices information
            int rawCount = jTableCart.getRowCount();

            for (int i = 0; i < rawCount; i++) {
                String pid = String.valueOf(jTableCart.getValueAt(i, 0));
                String pFullName = String.valueOf(jTableCart.getValueAt(i, 1));
                String sQuantity = String.valueOf(jTableCart.getValueAt(i, 4));
                try {
                    pst = db.get().prepareStatement("INSERT INTO invoices(invoice_no, s_date, c_id, p_id, p_full_name, s_quantity) VALUES(?, ?, ?, ?, ?, ?)");
                    pst.setString(1, String.valueOf(invoiceNo));
                    pst.setString(2, String.valueOf(sDate));
                    pst.setString(3, String.valueOf(cId));
                    pst.setString(4, pid);
                    pst.setString(5, pFullName);
                    pst.setString(6, sQuantity);
                    pst.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                // update product Table
                try {
                    int stock = Integer.valueOf(jTableCart.getValueAt(i, 2).toString());
                    int quantity = Integer.valueOf(jTableCart.getValueAt(i, 4).toString());
                    int uStock = stock - quantity;
                    pst = db.get().prepareStatement("UPDATE product SET p_stock = ? WHERE p_id = ?");
                    pst.setInt(1, uStock);
                    pst.setString(2, pid);
                    pst.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e);
                }

            }

            // Update customer credit
            try {
                pst = db.get().prepareStatement("UPDATE customer SET c_credit = ? WHERE c_id = ?");
                pst.setDouble(1, dueAmount);
                pst.setInt(2, cId);
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Exception in update Customer credit");
            }
            createInvoice();
            JOptionPane.showMessageDialog(null, "Sale confarmed");
        }


    }//GEN-LAST:event_btnConformSaleActionPerformed

    private void btnRemoveFromCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromCartActionPerformed
        // TODO add your handling code here:
        if (jTableCart.getSelectedRowCount() == 1) {
            dtmCart.removeRow(jTableCart.getSelectedRow());
        } else {
            if (jTableCart.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Cart is empty");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a product to  remove");
            }
        }
        calculationOfCartTotal();

    }//GEN-LAST:event_btnRemoveFromCartActionPerformed

    private void btnRemoveAllFromCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAllFromCartActionPerformed
        // TODO add your handling code here:

//        for (int i = 0; i < jTableCart.getRowCount(); i++) {
//            dtmCart.removeRow(i);
//        }
        dtmCart.setRowCount(0);
        calculationOfCartTotal();
    }//GEN-LAST:event_btnRemoveAllFromCartActionPerformed

    private void btnSaveInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveInvoiceActionPerformed
        // TODO add your handling code here:

        try {
            pst = db.get().prepareStatement("UPDATE sales SET invoice = ? WHERE invoice_no = ?");
            pst.setString(1, txaInvoice.getText());
            pst.setString(2, txfInvoiceNo.getText());
            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnSaveInvoiceActionPerformed

    private void btnPrintInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintInvoiceActionPerformed
        // TODO add your handling code here:
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");

        job.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                pf.setOrientation(PageFormat.LANDSCAPE);
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.47, 0.47);

                txaInvoice.print(g2);

                return Printable.PAGE_EXISTS;

            }
        });
        boolean ok = job.printDialog();
        if (ok) {
            try {

                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnPrintInvoiceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCart;
    private javax.swing.JButton btnConformSale;
    private javax.swing.JButton btnPrintInvoice;
    private javax.swing.JButton btnRemoveAllFromCart;
    private javax.swing.JButton btnRemoveFromCart;
    private javax.swing.JButton btnResetProduct;
    private javax.swing.JButton btnSaveInvoice;
    private javax.swing.JButton btnSearchCustomer;
    private javax.swing.JButton btnSearchProduct;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateCurrent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableCart;
    private javax.swing.JTable jTsearch;
    private javax.swing.JTextField texProductQuantity;
    private javax.swing.JTextArea txaInvoice;
    private javax.swing.JTextField txfCustomerContract;
    private javax.swing.JTextField txfCustomerCredit;
    private javax.swing.JTextField txfCustomerDue;
    private javax.swing.JTextField txfCustomerId;
    private javax.swing.JTextField txfCustomerLocation;
    private javax.swing.JTextField txfCustomerName;
    private javax.swing.JTextField txfCustomerPaidAmount;
    private javax.swing.JTextField txfCustomerPreviousDue;
    private javax.swing.JTextField txfDiscountAmount;
    private javax.swing.JTextField txfInvoiceNo;
    private javax.swing.JTextField txfNetSale;
    private javax.swing.JTextField txfProductFullName;
    private javax.swing.JTextField txfProductStock;
    private javax.swing.JTextField txfProductUnitPrice;
    private javax.swing.JTextField txfSaleDiscountPercentage;
    private javax.swing.JTextField txfSearchCustomer;
    private javax.swing.JTextField txfSearchProduct;
    private javax.swing.JTextField txfTotalPayable;
    private javax.swing.JTextField txfTotalPrice;
    private javax.swing.JTextField txfTotalSale;
    private javax.swing.JTextField txtProductId;
    // End of variables declaration//GEN-END:variables
}
