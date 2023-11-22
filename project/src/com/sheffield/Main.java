// Import necessary libraries and classes
// minimum size 1216, 636
package com.sheffield;

import com.sheffield.model.DatabaseConnectionHandler;
import com.sheffield.views.LoginScreen;
import com.sheffield.views.NewLoginScreen;
import com.sheffield.views.TemplateScreen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // Create an instance of DatabaseConnectionHandler for managing database connections
        DatabaseConnectionHandler databaseConnectionHandler = new DatabaseConnectionHandler();
        new NewLoginScreen(databaseConnectionHandler.getConnection());
    }
}