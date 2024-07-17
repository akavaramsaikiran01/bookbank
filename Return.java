package bookbank;
//
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Return extends JFrame implements ActionListener {
    JButton b1, b2;
    JLabel L1,L2,L3,L;
    JFormattedTextField tf3;
    JTextField tf2,tf1;
    String idd;
    String bid;
    
    public Return() {
//        idd = id;
//        bid=bi;
        // Setting up the frame components
        L1 = new JLabel("CUSTOMER ID : ");
        tf1 = new JTextField(20);
        
        L = new JLabel("RETURN BOOK ");
        L.setFont(new Font("Arial",Font.BOLD,30));
        
        L2 = new JLabel("BOOK ID : ");
        tf2 = new JTextField(20);
        
        L3=new JLabel("DATE");
        tf3 = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        tf3.setColumns(15);
        tf3.setValue(new Date());

        b1 = new JButton("SUBMIT");
        b2 = new JButton("BACK");
        L.setBounds(100, 50, 250, 40);
        L1.setBounds(200, 150, 150, 40); tf1.setBounds(350, 150, 150, 40);
        L2.setBounds(200, 240, 150, 40); tf2.setBounds(350, 240, 150, 40);
        L3.setBounds(200, 330, 150, 40); tf3.setBounds(350, 330, 150, 40);
        
//        tf3.setBounds(100, 115, 150, 30);
        b1.setBounds(220, 420, 200, 55);
        b2.setBounds(220, 500, 200, 55);

        
        add(L);
        add(L1);
        add(tf1);
        add(L2);
        add(tf2);
        add(L3);
        add(tf3);
        add(b1);
        //add(tf3);
        add(b2);
        setLayout(null);

        setLocation(300,5);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
    	 String Bname = tf2.getText();
    	 if(ae.getSource()==b1 && Bname.equals(""))
         {
             JOptionPane.showMessageDialog(Return.this, "Enter the Proper BookId","Error", JOptionPane.ERROR_MESSAGE);
             tf2.setText("");
         }
    	 else if (ae.getSource() == b1) {
            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bookbank", "root", "");

                String q = "UPDATE statustable SET statuss='returned' WHERE customerId = ? and bookId=?";
                idd= tf1.getText();
                bid= tf2.getText();
                PreparedStatement pstmt = con.prepareStatement(q);
                pstmt.setString(1, idd);
                pstmt.setString(2, bid);

                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(Return.this, "Book status updated successfully",
                        "Success", JOptionPane.INFORMATION_MESSAGE);

                con.close();
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(Return.this, "Error: MySQL Driver not found",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(Return.this, "Error: " + e.getMessage(),
                        "SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    	 else if(ae.getSource()==b2)
         {
            
    		 UserAccount ua=new UserAccount();
    	     ua.setSize(570,350);
    	     ua.setVisible(true);
    	     ua. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	     this.dispose();
         }
    }

    public static void main(String args[]) {
        Return r = new Return();
        r.setSize(700, 700);
        r.setVisible(true);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
 
//         Return r=new Return("12","21");
//         r.setSize(350,350);
//         r.setVisible(true);
//         r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     }
//}

