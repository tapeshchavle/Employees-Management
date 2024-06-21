/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class EmployeesConnection {
    private static Connection conn=null;
    static {
        try{
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-S1QPSLM6:1521/xe","tapesh","abc");
            
        }catch(SQLException ex){
            System.out.println("Error during create the connection:"+ex.getMessage());
            System.exit(0);
        }
    }
    public static Connection getDbConnection(){
        return conn;
    }
    public static void getDbClose(){
        try{
            conn.close();
            System.out.println("Connection succesfully close");
        }catch(SQLException ex){
            System.out.println("Error when close the file"+ex.getMessage());
        }
        
    }
    
}
