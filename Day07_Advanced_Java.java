package cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Day07_Advanced_Java {
	 static Scanner sc = new Scanner(System.in);
	public  Connection con;

	public void accessConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newDatabase", "root", "993450@Awi");
	}

	public void display(ResultSet rs) throws SQLException {
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
		}
	}

	public void insertStudent() throws SQLException {

		System.out.println("Enter the name of Student");
		String name = sc.next();

		System.out.println("Enter the Age of Student");
		int age = sc.nextInt();

		System.out.println("Enter the marks of Student");
		int marks = sc.nextInt();

		String sql = "insert into Student (s_name,age,marks) VALUES(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setInt(3, marks);

		ps.executeUpdate();
		System.out.println("Record Inserted");

	}

	public void viewAllStudent() throws SQLException {
		String sql = "select * from Student";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		display(rs);

	}

	public void getById() throws SQLException {
		String viewById = "select * from Student where id = ?";
		PreparedStatement ps = con.prepareStatement(viewById);
		System.out.println("Enter id to display: ");
		int id = sc.nextInt();
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		display(rs);
	}

	public void deleteById() throws SQLException {
		String deletingById = "delete from Student where id = ?";
		PreparedStatement ps = con.prepareStatement(deletingById);
		System.out.println("Enter the id you want to delete: ");
		int id = sc.nextInt();

		ps.setInt(1, id);
		ps.executeUpdate();

		System.out.println("deleted successfully!");
	}

	public void updateStudent() throws SQLException {
		String sql = "update Student set s_name = ?,age=?,marks =? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("Enter the Id of Student to Update");
		int id = sc.nextInt();

		System.out.println("Enter the new Name: ");
		String name = sc.next();

		System.out.println("Enter the new Age: ");
		int age = sc.nextInt();

		System.out.println("Enter the new Marks: ");
		int marks = sc.nextInt();

		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setInt(3, marks);
		ps.setInt(4, id);

		ps.executeUpdate();
		System.out.println("data has been updated successfully!");

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// load Driver
		Day07_Advanced_Java aj = new Day07_Advanced_Java();

		aj.accessConnection();

		System.out.println("Connected to the database");

		int choice;
		do {
			System.out.println("\n==== Student Management System ====");
			System.out.println("1.View Student data");
			System.out.println("2.View by Id");
			System.out.println("3.Insert Student");
			System.out.println("4.Update Student");
			System.out.println("5.Delete Student");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			System.out.println();
			switch (choice) {
			case 1:
				aj.viewAllStudent();
				break;
			case 2:
				aj.getById();
				break;
			case 3:
				aj.insertStudent();
				break;
			case 4:
				aj.updateStudent();
				break;
			case 5:
				aj.deleteById();
				break;
			default:
				System.out.println("Invalid input");
			}

		} while (choice != 6);
	}
}
