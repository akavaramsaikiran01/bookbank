package bookbank;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HistoryTable extends JFrame implements ActionListener 
{
	JLabel L1,L2;
	JTextField tf;
	JButton b1,b2;
	public HistoryTable()
	{
		L1=new JLabel("HISTORY");
		L2=new JLabel("ENTER CUSTOMER ID");
		tf=new JTextField(20);
		b1=new JButton("SHOW HISTORY");
		b2=new JButton("BACK");
		
		L1.setBounds(300,50,400,50);
		L1.setFont(new Font("Arial",Font.BOLD,30));
		
		L2.setBounds(100,150,300,50);  tf.setBounds(360,150,300,50);
		L2.setFont(new Font("Arial",Font.BOLD,20));
		
		 b1.setBounds(250,250,300,55);
		 b2.setBounds(250,350,300,55);
       
//        b.setBounds(260,160,300,55)
		
		
		
		add(L1);
		add(L2);
		add(tf);
		add(b1);
		add(b2);
		
		 b1.addActionListener(this);
	     b2.addActionListener(this);
		
		setLayout(null);
	}
	
	public static void main(String[] args)
	{
		HistoryTable f=new HistoryTable();
		 f.setSize(800,600);
         f.setVisible(true);
         f.setLocation(300,100);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b2)
        {
           
   		 UserAccount ua=new UserAccount();
   	     ua.setSize(570,350);
   	     ua.setVisible(true);
   	     ua. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	     this.dispose();
        }
		else if(ae.getSource()==b1)
        {   
			String cid= tf.getText();
			
			ShowHistory sb=new ShowHistory(cid);
            sb.setSize(1000,700);
            sb.setVisible(true);
            sb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
            
            //this.dispose();
            
        }
		
	}

}
