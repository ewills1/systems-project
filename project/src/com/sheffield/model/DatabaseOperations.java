package com.sheffield.model;

import com.sheffield.util.HashedPasswordGenerator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class DatabaseOperations {

    /**
     * Gets the userId based on the email from the 'Users' table.
     *
     * @param connection The database connection.
     * @param email   The email for which to retrieve the userId.
     * @return The userId corresponding to the given email.
     */
    public String getUserIdByEmail(Connection connection, String email) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Prepare the SQL statement to select the userId based on the username
            String sql = "SELECT userId FROM Users WHERE username = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Set the parameter for the prepared statement
            preparedStatement.setString(1, email);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if a result is found
            if (resultSet.next()) {
                return resultSet.getString("userId");
            } else {
                System.out.println("User with username " + email + " not found.");
                return null; // Or throw an exception or handle the case as appropriate for your application
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
            return null;
        } finally {
            // Close the resources in a finally block to ensure they're closed even if an exception occurs
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle the exception according to your application's needs
            }
        }
    }

    public void printTEST(Connection connection) throws SQLException {
        System.out.println("Dummy function to test connection to database");
        System.out.println("Should print cityName from Addresses from DB");
        Statement st = connection.createStatement();
        String query = "select * from team060.Addresses";
        ResultSet rs = st.executeQuery(query); // Execute query
        while (rs.next()) { // Check if result set has data
            String result = rs.getString("cityName"); // Retrieve name from db
            System.out.println(result); // Print result on console
        }
        /*else {
            System.out.println("No data found in the result set");
        }*/

        rs.close(); // Close result set
        st.close(); // Close statement
    }

     /**
     * Promotes the selected user to the role of Moderator.
     *
     * @param connection    The database connection.
     * @param selectedUser  The username of the user to be promoted.
     */
    public void promoteToModerator(Connection connection, String selectedUser) {
        PreparedStatement preparedStatement = null;

        try {
            // Get the userId based on the username
            String userId = getUserIdByEmail(connection, selectedUser);

            // Prepare the SQL statement to update the user's role to "Moderator"
            String sql = "INSERT INTO Roles (userId, role) VALUES (?, 'Moderator')";
            preparedStatement = connection.prepareStatement(sql);

            // Set the parameters for the prepared statement
            preparedStatement.setString(1, userId);

            // Execute the update
            preparedStatement.executeUpdate();

            // Additional actions may be performed here if needed after the user is promoted
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            // Close the prepared statement in a finally block to ensure it's closed even if an exception occurs
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle the exception according to your application's needs
            }
        }
    }

    /**
     * Gets the user roles based on the userId.
     *
     * @param connection  The database connection.
     * @param userId  The userId for which to retrieve roles.
     * @return The user's roles.
     */
    private List<Role> getRolesForUserId(Connection connection, String userId) {
        List<Role> listOfRoles = new ArrayList<>();
        try {
            String sql = "SELECT role FROM Roles WHERE userId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                listOfRoles.add(Role.fromString(resultSet.getString("role")));
            }
            return listOfRoles;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    
}
