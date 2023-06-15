/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


public class updatetech  extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,aad;
    JComboBox co,conew;
    JButton b1,b2,b3,b4;
    Choice c2;
    JLabel doc;
     updatetech()
     {
         getContentPane().setBackground(Color.WHITE);
        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,80,120,30);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(230,80,150,30);
        add(t1);
        
//        c2 = new Choice();
//        c2.setBounds(160,40,200,20);
//        c2.addItemListener(this);
//       
//        try{
//            conn c = new conn();
//            ResultSet rs = c.s.executeQuery("select * from technician");
//      
//            while(rs.next()){
//                c2.add(rs.getString("aadhar"));    
//            }
//        }catch(Exception e){ }
       
        doc = new JLabel("Aadhar no");
        doc.setBounds(40,40,100,20);
        add(doc);
//        add(c2);
        aad = new JTextField();
        aad.setBounds(230,30,150,30);
        add(aad);
        
        
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
        


          t7 = new JTextField();
          t7.setBounds(230,180,150,30);
          add(t7);
          
         JLabel l2 = new JLabel("Update Technician");
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Tahoma",Font.PLAIN,30));
        l2.setBounds(430,80,400,30);
        add(l2);
                
        JLabel spec = new JLabel("SPECIALIZATION");
        spec.setFont(new Font("Tahoma",Font.PLAIN,17));
        spec.setBounds(60,230,150,30);
        add(spec);
        
          t8 = new JTextField();
          t8.setBounds(230,230,150,30);
          add(t8);
        
        
//        co = new JComboBox();
//         
//        co.setBounds(230,280,150,30);
//        co.setBackground(Color.WHITE);
////        co.setVisible(false);
//        add(co);
        
//        
        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        salary.setBounds(60,280,120,30);
        add(salary);
        
        t3 = new JTextField();
        t3.setBounds(230,280,150,30);
        add(t3);

    
        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        phone.setBounds(60,330,120,30);
        add(phone);
        
        t4 = new JTextField();
        t4.setBounds(230,330,150,30);
        add(t4);
        
//        JLabel aadhar = new JLabel("AADHAR");
//        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
//        aadhar.setBounds(60,380,120,30);
//        add(aadhar);
//        
//        t5 = new JTextField();
//        t5.setBounds(230,380,150,30);
//        add(t5);
        
        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        email .setBounds(60,380,120,30);
        add(email);
        
        t6 = new JTextField();
        t6.setBounds(230,380,150,30);
        add(t6);
        
        
        b3 = new JButton("Update");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(210,470,120,30);
        b3.addActionListener(this);
        add(b3);
        
        
        b4 = new JButton("Load Data");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(50,470,120,30);
        b4.addActionListener(this);
        add(b4);
        
        b1 = new JButton("BACK");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50,520,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("LOGOUT");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,520,120,30);
        b2.addActionListener(this);
        add(b2);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/doctor.png"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400,150,450,400);
        add(l1);
        
       
//        
        
       
        setLayout(null);
        setBounds(200,200,900,700);
        setVisible(true);
     }
     public void actionPerformed(ActionEvent ae)
    {   
         if(ae.getSource()==b1){
           
                 new technician().setVisible(true);
                 this.setVisible(false);
             
        }
        
        else if(ae.getSource()==b2)
        {
           System.exit(0);
        }
         
          else if(ae.getSource()==b3)
        {
           String name = t1.getText();
           String age = t2.getText();
           String gender = t7.getText();
           String spec = t8.getText();
           String sal = t3.getText();
           String phone = t4.getText();
           String email = t6.getText();
           String aadhar = aad.getText();
           
           
            String qry = "update technician set name='"+name+"',age='"+age+"',gender='"+gender+"',specification='"+spec+"',salary='"+sal+"',phone='"+phone+"',email='"+email+"'   where aadhar="+aadhar;
            try{
                conn conect = new conn();
                conect.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Technician Updated");
            }catch(Exception ee){
                System.out.println(ee);
            }
        }
         else if(ae.getSource()==b4)
        {
          try
          {
              conn p = new conn();
              String sql = "select * from technician where aadhar = ?";
              PreparedStatement st = p.c.prepareStatement(sql);
              st.setString(1,aad.getText());
              ResultSet rs = st.executeQuery();
//               if(rs.next() == false)
//                {
//                  JOptionPane.showMessageDialog(null,"Record Not Found");
//                }
              while(rs.next())
              {   
//                  System.out.print(rs.next());
                  t1.setText(rs.getString("name"));
                  t2.setText(rs.getString("age"));
                  t7.setText(rs.getString("gender"));
                  t8.setText(rs.getString("specification"));
                  t3.setText(rs.getString("salary"));
              //  t5.setText(rs.getString("aadhar"));
                 t4.setText(rs.getString("phone"));
                 t6.setText(rs.getString("email"));
//                 t8.setText(rs.getString("email"));
//                 System.out.println(rs.getString("email"));
                
                 
              }
//              System.out.print(rs.next());
              
             
          }
          catch(Exception e)
          {
              System.out.print(e);
          }
            
        }
    }
           
    public static void main(String[] args)
    {
        new updatetech().setVisible(true);   //object of the class
    }
}
        
        

    
//    public void itemStateChanged(ItemEvent ie){
//        try{
//            conn c1 = new conn();
//            ResultSet rs = c1.s.executeQuery("select * from technician where aadhar="+c2.getSelectedItem());
//            
//            if(rs.next()){
//                t1.setText(rs.getString("name"));
//                t2.setText(rs.getString("age"));
//                t3.setText(rs.getString("salary"));
//                t7.setText(rs.getString("gender"));
//                t4.setText(rs.getString("phone"));
//              //  t5.setText(rs.getString("aadhar"));
//                t6.setText(rs.getString("email"));
////                co.addItem(rs.getString("specification"));
////                co.setVisible(true);
//                t8.setText(rs.getString("specification"));
//                System.out.println(rs.getString("specification"));
//                
//                
//            }
//        }catch(Exception ee){
//           System.out.println(ee);
//        }
//    
//    }
    
     
