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


public class updatedoc extends JFrame implements ActionListener,ItemListener{
    
    
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JRadioButton r1,r2;
    JComboBox co,conew;
    JButton b1,b2,b3;
    Choice c2;
    JLabel doc;
    
    updatedoc()
    {
         getContentPane().setBackground(Color.WHITE);
        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,80,120,30);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(230,80,150,30);
        add(t1);
        
        c2 = new Choice();
        c2.setBounds(160,40,200,20);
        c2.addItemListener(this);
       
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from doctor");
      
            while(rs.next()){
                c2.add(rs.getString("id"));    
            }
        }catch(Exception e){ }
       
        doc = new JLabel("Select doctor no");
        doc.setBounds(40,40,100,20);
        add(doc);
        add(c2);
        
        
        
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
        
//        r1 = new JRadioButton("Male");
////      r1.setFont("Tahoma",Font.PLAIN,16);
//        r1.setBackground(Color.WHITE);
//        r1.setBounds(230,180,70,30);
//        add(r1);
//        
//        r2 = new JRadioButton("Female");
////      r1.setFont("Tahoma",Font.PLAIN,16);
//        r2.setBounds(310,180,70,30);
//        r2.setBackground(Color.WHITE);
//        add(r2);
        
//        
        JLabel spec = new JLabel("SPECIALIZATION");
        spec.setFont(new Font("Tahoma",Font.PLAIN,17));
        spec.setBounds(60,230,150,30);
        add(spec);
        
        t8 = new JTextField();
        t8.setBounds(230,230,150,30);
        add(t8);
        
//        co = new JComboBox();
//         
//        co.setBounds(230,230,150,30);
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
        
        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        aadhar.setBounds(60,380,120,30);
        add(aadhar);
        
        t5 = new JTextField();
        t5.setBounds(230,380,150,30);
        add(t5);
        
        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        email .setBounds(60,430,120,30);
        add(email);
        
        t6 = new JTextField();
        t6.setBounds(230,430,150,30);
        add(t6);
        
       
        
        
        b1 = new JButton("UPDATE");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(120,510,150,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("BACK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(50,570,120,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("LOGOUT");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(200,570,120,30);
        b3.addActionListener(this);
        add(b3);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/doctor.png"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400,150,450,400);
        add(l1);
        
        JLabel l2 = new JLabel("UPDATE DOCTOR'S DETAILS");
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Tahoma",Font.PLAIN,30));
        l2.setBounds(430,80,400,30);
        add(l2);
//        
        
       
        setLayout(null);
        setBounds(200,200,900,700);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {   
         if(ae.getSource()==b1){
           String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phone = t4.getText();
        String aadhar = t5.getText();
        String email = t6.getText();
        String gender = t7.getText();
        String specification = t8.getText();
        
//        if(r1.isSelected())
//        {
//            gender = "Male";
//        }else if(r2.isSelected())
//        {
//            gender = "Female";
//        }
//        String str[] = {"Cardiologist","Paediatrician","Neurologist"};
//       
//        conew = new JComboBox(str);
//        String specification = (String)conew.getSelectedItem();
        
         String qry = "update doctor set name='"+name+"',age='"+age+"',gender='"+gender+"',specification='"+specification+"',salary='"+salary+"',phone='"+phone+"',aadhar='"+aadhar+"',email='"+email+"'   where id="+c2.getSelectedItem();
       
            try{
                conn c1 = new conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Doctor Updated");
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        
        else if(ae.getSource()==b2)
        {
            System.out.println("back");
            new doctor().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b3)
        {
            System.exit(0);
        }
        
    }
    
    public void itemStateChanged(ItemEvent ie){
        try{
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from doctor where id="+c2.getSelectedItem());
            
            if(rs.next()){
                t1.setText(rs.getString("name"));
                t2.setText(rs.getString("age"));
                t3.setText(rs.getString("salary"));
                t4.setText(rs.getString("phone"));
                t5.setText(rs.getString("aadhar"));
                t6.setText(rs.getString("email"));
                t7.setText(rs.getString("gender"));
//                co.addItem(rs.getString("specification"));
//                co.setVisible(true);
                t8.setText(rs.getString("specification"));
                System.out.println(rs.getString("specification"));
                
                
            }
        }catch(Exception ee){
           ee.printStackTrace();
        }
    
    }
    
     public static void main(String[] args)
    {
        new updatedoc().setVisible(true);   //object of the class
    }
}
