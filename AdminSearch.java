	package bookbank;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AdminSearch extends JFrame implements ActionListener
{
    JTextField t1;
    JLabel  L1;
    JButton b,b2;
   
    AdminSearch()
    {
       L1=new JLabel("Enter Book Name");
       b=new JButton("Search");
       b2=new JButton("BACK");
       t1=new JTextField(20);
       L1.setBounds(123, 40,150 , 50);
       t1.setBounds(100, 90,150 , 30);
       b.setBounds(110, 140,125 , 35);
       b2.setBounds(110, 190,125 , 35);

       add(L1);
       add(t1);
       add(b);
       add(b2);
       setLayout(null);

       b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae) 
    { 
        if(ae.getSource()==b2)
        {
        	AdminAccount ua=new AdminAccount();
            ua.setSize(1700,1700);
            ua.setVisible(true);
            ua.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose(); 
        }
       
    }
    public static void main(String args[])
    {
    		AdminSearch sb=new AdminSearch();
            sb.setSize(400,400);
            sb.setVisible(true);
            sb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}




