//package bookbank;
//
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//// import javax.swing.border.Border;
//
//class Start extends JFrame implements ActionListener
//{
//    JButton b1,b2;
//    
//    public Start()
//    {
//        b1=new JButton("USER");
//        b2=new JButton("ADMIN");
//        b1.setBounds(100, 90,150 , 50);
//        b2.setBounds(100, 170,150 , 50);
//        add(b1);
//        add(b2);
//        setLayout(null);
//        b1.addActionListener(this);
//        b2.addActionListener(this);
//        
//        setLocation(500,200);
//    }
//    public void actionPerformed(ActionEvent ae) 
//    { 
//        if(ae.getSource()==b1)
//        {
//        	SignUpLogin l=new SignUpLogin();
//            l.setSize(350,350);
//            l.setVisible(true);
//        }
//        else
//        {
//            AdminLogin f =new AdminLogin();
//            f.setSize(400,400);
//            f.setVisible(true);
//            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        }
//    }
//}
//public class StartingPage
//{
//    public static void main(String args[])
//    {
//        Start s=new Start();
//        s.setSize(350,350);
//        s.setVisible(true);
//        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//}

package bookbank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Start extends JFrame implements ActionListener {
    JButton b1, b2;
    ImageIcon backgroundImageIcon;
    JLabel headingLabel, quotationLabel;

    public Start() {
        // Load the background image
        backgroundImageIcon = new ImageIcon("src/bookbank/bookbank4.jpg");

        // Setting up the frame
        setTitle("BookBank - Choose Your Role");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the frame full-screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creating a panel with a background image
        BackgroundPanel panel = new BackgroundPanel();
        panel.setLayout(new GridBagLayout());

        // Initializing buttons
        b1 = new JButton("USER");
        b2 = new JButton("ADMIN");

        // Customizing buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 28); // Increased font size
        b1.setFont(buttonFont);
        b2.setFont(buttonFont);
        b1.setPreferredSize(new Dimension(350, 80)); // Increased button size
        b2.setPreferredSize(new Dimension(350, 80)); // Increased button size

        // Adding action listeners
        b1.addActionListener(this);
        b2.addActionListener(this);

        // Setting button colors and adding border radius
        b1.setBackground(new Color(0, 153, 204)); // Attractive blue color
        b1.setForeground(Color.WHITE);
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true)); // Border radius

        b2.setBackground(new Color(255, 87, 34)); // Attractive orange color
        b2.setForeground(Color.WHITE);
        b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true)); // Border radius

        // Creating a header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); // Steel blue color
        headerPanel.setPreferredSize(new Dimension(getWidth(), 100)); // Set navbar height
        headerPanel.setLayout(new GridBagLayout()); // Center the label

        // Adding heading title to the header panel
        headingLabel = new JLabel("Welcome to BookBank", JLabel.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 48)); // Increased navbar size
        headingLabel.setForeground(Color.WHITE);
        headerPanel.add(headingLabel, new GridBagConstraints()); // Center the label in the panel

        // Creating a footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(47, 79, 79)); // Dark slate gray color
        footerPanel.setPreferredSize(new Dimension(getWidth(), 60)); // Set footer height
        footerPanel.setLayout(new GridBagLayout()); // Center the label

        // Adding quotation to the footer panel
        quotationLabel = new JLabel("\"A room without books is like a body without a soul.\"", JLabel.CENTER);
        quotationLabel.setFont(new Font("Arial", Font.ITALIC, 24)); // Increased footer size
        quotationLabel.setForeground(Color.WHITE);
        footerPanel.add(quotationLabel, new GridBagConstraints()); // Center the label in the panel

        // Adding the header panel to the frame
        add(headerPanel, BorderLayout.NORTH);

        // Adding buttons to the panel with constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(40, 40, 40, 40); // Increased insets for larger borders
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(b1, gbc);

        gbc.gridy = 1;
        panel.add(b2, gbc);

        // Adding the panel to the frame
        add(panel, BorderLayout.CENTER);

        // Adding the footer panel to the frame
        add(footerPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            SignUpLogin l = new SignUpLogin();
//            l.setSize(35, 350);
            l.setVisible(true);
        } else if (ae.getSource() == b2) {
            AdminLogin f = new AdminLogin();
//            f.setSize(400, 400);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}

public class StartingPage {
    public static void main(String[] args) {
        // Running the application
        SwingUtilities.invokeLater(() -> {
            Start s = new Start();
            s.setVisible(true);
        });
    }
}
