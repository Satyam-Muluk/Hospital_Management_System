
package hospital.management.system;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
public class HospitalManagementSystem extends JFrame implements ActionListener{

    HospitalManagementSystem()
    {   
        setBounds(300,200,1024,536); // takes setsize and setlocation in single command
        
       // setSize(400,400);
      
       // setLocation(300,300);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hospital/Management/System/icons/intro.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1024,536,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        //JLabel l1 = new JLabel(i1);
        l3.setBounds(0,0,1024,536);
        add(l3);
       
       
       JLabel l2 = new JLabel("Hospital Management System");
       l2.setBounds(100,0,1000,70);
       l2.setForeground(Color.WHITE);
       l2.setFont(new Font("serif",Font.PLAIN,70));
       l3.add(l2);
       
       JButton b1 = new JButton("NEXT");
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       b1.setBounds(700,430,120,30);
       b1.addActionListener(this);
       l3.add(b1);
       
       
       setLayout(null);
       setVisible(true);
//       
      
    }
    public void actionPerformed(ActionEvent ae){
                new log().setVisible(true);
                this.setVisible(false);
                
        }
    public static void main(String[] args) {
        new HospitalManagementSystem();
    }
    
}
