
package hospital.management.system;



import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import static java.awt.PageAttributes.ColorType.COLOR;

public class addadmit extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JComboBox c1;
    Choice c2;
    
    JRadioButton r1,r2;
    addadmit()
    {
        JLabel l1 = new JLabel("Admit New Patient");
         l1.setFont(new Font("Tahoma",Font.PLAIN,18));
         l1.setForeground(Color.BLUE);
        l1.setBounds(100,20,200,30);
        add(l1);
        
        JLabel l2 = new JLabel("ID");
        l2.setBounds(35,80,100,20);
        add(l2);
        
        c1 = new JComboBox(new String[] {"Passport","Voter id","Driving License","Aadhar"});
        c1.setBackground(Color.WHITE);
//        c1.setForeground(Color.WHITE);
        c1.setBounds(200,80,150,25);
        add(c1);
        
        JLabel l3 = new JLabel("NUMBER");
        l3.setBounds(35,120,100,20);
        add(l3);
        
        
        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);
        
        JLabel l4 = new JLabel("NAME");
        l4.setBounds(35,160,100,20);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);
        
        JLabel l5 = new JLabel("GENDER");
        l5.setBounds(35,200,100,20);
        add(l5);
        
         r1 = new JRadioButton("Male");
//      r1.setFont("Tahoma",Font.PLAIN,16);
        r1.setBackground(Color.WHITE);
        r1.setBounds(200,200,60,25);
        add(r1);
        
        r2 = new JRadioButton("Female");
//      r1.setFont("Tahoma",Font.PLAIN,16);
        r2.setBounds(270,200,80,25);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        JLabel l6 = new JLabel("DISEASE");
        l6.setBounds(35,240,100,20);
        add(l6);
        
        
        t3 = new JTextField();
        t3.setBounds(200,240,150,25);
        add(t3);
        
        
        JLabel l7 = new JLabel("Room Number");
        l7.setBounds(35,280,100,20);
        add(l7);
        
        
        c2 = new Choice();
        try
        {
            conn c = new conn();
            String str = "select *from room WHERE available = 'Available'";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next())
            {
                c2.add(rs.getString("room_number"));
//                System.out.println(rs.getString(str));
            }
        }catch(Exception e)
        {
            
        }
        c2.setBounds(200,280,150,25);
        add(c2);
        JLabel l8 = new JLabel("Admitted");
        l8.setBounds(35,320,100,20);
        add(l8);
        
        t4 = new JTextField();
        t4.setBounds(200,320,150,25);
        add(t4);
        
        
        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(35,360,100,20);
        add(l9);
        
        t5 = new JTextField();
        t5.setBounds(200,360,150,25);
        add(t5);
        
        
        b1 = new JButton("Admit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50,410,120,25);
        add(b1);
        b1.addActionListener(this);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,410,120,25);
        b2.addActionListener(this);
        add(b2);
        
         getContentPane().setBackground(Color.WHITE);
         
        setLayout(null);
        setBounds(200,200,900,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {  
        
        if(ae.getSource()==b1)
        {
            String id = (String)c1.getSelectedItem();
        String number = t1.getText();
        String name = t2.getText();
        String gender = null;
         if(r1.isSelected())
        {
            gender = "Male";
        }else if(r2.isSelected())
        {
            gender = "Female";
        }
        String disease = t3.getText();
        String room = (String)c2.getSelectedItem();
        String status = t4.getText();
        String deposit = t5.getText();
        
        String str = "insert into admitpatient values('"+id+"','"+number+"','"+name+"','"+gender+"','"+disease+"','"+room+"','"+status+"','"+deposit+"')";
        String str2 = "update room set available = 'Occupied' where room_number = '"+room+"'";
        try
        {
            conn c = new conn();
            c.s.executeUpdate(str);
            c.s.executeUpdate(str2);
            JOptionPane.showMessageDialog(null,"Patient Admitted");
        }catch(Exception e)
        { }

        }else if(ae.getSource()==b2)
        {
            new homepat().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new addadmit().setVisible(true);
    }
    
}
