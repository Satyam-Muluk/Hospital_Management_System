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
public class deletedoc extends JFrame implements ActionListener {
      
     Choice c1;
    JTextField t1;
    JButton b1,b2,b3;
    
    deletedoc()
    {
        
        JLabel  l1 = new JLabel("Delete Doctor's Record");
        l1.setBounds(30,20,230,30);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        add(l1);
        
        
        JLabel  l2 = new JLabel("Doctor Id");
        l2.setBounds(30,80,100,30);
        add(l2);
        
        
        
        c1 = new Choice();
         try{
            
            conn c  = new conn();
            ResultSet rs = c.s.executeQuery("select *from doctor");
            while(rs.next())
            {
                c1.add(rs.getString("id"));
            }
            
        }catch(Exception e)
        {
            
        }
        c1.setBounds(150,80,150,25);
        add(c1);
        
        
        JLabel  l3 = new JLabel("Doctor's Name");
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
        
        b2 = new JButton("Delete");
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
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(200,200,800,400);
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
               ResultSet rs = c.s.executeQuery("select *from doctor where id = '"+s+"'");
               
               while(rs.next())
               {
                   t1.setText(rs.getString("name"));
               }
            }catch(Exception e)
            {
                
            }
        }
        else if(ae.getSource() == b2)
        {   
             String s = c1.getSelectedItem();
             String str = "delete from doctor where id ='"+s+"'";
             try
            {  
              
                
                conn c = new conn();
                c.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null,"Doctor Deleted");
            
                
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == b3)
        {
            new doctor().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new deletedoc().setVisible(true);
    }
}
