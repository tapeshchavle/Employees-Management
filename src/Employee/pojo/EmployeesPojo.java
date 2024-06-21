/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee.pojo;

/**
 *
 * @author hp
 */
public class EmployeesPojo {

    public EmployeesPojo() {
    }

    public EmployeesPojo(int eid, String ename, double esal, int edeptno) {
        this.eid = eid;
        this.ename = ename;
        this.esal = esal;
        this.edeptno = edeptno;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getEsal() {
        return esal;
    }

    public void setEsal(double esal) {
        this.esal = esal;
    }

    public int getEdeptno() {
        return edeptno;
    }

    public void setEdeptno(int edeptno) {
        this.edeptno = edeptno;
    }
    private int eid;
    private String ename;
    private double esal;
    private int edeptno;
    
}
