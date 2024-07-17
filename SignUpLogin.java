/*
 * package bookbank;
 * 
 * import java.awt.*; import javax.swing.*; import java.awt.event.*; // import
 * javax.swing.border.Border;
 * 
 * public class SignUpLogin extends JFrame implements ActionListener { JButton
 * b1,b2,b3; public SignUpLogin() { b1=new JButton("REGISTER"); b2=new
 * JButton("LOGIN"); b3=new JButton("Back"); setBackground(Color.green);
 * 
 * b1.setBounds(100, 70,150 , 45); b2.setBounds(100, 125,150 , 45);
 * b3.setBounds(100, 180,150 , 45); add(b1); add(b2); add(b3);
 * 
 * b1.addActionListener(this); b2.addActionListener(this);
 * b3.addActionListener(this); setLayout(null); setLocation(500,200);
 * 
 * } public void actionPerformed(ActionEvent ae) { if(ae.getSource()==b2) {
 * Login l=new Login("sundaram"); l.setSize(500,500); l.setVisible(true);
 * l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); this.dispose(); }
 * 
 * else if(ae.getSource()==b1) { Register r =new Register(); r.setSize(520,480);
 * r.setVisible(true); r.setTitle(" USER REGISTER");
 * r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); } else { this.dispose(); }
 * } public static void main(String args[]) { SignUpLogin s= new SignUpLogin();
 * s.setSize(400,400); s.setVisible(true); s.setTitle(" Sign up Login");
 * s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); } }
 * 
 */

package bookbank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUpLogin extends JFrame implements ActionListener {
    JButton b1, b2, b3;
    ImageIcon backgroundImageIcon;

    public SignUpLogin() {
        // Load the background image
        backgroundImageIcon = new ImageIcon("src/bookbank/bookbank4.jpg");

        // Setting up the frame
        setTitle("Sign Up/Login");
        setSize(1366, 768); // Set the frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creating a panel with a background image
        BackgroundPanel panel = new BackgroundPanel();
        panel.setLayout(new GridBagLayout());

        // Creating buttons
        b1 = new JButton("REGISTER");
        b2 = new JButton("LOGIN");
        b3 = new JButton("Back");

        // Customizing buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 28); // Button font
        b1.setFont(buttonFont);
        b2.setFont(buttonFont);
        b3.setFont(buttonFont);
        b1.setPreferredSize(new Dimension(350, 80)); // Match button size
        b2.setPreferredSize(new Dimension(350, 80)); // Match button size
        b3.setPreferredSize(new Dimension(350, 80)); // Match button size

        // Setting button colors and adding border radius
        b1.setBackground(new Color(0, 153, 204)); // Attractive blue color
        b1.setForeground(Color.WHITE);
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true)); // Border radius

        b2.setBackground(new Color(255, 87, 34)); // Attractive orange color
        b2.setForeground(Color.WHITE);
        b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true)); // Border radius

        b3.setBackground(new Color(70, 130, 180)); // Steel blue
        b3.setForeground(Color.WHITE);
        b3.setFocusPainted(false);
        b3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true)); // Border radius

        // Adding action listeners
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        // Adding buttons to the panel with constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 30, 30, 30); // Increased insets for larger borders
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(b1, gbc);

        gbc.gridy = 1;
        panel.add(b2, gbc);

        gbc.gridy = 2;
        panel.add(b3, gbc);

        // Adding the panel to the frame
        add(panel, BorderLayout.CENTER);

        // Creating a header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); // Steel blue
        headerPanel.setPreferredSize(new Dimension(getWidth(), 100)); // Set navbar height
        headerPanel.setLayout(new GridBagLayout()); // Center the label

        // Adding heading title to the header panel
        JLabel headingLabel = new JLabel("BookBank Sign Up/Login", JLabel.CENTER); // Changed header title
        headingLabel.setFont(new Font("Arial", Font.BOLD, 48)); // Increased navbar size
        headingLabel.setForeground(Color.WHITE);
        headerPanel.add(headingLabel, new GridBagConstraints()); // Center the label in the panel

        // Adding the header panel to the frame
        add(headerPanel, BorderLayout.NORTH);

        // Creating a footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(47, 79, 79)); // Dark slate gray
        footerPanel.setPreferredSize(new Dimension(getWidth(), 60)); // Set footer height
        footerPanel.setLayout(new GridBagLayout()); // Center the label

        // Adding quotation to the footer panel
        JLabel quotationLabel = new JLabel("\"The more that you read, the more things you will know. "
                + "The more that you learn, the more places you'll go.\"", JLabel.CENTER); // Changed quotation
        quotationLabel.setFont(new Font("Arial", Font.ITALIC, 24)); // Increased footer size
        quotationLabel.setForeground(Color.WHITE);
        footerPanel.add(quotationLabel, new GridBagConstraints()); // Center the label in the panel

        // Adding the footer panel to the frame
        add(footerPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            Login l = new Login("sundaram");
            l.setSize(1366, 768); // Adjusted size to match StartingPage
            l.setVisible(true);
            l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose(); // Close the current frame
        } else if (ae.getSource() == b1) {
            Register r = new Register();
            r.setSize(1366, 768); // Adjusted size to match StartingPage
            r.setVisible(true);
            r.setTitle(" USER REGISTER");
            r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            dispose(); // Close the current frame (b3 action)
        }
    }

    // Custom JPanel class to draw the background image
    class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(backgroundImageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        // Running the application
        SwingUtilities.invokeLater(() -> {
            new SignUpLogin().setVisible(true);
        });
    }
}
