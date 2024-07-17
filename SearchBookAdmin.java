package bookbank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SearchBookAdmin extends JFrame implements ActionListener
{
    JTextField t1;
    JLabel  L1,L;
    JButton b,b2;
   
    SearchBookAdmin()
    {
    	L=new JLabel("SEARCH");
    	L.setFont(new Font("Arial",Font.BOLD,25));
       L1=new JLabel("Enter Book Name");
       b=new JButton("Search");
       b2=new JButton("BACK");
       t1=new JTextField(20);
       L.setBounds(123, 15,150 , 50);
       L1.setBounds(123, 55,150 , 50);
       t1.setBounds(100, 95,150 , 30);
       b.setBounds(110, 145,125 , 35);
       b2.setBounds(110, 195,125 , 35);

       add(L);
       add(L1);
       add(t1);
       add(b);
       add(b2);
       setLocation(400, 200);
       
       b.addActionListener(new ActionListener() 
       {
       		public void actionPerformed(ActionEvent ae) 
       		{
       			String srch = t1.getText();
       			if(ae.getSource() == b) 
       	        {
       	        	new SearchView(srch);
       	        }
       		}
       });
      
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
    	SearchBookAdmin sb=new SearchBookAdmin();
            sb.setSize(350,350);
            sb.setVisible(true);
            sb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}



