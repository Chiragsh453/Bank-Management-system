package bankmanagement.system;

import java.sql.*;

public class Conn {

    /* mysql ek external entity h isiliye hme exception handling lagane padegi*/
Connection c; 
Statement s;

   public Conn(){
    try{
      //Class.forName(com.mysql.cj.jdbc.Driver);
      c= DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","chirag8755");
     s=c.createStatement();
    
    }catch(Exception e){
       System.out.print(e);
       }
 }  
 }
 