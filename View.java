package bookbank;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class View extends JFrame implements ActionListener {
    private JTable table;
    private JButton backButton;

    public static void main(String[] args) {
        new View(null);
    }

    public View(String genre) {
        // Set up frame properties
        setTitle("Books Details");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Adding header panel for the frame
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); // Steel blue
        headerPanel.setBounds(0, 0, getWidth(), 100); // Position and size
        headerPanel.setLayout(new GridBagLayout()); // Center the label

        // Adding header label to the frame header panel
        JLabel frameHeaderLabel = new JLabel("Books Details:", JLabel.CENTER);
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
        pane.setBounds(40, 120, 1266, 600); // Adjusted size to fit the frame
        pane.setBackground(Color.WHITE);
        add(pane);

        // Fetch and display data
        try {
            Conn c = new Conn();
            String str = "SELECT * FROM books WHERE genre = '" + genre + "'";
            ResultSet rs = c.stmt.executeQuery(str);

            // Delay for visual effect (optional)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Check if the result set is empty
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No books available in this genre.");
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
        backButton.setBackground(new Color(255, 87, 34)); // Orange color for the button
        backButton.setBounds(1200, 20, 100, 50); // Position at the top right corner
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        backButton.addActionListener(this);

        // Add hover effects for the back button
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new Color(255, 87, 34).darker()); // Darker color on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new Color(255, 87, 34)); // Restore original background color
            }
        });

        // Add back button to the frame
        add(backButton);

        setVisible(true);
    }

    // Action listener method
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            // Go back to the previous screen (ViewBooks)
            ViewBooks viewBooks = new ViewBooks();
            viewBooks.setSize(1366, 768);
            viewBooks.setVisible(true);
            viewBooks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
    }
}
