/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.management.system;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.*;


public class db {
    
    Connection con;
    java.sql.PreparedStatement pst;
    public static Connection dbconnect()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost::3325/hms","root","");
            return (Connection) conn;
        }
       catch(Exception e2)
       {
           System.out.println(e2);
           return null;
       }
    }
}
