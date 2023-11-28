package com.sheffield.util;

import java.awt.Component;
import java.awt.Window;
import java.sql.Connection;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.sheffield.views.ItemFormScreen;
import com.sheffield.views.ProductListingScreen;

// Custom cell editor to handle button clicks
public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    private JTable table;
    private Connection connection;
    private String storedId;
    private String storedProductName;
    private int quantity;

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
            storedProductName = (String) table.getValueAt(row, column+1);
            quantity = (int) table.getValueAt(row, column + 4);
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
            } else if (this.label == "+ OrderLine") {
                JFrame frame = new JFrame();
                String inputQuantity = JOptionPane.showInputDialog(frame, "Enter quantity for "+ this.storedProductName + " :");
                
                if (Integer.parseInt(inputQuantity) > quantity) {
                    JOptionPane.showMessageDialog(button, "Input too large");
                } else {
                    JOptionPane.showMessageDialog(button, "Product added  to OrderLine");
                    // Window window = SwingUtilities.windowForComponent(button);
                    // if (window instanceof JFrame) {
                    //     window.dispose();
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