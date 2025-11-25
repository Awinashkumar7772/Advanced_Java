package cdac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Day08_Callable_Statement {
	static Scanner sc = new Scanner(System.in);
	public static Connection con;
	
	public void accessConnection() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newDatabase","root","993450@Awi");
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Day08_Callable_Statement cl = new Day08_Callable_Statement();
		cl.accessConnection();
		
		System.out.println("Connected to the database");
		CallableStatement cls = con.prepareCall("{call getAnnualSal(?,?,?)}");
        
		System.out.println("Enter the emp_id");
		int emp_id = sc.nextInt();
		cls.setInt(1, emp_id);
		
		cls.registerOutParameter(2, Types.VARCHAR);
		cls.registerOutParameter(3, Types.INTEGER);
		
		cls.executeQuery();
		
		String emp_name = cls.getString(2);
		int AnnualSalary = cls.getInt(3);
		
		if(emp_name !=null) {
			System.out.println(emp_name+ " "+ "has" +" " + AnnualSalary+" "+"annual package");
			
		}else {
			System.out.println("Employee number does not exist"+ emp_id);
		}
	}

}
