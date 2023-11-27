package com.sheffield.model;

import com.sheffield.util.HashedPasswordGenerator;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class DatabaseOperations {

    /**
     * Promotes the selected user to the role of Staff.
     *
     * @param connection   The database connection.
     * @param selectedUser The username of the user to be promoted.
     */
    public void promoteToStaff(Connection connection, String selectedUser) {
        PreparedStatement preparedStatement = null;

        try {
            // Get the userID based on the username
            String userID = getuserIDByUsername(connection, selectedUser);

            // Prepare the SQL statement to update the user's role to "Staff"
            String sql = "INSERT INTO Roles (userID, role) VALUES (?, 'Staff')";
            preparedStatement = connection.prepareStatement(sql);

            // Set the parameters for the prepared statement
            preparedStatement.setString(1, userID);

            // Execute the update
            preparedStatement.executeUpdate();

            // Additional actions may be performed here if needed after the user is promoted
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            // Close the prepared statement in a finally block to ensure it's closed even if
            // an exception occurs
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
     * Demotes the selected staff to the role of user.
     *
     * @param connection   The database connection.
     * @param selectedUser The username of the user to be promoted.
     */
    public void demoteStaff(Connection connection, String selectedUser) {
        PreparedStatement preparedStatement = null;

        try {
            // Get the userID based on the username
            String userID = getuserIDByUsername(connection, selectedUser);

            // Prepare the SQL statement to update the staff's role to "User"
            String sql = "INSERT INTO Roles (userID, role) VALUES (?, 'User')";
            preparedStatement = connection.prepareStatement(sql);

            // Set the parameters for the prepared statement
            preparedStatement.setString(1, userID);

            // Execute the update
            preparedStatement.executeUpdate();

            // Additional actions may be performed here if needed after the user is demoted
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            // Close the prepared statement in a finally block to ensure it's closed even if
            // an exception occurs
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
     * Gets the userID based on the username from the 'Users' table.
     *
     * @param connection The database connection.
     * @param username   The username for which to retrieve the userID.
     * @return The userID corresponding to the given username.
     */
    public String getuserIDByUsername(Connection connection, String username) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Prepare the SQL statement to select the userID based on the username
            String sql = "SELECT userID FROM Users WHERE username = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Set the parameter for the prepared statement
            preparedStatement.setString(1, username);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if a result is found
            if (resultSet.next()) {
                return resultSet.getString("userID");
            } else {
                System.out.println("User with username " + username + " not found.");
                return null; // Or throw an exception or handle the case as appropriate for your application
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
            return null;
        } finally {
            // Close the resources in a finally block to ensure they're closed even if an
            // exception occurs
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

    /**
     * Gets the userId based on the email from the 'Users' table.
     *
     * @param connection The database connection.
     * @param email      The email for which to retrieve the userId.
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
            // Close the resources in a finally block to ensure they're closed even if an
            // exception occurs
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

    /**
     * Promotes the selected user to the role of Moderator.
     *
     * @param connection The database connection.
     * @param User       The user to be promoted.
     */
    public void promoteToStaff(Connection connection, User selectedUser) {
        PreparedStatement preparedStatement = null;

        try {
            // Get the userId based on the username
            String userId = selectedUser.getUserID();

            // Prepare the SQL statement to update the user's role to "Staff"
            String sql = "INSERT INTO Roles (userId, role) VALUES (?, 'Staff')";
            preparedStatement = connection.prepareStatement(sql);

            // Set the parameters for the prepared statement
            preparedStatement.setString(1, userId);

            // Execute the update
            preparedStatement.executeUpdate();

            // Additional actions may be performed here if needed after the user is promoted
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            // Close the prepared statement in a finally block to ensure it's closed even if
            // an exception occurs
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
     * @param connection The database connection.
     * @param userId     The userId for which to retrieve roles.
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

    /**
     * Retrieves a result set containing all usernames from the 'Users' table.
     *
     * @param connection The database connection.
     * @return A result set containing all usernames.
     */
    public ResultSet getAllUsers(Connection connection) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try {
            // Execute the query to select all usernames from the 'Users' table
            String query = "SELECT u.userId, u.username, r.role FROM Users u, Roles r WHERE u.userId=r.userId";

            // Create a statement
            statement = connection.prepareStatement(query);

            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
        return null;
    }

    public boolean verifyLogin(Connection connection, String email, char[] enteredPassword) {

        try {
            // Fetch user information from database
            String sql = "SELECT userID, password, accountLocked " + "FROM Users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String userID = resultSet.getString("userID");
                String storedPasswordHash = resultSet.getString("password");
                boolean accountLocked = resultSet.getBoolean("accountLocked");

                // Check if account is locked
                if (accountLocked) {
                    System.out.println("Account is locked. Please contact support");
                    return false;
                } else {
                    // Verify entered password against stored hash
                    if (verifyPassword(enteredPassword, storedPasswordHash)) {
                        User user = new User(userID, email, getRolesForUserId(connection, userID));
                        CurrentUserManager.setCurrentUser(user);
                        System.out.println("Login successful for user: " + user);
                        return true;
                    } else {
                        // Incorrect password
                        System.out.println("Incorrect password");
                        return false;
                    }
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("User not found.");
        return false;

    }

    /**
     * Verifies a password against stored hash
     *
     * @param enteredPassword    The entered password.
     * @param storedPasswordHash The stored password hash.
     * @return True if the password is verified, false otherwise
     */
    private static boolean verifyPassword(char[] enteredPassword, String storedPasswordHash) {
        try {
            String hashedEnteredPassword = HashedPasswordGenerator.hashPassword(enteredPassword);
            return hashedEnteredPassword.equals(storedPasswordHash);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // USER OPERATION
    public boolean registerNewUser(Connection connection, User newUser) throws SQLException {
        try {
            String insertSQL = "INSERT INTO Users (userID, forename, surname, email, password, addressID)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, newUser.getUserID());
            preparedStatement.setString(2, newUser.getForename());
            preparedStatement.setString(3, newUser.getSurname());
            preparedStatement.setString(4, newUser.getEmail());
            preparedStatement.setString(5, newUser.getPassword());
            preparedStatement.setInt(6, 1);

            int rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + "row(s) inserted successfully.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception to signal an error.
        }
    }

    public boolean verifyEmailIsUsed(Connection connection, String email) throws SQLException {
        try {
            String query = "SELECT COUNT(*) AS count FROM Users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("count");

            if (count > 0) {
                return true;
            } else
                return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int countUsers(Connection connection) throws SQLException {
        try {
            String query = "SELECT COUNT(*) AS rowCount FROM Users";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int rowCount = resultSet.getInt("rowCount");
            System.out.println("Number of rows in the table: " + rowCount);

            return rowCount;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    // =========== PRODUCTS TABLE OPERATIONS ===========

    // Insert a new product into the database
    public void insertProduct(Product newProduct, Connection connection) throws SQLException {
        try {
            // Create an SQL INSERT statement
            String insertSQL = "INSERT INTO Products (productCode, name, brandName,"+
            "price, quantity, gaugeScale) VALUES (?, ?, ?, ?, ?, ?)";

            // Prepare and execute the INSERT statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, newProduct.getProductCode());
            preparedStatement.setString(2, newProduct.getName());
            preparedStatement.setString(3, newProduct.getBrandName());
            preparedStatement.setBigDecimal(4, newProduct.getPrice());
            preparedStatement.setInt(5, newProduct.getQuantity());
            preparedStatement.setString(6, newProduct.getGaugeScale());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception to signal an error.
        }
    }

    //  insert the extened values to the foreign product table
    public void insertForeignKey(int selectedIndex, Product newProduct, Connection connection) throws SQLException {
        try {
            // Create an SQL INSERT statement
            String insertSQL = "";
            PreparedStatement preparedStatement;
            int rowsAffected = 0;
            switch (selectedIndex) {
                case 0:
                    TrainSet newTrainSet = (TrainSet) newProduct;
                    insertSQL = "INSERT INTO TrainSets (productCode, era) VALUES (?, ?)";
                    // Prepare and execute the INSERT statement
                    preparedStatement = connection.prepareStatement(insertSQL);
                    preparedStatement.setString(1, newTrainSet.getProductCode());
                    preparedStatement.setString(2, newTrainSet.getEra());

                    rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " row(s) inserted successfully.");
                    break;
                case 1:
                    TrackPack newTrackPack = (TrackPack) newProduct;
                    insertSQL = "INSERT INTO TrackPacks (productCode) VALUES (?)";
                    // Prepare and execute the INSERT statement
                    preparedStatement = connection.prepareStatement(insertSQL);
                    preparedStatement.setString(1, newTrackPack.getProductCode());

                    rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " row(s) inserted successfully.");
                    break;
                case 2:
                    Track newTrack = (Track) newProduct;
                    insertSQL = "INSERT INTO Tracks (productCode) VALUES (?)";
                    // Prepare and execute the INSERT statement
                    preparedStatement = connection.prepareStatement(insertSQL);
                    preparedStatement.setString(1, newTrack.getProductCode());

                    rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " row(s) inserted successfully.");
                    break;
                case 3:
                    Locomotive newLocomotive = (Locomotive) newProduct;
                    insertSQL = "INSERT INTO Locomotives (productCode, era, dcc) VALUES (?, ?, ?)";
                    // Prepare and execute the INSERT statement
                    preparedStatement = connection.prepareStatement(insertSQL);
                    preparedStatement.setString(1, newLocomotive.getProductCode());
                    preparedStatement.setString(2, newLocomotive.getEra());
                    preparedStatement.setString(3, newLocomotive.getControllerType());

                    rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " row(s) inserted successfully.");

                    break;
                case 4:
                    RollingStock newRollingStock = (RollingStock) newProduct;
                    insertSQL = "INSERT INTO RollingStocks (productCode, era, rollingStockType) VALUES (?, ?, ?)";
                    // Prepare and execute the INSERT statement
                    preparedStatement = connection.prepareStatement(insertSQL);
                    preparedStatement.setString(1, newRollingStock.getProductCode());
                    preparedStatement.setString(2, newRollingStock.getEra());
                    preparedStatement.setString(3, newRollingStock.getRollingStockType());

                    rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " row(s) inserted successfully.");
                    break;
                case 5:
                    Controller newController = (Controller) newProduct;
                    insertSQL = "INSERT INTO Controllers (productCode, dcc) VALUES (?, ?)";
                    // Prepare and execute the INSERT statement
                    preparedStatement = connection.prepareStatement(insertSQL);
                    preparedStatement.setString(1, newController.getProductCode());
                    preparedStatement.setString(2, newController.getControllerType());

                    rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " row(s) inserted successfully.");
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception to signal an error.
        }
    }

    // count the number of product in the table
    public int countProduct(String tableName, Connection connection) throws SQLException {
        try {
            String query = "SELECT COUNT(*) AS rowCount FROM " + tableName;
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int rowCount = resultSet.getInt("rowCount");

            return rowCount;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

     // Get all products from the database
     public ResultSet getAllProducts(Connection connection, String tableName) throws SQLException {
        try {
            String selectSQL = "SELECT * FROM " + tableName;
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            // System.out.println("<=================== GET ALL PRODUCTS ====================>");
            // while (resultSet.next()) {
            //     // Print each product's information in the specified format
            //     System.out.println("{" +
            //             "productCode='" + resultSet.getString("productCode") + "'" +
            //             ", name='" + resultSet.getString("name") + "'" +
            //             ", brandName='" + resultSet.getString("brandName") + "'" +
            //             ", quantity='" + resultSet.getInt("quantity") + "'" +
            //             ", price='" + resultSet.getDouble("price") + "'" +
            //             ", gaugeScale='" + resultSet.getString("gaugeScale") + "'" +
            //             "}");
            // }
            // System.out.println("<======================================================>");
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;// Re-throw the exception to signal an error.
        }
    }

    // Get all subproducts from the database
    public ResultSet getAllAggregatedProducts(Connection connection, String originTable, String foreignTable, String aggregatedColumns) throws SQLException {
        ResultSet resultSet = null;
        try {
            String selectSQL = "SELECT u.* " + aggregatedColumns + " FROM " + originTable + " u JOIN " + foreignTable + " a ON u.productCode = a.productCode";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            resultSet = preparedStatement.executeQuery();
            // System.out.println("<=================== GET ALL PRODUCTS ====================>");
            // while (resultSet.next()) {
            //     // Print each product's information in the specified format
            //     System.out.println("{" +
            //             "productCode='" + resultSet.getString("productCode") + "'" +
            //             ", name='" + resultSet.getString("name") + "'" +
            //             ", brandName='" + resultSet.getString("brandName") + "'" +
            //             ", quantity='" + resultSet.getInt("quantity") + "'" +
            //             ", price='" + resultSet.getDouble("price") + "'" +
            //             ", gaugeScale='" + resultSet.getString("gaugeScale") + "'" +
            //             "}");
            // }
            // System.out.println("<======================================================>");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;// Re-throw the exception to signal an error.
        }

        return resultSet;
    }

    // Get a product by it's productCode
    public ResultSet getProductByCode(String productCode, Connection connection) throws SQLException {
        try {
            String selectSQL = "SELECT * FROM Products WHERE productCode=?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, productCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            // System.out.println("<==================== PRODUCT BY CODE =====================>");
            // if (resultSet.next()) {
            //     System.out.println("{" +
            //             "productCode='" + resultSet.getString("productCode") + "'" +
            //             ", name='" + resultSet.getString("name") + "'" +
            //             ", brandName='" + resultSet.getString("brand_name") + "'" +
            //             ", quantity='" + resultSet.getInt("quantity") + "'" +
            //             ", price='" + resultSet.getDouble("price") + "'" +
            //             "}");
            // } else {
            //     System.out.println("Product with productCode " + productCode + " not found.");
            // }
            // System.out.println("<=======================================================>");
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;// Re-throw the exception to signal an error.
        }
    }

    public ResultSet getSelectedAggregatedProducts(String productCode, Connection connection, String originTable, String foreignTable, String aggregatedColumns) throws SQLException {
        try {
            String selectSQL = "SELECT u.* " + aggregatedColumns + " FROM " + originTable + " u JOIN " + foreignTable + " a ON u.productCode = a.productCode WHERE u.productCode=?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, productCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            // System.out.println("<=================== GET ALL PRODUCTS ====================>");
            // while (resultSet.next()) {
            //     // Print each product's information in the specified format
            //     System.out.println("{" +
            //             "productCode='" + resultSet.getString("productCode") + "'" +
            //             ", name='" + resultSet.getString("name") + "'" +
            //             ", brandName='" + resultSet.getString("brandName") + "'" +
            //             ", quantity='" + resultSet.getInt("quantity") + "'" +
            //             ", price='" + resultSet.getDouble("price") + "'" +
            //             ", gaugeScale='" + resultSet.getString("gaugeScale") + "'" +
            //             "}");
            // }
            // System.out.println("<======================================================>");
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;// Re-throw the exception to signal an error.
        }
    }

    // Update an existing product in the database
    public void updateProduct(Product newProduct, Connection connection) throws SQLException {
        try {
            String updateSQL = "UPDATE Products SET name=?, brandName=?,"+
            "quantity=?, price=?, gaugeScale=? WHERE productCode=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);

            preparedStatement.setString(1, newProduct.getName());
            preparedStatement.setString(2, newProduct.getBrandName());
            preparedStatement.setInt(3, newProduct.getQuantity());
            preparedStatement.setBigDecimal(4, newProduct.getPrice());
            preparedStatement.setString(5, newProduct.getGaugeScale());
            preparedStatement.setString(6, newProduct.getProductCode());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " row(s) updated successfully.");
            } else {
                System.out.println("No rows were updated for productCode: " + newProduct.getProductCode());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;// Re-throw the exception to signal an error.
        }
    }

    //  insert the extened values to the foreign product table
    public void updateForeignKey(int selectedIndex, Product newProduct, Connection connection) throws SQLException {
        try {
            // Create an SQL INSERT statement
            String updateSQL = "";
            PreparedStatement preparedStatement;
            int rowsAffected = 0;
            switch (selectedIndex) {
                case 0:
                    TrainSet newTrainSet = (TrainSet) newProduct;
                    updateSQL = "UPDATE TrainSets SET era=? WHERE productCode=?";
                    // Prepare and execute the INSERT statement
                    preparedStatement = connection.prepareStatement(updateSQL);
                    preparedStatement.setString(1, newTrainSet.getEra());
                    preparedStatement.setString(2, newTrainSet.getProductCode());

                    rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " row(s) updated successfully.");
                    break;
                case 3:
                    Locomotive newLocomotive = (Locomotive) newProduct;
                    updateSQL = "UPDATE Locomotives SET era=?, dcc=? WHERE productCode=?";
                    // Prepare and execute the INSERT statement
                    preparedStatement = connection.prepareStatement(updateSQL);
                    preparedStatement.setString(1, newLocomotive.getEra());
                    preparedStatement.setString(2, newLocomotive.getControllerType());
                    preparedStatement.setString(3, newLocomotive.getProductCode());

                    rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " row(s) updated successfully.");
                    break;
                case 4:
                    RollingStock newRollingStock = (RollingStock) newProduct;
                    updateSQL = "UPDATE RollingStocks SET era=?,  rollingStockType=? WHERE productCode=?";
                    // Prepare and execute the INSERT statement
                    preparedStatement = connection.prepareStatement(updateSQL);
                    preparedStatement.setString(1, newRollingStock.getEra());
                    preparedStatement.setString(2, newRollingStock.getRollingStockType());
                    preparedStatement.setString(3, newRollingStock.getProductCode());

                    rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " row(s) updated successfully.");
                    break;
                case 5:
                    Controller newController = (Controller) newProduct;
                    updateSQL = "UPDATE Controllers SET dcc=? WHERE productCode=?";
                    // Prepare and execute the INSERT statement
                    preparedStatement = connection.prepareStatement(updateSQL);
                    preparedStatement.setString(1, newController.getControllerType());
                    preparedStatement.setString(2, newController.getProductCode());

                    rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " row(s) updated successfully.");
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception to signal an error.
        }
    }

    // Delete a product from the database by productCode
    public void deleteProduct(String tableName, String productCode, Connection connection) throws SQLException {
        try {
            String deleteSQL = "DELETE FROM " + tableName + " WHERE productCode=?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, productCode);
            preparedStatement.executeUpdate();
            
            deleteSQL = "DELETE FROM Products WHERE productCode=?";
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, productCode);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " row(s) deleted successfully.");
            } else {
                System.out.println("No rows were deleted for the product code: " + productCode);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;// Re-throw the exception to signal an error.
        }
    }

    // Get list columnName from tableName
    public List<Object> getListFromTable(Connection connection, String tableName, String columnName) throws SQLException {
        Statement st = connection.createStatement();
        String query = "SELECT " + columnName + " FROM team060." + tableName;

        List<Object> columnList = new ArrayList<>();

        ResultSet rs = st.executeQuery(query); // Execute query

        while (rs.next()) { // Check if result set has data
            String result = rs.getString(columnName);
            columnList.add(result);
        }

        rs.close(); // Close result set
        st.close(); // Close statement

        return columnList;
    }

    // Get record columnName with userID from tableName
    public String getRecordFromTable(Connection connection, String columnName, String tableName, String id) throws SQLException {

        String result = "";
        String query = "SELECT " + columnName + " FROM " + tableName + " WHERE userID='" + id + "'" ;

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                result = rs.getString(columnName);
            }
        }

        return result;
    }

    //Get UserID as token (from email) when logging in
    public String getUserID(Connection connection, String email) throws SQLException {

        String userID = "";
        String query = "SELECT userID FROM Users WHERE email=" + "'" + email + "'";

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                userID = rs.getString("userID");
            }
        }

        return userID;
    }

    //Update user details in ProfileScreen (ONLY FOR Users TABLE)
    public void updateUserDetails(Connection connection, String columnName, String value, String id) {
        String query = "UPDATE Users SET " + columnName + " = ? WHERE userID = ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, value); // Set the new value for the specified column
            pst.setString(2, id); // Set the user ID for the WHERE clause

            int rowsAffected = pst.executeUpdate(); // Execute the update statement
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}