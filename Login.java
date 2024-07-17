package bookbank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Login extends JFrame implements ActionListener
{
    JLabel  L,L1,L2;
    JButton b,b2;
    JTextField t1,t2;
    JPasswordField ps;


    Login(String str)
    {
    	L=new JLabel("LOGIN");
        L1=new JLabel("USER NAME");
        L2=new JLabel("PASSWORD");
        b=new JButton("SIGN IN");
        b2=new JButton("BACK");
        t1=new JTextField(20);
        ps = new JPasswordField(20); 

        L.setBounds(195,13,100,105);
        L.setFont(new Font("Arial",Font.BOLD,30));
        L1.setBounds(150,100,100,35);
        t1.setBounds(150,125,200,30);
        L2.setBounds(150,160,100,30);
        ps.setBounds(150,200,200,30);
        b.setBounds(200,270,100,35);
        b2.setBounds(200,320,100,35);
        

        
        add(L1);
        add(L);
        add(t1);
        add(L2);
        add(ps);
        add(b);
        add(b2);
    
        setLocation(400,150);
        
        setLayout(null);
        b.addActionListener(this);
        b2.addActionListener(this);

    }

    
    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==b) {
	        String name=t1.getText();
	        String password=String.valueOf(ps.getPassword());
	       
	        if(name.equals("rgukt") && password.equals("rgukt123"))
	        {
	            UserAccount ua=new UserAccount();
	            ua.setSize(570,350);
	            ua.setVisible(true);
	            ua. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            this.dispose();
	        }
	        else
	        {
	            JOptionPane.showMessageDialog(Login.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
	            t1.setText("");
	            ps.setText("");
	        }
    	}
    	else if(ae.getSource()==b2)
    	{
    		SignUpLogin s= new SignUpLogin();
        	s.setSize(400,400);
            s.setVisible(true);
            s.setTitle(" Sign up Login");
            s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.dispose();
    	}
            
    }
    
    public static void main(String args[])
    {
        Login f =new Login("s");
        f.setSize(500,500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
}
// public class login
// {
// //    public static void main(String args[])
//     {
//         Login f =new Login("s");
//         f.setSize(400,400);
//         f.setVisible(true);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     }
// }

