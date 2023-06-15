
package hospital.management.system;


import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class viewvac extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    viewvac()
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
       
       
//       JLabel l1 = new JLabel("ID");
//       l1.setBounds(40,10,70,20);
//       add(l1);
//       
       JLabel l2 = new JLabel("NAME");
       l2.setBounds(40,10,70,20);
       add(l2);
       
       JLabel l3 = new JLabel("AGE");
       l3.setBounds(150,10,70,20);
       add(l3);
       
       JLabel l4 = new JLabel("GENDER");
       l4.setBounds(260,10,70,20);
       add(l4);
       
       JLabel l5 = new JLabel("Vaccine type");
       l5.setBounds(390,10,100,20);
       add(l5);
       
       JLabel l6 = new JLabel("Status");
       l6.setBounds(530,10,100,20);
       add(l6);
       
       
       JLabel l7 = new JLabel("PHONE");
       l7.setBounds(650,10,100,20);
       add(l7);
       
       
       JLabel l8 = new JLabel("Aadhar");
       l8.setBounds(780,10,100,20);
       add(l8);
       
       JLabel l9 = new JLabel("EMAIL");
       l9.setBounds(920,10,100,20);
       add(l9);
       
       
       b2 = new JButton("Back");
       b2.setBounds(530,560,120,30);
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.WHITE);
       add(b2);
       b2.addActionListener(this);
       
       
       getContentPane().setBackground(Color.WHITE);
       
       setLayout(null);
       setBounds(100,200,1020,650);
       setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try{
                conn c = new conn();
                String str = "select * from vaccination";
                ResultSet rs = c.s.executeQuery(str);
                
                
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                
            }
            
        }else if(ae.getSource() == b2)
        {
            new vaccine().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new viewvac().setVisible(true);
    }
    
    
}
