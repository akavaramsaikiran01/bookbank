package bookbank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SearchBook extends JFrame implements ActionListener
{
    JTextField t1;
    JLabel  L1;
    JButton b,b2;
   
    SearchBook()
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
       setLocation(500, 200);
       
       b.addActionListener(new ActionListener() 
       {
       		public void actionPerformed(ActionEvent ae) 
       		{
       			String srch = t1.getText();
       			if(ae.getSource() == b) 
       	        {
       				SearchView v= new SearchView(srch);
       				v.setSize(1000,600);
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
            UserAccount ua=new UserAccount();
            ua.setSize(570,350);
            ua.setVisible(true);
            ua.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose(); 
        }
       
    }
    public static void main(String args[])
    {
            SearchBook sb=new SearchBook();
            sb.setSize(350,350);
            sb.setVisible(true);
            sb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}



