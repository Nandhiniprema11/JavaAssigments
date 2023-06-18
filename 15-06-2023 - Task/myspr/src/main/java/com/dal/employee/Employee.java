package com.dal.employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Employee {
   @Value("101")
    private int eid; 
   @Value("Nandhini")
    private String ename;
 
	    public Employee() {
        super();
        // TODO Auto-generated constructor stub
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
 
    @Override
    public String toString() {
        return "Employee [eid=" + eid + ", ename=" + ename + "]";
    }
    }   