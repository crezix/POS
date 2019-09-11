/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author iresh
 */
public class BillWindow extends javax.swing.JFrame {

    /**
     * Creates new form StockWindow
     */
    public BillWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        POSPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("POSPU").createEntityManager();
        prCodeQuery = java.beans.Beans.isDesignTime() ? null : POSPUEntityManager.createQuery("SELECT p.id FROM Product p");
        prCodeList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : prCodeQuery.getResultList();
        qtyQuery = java.beans.Beans.isDesignTime() ? null : POSPUEntityManager.createQuery("SELECT p.qty FROM Product p");
        qtyList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : qtyQuery.getResultList();
        brandQuery = java.beans.Beans.isDesignTime() ? null : POSPUEntityManager.createQuery("SELECT p.brand FROM Product p");
        brandList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : brandQuery.getResultList();
        productQuery = java.beans.Beans.isDesignTime() ? null : POSPUEntityManager.createQuery("SELECT p.product FROM Product p");
        productList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : productQuery.getResultList();
        added = new javax.swing.JOptionPane();
        prList = new ArrayList();
        mainPanel = new javax.swing.JPanel();
        addPanel = new javax.swing.JPanel();
        productLabel = new javax.swing.JLabel();
        productCombo = new javax.swing.JComboBox();
        qtyLabel = new javax.swing.JLabel();
        retailPriceLabel = new javax.swing.JLabel();
        qtyBox = new javax.swing.JTextField();
        retailPriceBox = new javax.swing.JTextField();
        customProductBox = new javax.swing.JTextField();
        newBillButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        addBillButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        totalBox = new javax.swing.JTextField();

        added.setMessage("Stock added!");

        for(int i = 0; i<productList.size(); i++){
            String prd = prCodeList.get(i)+" - "+productList.get(i)+" ("+qtyList.get(i)+") - "+brandList.get(i);
            prList.add(i,prd);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setBackground(java.awt.Color.gray);

        productLabel.setText("Product");

        productCombo.setEnabled(false);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, prList, productCombo);
        bindingGroup.addBinding(jComboBoxBinding);

        productCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                productComboItemStateChanged(evt);
            }
        });

        qtyLabel.setText("Quantity");

        retailPriceLabel.setText("Retail Price");

        qtyBox.setToolTipText("");
        qtyBox.setEnabled(false);

        retailPriceBox.setEnabled(false);

        customProductBox.setEnabled(false);

        newBillButton.setText("New Bill");
        newBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBillButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newBillButton, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customProductBox, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productLabel)
                            .addComponent(productCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qtyBox, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtyLabel))
                        .addGap(18, 18, 18)
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(retailPriceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(retailPriceLabel))))
                .addGap(150, 150, 150))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productLabel)
                            .addComponent(retailPriceLabel)
                            .addComponent(qtyLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtyBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(retailPriceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customProductBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(newBillButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        addButton.setText("+");
        addButton.setEnabled(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Quantity", "Retail Price", "Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableScrollPane.setViewportView(table);

        deleteButton.setText("Delete");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        addBillButton.setText("Add Bill");
        addBillButton.setEnabled(false);
        addBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBillButtonActionPerformed(evt);
            }
        });

        totalLabel.setForeground(java.awt.Color.white);
        totalLabel.setText("Total Bill : Rs.");

        totalBox.setEditable(false);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addBillButton))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(totalLabel)
                        .addGap(4, 4, 4)
                        .addComponent(totalBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(addPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(addBillButton))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(totalBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void listBind(){
        qtyQuery = java.beans.Beans.isDesignTime() ? null : POSPUEntityManager.createQuery("SELECT p.qty FROM Product p");
        qtyList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : qtyQuery.getResultList();
        
        for(int i = 0; i<productList.size(); i++){
            String prd = prCodeList.get(i)+" - "+productList.get(i)+" ("+qtyList.get(i)+") - "+brandList.get(i);
            prList.add(i,prd);
        }
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, prList, productCombo);
        bindingGroup.addBinding(jComboBoxBinding);
    }
            
    private void addProduct(){
        String product,costPrice,qty;
        double cost;
        
        if (customProductBox.getText().isEmpty()){
        product = productCombo.getItemAt(productCombo.getSelectedIndex()).toString();
        }
        else{
            product = customProductBox.getText();
        }
        costPrice = retailPriceBox.getText();
        qty = qtyBox.getText();
        cost = (Float.parseFloat(qty)*Float.parseFloat(costPrice));
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{product,qty,costPrice,cost});
    }
    
    private void deleteProduct(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(table.getSelectedRow());
    }
    
    private void addBill(){
        String sumStr, billMonth, billName;
        float sum=0;
        int i= 0;
        
        billMonth = java.time.LocalDateTime.now().getMonth().toString();//.split("=")[1].split("T")[0]+"S";
        billName =   billMonth.substring(0, 3)+"b"+java.time.LocalDateTime.now().getDayOfMonth()
                     +java.time.LocalDateTime.now().getHour()+java.time.LocalDateTime.now().getMinute()
                     +java.time.LocalDateTime.now().getSecond();
        db.Account acc = new db.Account(billName);
        
        while(i<table.getRowCount()){
            sum= sum+Float.parseFloat(table.getValueAt(i, 3).toString());
            i=i+1;
        }
        sumStr = ""+sum+"";
        totalBox.setText(sumStr);
        
        
        acc.setPrice(sum);
        try {
            ajc.create(acc);
            addBillButton.setEnabled(false);
            deleteButton.setEnabled(false);
            productCombo.setEnabled(false);
            customProductBox.setEnabled(false);
            qtyBox.setEnabled(false);
            retailPriceBox.setEnabled(false);
            addButton.setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(BillWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void newBill(){
        deleteButton.setEnabled(true);
        addBillButton.setEnabled(true);
        productCombo.setEnabled(true);
        productCombo.setSelectedIndex(0);
        customProductBox.setEnabled(true);
        customProductBox.setText(null);
        qtyBox.setEnabled(true);
        qtyBox.setText(null);
        retailPriceBox.setEnabled(true);
        addButton.setEnabled(true);
        totalBox.setText(null);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }
    
    private void reduceQty(){
        float qty,qtyDb,qtyFinal;
        int i = 0;
        int rowCount = table.getRowCount();
        while (i<rowCount){
            qty = Float.parseFloat(table.getValueAt(i, 1).toString());
            String prName = table.getValueAt(i, 0).toString().split(" ")[0];
            qtyDb = Float.parseFloat(pjc.findProduct(prName).getQty());
            qtyFinal = qtyDb-qty;
            System.out.print(qtyFinal);
            db.Product pr = new db.Product(prName);
            pr.setQty(""+qtyFinal);
            pr.setBarcode(pjc.findProduct(prName).getBarcode());
            pr.setBrand(pjc.findProduct(prName).getBrand());
            pr.setCategory(pjc.findProduct(prName).getCategory());
            pr.setDescription(pjc.findProduct(prName).getDescription());
            pr.setProduct(pjc.findProduct(prName).getProduct());
            pr.setRetailPrice(pjc.findProduct(prName).getRetailPrice());
            pr.setStatus(pjc.findProduct(prName).getStatus());
            pr.setCostPrice(pjc.findProduct(prName).getCostPrice());
            
            try {
                pjc.edit(pr);
            } catch (Exception ex) {
                Logger.getLogger(BillWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        addProduct();
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteProduct();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBillButtonActionPerformed
        addBill();
        reduceQty();
        listBind();
    }//GEN-LAST:event_addBillButtonActionPerformed

    private void newBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBillButtonActionPerformed
        newBill();
    }//GEN-LAST:event_newBillButtonActionPerformed

    private void productComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_productComboItemStateChanged
        retailPriceBox.setText(pjc.findProductEntities().get(productCombo.getSelectedIndex()).getRetailPrice());        // TODO add your handling code here:
    }//GEN-LAST:event_productComboItemStateChanged

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
            java.util.logging.Logger.getLogger(BillWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager POSPUEntityManager;
    private javax.swing.JButton addBillButton;
    private javax.swing.JButton addButton;
    private javax.swing.JPanel addPanel;
    private javax.swing.JOptionPane added;
    private java.util.List<db.Brand> brandList;
    private javax.persistence.Query brandQuery;
    private javax.swing.JTextField customProductBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton newBillButton;
    private java.util.List<db.Brand> prCodeList;
    private javax.persistence.Query prCodeQuery;
    private java.util.List prList;
    private javax.swing.JComboBox productCombo;
    private javax.swing.JLabel productLabel;
    private java.util.List<db.Product> productList;
    private javax.persistence.Query productQuery;
    private javax.swing.JTextField qtyBox;
    private javax.swing.JLabel qtyLabel;
    private java.util.List<db.Brand> qtyList;
    private javax.persistence.Query qtyQuery;
    private javax.swing.JTextField retailPriceBox;
    private javax.swing.JLabel retailPriceLabel;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JTextField totalBox;
    private javax.swing.JLabel totalLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    //private String stockNumber;
    EntityManagerFactory emf  = Persistence.createEntityManagerFactory("POSPU");
    private db.AccountJpaController ajc = new db.AccountJpaController(emf);
    private db.ProductJpaController pjc  = new db.ProductJpaController(emf);
    
}
