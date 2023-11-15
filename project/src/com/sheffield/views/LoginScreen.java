package com.sheffield.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    //private static final long serialVersionUID = 1L;

    public LoginScreen(String title) throws HeadlessException {
        super(title);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        setSize(screenSize.width/2, screenSize.height/2);
        setLocation(screenSize.width/4, screenSize.height/4);

        JPanel panel = new JPanel();
        panel.setLayout(null); //layout should take the entire width and height of the screen.

        JLabel labelUsername = new JLabel("Username");
        labelUsername.setBounds(100,8,70,20);

        JTextField textFieldUsername = new JTextField();
        textFieldUsername.setBounds(100,27,193,28);

        JLabel labelPassword = new JLabel("Password");
        labelPassword.setBounds(100, 55, 70, 20);

        JPasswordField textFieldPassword = new JPasswordField();
        textFieldPassword.setBounds(100, 75, 193, 28);

        JButton button = new JButton("Login");
        button.setBounds(100, 110, 90, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the login screen
                MainScreen mainMenu = new MainScreen("Train Toy Store - Main Menu");
                mainMenu.setVisible(true); // Show the main menu screen
            }
        });
        //button.addActionListener((ActionListener) new Java_GUI());

        panel.add(labelUsername);
        panel.add(textFieldUsername);
        panel.add(labelPassword);
        panel.add(textFieldPassword);

        panel.add(button);

        add(panel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }

}