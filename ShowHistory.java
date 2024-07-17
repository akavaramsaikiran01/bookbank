package bookbank;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class ShowHistory extends JFrame{
    private JTable table;
    public static void main(String[] args){		 
    	new View(null);    
    }
    
    public ShowHistory(String cid) {
        
	    getContentPane().setBackground(Color.WHITE);
	    getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(860,523);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(900,600);
	    setLocation(200,50);
			
			
		JLabel FlightDetails = new JLabel("History : ");
		FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
		FlightDetails.setForeground(new Color(100, 149, 237));
		FlightDetails.setBounds(50, 70, 570, 35);
		add(FlightDetails);
		
		table = new JTable();
	    table.setBackground(Color.WHITE);
		table.setBounds(40, 120, 800, 400);
	        
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(40, 120, 800, 400);
	    pane.setBackground(Color.WHITE);
	    add(pane);

	    
	    try {
            Conn c = new Conn();
            //String str = "select * from books where genre ='" + genre + "'";
           
            String str = "select * from statustable where customerId ='" + cid + "'";

            ResultSet rs = c.stmt.executeQuery(str);
            
            try {
            	Thread.sleep(1000);
            } 
            catch(Exception e) {}
            
            	if (!rs.isBeforeFirst())
            	{
            		table.setModel(DbUtils.resultSetToTableModel(rs));
            		JOptionPane.showMessageDialog(null, "Hey there!\n\n\tIt looks like there is no books available in this genre");
            	
            	}
            	else {
            	table.setModel(DbUtils.resultSetToTableModel(rs));
            	}
            
        }
	    catch(SQLException e){
            e.printStackTrace();
        }
		
	    
		
    }
    
}


