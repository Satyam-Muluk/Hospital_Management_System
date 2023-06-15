
package hospital.management.system;


import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import static java.awt.PageAttributes.ColorType.COLOR;
import net.proteanit.sql.DbUtils;

public class viewroom extends JFrame implements ActionListener {
    
    
    JTable t1;
    JButton b1,b2;
    viewroom()
    {  
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/room.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(510,0,600,600);
        add(l3);
        
        t1 = new JTable();
        t1.setBounds(0,40,500,400);
        add(t1);
        
        
        
       JLabel room_no = new JLabel("Room Number");
       room_no.setBounds(10,10,100,20);
       add(room_no);
       
       JLabel l2 = new JLabel("Availaibility");
       l2.setBounds(120,10,100,20);
       add(l2);
       
       JLabel status = new JLabel("Room Status");
       status.setBounds(210,10,100,20);
       add(status);
       
       JLabel l4 = new JLabel("Price");
       l4.setBounds(320,10,100,20);
       add(l4);
       
       JLabel l5 = new JLabel("Type");
       l5.setBounds(400,10,100,20);
       add(l5);
        
        
        
        b1 = new JButton("LOAD DATA");
        b1.setBounds(100,460,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        
        b2 = new JButton("BACK");
        b2.setBounds(250,460,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        
        
        
        
        
         getContentPane().setBackground(Color.WHITE);
         
        setLayout(null);
        setBounds(200,200,1100,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try{
                
                
                conn c = new conn();
                String str = "select * from room";
                
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
            {
                
            }
        }
        else if(ae.getSource()==b2)
        {
            new homepat().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new viewroom().setVisible(true);
    }
}
