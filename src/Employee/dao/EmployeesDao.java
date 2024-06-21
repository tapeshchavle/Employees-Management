/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee.dao;

import Employee.dbutil.EmployeesConnection;
import Employee.pojo.EmployeesPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class EmployeesDao {
    /*Add Employee*/
    public static void setEmpdetails(EmployeesPojo emp)throws SQLException{
        Connection conn=EmployeesConnection.getDbConnection();
        PreparedStatement ps=conn.prepareStatement("insert into employees values(?,?,?,?)");
        ps.setInt(1, emp.getEid());
        ps.setString(2, emp.getEname());
        ps.setDouble(3, emp.getEsal());
        ps.setInt(4, emp.getEdeptno());
        int res=ps.executeUpdate();
        System.out.println("Record inserted "+res);
        
    }
    /*search employee by id*/
    public static EmployeesPojo seachEmpById(int id)throws SQLException{
        Connection conn=EmployeesConnection.getDbConnection();
        PreparedStatement ps=conn.prepareStatement("select * from employees where eid=?");
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        EmployeesPojo empdetails=null;
        while(rs.next()){
            empdetails=new EmployeesPojo();
            empdetails.setEid(rs.getInt(1));
            empdetails.setEname(rs.getString(2));
            empdetails.setEsal(rs.getDouble(3));
            empdetails.setEdeptno(rs.getInt(4));
            
        }
        return empdetails;
    }
    /*show all employees*/
    public static List showAllEmployees()throws SQLException{
        Connection conn=EmployeesConnection.getDbConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from employees");
        List <EmployeesPojo> emplist=new ArrayList<>();
        while(rs.next()){
            EmployeesPojo empdetails=new EmployeesPojo();
            empdetails.setEid(rs.getInt(1));
            empdetails.setEname(rs.getString(2));
            empdetails.setEsal(rs.getDouble(3));
            empdetails.setEdeptno(rs.getInt(4));
            emplist.add(empdetails);
        }
        return emplist;       
        
    }
    /*update employee by id*/
    public static boolean empUpdate(EmployeesPojo emp)throws SQLException{
        Connection conn=EmployeesConnection.getDbConnection();
        PreparedStatement ps=conn.prepareStatement("update employees set ename=?,esal=?,edeptno=? where eid=?");
        ps.setString(1, emp.getEname());
        ps.setDouble(2,emp.getEsal());
        ps.setInt(3, emp.getEdeptno());
        ps.setInt(4,emp.getEid());
        int res=ps.executeUpdate();
        return res==1;
        
        
    }
    /*delete employee by id*/
    public static boolean empdelete(int id)throws  SQLException{
        Connection conn=EmployeesConnection.getDbConnection();
        PreparedStatement ps=conn.prepareStatement("delete from employees where eid=?");
        ps.setInt(1, id);
        int rs=ps.executeUpdate();
        return rs==1;       
        
    }
            
    
}
