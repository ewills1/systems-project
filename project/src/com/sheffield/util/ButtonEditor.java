package com.sheffield.util;

import java.awt.Component;
import java.awt.Window;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.sheffield.views.ItemFormScreen;
import com.sheffield.views.ProductListingScreen;
import com.sheffield.model.Product;
import com.sheffield.model.OrderLine;
import com.sheffield.model.DatabaseOperations;
import com.sheffield.model.Order;
import com.sheffield.model.Status;

// Custom cell editor to handle button clicks
public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    private JTable table;
    private Connection connection;
    private String storedId;
    private String storedProductName;
    private String storedBrandName;
    private BigDecimal storedPrice;
    private String storedGauge;
    private int storedQuantity;
    private int orderID;
    private List<OrderLine> orderLines;
    private Date date;
    private double totalCost;

    DatabaseOperations databaseOperations = new DatabaseOperations();

    public ButtonEditor(JTextField textField, JTable table, Connection connection) {
        super(textField);
        this.table = table;
        this.connection = connection;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> {
            int row = this.table.getEditingRow(); // Get the row index of the clicked button
            int column = 1; // Get the column index of the clicked button
            storedId = (String) table.getValueAt(row, column);
            storedProductName = (String) table.getValueAt(row, column + 1);
            storedBrandName = (String) table.getValueAt(row, column + 2);
            storedPrice = (BigDecimal) table.getValueAt(row, column + 3);
            storedQuantity = (int) table.getValueAt(row, column + 4);
            storedGauge = (String) table.getValueAt(row, column + 5);
            // Perform different actions based on row and column indices
            fireEditingStopped();
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    public Object getCellEditorValue() {
        if (isPushed) {
            // Perform the action when the button is clicked
            if (this.label == "Update/Delete") {
                JOptionPane.showMessageDialog(button, "Editing: " + storedId);
                // Close the current screen (frame)
                Window window = SwingUtilities.windowForComponent(button);
                if (window instanceof JFrame) {
                    window.dispose();
                }

                // Open another screen (frame)
                JFrame newFrame = new ItemFormScreen(connection, storedId);
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Change to your desired close operation
                // Configure the new frame: set size, add components, etc.
                newFrame.setVisible(true);
            } else if (this.label == "Add to order") {
                JFrame frame = new JFrame();
                String inputQuantity = JOptionPane.showInputDialog(frame,
                        "Enter quantity for " + this.storedProductName + " :");

                int inpQ = Integer.parseInt(inputQuantity);
                if (inpQ > storedQuantity) {
                    JOptionPane.showMessageDialog(button, "Input too large");
                } else {
                    Product product = new Product(storedId, storedProductName, storedBrandName,
                            storedQuantity, storedPrice, storedGauge);
                    // create an orderLine
                    OrderLine line = new OrderLine(orderID, product, inpQ);
                    orderLines.add(line);
                    databaseOperations.insertOrderLine(connection, line);

                    /*
                     * THIS CODE CREATES THE ORDER AND ADDS IT TO THE DATABASE
                     * CREATE A SEPARATE BUTTON FOR THIS
                     * 
                     * Order order = new Order(orderID, orderLines, date, Status.PENDING);
                     * totalCost = order.getTotalCost();
                     * 
                     * databaseOperations.insertOrder(connection, order); // confirm order
                     * 
                     * orderID += 1;
                     */

                    // implement code that adds the storedProductName and its inputQuantity to the
                    // order as an
                    // orderLine
                    JOptionPane.showMessageDialog(button, "Product added to order");
                    // Window window = SwingUtilities.windowForComponent(button);
                    // if (window instanceof JFrame) {
                    // window.dispose();
                    // }

                    // JFrame newFrame = new ProductListingScreen(connection, "");
                    // newFrame.setVisible(true);
                }
            }
        }
        isPushed = false;
        return label;
    }

    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}