package bookbank;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

class MyPanel extends JPanel {
    JButton b1;
        MyPanel() {
               this.setBackground(Color.green);
                b1=new JButton("Try Again");
        b1.setBounds(90, 100, 100, 35);    
       }
       public void paintComponent(Graphics g) 
       {
              //super.paintComponent(g);
            g.setColor(Color.red);
            g.setFont(new Font("Helvetica",Font.BOLD,20));
            g.drawString(" Incorrect UserName ",50,60);
            g.drawString(" or Password ",50,80);
            add(b1);
        }
}

class Error1 extends JFrame 
{
    JButton b1 = new JButton();
    public  Error1()
    {
        Container c=this.getContentPane();
        b1=new JButton();
        b1.setBounds(100, 100, 100, 50);
             //create Mypanel object and add it to c
        MyPanel mp=new MyPanel();         
        c.add(mp);
       
        //setLayout(null);
    }
    
}



public class UserNameError
{
    public static void main(String args[])
    {
        Error1 e=new Error1();
        e.setSize(300,200);
        e.setVisible(true);
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
