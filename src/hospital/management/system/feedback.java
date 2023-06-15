
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

public class feedback extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3;
      JButton b1,b2,b3,b4;
      
    feedback()
    {
         getContentPane().setBackground(Color.WHITE);
        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,80,120,30);
        add(name);
        
        
        
//          
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/feedback.jpg"));
       Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400,10,450,400);
        add(l1);
        
        
         JLabel giv = new JLabel("Please enter adhar number first!");
        giv.setFont(new Font("Tahoma",Font.PLAIN,17));
        giv.setForeground(Color.RED);
        giv.setBounds(60,220,250,30);
        add(giv);
        
        
         JLabel title = new JLabel("Vaccination Feedback");
        title.setFont(new Font("Tahoma",Font.BOLD,17));
        title.setForeground(Color.BLUE);
        title.setBounds(180,20,190,30);
        add(title);
        
        
        t1 = new JTextField();
        t1.setBounds(230,80,150,30);
        add(t1);
        

        
        
        JLabel age = new JLabel("Feedback");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60,130,120,30);
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(230,130,150,30);
        add(t2);
        
        JLabel gender = new JLabel("Aadhar");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60,180,120,30);
        add(gender);
        


          t3 = new JTextField();
          t3.setBounds(230,180,150,30);
          add(t3);
        
                
      b1 = new JButton("BACK");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50,320,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("LOGOUT");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,320,120,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Load Data");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(50,260,120,30);
        b3.addActionListener(this);
        add(b3);
        
        b4 = new JButton("Insert");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(200,260,120,30);
        b4.addActionListener(this);
        add(b4);

     
        
       
        setLayout(null);
        setBounds(200,200,900,500);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae)
    {   
         if(ae.getSource()==b1){
//           
                 new vaccine().setVisible(true);
                 this.setVisible(false);
             
        }
        
        else if(ae.getSource()==b2)
        {
           System.exit(0);
        }
         
         else if(ae.getSource()==b3)
        {
          try
          {
             conn p = new conn();
              String sql = "select * from vaccination where aadhar = ?";
              PreparedStatement st = p.c.prepareStatement(sql);
              st.setString(1,t3.getText());  // here aadhar is only parameter
              ResultSet rs = st.executeQuery();
              while(rs.next())
              {   
                  System.out.println(rs.getString("status"));
                  String vacci = rs.getString("status");
                   if(vacci.equals("Vaccinated") || vacci.equals("vaccinated"))
                  {
                       t1.setText(rs.getString("name"));
                  }
                  else
                  {
                       JOptionPane.showMessageDialog(null,"Please complete 2nd dose");
                  }
//                 
                 
              }
          }catch(Exception e)
          {
              
          }
        }
         else if(ae.getSource()== b4)
         {
             String name = t1.getText();
           String feedback = t2.getText();
           String aadhar = t3.getText();
            conn c = new conn();
            String str = "insert into vaccfeedback(name,feedback,aadhar) values('"+name+"','"+feedback+"','"+aadhar+"')";
        
        try{
            c.s.executeUpdate(str);
           JOptionPane.showMessageDialog(null, "Feedback Added");
           //this.setVisible(false);
            
        }catch(Exception e){
            System.out.println(e);
        }
         }
        
        
    }
      public static void main(String[] args)
    {
        new feedback().setVisible(true);   //object of the class
    }
}
