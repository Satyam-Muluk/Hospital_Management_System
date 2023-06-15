
package hospital.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class log extends JFrame implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    log(){

//        f=new JFrame("Login");
//
//        f.setBackground(Color.white);
//        f.setLayout(null);
       
        setBackground(Color.WHITE);
        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/mid.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        add(l3);
        
       


        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        add(b2);

        b2.addActionListener(this);
        
//        f.getContentPane().setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setSize(600,300);
        setLocation(400,300);
        setTitle("Login");

    }
public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1)
        {
            try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select * from login where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q);  // s is a createstatement object in conn class
            if(rs.next()){

                 new frontpage().setVisible(true);
                 this.setVisible(false);
                 System.out.println("Success");
                 System.out.println(ae.getSource());
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                f.setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()==b2){
            System.exit(0);
        }
        
    }
    
    public static void main(String[] arg){
//        log l=new log();
           new log().setVisible(true);
    }

    

   
}
