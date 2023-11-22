// Import necessary libraries and classes
// minimum size 1216, 636
package com.sheffield;

import com.sheffield.model.DatabaseConnectionHandler;
import com.sheffield.views.LoginScreen;
import com.sheffield.views.NewLoginScreen;
import com.sheffield.views.TemplateScreen;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        // Create an instance of DatabaseConnectionHandler for managing database connections
        DatabaseConnectionHandler databaseConnectionHandler = new DatabaseConnectionHandler();
<<<<<<< HEAD
=======

<<<<<<< HEAD
        // Execute the Swing GUI application on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            NewLoginScreen newLoginScreen = null;
            try {
                // Open a database connection
                databaseConnectionHandler.openConnection();

                // Create and initialize the LoanTableDisplay view using the database connection
                newLoginScreen = new NewLoginScreen(databaseConnectionHandler.getConnection());

            } catch (Throwable t) {
                // Close connection if database crashes.
                databaseConnectionHandler.closeConnection();
                throw new RuntimeException(t);
            }
        });


=======
>>>>>>> 4ee7fc6594ae906a83da4d01894c087b1e3b42f5
>>>>>>> 566eb15f8ec548f2b31015b9693d3da203035a2d
    }
}