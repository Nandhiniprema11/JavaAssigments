package com.dal.hibproj;
 
import com.dal.controller.EmployeeController;
 
public class App {
 
    public static void main(String[] args) {
        EmployeeController ec = new EmployeeController();
        ec.addEmployee();
    }
 
}