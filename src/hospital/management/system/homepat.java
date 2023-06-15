
package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
//import java.sql.ResultSet;
import javax.swing.*;

public class homepat extends JFrame implements ActionListener {
     JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    
    homepat()
    {
         setBounds(200,200,800,700);
         getContentPane().setBackground(Color.WHITE);
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
       
       b2 = new JButton("Admit Patient");
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.WHITE);
       b2.setBounds(100,200,200,30);
       add(b2);
       b2.addActionListener(this);
       
       b3 = new JButton("Add Rooms");
       b3.setBackground(Color.BLACK);
       b3.setForeground(Color.WHITE);
       b3.setBounds(100,250,200,30);
       add(b3);
       b3.addActionListener(this);
       
       b4 = new JButton("View Rooms");
       b4.setBackground(Color.BLACK);
       b4.setForeground(Color.WHITE);
       b4.setBounds(100,300,200,30);
       add(b4);
       b4.addActionListener(this);
       
       b7 = new JButton("View Admit Patients");
       b7.setBackground(Color.BLACK);
       b7.setForeground(Color.WHITE);
       b7.setBounds(100,350,200,30);
       add(b7);
       b7.addActionListener(this);
       
       b8 = new JButton("Update Room");
       b8.setBackground(Color.BLACK);
       b8.setForeground(Color.WHITE);
       b8.setBounds(100,400,200,30);
       add(b8);
       b8.addActionListener(this);
       
       
       b9 = new JButton("Update Admit Status");
       b9.setBackground(Color.BLACK);
       b9.setForeground(Color.WHITE);
       b9.setBounds(100,450,200,30);
       add(b9);
       b9.addActionListener(this);
       
       b10 = new JButton("Discharge Patient");
       b10.setBackground(Color.BLACK);
       b10.setForeground(Color.WHITE);
       b10.setBounds(100,500,200,30);
       add(b10);
       b10.addActionListener(this);
       
       
       b5 = new JButton("BACK");
       b5.setBackground(Color.BLACK);
       b5.setForeground(Color.WHITE);
       b5.setBounds(100,600,200,30);
       add(b5);
       b5.addActionListener(this);
       
       b6 = new JButton("LOGOUT");
       b6.setBackground(Color.BLACK);
       b6.setForeground(Color.WHITE);
       b6.setBounds(400,600,200,30);
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
            new patient().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b2)
        {
            System.out.println("view");
            new addadmit().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b3)
        {
            System.out.println("search");
            new addroom().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b4)
        {
            System.out.println("update");
            new viewroom().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b5)
        {
            System.out.println("back");
//            new frontpage().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b6)
        {
            System.out.println("logout");
            System.exit(0);
        }
        
         else if(ae.getSource() == b7)
        {
            new admitpatinfo().setVisible(true);
            this.setVisible(false);
        }
        
         else if(ae.getSource() == b8)
        {
            new updateroom().setVisible(true);
            this.setVisible(false);
        }
        
           else if(ae.getSource() == b9)
        {
            new updateadmit().setVisible(true);
            this.setVisible(false);
        }
        
          else if(ae.getSource() == b10)
        {
            new discharge().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new homepat().setVisible(true);
    }
}
