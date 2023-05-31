package util.deda.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbConnection {

	static Connection con;
	
	public static Connection getMyConnection() {
		try {
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "Apjak$2023");			
			System.out.println(con);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();	
			
		}		
		return con;
	}	
	
	public static void main(String[] args) {
		System.out.println(getMyConnection());
	}
}
