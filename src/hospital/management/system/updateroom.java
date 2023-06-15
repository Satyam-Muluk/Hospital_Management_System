
package hospital.management.system;



import java.awt.Choice;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
//import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class updateroom extends JFrame implements ActionListener{
    
    Choice c1;
    JTextField t1,t2;
    JButton b1,b2,b3;
    updateroom()
    {
        JLabel l1 = new JLabel("Update Room Status");
        l1.setFont(new Font("Tahoma",Font.PLAIN,26));
        l1.setForeground(Color.BLUE);
        l1.setBounds(30,20,250,30);
        add(l1);
        
        JLabel l2 = new JLabel("Patient Id");
        l2.setBounds(30,80,120,20);
        add(l2);
        
        
        c1 = new Choice();
        try
        {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select *from admitpatient");
            while(rs.next())
            {
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){
            
        }
        c1.setBounds(200,80,150,25);
        add(c1);
        
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,120,20);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(200,130,150,25);
        add(t1);
        
        JLabel l4 = new JLabel("Room Status");
        l4.setBounds(30,180,120,20);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(200,180,150,25);
        add(t2);
        
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(120,250,120,30);
        b1.addActionListener(this);
        add(b1);
        
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(40,300,120,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(200,300,120,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/room1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel im = new JLabel(i3);
        im.setBounds(400,0,500,400);
        add(im);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(200,200,980,500);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {   
            String room = null;
            String s1 = c1.getSelectedItem();
            conn c = new conn();
            try
            {
                 ResultSet rs = c.s.executeQuery("select *from admitpatient where number = '"+s1+"'");
                
                 while(rs.next())
                 {
                     t1.setText(rs.getString("room_no"));
                     room = rs.getString("room_no");
                 }
                 
                  ResultSet rs2 = c.s.executeQuery("select *from room where room_number = '"+room+"'");
                  while(rs2.next())
                  {
                      t2.setText(rs2.getString("status"));
                  }
            }catch(Exception e)
            {
                System.out.println(e);
            }
           
        }
        else if(ae.getSource()==b2)
        {
            try{
                
                conn c = new conn();
                String room = t1.getText();
                String status = t2.getText();
                
                String str = "update room set status = '"+status+"'where room_number = '"+room+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Room Updated Successfully");
                
            }catch(Exception e)
            {
                
            }
        }
        else if(ae.getSource() == b3)
        {
            new homepat().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new updateroom().setVisible(true);
    }
    
    
}
