
package bookbank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddBooks extends JFrame implements ActionListener {
    JButton b1, b2;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    JLabel L1, L2, L3, L4, L5, L6, L7;

    public AddBooks() {
        setTitle("Add Books");
        setSize(1366, 768); // Set the frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE); // Set background color to white
        setLayout(null); // Using absolute positioning

        // Adding header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); // Steel blue
        headerPanel.setBounds(0, 0, getWidth(), 100); // Position and size
        headerPanel.setLayout(new GridBagLayout()); // Center the label

        // Adding header label to the header panel
        L7 = new JLabel("Add Books", JLabel.CENTER);
        L7.setFont(new Font("Arial", Font.BOLD, 36));
        L7.setForeground(Color.WHITE);
        headerPanel.add(L7);

        // Adding header panel to the frame
        add(headerPanel);

        // Initialize components
        L1 = new JLabel("BOOK ID");
        L2 = new JLabel("BOOK NAME");
        L3 = new JLabel("AUTHOR");
        L4 = new JLabel("GENRE");
        L5 = new JLabel("PRICE");
        L6 = new JLabel("COPIES");

        // Set font size for labels
        Font labelFont = new Font("Arial", Font.BOLD, 30); // Increased font size
        L1.setFont(labelFont);
        L2.setFont(labelFont);
        L3.setFont(labelFont);
        L4.setFont(labelFont);
        L5.setFont(labelFont);
        L6.setFont(labelFont);

        // Calculate positions for centering labels and text fields
        int labelX = (getWidth() - 650) / 2; // Center labels horizontally
        int textFieldX = labelX + 300; // Adjust text fields relative to labels
        int startY = 150;
        int verticalGap = 60;
        int labelWidth = 200;
        int textFieldWidth = 300;
        int labelHeight = 40;
        int textFieldHeight = 40;

        L1.setBounds(labelX, startY, labelWidth, labelHeight);
        L2.setBounds(labelX, startY + verticalGap, labelWidth, labelHeight);
        L3.setBounds(labelX, startY + 2 * verticalGap, labelWidth, labelHeight);
        L4.setBounds(labelX, startY + 3 * verticalGap, labelWidth, labelHeight);
        L5.setBounds(labelX, startY + 4 * verticalGap, labelWidth, labelHeight);
        L6.setBounds(labelX, startY + 5 * verticalGap, labelWidth, labelHeight);

        tf1 = createStyledTextField(textFieldX, startY);
        tf2 = createStyledTextField(textFieldX, startY + verticalGap);
        tf3 = createStyledTextField(textFieldX, startY + 2 * verticalGap);
        tf4 = createStyledTextField(textFieldX, startY + 3 * verticalGap);
        tf5 = createStyledTextField(textFieldX, startY + 4 * verticalGap);
        tf6 = createStyledTextField(textFieldX, startY + 5 * verticalGap);

        b1 = createStyledButton("ADD BOOKS", 300, 540, new Color(0, 153, 204)); // Blue
        b2 = createStyledButton("BACK", 700, 540, new Color(255, 87, 34)); // Orange

        // Adding components to the frame
        add(L1);
        add(L2);
        add(L3);
        add(L4);
        add(L5);
        add(L6);
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(tf5);
        add(tf6);
        add(b1);
        add(b2);

        // Add action listeners to buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    // Method to create styled buttons
    private JButton createStyledButton(String text, int x, int y, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setForeground(Color.WHITE);
        button.setBackground(color); // Set button background color
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setBounds(x, y, 300, 70);

        // Custom hover effects
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(color.darker()); // Darker color on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color); // Restore original background color
            }
        });

        return button;
    }

    // Method to create styled text fields with hover effect
    private JTextField createStyledTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setForeground(Color.BLACK);
        textField.setBackground(Color.WHITE); // Set initial background color
        textField.setBounds(x, y, 300, 40);

        // Custom hover effects
        textField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                textField.setBackground(Color.LIGHT_GRAY); // Change background on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                textField.setBackground(Color.WHITE); // Restore original background color
            }
        });

        return textField;
    }

    // Action listener method
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            // Add book functionality
            try {
                // Validate input fields
                if (tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || 
                    tf4.getText().isEmpty() || tf5.getText().isEmpty() || tf6.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit method if validation fails
                }

                // Step 1: Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Step 2: Create the connection object
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bookbank", "root", "");

                // Step 3: Create the statement object
                String q = "INSERT INTO Books VALUES(?,?,?,?,?,?)";

                // Get the preparedStatement object
                PreparedStatement pstmt = con.prepareStatement(q);

                String book_id = tf1.getText();
                String bname = tf2.getText();
                String author = tf3.getText();
                String genre = tf4.getText();
                String price = tf5.getText();
                String no_of_copies = tf6.getText();

                pstmt.setString(1, book_id);
                pstmt.setString(2, bname);
                pstmt.setString(3, author);
                pstmt.setString(4, genre);
                pstmt.setString(5, price);
                pstmt.setString(6, no_of_copies);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Book added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Clear text fields after adding
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");
                tf6.setText("");

            } catch (Exception ee) {
                ee.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error in adding book", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == b2) {
            // Back button functionality
            AdminAccount adminAccount = new AdminAccount();
            adminAccount.setSize(1366, 768);
            adminAccount.setVisible(true);
            adminAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
    }

    // Main method to run the application
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            AddBooks addBooks = new AddBooks();
            addBooks.setVisible(true);
        });
    }
}
