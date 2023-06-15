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

public class updateadmit extends JFrame implements ActionListener {
    
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    updateadmit()
    {
        JLabel l1 = new JLabel("Admit Details");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(90,20,200,30);
        add(l1);
        
        
        JLabel l2 = new JLabel("Patient ID");
        l2.setBounds(30,80,100,20);
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
        c1.setBounds(200,80,150,25);
        add(c1);
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,120,100,20);
        add(l3);
        
        
        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);
        
        JLabel l4 = new JLabel("Name");
        l4.setBounds(30,160,100,20);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);
        
        JLabel l5 = new JLabel("Admit Status");
        l5.setBounds(30,200,100,20);
        add(l5);
        
        t3 = new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);
        
         JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(30,240,100,20);
        add(l6);
        
        t4 = new JTextField();
        t4.setBounds(200,240,150,25);
        add(t4);
        
        
        JLabel l7 = new JLabel("Pending Amount");
        l7.setBounds(30,280,100,20);
        add(l7);
        
        t5 = new JTextField();
        t5.setBounds(200,280,150,25);
        add(t5);
        
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,390,100,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150,390,100,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(270,390,100,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/admitroom.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel im = new JLabel(i3);
        im.setBounds(400,50,800,400);
        add(im);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(200,200,1200,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            
            try
            {
                String room = null;
                String deposit = null;
                int amountPaid;
                String price = null;
                conn c = new conn();
                String id = c1.getSelectedItem();
                
                String str = "select *from admitpatient where number = '"+id+"'";
                ResultSet rs = c.s.executeQuery(str);
                
                while(rs.next())
                {
                    t1.setText(rs.getString("room_no"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));
                    room = rs.getString("room_no");
                    deposit = rs.getString("deposit");
                }
                
                ResultSet rs2 = c.s.executeQuery("select *from room where room_number = '"+room+"'");
                while(rs2.next())
                {
                    price = rs2.getString("price");
                    amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                    System.out.println(amountPaid);
                    t5.setText(Integer.toString(amountPaid));
                    
                }
                
            }catch(Exception e)
            {
                
            }
            
        }
        else if(ae.getSource() == b2)
        {
             try{
                                conn c = new conn();
                                
                                String s1 = c1.getSelectedItem();
				//String s2 = txt_ID.getText(); //room_number;    
                                String s2 = t2.getText(); //name    
                                String s3 = t4.getText(); //status;    
//                                String s5 = txt_Time.getText(); //deposit    
				
                                c.s.executeUpdate("update admitpatient set name = '"+s2+"', deposit = '"+s3+"' where number = '"+s1+"'");
                                
                                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
//                                new Reception().setVisible(true);
//                                setVisible(false);
                            }catch(Exception ee){
                                System.out.println(ee);
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
        new updateadmit().setVisible(true);
    }
}
