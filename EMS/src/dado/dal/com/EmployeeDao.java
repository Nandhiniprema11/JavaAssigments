package dado.dal.com;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import com.dal.model.Employee1;
import util.deda.com.MyDbConnection;


public class EmployeeDao {

	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
	public void insertEmployee(Employee1 emp) {
		
		con =MyDbConnection.getMyConnection();
		try {
			ps =con.prepareStatement("insert into dalemp values(?,?)");
			
			//System.out.println(ps);
			
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
		    int noofrows =ps.executeUpdate();
		    
			System.out.println(noofrows + " got inserted into DB successfully!");
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
public void updateEmployee(Employee1 emp) {
		
		con =MyDbConnection.getMyConnection();
		try {
			ps =con.prepareStatement("update dalemp set empname=? where empno=?");
			
			System.out.println(ps);
			
			ps.setString(1, emp.getEname());
			ps.setInt(2, emp.getEmpno());
			
		    int noofrows =ps.executeUpdate();
		    
			System.out.println(noofrows + " got updated into DB successfully!");
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

public void deleteEmployee(Employee1 emp) {
	
	con =MyDbConnection.getMyConnection();
	try {
		ps =con.prepareStatement("delete from dalemp where empno=?");
		
		System.out.println(ps);
		
		ps.setInt(1, emp.getEmpno());
		
	    int noofrows =ps.executeUpdate();
	    
		System.out.println(noofrows + " got deleted into DB successfully!");
	} 
	catch (SQLException e) {
	
		e.printStackTrace();
	}
	
}
	
	public void showEmployee() {
		con =MyDbConnection.getMyConnection();
		try {
			stmt =con.createStatement();
			rs =stmt.executeQuery("select * from dalemp");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}