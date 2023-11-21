// Import necessary libraries and classes
// minimum size 1216, 636
package com.sheffield;

import com.sheffield.model.DatabaseConnectionHandler;
import com.sheffield.views.LoanTableDisplay;
import com.sheffield.views.LoginScreen;
import com.sheffield.views.NewLoginScreen;
import com.sheffield.views.TemplateScreen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        new NewLoginScreen();

        // LoginScreen loginDisplay = new LoginScreen("Train Toy Store - Login"); //visible(true)

        // Create an instance of DatabaseConnectionHandler for managing database connections
        DatabaseConnectionHandler databaseConnectionHandler = new DatabaseConnectionHandler();
    }
}