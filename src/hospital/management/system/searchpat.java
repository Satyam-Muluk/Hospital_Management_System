
package hospital.management.system;


import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;
import java.sql.PreparedStatement;


public class searchpat extends JFrame implements ActionListener{
    
     JTextField t1,t2,t3,t4,t5;
    JComboBox co,conew;
    JButton b1,b2,b3;
    Choice c2;
    JLabel doc;
    
    searchpat()
    {
         getContentPane().setBackground(Color.WHITE);
        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,80,120,30);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(230,80,150,30);
        add(t1);
        

        
        
        
        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60,130,120,30);
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(230,130,150,30);
        add(t2);
        
        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60,180,120,30);
        add(gender);
        


          t3= new JTextField();
          t3.setBounds(230,180,150,30);
          add(t3);
        
                
        JLabel dis = new JLabel("Disease");
        dis.setFont(new Font("Tahoma",Font.PLAIN,17));
        dis.setBounds(60,230,150,30);
        add(dis);
        
        
        

        
        t4 = new JTextField();
        t4.setBounds(230,230,150,30);
        add(t4);
        
//        
       
        
        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        aadhar.setBounds(60,280,120,30);
        add(aadhar);
        
        JLabel giv = new JLabel("Please enter adhar number first!");
        giv.setFont(new Font("Tahoma",Font.PLAIN,17));
        giv.setForeground(Color.RED);
        giv.setBounds(60,310,250,30);
        add(giv);
        
        
        t5 = new JTextField();
        t5.setBounds(230,280,150,30);
        add(t5);
        
        
        
        
        b3= new JButton("Load Data");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(120,350,120,30);
        b3.addActionListener(this);
        add(b3);
        
        b1 = new JButton("BACK");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50,400,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("LOGOUT");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,400,120,30);
        b2.addActionListener(this);
        add(b2);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/doctor.png"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400,150,450,400);
        add(l1);
        
        JLabel l2 = new JLabel("Search Patient");
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Tahoma",Font.PLAIN,30));
        l2.setBounds(530,80,400,30);
        add(l2);
//        
        
       
        setLayout(null);
        setBounds(200,200,900,700);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {   
         if(ae.getSource()==b1){
           
                 new patient().setVisible(true);
                 this.setVisible(false);
             
        }
        
        else if(ae.getSource()==b2)
        {
           System.exit(0);
        }
        else if(ae.getSource() == b3)
        {
             try
          {
              conn p = new conn();
              String sql = "select * from patient where aadhar = ?";
              PreparedStatement st = p.c.prepareStatement(sql);
              st.setString(1,t5.getText());
              ResultSet rs = st.executeQuery();
              while(rs.next())
              {
                  t1.setText(rs.getString("name"));
                  t2.setText(rs.getString("age"));
                  t3.setText(rs.getString("gender"));
                  t4.setText(rs.getString("disease"));
              //  t5.setText(rs.getString("aadhar"));
                
                 
                 System.out.println(rs.getString("email"));
                 
              }
          }catch(Exception e)
          {
              
          }
        }
        
    }

    

    
     public static void main(String[] args)
    {
        new searchpat().setVisible(true);   //object of the class
    }
    
    
}
