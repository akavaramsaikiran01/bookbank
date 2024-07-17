package bookbank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Issue extends JFrame implements ActionListener {
    JLabel L1, L2;
    JButton b1, b2;
    JTextField t1, t2;

    public Issue() {
        setTitle("Issue Book");
        setSize(1366, 768); // Adjusted frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE); // Set background color to white
        setLayout(new BorderLayout()); // Use BorderLayout for the frame

        // Adding header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); // Steel blue
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30)); // Center header content vertically
        headerPanel.setPreferredSize(new Dimension(1366, 100)); // Set preferred size
        JLabel L7 = new JLabel("Issue Book");
        L7.setFont(new Font("Arial", Font.BOLD, 36));
        L7.setForeground(Color.WHITE);
        headerPanel.add(L7);

        // Adding header panel to the top of the frame
        add(headerPanel, BorderLayout.NORTH);

        // Panel for form components
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Using absolute positioning for form components
        formPanel.setBackground(Color.WHITE);

        // Initialize components
        L1 = new JLabel("Customer Id");
        L2 = new JLabel("Book Id");
        Font labelFont = new Font("Arial", Font.BOLD, 24); // Increased font size
        L1.setFont(labelFont);
        L2.setFont(labelFont);

        int labelWidth = 200;
        int labelHeight = 30;

        L1.setBounds(50, 50, labelWidth, labelHeight);
        L2.setBounds(50, 110, labelWidth, labelHeight);

        t1 = createStyledTextField(270, 50, 250); // Adjusted text field position
        t2 = createStyledTextField(270, 110, 250); // Adjusted text field position

        b1 = createStyledButton("ISSUE", 200, 180, new Color(0, 153, 204)); // Blue
        b2 = createStyledButton("BACK", 400, 180, new Color(255, 87, 34)); // Orange

        formPanel.add(L1);
        formPanel.add(L2);
        formPanel.add(t1);
        formPanel.add(t2);
        formPanel.add(b1);
        formPanel.add(b2);

        // Add formPanel to center of BorderLayout
        add(formPanel, BorderLayout.CENTER);

        // Add action listeners to buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    // Method to create styled buttons
    private JButton createStyledButton(String text, int x, int y, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(color); // Set button background color
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setBounds(x, y, 150, 40); // Adjusted button size

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
    private JTextField createStyledTextField(int x, int y, int width) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 18));
        textField.setForeground(Color.BLACK);
        textField.setBackground(Color.WHITE); // Set initial background color
        textField.setBounds(x, y, width, 30);

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
            String cid = t1.getText();
            String bid = t2.getText();

            // Check if both customer and book exist
            if (!isCustomerExists(cid)) {
                JOptionPane.showMessageDialog(this, "Customer with ID " + cid + " does not exist", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return; // Exit the method if customer does not exist
            }

            if (!isBookExists(bid)) {
                JOptionPane.showMessageDialog(this, "Book with ID " + bid + " does not exist", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return; // Exit the method if book does not exist
            }

            // Issue the book
            try {
                // Step 1: Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Step 2: Create the connection object
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bookbank", "root", "");

                // Step 3: Insert into statustable
                String q1 = "INSERT INTO statustable (CustomerId, BookId, statuss) VALUES (?, ?, ?)";
                PreparedStatement pstmt1 = con.prepareStatement(q1);
                pstmt1.setString(1, cid);
                pstmt1.setString(2, bid);
                pstmt1.setString(3, "not returned");
                pstmt1.executeUpdate();

                // Step 4: Update number of copies in books table
                String q2 = "UPDATE books SET Copies = Copies - 1 WHERE BookId = ?";
                PreparedStatement pstmt2 = con.prepareStatement(q2);
                pstmt2.setString(1, bid);
                pstmt2.executeUpdate();

                JOptionPane.showMessageDialog(this, "Book issued successfully", "Success",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (ClassNotFoundException | SQLException ee) {
                JOptionPane.showMessageDialog(this, "Error: " + ee.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == b2) {
            AdminAccount adminAccount = new AdminAccount();
            adminAccount.setSize(1366, 768); // Adjusted frame size
            adminAccount.setVisible(true);
            adminAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
    }

    private boolean isCustomerExists(String customerId) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookbank", "root", "")) {

            String query = "SELECT * FROM customers WHERE CustomerId = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, customerId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // true if customer exists, false otherwise
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isBookExists(String bookId) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookbank", "root", "")) {

            String query = "SELECT * FROM books WHERE BookId = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, bookId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // true if book exists, false otherwise
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Issue issue = new Issue();
            issue.setVisible(true);
        });
    }
}
