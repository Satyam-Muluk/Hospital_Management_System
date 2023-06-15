/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;


import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class patinfo extends JFrame implements ActionListener{
    
    
    JTable t1;
    JButton b1,b2;
    
    patinfo()
    {
         t1 = new JTable();
       t1.setBounds(0,40,1000,500);
       add(t1);
       
       b1 = new JButton("Load Data");
       b1.setBounds(350,560,120,30);
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       add(b1);
       b1.addActionListener(this);
       
       
       JLabel l1 = new JLabel("Name");
       l1.setBounds(50,10,100,20);
       add(l1);
       
//    
//       
       JLabel l2 = new JLabel("Age");
       l2.setBounds(290,10,70,20);
       add(l2);
       
       JLabel l3 = new JLabel("GENDER");
       l3.setBounds(450,10,70,20);
       add(l3);
       

       
       
       JLabel l4 = new JLabel("Aadhar");
       l4.setBounds(690,10,100,20);
       add(l4);
       
       
       JLabel l5 = new JLabel("Disease");
       l5.setBounds(830,10,100,20);
       add(l5);
       

       
       
       b2 = new JButton("Back");
       b2.setBounds(530,560,120,30);
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.WHITE);
       add(b2);
       b2.addActionListener(this);
       
       
       getContentPane().setBackground(Color.WHITE);
       
       setLayout(null);
       setBounds(200,200,950,650);
       setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try{
                conn c = new conn();
                String str = "select * from patient";
                ResultSet rs = c.s.executeQuery(str);
                
                
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                
            }
            
        }else if(ae.getSource() == b2)
        {
            new patient().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new patinfo().setVisible(true);
    }
}
