package bookbank;



import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

import java.sql.*;
import java.util.*;
import java.io.*;

public class Register extends JFrame  implements ActionListener

{
    JLabel L1,L2,L3,L4,L5,L6,L;
    JButton b1,b2;
    JTextField tf1,tf2,tf3,tf4,tf5;

    JFormattedTextField tf6 ;
    DateFormat df;

    public Register()
    {

        df = new SimpleDateFormat("dd/MM/yyyy");
        tf6 = new JFormattedTextField(df);
        tf6.setColumns(15);
        tf6.setValue(new Date());

        L=new JLabel("REGISTER");
        L1=new JLabel("NAME : ");
        L2=new JLabel("EMAIL : ");
        L3=new JLabel("Mobile:  ");
        L4=new JLabel("CREATE PASSWORD : ");
        L5=new JLabel("CONFIRM PASSWORD : ");
        L6=new JLabel("DATE : ");

        tf1=new JTextField(20);
        tf2=new JTextField(20);
        tf3=new JTextField(20);
        tf4=new JTextField(20);
        tf5=new JTextField(20);
       // tf6=(JFormattedTextField) new JTextField(20);
      


        b1=new JButton("SUBMIT");
        b2=new JButton("BACK");

        L.setBounds(200,30,150,30);
        L1.setBounds(100,80,150,30);
        L2.setBounds(100,120,150,30);
        L3.setBounds(100,160,150,30);
        L4.setBounds(100,200,150,30);
        L5.setBounds(100,240,150,30);
        L6.setBounds(100,280,150,30);

        tf1.setBounds(260,80,150,30);
        tf2.setBounds(260,120,150,30);
        tf3.setBounds(260,160,150,30);
        tf4.setBounds(260,200,150,30);
        tf5.setBounds(260,240,150,30);
        tf6.setBounds(260,280,150,30);

        b1.setBounds(200,340,100,30);
        b2.setBounds(200,380,100,30);

        L.setFont(new Font("Arial",Font.BOLD,20));

        add(L);
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
        
        setLayout(null);
        setVisible(true);
        setSize(600, 500);
        setLocation(400,180);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
       
    }
    public void actionPerformed(ActionEvent ae) 
    {
    	String Bn1 = tf1.getText();
    	String Bn2 = tf2.getText();
    	String Bn3 = tf3.getText();
    	String Bn5 = tf5.getText();
    	String Bn4 = tf4.getText();
    	
    	if(ae.getSource()==b1 && (Bn1.equals("") || Bn2.equals("") || Bn3.equals("") || Bn4.equals("") || Bn5.equals("")))
        {
            JOptionPane.showMessageDialog(Register.this, "Enter all the details ","Error", JOptionPane.ERROR_MESSAGE);
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            tf5.setText("");
            
        }
    	else if(ae.getSource()==b1)
        {
        	 try{
 				// Step 1: Load the MySQL JDBC driver
 				    Class.forName("com.mysql.cj.jdbc.Driver");
 	
 				    // Step 2: Create the connection object
 				    Connection con = DriverManager.getConnection(
 					    "jdbc:mysql://localhost:3306/bookbank", "root", "");
 	
 				    // Step 3: Create the statement object
 				    Statement stmt = con.createStatement();
 	
 				    // Step 4: Execute query
 				    String q = "INSERT INTO customers VALUES(?,?,?,?)";
 				    
 				    //get the preparedStatement object
 				    PreparedStatement pstmt=con.prepareStatement(q);
 				    
 				    String nam= tf1.getText();
 				    String mail= tf2.getText();
 				    String mobile= tf3.getText();
 				    String dat= tf6.getText();
 				   
 				    
 				    pstmt.setString(1,nam);
 				    pstmt.setString(2,mail);
 				    pstmt.setString(3,mobile);
 				    pstmt.setString(4,dat);
 				    
 				    
 				    
 				    pstmt.executeUpdate();
 				    
 				    JOptionPane.showMessageDialog(Register.this, " Registered successfully.Login with your creditial","", JOptionPane.ERROR_MESSAGE);
 				    SignUpLogin s= new SignUpLogin();
 			    	s.setSize(400,400);
 			        s.setVisible(true);
 			        s.setTitle(" Sign up Login");
 			        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 			        this.dispose();
             
         	} 
        	 catch(Exception ee) {
         		System.out.println("Invalid");
         	}
        }
        else if(ae.getSource()==b2)
        {
        	SignUpLogin f =new SignUpLogin();
            f.setSize(400,400);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
       
        
    }
    public static void main(String args[])
    {
            Register r =new Register();
            r.setTitle(" USER REGISTER");
            r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
