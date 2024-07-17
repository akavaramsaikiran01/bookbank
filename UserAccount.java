package bookbank;



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class UserAccount extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4;
    public UserAccount()
    {
        b1=new JButton("SEARCH BOOKS");
        b2=new JButton("RETURN");
        b3=new JButton("YOUR HISTORY");
        b4=new JButton("LOG OUT");
        b1.setBounds(120,70, 150,50);
        b2.setBounds(120,150, 150,50);
        b3.setBounds(300,70, 150,50);
        b4.setBounds(300,150, 150,50);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        setLayout(null);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        setLocation(400,200);
        setSize(500,350);
    }
    public void actionPerformed(ActionEvent ae) 
    {
        
        if(ae.getSource()==b1)
        {
            SearchBook sb=new SearchBook();
            sb.setSize(350,350);
            sb.setVisible(true);
            sb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        else if(ae.getSource()==b2)
        {
            Return r=new Return();
            r.setSize(700,700);
            r.setVisible(true);
            r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        else if(ae.getSource()==b3)
        {
        	HistoryTable f=new HistoryTable();
   		 	f.setSize(1000,600);
            f.setVisible(true);
            f.setLocation(300,100);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //this.dispose();
        }
        else if(ae.getSource()==b4)
        {
            Start s=new Start();
            s.setSize(350,350);
            s.setVisible(true);
            s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        
        // else
        // {
        //     JOptionPane.showMessageDialog(Return.this, "Book Submitted Successfully","Successful!", JOptionPane.ERROR_MESSAGE);
        //     // tf.setText("");
        //     this.dispose(); 
        // }
    }
    public static void main(String args[])
    {
        UserAccount ua=new UserAccount();
        ua.setSize(570,350);
        ua.setVisible(true);
        ua. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


