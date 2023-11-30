package com.sheffield.views;
/**
 * @author afiq_ismail
 */
import com.sheffield.model.DatabaseConnectionHandler;
import com.sheffield.model.DatabaseOperations;
import com.sheffield.model.User;

import com.sheffield.util.EmailValidator;

import java.awt.*;
import java.sql.Connection;
import javax.swing.*;

public class RegisterScreen extends JFrame {
    /**
     * Needed for serialisation
     */
    private static final long serialVersionUID = 1L;
    DatabaseConnectionHandler databaseConnectionHandler = new DatabaseConnectionHandler();
    // Create an instance of DatabaseConnectionHandler for managing database connections
    DatabaseOperations databaseOperations = new DatabaseOperations();

    // Variables declaration                 
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel forenameLabel;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField forenameField;
    private javax.swing.JTextField surnameField;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField passwordField;
    // End of variables declaration
    
    /**
     * Creates RegisterScreen constructor
     */
    public RegisterScreen(Connection connection) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        forenameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        forenameField = new javax.swing.JTextField();
        surnameField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register Screen");
        setMinimumSize(new java.awt.Dimension(623, 574));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("REGISTER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(248, 248, 248)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addContainerGap(24, Short.MAX_VALUE)));

        forenameLabel.setText("Forename:");

        surnameLabel.setText("Surname:");

        emailLabel.setText("Email:");

        passwordLabel.setText("Password:");

        jButton1.setText("REGISTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register(evt, connection);
            }
        });

        jLabel6.setText("Already a member? Login.");

        jButton2.setText("LOGIN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToLoginScreen(evt, connection);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(114, 114, 114)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                        .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(emailLabel)
                                                                                .addComponent(surnameLabel)
                                                                                .addComponent(passwordLabel))
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(emailField)
                                                                                .addComponent(passwordField)
                                                                                .addComponent(surnameField,
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        296,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                        .addComponent(forenameLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(forenameField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                299,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel2Layout.createSequentialGroup()
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                126,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel6)
                                                                                .addComponent(jButton1,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        128,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(96, 96, 96))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(267, 267, 267)
                                                .addComponent(jButton2)))
                                .addContainerGap(136, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(forenameLabel)
                                        .addComponent(forenameField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(surnameLabel)
                                        .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailLabel)
                                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(jButton1)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel6)
                                .addGap(35, 35, 35)
                                .addComponent(jButton2)
                                .addContainerGap(72, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        pack();
    }
    
    /**
     * Action-button || other functions | listeners
     */
   private void goToLoginScreen(java.awt.event.ActionEvent evt, Connection connection) {
        dispose();
        new LoginScreen(connection);
    }

    private void register(java.awt.event.ActionEvent evt, Connection connection) {
        forenameLabel.setForeground(Color.BLACK);
        surnameLabel.setForeground(Color.BLACK);
        emailLabel.setForeground(Color.BLACK);
        passwordLabel.setForeground(Color.BLACK);

        JFrame frame = new JFrame();
        String forename = forenameField.getText();
        String surname = surnameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        if (forename.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty()) {
            if (forename.isEmpty()) {
                forenameLabel.setForeground(Color.RED);
            }
            if (surname.isEmpty()) {
                surnameLabel.setForeground(Color.RED);
            }
            if (email.isEmpty()) {
                emailLabel.setForeground(Color.RED);
            }
            if (password.isEmpty()) {
                passwordLabel.setForeground(Color.RED);
            }
            JOptionPane.showMessageDialog(frame, "Text field cannot be empty");

        } else if (!(EmailValidator.isValidEmail(email))) {
            System.out.println("Email address is invalid");
            JOptionPane.showMessageDialog(frame, "Email address is invalid");
        } else {
            try {
                databaseConnectionHandler.openConnection();
                if(databaseOperations.verifyEmailIsUsed(connection, email) == false) {
                    char[] charPassword = password.toCharArray();
                    User newUser = new User(forename, surname, email, charPassword);
                    boolean isSuccess = databaseOperations.registerNewUser(connection, newUser);
                    if (isSuccess) {
                        JOptionPane.showMessageDialog(frame, "User successfully registered.");
                        forenameField.setText("");
                        surnameField.setText("");
                        emailField.setText("");
                        passwordField.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Email already used.");
                    emailLabel.setForeground(Color.RED);
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
    
}
