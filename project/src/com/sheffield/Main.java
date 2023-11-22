// Import necessary libraries and classes
// minimum size 1216, 636
package com.sheffield;

import com.sheffield.model.DatabaseConnectionHandler;
import com.sheffield.views.NewLoginScreen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // Create an instance of DatabaseConnectionHandler for managing database connections
        DatabaseConnectionHandler databaseConnectionHandler = new DatabaseConnectionHandler();
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
>>>>>>> 334a6e66264fa3ea3f880c3ffa51f761862b37ba
    }
}