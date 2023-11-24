package com.sheffield.views;
/**
 * @author afiq_ismail
 */
import java.awt.*;
import java.sql.Connection;
import javax.swing.*;

public class ProductListingScreen extends JFrame {
    /**
     * Needed for serialisation
     */
    private static final long serialVersionUID = 1L;

    // Variables declaration                 
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration
    
    /**
     * Creates ProductListingScreen constructor
     */
    public ProductListingScreen(Connection connection) {
        super();

        Toolkit toolkit = Toolkit.getDefaultToolkit ();
        Dimension screenSize = toolkit.getScreenSize();

        setSize(screenSize.width/2, screenSize.height/2);
        setLocation(screenSize.width/4, screenSize.height/4);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // initialise widgets and other components
        initComponents(connection);

        setVisible(true);
    }

    /**
     * Initialise widgets and other components
     */
    private void initComponents(Connection connection) {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product Listing Screen");
        setMinimumSize(new java.awt.Dimension(1216, 636));
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("SHEFFIELD'S TRAIN CATALOGUE");

        jButton1.setText("Profile");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToProfileScreen(connection, evt);
            }
        });

        jButton2.setText("Staff Dashboard");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToStaffDashboard(connection, evt);
            }
        });

        jButton3.setText("Order Line");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToOrderLineScreen(connection, evt);
            }
        });

        jButton4.setText("My Order");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToMyOrderScreen(connection, evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(123, 123, 123)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)
                        .addComponent(jButton4))
                    .addComponent(jLabel2)
                    .addComponent(jButton2))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel1.setText("All");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(552, 552, 552)
                .addComponent(jLabel1)
                .addContainerGap(639, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel1)
                .addContainerGap(290, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("All", jPanel1);

        jLabel3.setText("Train Set");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(552, 552, 552)
                .addComponent(jLabel3)
                .addContainerGap(608, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel3)
                .addContainerGap(290, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Train Set", jPanel3);

        jLabel5.setText("Track Pack");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(558, 558, 558)
                .addComponent(jLabel5)
                .addContainerGap(591, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel5)
                .addContainerGap(280, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Track Pack", jPanel4);

        jLabel4.setText("Individual Model & Parts");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(544, 544, 544)
                .addComponent(jLabel4)
                .addContainerGap(530, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel4)
                .addContainerGap(280, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Parts", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }
    
    /** setExtendedState(JFrame.MAXIMIZED_BOTH);
     * Action-button || other functions | listeners
     */  
    private void goToProfileScreen(Connection connection, java.awt.event.ActionEvent evt) {
        dispose();
        new ProfileScreen(connection);
    }                                        

    private void goToStaffDashboard(Connection connection, java.awt.event.ActionEvent evt) {
        dispose();
        new StaffDashboardScreen(connection);
    }

    private void goToOrderLineScreen(Connection connection, java.awt.event.ActionEvent evt) {
        dispose();
        new OrderLineScreen(connection);
    } 

    private void goToMyOrderScreen(Connection connection, java.awt.event.ActionEvent evt) {
        dispose();
        new MyOrderScreen(connection);
    }
}
