
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

public class updatepat extends JFrame implements ActionListener, ItemListener{
    
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JComboBox co,conew;
    JButton b1,b2,b3;
    Choice c2;
    JLabel pat;
    
    updatepat()
    {
         JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,80,120,30);
        add(name);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/doctor.png"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400,150,450,400);
        add(l1);
        
         getContentPane().setBackground(Color.WHITE);
        
        JLabel l2 = new JLabel("Update Patient");
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Tahoma",Font.PLAIN,30));
        l2.setBounds(530,80,400,30);
        add(l2);
        
        t1 = new JTextField();
        t1.setBounds(230,80,150,30);
        add(t1);
        
        c2 = new Choice();
        c2.setBounds(160,40,200,20);
        c2.addItemListener(this);
       
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from patient");
      
            while(rs.next()){
                c2.add(rs.getString("aadhar"));    
            }
        }catch(Exception e){ }
       
        pat = new JLabel("Select Aadhar no");
        pat.setBounds(40,40,100,20);
        add(pat);
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
        


        t3 = new JTextField();
        t3.setBounds(230,180,150,30);
        add(t3);
        
         JLabel dis = new JLabel("Disease");
        dis.setFont(new Font("Tahoma",Font.PLAIN,17));
        dis.setBounds(60,230,150,30);
        add(dis);
        
          t4 = new JTextField();
          t4.setBounds(230,230,150,30);
          add(t4);
          
          
        b3 = new JButton("Update");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(120,320,120,30);
        b3.addActionListener(this);
        add(b3);
        
        
        b1 = new JButton("BACK");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50,370,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("LOGOUT");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,370,120,30);
        b2.addActionListener(this);
        add(b2);
        
         setLayout(null);
        setBounds(200,200,900,600);
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
         
           else if(ae.getSource()==b3)
        {
           String name = t1.getText();
           String age = t2.getText();
           String gender = t3.getText();
           String disease = t4.getText();

           
           
            String qry = "update patient set name='"+name+"',age='"+age+"',gender='"+gender+"',disease='"+disease+"'   where aadhar="+c2.getSelectedItem();
            try{
                conn conect = new conn();
                conect.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Patient Updated");
            }catch(Exception ee){
                System.out.println(ee);
            }
        }
    }

    
     public void itemStateChanged(ItemEvent ie){
        try{
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from patient where aadhar="+c2.getSelectedItem());
            
            if(rs.next()){
                t1.setText(rs.getString("name"));
                t2.setText(rs.getString("age"));
                t3.setText(rs.getString("gender"));
                t4.setText(rs.getString("disease"));

                
                
            }
        }catch(Exception ee){
           System.out.println(ee);
        }
    
    }
    
    public static void main(String[] args)
    {
        new updatepat().setVisible(true);
     
    }
}
