


package hospital.management.system;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
//import java.sql.ResultSet;
import javax.swing.*;


public class patient extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6;
    
    patient()
    {
         setBounds(200,200,800,700);
         getContentPane().setBackground(Color.lightGray);
         l1 = new JLabel("Patient's Module");
         l1.setBounds(250,0,1000,70);
         l1.setFont(new Font("serif",Font.PLAIN,40));
         add(l1);
         
       b1 = new JButton("Add Patient's Record");
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       b1.setBounds(100,150,200,30);
       add(b1);
       b1.addActionListener(this);
       
       b2 = new JButton("View Patient's Record");
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.WHITE);
       b2.setBounds(100,200,200,30);
       add(b2);
       b2.addActionListener(this);
       
       b3 = new JButton("Search Patient's Record");
       b3.setBackground(Color.BLACK);
       b3.setForeground(Color.WHITE);
       b3.setBounds(100,250,200,30);
       add(b3);
       b3.addActionListener(this);
       
       b4 = new JButton("Update Patient's Record");
       b4.setBackground(Color.BLACK);
       b4.setForeground(Color.WHITE);
       b4.setBounds(100,300,200,30);
       add(b4);
       b4.addActionListener(this);
       
       b5 = new JButton("BACK");
       b5.setBackground(Color.BLACK);
       b5.setForeground(Color.WHITE);
       b5.setBounds(100,400,200,30);
       add(b5);
       b5.addActionListener(this);
       
       b6 = new JButton("LOGOUT");
       b6.setBackground(Color.BLACK);
       b6.setForeground(Color.WHITE);
       b6.setBounds(400,400,200,30);
       add(b6);
       b6.addActionListener(this);
       
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/pat.png"));
        Image i2 = i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(400,130,200,200);
        add(l3);
        setLayout(null);
        setVisible(true);
       
       setLayout(null);
       setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            System.out.println("add");
            new addpat().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b2)
        {
            System.out.println("view");
            new patinfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b3)
        {
            System.out.println("search");
            new searchpat().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b4)
        {
            System.out.println("update");
            new updatepat().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b5)
        {
            System.out.println("back");
            new homepat().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b6)
        {
            System.out.println("logout");
            System.exit(0);
        }
    }
        public static void main(String[] args) {
                patient window = new patient();
                window.setVisible(true);			
	}
    
}
