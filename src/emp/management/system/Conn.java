/*JDBC Connectivity
1.Register the driver class
2.Creating Connection String
3.Creating a statement 
4.Executing mysql quries
5.Closing the connections

*/

package emp.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
 public Conn(){
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         c=DriverManager.getConnection("jdbc:mysql:///emp_management_system","root","Mysql@2023");
         s=c.createStatement();
     }
     catch(Exception e){
         e.printStackTrace();
     }
 }   
}
