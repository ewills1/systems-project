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
 * The DemoteStaff class represents the GUI window for demoting Staff to User.
 */
public class DemoteStaff extends JFrame {
    private JComboBox<String> userComboBox;
    private final DatabaseOperations databaseOperations;

    /**
     * Constructor for the demoteStaff.
     *
     * @param connection The database connection.
     * @throws SQLException if a database access error occurs.
     */
    public DemoteStaff(Connection connection) throws SQLException {
        // Initialize DatabaseOperations
        databaseOperations = new DatabaseOperations();

        // Set properties for the new window
        setTitle("Demote Staff");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel for the new window
        JPanel panel = new JPanel();
        add(panel);

        // Add a welcome label to the panel
        JLabel welcomeLabel = new JLabel(
                "Welcome to the Demote Staff Window! " + CurrentUserManager.getCurrentUser().getForename());
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

            // Create a button to demote the selected user to User
            JButton demoteButton = new JButton("demote to User");
            panel.add(demoteButton);

            // Add action listener to the button
            demoteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isUserAuthorised(Role.MANAGER)) {
                        // Get the selected staff from the combo box
                        String selectedStaff = String.valueOf(userComboBox.getSelectedItem());

                        // Check if a member of staff is selected
                        if (selectedStaff != null) {

                            // Ask for confirmation
                            int dialogResult = JOptionPane.showConfirmDialog(null,
                                    "Are you sure you want to promote " + selectedStaff + " to Staff?", "Confirmation",
                                    JOptionPane.YES_NO_OPTION);

                            // Check the Manager's choice
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                // Manager confirmed, demote the selected Staff to User
                                databaseOperations.demoteStaff(connection, selectedStaff);
                                JOptionPane.showMessageDialog(null, selectedStaff + " has been demoted to User.");
                            } else {
                                // Manager canceled the action
                                JOptionPane.showMessageDialog(null, "demotion canceled.", "Canceled",
                                        JOptionPane.WARNING_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Please select a member of staff.");
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