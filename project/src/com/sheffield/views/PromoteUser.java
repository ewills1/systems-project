package com.sheffield.views;

import com.sheffield.model.CurrentUserManager;
import com.sheffield.model.DatabaseOperations;
import com.sheffield.model.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * The PromoteUser class represents the GUI window for promoting users to Staff.
 */
public class PromoteUser extends JFrame {
    private JComboBox<String> userComboBox;
    private final DatabaseOperations databaseOperations;

    public PromoteUser(Connection connection, String id) {
        super();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        setSize(screenSize.width / 2, screenSize.height / 2);
        setLocation(screenSize.width / 4, screenSize.height / 4);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // initialise widgets and other components
        initComponents(connection, id);

        setVisible(true);
    }

    /**
     * Constructor for the promoteUser.
     *
     * @param connection The database connection.
     * @throws SQLException if a database access error occurs.
     */
    public PromoteUser(Connection connection) throws SQLException {
        // Initialize DatabaseOperations
        databaseOperations = new DatabaseOperations();

        // Set properties for the new window
        setTitle("Promote Users");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel for the new window
        JPanel panel = new JPanel();
        add(panel);

        // Add a welcome label to the panel
        JLabel welcomeLabel = new JLabel(
                "Welcome to the Promote User Window! " + CurrentUserManager.getCurrentUser().getForename());
        if (CurrentUserManager.getCurrentUser().getRoles().contains(Role.MANAGER)) {
            welcomeLabel.setForeground(Color.RED); // Set the foreground color to red for managers
        }
        panel.add(welcomeLabel);

        // Check if the current user is a manager or staff
        if (isUserAuthorised(Role.MANAGER) || isUserAuthorised(Role.STAFF)) {
            // Create a JComboBox for user selection
            userComboBox = new JComboBox<>();
            // Populate the combo box with user data (you need to have a method to get
            // users)
            populateUserComboBox(connection);
            panel.add(userComboBox);

            // Create a button to promote the selected user to Staff
            JButton promoteButton = new JButton("Promote to Staff");
            panel.add(promoteButton);

            // Add action listener to the button
            promoteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isUserAuthorised(Role.MANAGER)) {
                        // Get the selected user from the combo box
                        String selectedUser = String.valueOf(userComboBox.getSelectedItem());

                        // Check if a user is selected
                        if (selectedUser != null) {

                            // Ask for confirmation
                            int dialogResult = JOptionPane.showConfirmDialog(null,
                                    "Are you sure you want to promote " + selectedUser + " to Staff?", "Confirmation",
                                    JOptionPane.YES_NO_OPTION);

                            // Check the Manager's choice
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                // Manager confirmed, promote the selected user to Staff
                                databaseOperations.promoteToStaff(connection, selectedUser);
                                JOptionPane.showMessageDialog(null, selectedUser + " has been promoted to Staff.");
                            } else {
                                // Manager canceled the action
                                JOptionPane.showMessageDialog(null, "Promotion canceled.", "Canceled",
                                        JOptionPane.WARNING_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Please select a user.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "You are not a manager!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }
    }

    /**
     * Populates the user combo box with user data from the database.
     *
     * @param connection The database connection.
     * @throws SQLException if a database access error occurs.
     */
    private void populateUserComboBox(Connection connection) throws SQLException {
        ResultSet resultSet = databaseOperations.getAllUsers(connection);
        // Populate the JTable with the query results
        while (resultSet.next()) {
            // Get the userID from the result set
            String userID = resultSet.getString("userID");
            Role role = Role.fromString(resultSet.getString("role"));

            // Check if the userID is not the same as the current user's userID
            if (!userID.equals(CurrentUserManager.getCurrentUser().getUserID()) && role.equals(Role.USER)) {
                userComboBox.addItem(userID);
            }
        }
    }

    private boolean isUserAuthorised(Role role) {
        List<Role> listOfRolesForCurrentUser = CurrentUserManager.getCurrentUser().getRoles();
        for (Role roleForCurrentUser : listOfRolesForCurrentUser) {
            if (roleForCurrentUser.equals(role)) {
                return true;
            }
        }
        return false;
    }

}