package bookbank;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

public class TotalBooks extends JFrame {
    private JTable table;
    private JButton backButton;

    public TotalBooks() {
        setTitle("Books Details");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Adding header panel for the frame
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); // Steel blue
        headerPanel.setBounds(0, 0, getWidth(), 100); // Position and size
        headerPanel.setLayout(new GridBagLayout()); // Center the label

        // Adding header label to the frame header panel
        JLabel frameHeaderLabel = new JLabel("Available Books", JLabel.CENTER); // Centered text
        frameHeaderLabel.setFont(new Font("Arial", Font.BOLD, 36));
        frameHeaderLabel.setForeground(Color.WHITE);
        headerPanel.add(frameHeaderLabel);

        // Adding header panel to the frame
        add(headerPanel);

        // Initialize and set properties for the table
        table = new JTable();
        table.setBackground(Color.WHITE);

        // Create scroll pane for the table
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(40, 120, 1266, 550); // Adjusted size to fit the frame
        pane.setBackground(Color.WHITE);
        add(pane);

        try {
            Conn c = new Conn();
            String query = "SELECT * FROM books";
            ResultSet rs = c.stmt.executeQuery(query);

            // Check if ResultSet is empty
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No books available.");
            } else {
                table.setModel(DbUtils.resultSetToTableModel(rs));
                // Customize table cell rendering for alternating row colors
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        if (row % 2 == 0) {
                            c.setBackground(Color.WHITE); // Even row color
                        } else {
                            c.setBackground(new Color(240, 240, 240)); // Odd row color
                        }
                        return c;
                    }
                };

                // Apply the renderer to all columns
                for (int i = 0; i < table.getColumnCount(); i++) {
                    table.getColumnModel().getColumn(i).setCellRenderer(renderer);
                }

                // Customize table header
                JTableHeader header = table.getTableHeader();
                header.setFont(new Font("Arial", Font.BOLD, 14));
                header.setForeground(Color.WHITE);
                header.setBackground(new Color(0, 150, 136)); // Steel green for table header
                header.setPreferredSize(new Dimension(pane.getWidth(), 30));
                header.setReorderingAllowed(false);
                header.setResizingAllowed(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create and set properties for the back button
        backButton = new JButton("BACK");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(255, 87, 34));
        backButton.setBounds(1266 - 100 - 40, 20, 100, 50); // Positioned at the top right corner
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // Handle button click (navigate back to AdminAccount or other logic)
                AdminAccount adminAccount = new AdminAccount();
                adminAccount.setSize(1366, 768);
                adminAccount.setVisible(true);
                adminAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose(); // Close the current frame
            }
        });

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new Color(255, 87, 34).darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new Color(255, 87, 34));
            }
        });

        add(backButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TotalBooks tb = new TotalBooks();
            tb.setVisible(true);
        });
    }
}
