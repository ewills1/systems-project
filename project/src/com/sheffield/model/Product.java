package com.sheffield.model;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Product {
    private String productCode;
    private String name;
    private String brandName;
    private int quantity;
    private BigDecimal price;


    // Constructor to initialize a Product object with its attributes
    public Product(String name, String productCode, String brandName, int quantity, BigDecimal price) {
        this.setProductCode(productCode);
        this.setName(name);
        this.setBrandName(brandName);
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    // Getter and setter methods for the productCode attribute with validation
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        if (isValidCode(code)) {
            this.code = productCode;
        } else {
            throw new IllegalArgumentException("Product code is not valid.");
        }
    }

    // Getter and setter methods for the Name attribute with validation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isValidName(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Product name is not valid.");
        }
    }

    // Getter and setter methods for the BrandName attribute with validation
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        if (isValidBrandName(brandName)) {
            this.brandName = brandName;
        } else {
            throw new IllegalArgumentException("Brand name is not valid.");
        }
    }

    // Getter and setter methods for the Quantity attribute with validation
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (isValidQuantity(quantity)) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantity is not valid.");
        }
    }

    // Getter and setter methods for the Price attribute with validation
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (isValidPrice(price)) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price is not valid.");
        }
    }

    // Private validation methods for each attribute
    private boolean isValidProductCode(String productCode) {
        return productCode != null && productCode.length() <= 100;
    }

    private boolean isValidName(String name) {
        return name != null && name.length() <= 100;
    }

    private boolean isValidBrandName(String brandName) {
        return brandName != null && brandName.length() <= 100;
    }

    private boolean isValidQuantity(int quantity) {
        return quantity >= 0;
    }

    private boolean isValidPrice(BigDecimal price) {
        // price must be non-negative
        return price != null && price.compareTo(BigDecimal.ZERO) >= 0;
    }


    @Override
    public String toString() {
        return "{ " +
            " productCode='" + getProductCode() + "'" +
            ", name='" + getName() + "'" +
            ", brandName='" + getBrandName() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", price='" + getPrice() + "'" +
            " }";
    }

    // Insert a new product into the database
    public void insertProduct(Product newProduct, Connection connection) throws SQLException {
        try {
            // Create an SQL INSERT statement
            String insertSQL = "INSERT INTO Products (productCode, name, brand_name,"+
            "quantity, price) VALUES (?, ?, ?, ?, ?, ?)";

            // Prepare and execute the INSERT statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, newProduct.getProductCode());
            preparedStatement.setString(2, newProduct.getName());
            preparedStatement.setString(3, newProduct.getBrandName());
            preparedStatement.setInt(4, newProduct.getQuantity());
            preparedStatement.setBigDecimal(5, newProduct.getPrice());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception to signal an error.
        }
    }

    // Get all products from the database
    public void getAllProducts(Connection connection) throws SQLException {
        try {
            String selectSQL = "SELECT * FROM Products";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("<=================== GET ALL PRODUCTS ====================>");
            while (resultSet.next()) {
                // Print each product's information in the specified format
                System.out.println("{" +
                        "productCode='" + resultSet.getString("productCode") + "'" +
                        ", name='" + resultSet.getString("name") + "'" +
                        ", brandName='" + resultSet.getString("brand_name") + "'" +
                        ", quantity='" + resultSet.getInt("quantity") + "'" +
                        ", price='" + resultSet.getDouble("price") + "'" +
                        "}");
            }
            System.out.println("<======================================================>");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;// Re-throw the exception to signal an error.
        }
    }

    // Get a product by it's productCode
    public void getProductByCode(String productCode, Connection connection) throws SQLException {
        try {
            String selectSQL = "SELECT * FROM Products WHERE productCode=?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, productCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("<==================== PRODUCT BY CODE =====================>");
            if (resultSet.next()) {
                System.out.println("{" +
                        "productCode='" + resultSet.getString("productCode") + "'" +
                        ", name='" + resultSet.getString("name") + "'" +
                        ", brandName='" + resultSet.getString("brand_name") + "'" +
                        ", quantity='" + resultSet.getInt("quantity") + "'" +
                        ", price='" + resultSet.getDouble("price") + "'" +
                        "}");
            } else {
                System.out.println("Product with productCode " + productCode + " not found.");
            }
            System.out.println("<=======================================================>");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;// Re-throw the exception to signal an error.
        }
    }

    // Update an existing product in the database
    public void updateProduct(Product newProduct, Connection connection) throws SQLException {
        try {
            String updateSQL = "UPDATE Products SET name=?, brandName=?,"+
            "quantity=?, price=? WHERE productCode=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);

            preparedStatement.setString(1, newProduct.getName());
            preparedStatement.setString(2, newProduct.getBrandName());
            preparedStatement.setInt(3, newProduct.getQuantity());
            preparedStatement.setBigDecimal(4, newProduct.getPrice());
            preparedStatement.setString(5, newProduct.getProductCode());

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

    // Delete a product from the database by productCode
    public void deleteProduct(String productCode, Connection connection) throws SQLException {
        try {
            String deleteSQL = "DELETE FROM Product WHERE productCode=?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
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
}