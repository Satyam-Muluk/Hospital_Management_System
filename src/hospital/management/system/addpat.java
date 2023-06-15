
package hospital.management.system;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;
public class addpat extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1,b2,b3;
    addpat()
    {
        
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
        
        
        JLabel disease = new JLabel("Disease");
        disease.setFont(new Font("Tahoma",Font.PLAIN,17));
        disease.setBounds(60,180,120,30);
        add(disease);
        
        
        t3 = new JTextField();
        t3.setBounds(230,180,150,30);
        add(t3);
        
        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        aadhar.setBounds(60,240,120,30);
        add(aadhar);
        
        
        t4 = new JTextField();
        t4.setBounds(230,240,150,30);
        add(t4);
        
        
         b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(120,290,150,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("BACK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(50,340,120,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("LOGOUT");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(200,340,120,30);
        b3.addActionListener(this);
        add(b3);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setLayout(null);
        setBounds(200,200,900,550);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {   
        if(ae.getSource() == b1)
        {
        String name = t1.getText();
        String age = t2.getText();
        String disease = t3.getText();
        String aadhar = t4.getText();
       
        
        String gender = null;
        
        if(r1.isSelected())
        {
            gender = "Male";
        }else if(r2.isSelected())
        {
            gender = "Female";
        }
        
//        String specification = (String)c1.getSelectedItem(); //returns object hence need to typecast to string
        
        conn c = new conn();
        String str = "insert into patient values( '"+name+"','"+age+"','"+gender+"','"+aadhar+"','"+disease+"')";
        
        try{
            c.s.executeUpdate(str);
           JOptionPane.showMessageDialog(null, "New Patient Added");
           //this.setVisible(false);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Invalid Id");
            System.out.println(e);
        }
        }else if(ae.getSource()==b2)
        {
            System.out.println("back");
            new patient().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b3)
        {
            System.exit(0);
        }
        
    }
    
    
    public static void main(String[] args)
    {
        new addpat().setVisible(true);
    }
}
