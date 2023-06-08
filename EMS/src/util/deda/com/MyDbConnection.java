package util.deda.com;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

//import DesignPattern.Singleton;

class Singleton{
private static Singleton instance = null;
    
    private Connection con; // Example variable
    
    private Singleton() {
        // Private constructor to prevent instantiation from outside the class
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    public void setMessage(Connection con) {
        this.con = con;
    }
    
    public Connection getMessage() {
        return con;
    }
	
}

public class MyDbConnection {

	static Connection con1;
	
	public static Connection getMyConnection() {
		try {
			
			Singleton singleton = Singleton.getInstance();
			con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "Apjak$2023");	
			singleton.setMessage(con1);			
			System.out.println(con1);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();	
			
		}		
		return con1;
	}	
	
	public static void main(String[] args) {
		System.out.println(getMyConnection());
	}
}
