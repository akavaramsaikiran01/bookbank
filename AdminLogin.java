//package bookbank;
//
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//
//public class AdminLogin extends JFrame implements ActionListener
//{
//    JLabel  L,L1,L2;
//    JButton b,b2;
//    JTextField t1,t2;
//    JPasswordField ps;
//
//
//    public AdminLogin()
//    {
//    	L=new JLabel("LOGIN");
//        L1=new JLabel("USER NAME");
//        L2=new JLabel("PASSWORD");
//        b=new JButton("SIGN IN");
//        b2=new JButton("BACK");
//        t1=new JTextField(20);
//        ps = new JPasswordField(20); 
//
//        L.setBounds(155,20,100,30);
//        L.setFont(new Font("Arial",Font.BOLD,30));
//        L1.setBounds(100,60,100,30);
//        t1.setBounds(100,95,200,30);
//        L2.setBounds(100,140,100,30);
//        ps.setBounds(100,170,200,30);
//        b.setBounds(150,210,100,30);
//        b2.setBounds(150,260,100,30);
//
//        add(L);
//        add(L1);
//        add(t1);
//        add(L2);
//        add(ps);
//        add(b);
//        add(b2);
//    
//        setLayout(null);
//        setVisible(true);
//        setSize(400, 400);
//        setLocation(500, 200);
//        b.addActionListener(this);
//        b2.addActionListener(this);
//
//    }
//
//    
//    public void actionPerformed(ActionEvent ae)
//    {
//    	if(ae.getSource()==b)
//    	{
//	        String name=t1.getText();
//	        String password=String.valueOf(ps.getPassword());
//	       
//	        if(name.equals("bookbank") && password.equals("bookbank123"))
//	        {
//	            AdminAccount s=new AdminAccount();
//	            s.setSize(1750,1000);
//	            s.setVisible(true);
//	            s.setTitle(" USER REGISTER");
//	            s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	            this.dispose();
//	        }
//	        else
//	        {
//	            JOptionPane.showMessageDialog(AdminLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
//	            t1.setText("");
//	            ps.setText("");
//	        }
//    	}
//    	else if(ae.getSource()==b2)
//    	{
//    		Start s=new Start();
//            s.setSize(350,350);
//            s.setVisible(true);
//            s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            this.dispose();    	}
//            
//    }
//    
//    public static void main(String[] args) {
//    	new AdminLogin();
//    }
//    
//    
//}

package bookbank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminLogin extends JFrame implements ActionListener {
    JButton signInButton, backButton;
    JTextField usernameField;
    JPasswordField passwordField;
    ImageIcon backgroundImageIcon;

    public AdminLogin() {
        // Load the background image (optional)
        backgroundImageIcon = new ImageIcon("src/bookbank/bookbank4.jpg");

        // Setting up the frame
        setTitle("Admin Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creating a header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); // Steel blue
        headerPanel.setPreferredSize(new Dimension(getWidth(), 100)); // Set header panel height
        headerPanel.setLayout(new GridBagLayout());

        // Adding heading title to the header panel
        JLabel headingLabel = new JLabel("Admin Login", JLabel.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 48)); // Increased font size
        headingLabel.setForeground(Color.WHITE);
        headerPanel.add(headingLabel, new GridBagConstraints());

        // Adding the header panel to the frame
        add(headerPanel, BorderLayout.NORTH);

        // Creating a panel for the main content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBackground(Color.WHITE); // Background color (optional)

        // Creating components
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 36)); // Font for labels
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 36)); // Font for labels

        usernameField = new JTextField(20);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 36)); // Font for text fields
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 36)); // Font for password fields

        signInButton = new JButton("Sign In");
        signInButton.setFont(new Font("Arial", Font.BOLD, 36)); // Font for buttons
        signInButton.setPreferredSize(new Dimension(250, 60)); // Button size
        signInButton.setBackground(new Color(60, 179, 113)); // Medium sea green
        signInButton.setForeground(Color.WHITE);
        signInButton.setFocusPainted(false);
        signInButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 36)); // Font for buttons
        backButton.setPreferredSize(new Dimension(250, 60)); // Button size
        backButton.setBackground(new Color(70, 130, 180)); // Steel blue
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.addActionListener(this);

        // Adding components to the content panel with constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20); // Reduced insets for smaller space
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        contentPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        contentPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        contentPanel.add(signInButton, gbc);

        gbc.gridy = 3;
        contentPanel.add(backButton, gbc);

        // Adding the content panel to the frame
        add(contentPanel, BorderLayout.CENTER);

        // Creating a footer panel (optional)
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(47, 79, 79)); // Dark slate gray
        footerPanel.setPreferredSize(new Dimension(getWidth(), 60)); // Set footer height
        footerPanel.setLayout(new GridBagLayout()); // Center the label

        // Adding quotation to the footer panel (optional)
        JLabel quotationLabel = new JLabel("\"The more that you read, the more things you will know. "
                + "The more that you learn, the more places you'll go.\"", JLabel.CENTER); // Changed quotation
        quotationLabel.setFont(new Font("Arial", Font.ITALIC, 24)); // Increased footer size
        quotationLabel.setForeground(Color.WHITE);
        footerPanel.add(quotationLabel, new GridBagConstraints()); // Center the label in the panel

        // Adding the footer panel to the frame
        add(footerPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signInButton) {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (username.equals("admin") && password.equals("admin123")) {
                // Replace with actual admin functionality
                JOptionPane.showMessageDialog(AdminLogin.this, "Login Successful!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                // Example of opening a new AdminAccount frame
                AdminAccount adminAccount = new AdminAccount();
                adminAccount.setSize(1750, 1000); // Adjusted size
                adminAccount.setVisible(true);
                adminAccount.setTitle("Admin Account");
                adminAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose(); // Close the current frame
            } else {
                JOptionPane.showMessageDialog(AdminLogin.this, "Invalid Username or Password", "Login Error",
                        JOptionPane.ERROR_MESSAGE);
                // Clear fields on invalid login attempt
                usernameField.setText("");
                passwordField.setText("");
            }
        } else if (ae.getSource() == backButton) {
            Start startPage = new Start();
            startPage.setSize(350, 350); // Adjusted size
            startPage.setVisible(true);
            startPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose(); // Close the current frame
        }
    }

    // Custom JPanel class to draw the background image (optional)
    class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image (optional)
            if (backgroundImageIcon != null) {
                g.drawImage(backgroundImageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static void main(String[] args) {
        // Running the application
        SwingUtilities.invokeLater(() -> {
            new AdminLogin().setVisible(true);
        });
    }
}
