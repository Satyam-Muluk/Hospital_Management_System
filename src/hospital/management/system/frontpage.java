
package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
//import java.sql.ResultSet;
import javax.swing.*;

public class frontpage extends JFrame implements ActionListener{
    
    
    JLabel l1;
    JButton but1,but2,but3,but4;
    frontpage()
    {   
        
        
        setBounds(0,0,3000,1000);
        setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/hp.png"));
        Image i2 = i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,3000,1000);
        l3.setBackground(Color.WHITE);
        add(l3);
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/awareness.jpg"));
        Image i5 = i4.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i6 =  new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(50,180,700,1000);
        l4.setBackground(Color.WHITE);
        add(l4);
       
        
        JLabel l1 = new JLabel("Sancheti Hospital");
       l1.setBounds(230,30,1000,70);
       l1.setForeground(Color.BLACK);
       l1.setFont(new Font("serif",Font.PLAIN,50));
       l3.add(l1);
       l3.setBackground(Color.WHITE);
       getContentPane().setBackground(Color.WHITE);
       
       but1 = new JButton("DOCTOR'S MODULE");
       but1.setBackground(Color.BLACK);
       but1.setForeground(Color.WHITE);
       but1.setBounds(320,185,150,50);
       l3.add(but1);
       but1.addActionListener(this);
       
       
       but2 = new JButton("PATIENT'S MODULE");
       but2.setBackground(Color.BLACK);
       but2.setForeground(Color.WHITE);
       but2.setBounds(200,270,150,50);
      
       but2.addActionListener(this);
       l3.add(but2);
       
       
       but3 = new JButton("Technician'S MODULE");
       but3.setBackground(Color.BLACK);
       but3.setForeground(Color.WHITE);
       but3.setBounds(440,270,160,50);
      
       but3.addActionListener(this);
       l3.add(but3);
       
       
       but4 = new JButton("Vaccination Drive");
       but4.setBackground(Color.BLACK);
       but4.setForeground(Color.WHITE);
       but4.setBounds(320,355,160,50);
      
       but4.addActionListener(this);
       l3.add(but4);
       
       
       
       
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == but1)
        {
            System.out.println("doc");
            new doctor().setVisible(true);
//            this.setVisible(false);
        }
        else if(ae.getSource() == but2)
        {
            System.out.println("pat");
            new homepat().setVisible(true);
//            this.setVisible(false);
        }
        
         else if(ae.getSource() == but3)
        {
            System.out.println("pat");
            new technician().setVisible(true);
//            this.setVisible(false);
        }
         else if(ae.getSource() == but4)
         {
             System.out.println("vaccine");
             new vaccine().setVisible(true);
         }
    }
    
    
    public static void main(String[] args) {
                frontpage window = new frontpage();
                window.setVisible(true);			
	}
}
