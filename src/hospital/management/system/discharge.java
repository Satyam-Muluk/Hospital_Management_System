/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class discharge extends JFrame implements ActionListener {
    
    
    Choice c1;
    JTextField t1;
    JButton b1,b2,b3;
    discharge()
    {
        
        JLabel  l1 = new JLabel("Discharge");
        l1.setBounds(30,20,100,30);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        add(l1);
        
        
        JLabel  l2 = new JLabel("Patient Id");
        l2.setBounds(30,80,100,30);
        add(l2);
        
        c1 = new Choice();
         try{
            
            conn c  = new conn();
            ResultSet rs = c.s.executeQuery("select *from admitpatient");
            while(rs.next())
            {
                c1.add(rs.getString("number"));
            }
            
        }catch(Exception e)
        {
            
        }
        c1.setBounds(150,80,150,25);
        add(c1);
        
        JLabel  l3 = new JLabel("Room Number");
        l3.setBounds(30,140,100,30); 
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(150,140,150,25);
        add(t1);
        
        
        b1 = new JButton("Load Data");
         b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(130,200,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Discharge");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(30,240,120,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(220,240,120,30);
        b3.addActionListener(this);
        add(b3);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/dischargepat.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,280,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel im = new JLabel(i3);
        im.setBounds(300,0,500,300);
        add(im);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(200,350,800,340);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
               conn  c = new conn();
               String s = c1.getSelectedItem();
               ResultSet rs = c.s.executeQuery("select *from admitpatient where number = '"+s+"'");
               
               while(rs.next())
               {
                   t1.setText(rs.getString("room_no"));
               }
            }catch(Exception e)
            {
                
            }
        }
        else if(ae.getSource() == b2)
        {
            try
            {  
                String price = null;
                String deposit = null;
                String s1 = t1.getText();
                String s = c1.getSelectedItem();
                conn c = new conn();
              
                ResultSet rs2 = c.s.executeQuery("select *from room where room_number = '"+s1+"'");
                 while(rs2.next())
               {
                   price = rs2.getString("price");
                  
               }
                 ResultSet rs1 = c.s.executeQuery("select *from admitpatient where number = '"+s+"'");
               while (rs1.next())
               {
                   deposit = rs1.getString("deposit");
                   
               }
               System.out.println(deposit);
               System.out.println(price);
               
               if(price.contentEquals(deposit))
               {
                   System.out.println("equal");
                   System.out.println(s);
                   
                   String str = "delete from admitpatient where number ='"+s+"'";
                   String str2 = "update room set available = 'Available' where room_number ='"+s1+"'";
                   conn c1 = new conn();
                   try
                   {
                       c.s.executeUpdate(str);
                       c.s.executeUpdate(str2);
                       JOptionPane.showMessageDialog(null, "Patient Discharged");
                   }catch(Exception e)
                   {
                       System.out.println(e);
                   }
               }
               else
               {   JOptionPane.showMessageDialog(null, "Fees Not Paid");
                   System.out.println("not equal");
               }
               
                
            }catch(Exception e)
            {
                System.out.println(e);
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
        new discharge().setVisible(true);
       
    }
    
}
