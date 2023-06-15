
package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;

public class addtech extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1,b2,b3;
    addtech()
    {
          getContentPane().setBackground(Color.WHITE);
        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,30,120,30);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(230,30,150,30);
        add(t1);
        
        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60,80,120,30);
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(230,80,150,30);
        add(t2);
        
        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60,130,120,30);
        add(gender);
        
        r1 = new JRadioButton("Male");
//      r1.setFont("Tahoma",Font.PLAIN,16);
        r1.setBackground(Color.WHITE);
        r1.setBounds(230,130,70,30);
        add(r1);
        
        r2 = new JRadioButton("Female");
//      r1.setFont("Tahoma",Font.PLAIN,16);
        r2.setBounds(310,130,70,30);
        r2.setBackground(Color.WHITE);
        add(r2);
        
//        
        JLabel spec = new JLabel("SPECIALIZATION");
        spec.setFont(new Font("Tahoma",Font.PLAIN,17));
        spec.setBounds(60,180,150,30);
        add(spec);
        
        
        String str[] = {"Nurse","Ward Boy","Technician"};
        c1 = new JComboBox(str);
        c1.setBounds(230,180,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
//        
        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        salary.setBounds(60,230,120,30);
        add(salary);
        
        t3 = new JTextField();
        t3.setBounds(230,230,150,30);
        add(t3);

    
        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        phone.setBounds(60,280,120,30);
        add(phone);
        
        t4 = new JTextField();
        t4.setBounds(230,280,150,30);
        add(t4);
        
        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        aadhar.setBounds(60,330,120,30);
        add(aadhar);
        
        t5 = new JTextField();
        t5.setBounds(230,330,150,30);
        add(t5);
        
        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        email .setBounds(60,380,120,30);
        add(email);
        
        t6 = new JTextField();
        t6.setBounds(230,380,150,30);
        add(t6);
        
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(120,470,150,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("BACK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(50,540,120,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("LOGOUT");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(200,540,120,30);
        b3.addActionListener(this);
        add(b3);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/doctor.png"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400,100,450,400);
        add(l1);
        
        JLabel l2 = new JLabel("ADD Technician's DETAILS");
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Tahoma",Font.PLAIN,30));
        l2.setBounds(430,30,400,30);
        add(l2);
//        
        
       
        setLayout(null);
        setBounds(200,200,900,650);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {   
        if(ae.getSource() == b1)
        {
            String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phone = t4.getText();
        String aadhar = t5.getText();
        String email = t6.getText();
        
        String gender = null;
        
        if(r1.isSelected())
        {
            gender = "Male";
        }else if(r2.isSelected())
        {
            gender = "Female";
        }
        
        String specification = (String)c1.getSelectedItem(); //returns object hence need to typecast to string
        
        conn c = new conn();
        String str = "insert into technician values( '"+name+"','"+age+"','"+gender+"','"+specification+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
        
        try{
            c.s.executeUpdate(str);
           JOptionPane.showMessageDialog(null, "New Staff Added");
           //this.setVisible(false);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Invalid Id");
            System.out.println(e);
        }
        }else if(ae.getSource()==b2)
        {
            System.out.println("back");
            new technician().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b3)
        {
            System.exit(0);
        }
        
    }
    public static void main(String[] args)
    {
        new addtech().setVisible(true);   //object of the class
    }
    
}
