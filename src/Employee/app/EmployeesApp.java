/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee.app;

import Employee.dao.EmployeesDao;
import Employee.dbutil.EmployeesConnection;
import Employee.pojo.EmployeesPojo;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class EmployeesApp {
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        String choice;
        do{
            System.out.println("Select the Option");
            System.out.println("Press 1 for Add Employee");
            System.out.println("Press 2 for Search Employee by Id");
            System.out.println("Press 3 for Show All Employees:");
            System.out.println("Press 4 for Update record of Employee");
            System.out.println("Press 5 for Delete record of Employee");
            int inp=kb.nextInt();
            try{
            switch(inp){
                case 1:
                    System.out.println("Enter id ");
                    int eid=kb.nextInt();
                    System.out.println("Enter name");
                    String ename=kb.next();
                    System.out.println("Enter salary");
                    double esal=kb.nextDouble();
                    System.out.println("Enter deptno");
                    int edeptno=kb.nextInt();
                    EmployeesPojo eojb=new EmployeesPojo(eid, ename, esal, edeptno);
                    EmployeesDao.setEmpdetails(eojb);
                    break;
                case 2:
                    System.out.println("Enter id no:");
                    int id=kb.nextInt();
                    EmployeesPojo esearch=EmployeesDao.seachEmpById(id);
                    if(esearch!=null){
                        System.out.println("Record is found and Record details is:");
                        System.out.println(esearch.getEid()+"\t"+esearch.getEname()+"\t"+esearch.getEsal()+"\t"+esearch.getEdeptno());
                    }else{
                        System.out.println("Record is not found:");
                    }
                    break;
                case 3:
                    List <EmployeesPojo> emplist=EmployeesDao.showAllEmployees();
                    for(EmployeesPojo emp:emplist){
                        System.out.println(emp.getEid()+"\t"+emp.getEname()+"\t"+emp.getEsal()+"\t"+emp.getEdeptno());
                    }
                    break;
                case 4:
                    System.out.println("Enter id to be update");
                    int uid=kb.nextInt();
                    System.out.println("Enter name");
                    String uname=kb.next();
                    System.out.println("Enter salary");
                    double usal=kb.nextDouble();
                    System.out.println("Enter deptno");
                    int udeptno=kb.nextInt();
                    EmployeesPojo uemp=new EmployeesPojo(uid, uname, usal, udeptno);
                    boolean res=EmployeesDao.empUpdate(uemp);
                    if(res){
                        System.out.println("record updated");
                    }else{
                        System.out.println("record not updated");
                    }
                    break;
                case 5:
                    System.out.println("Enter id");
                    int did=kb.nextInt();
                    boolean dres=EmployeesDao.empdelete(did);
                    System.out.println(dres);
                    break;
                 default:
                     System.out.println("Please select valid option");
                            
                            
            }
            }catch(SQLException ex){
                System.out.println("some error "+ex.getMessage());
            }
            System.out.println("Do you want Continue:(yes/no)");
            choice=kb.next();
        }while(choice.equalsIgnoreCase("yes"));
        
        EmployeesConnection.getDbClose();
        
    }
    
}
