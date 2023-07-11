package Calculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Myconnection 
{
public static void main(String [] args) 
  {
	try 
	{
	Class.forName("com.mysql.jdbc.Driver");

	Connection 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			System.out.println("Successfully");
	} 
	catch (ClassNotFoundException e) 
	{
		System.out.println("Driver class not found");
	} 
	catch (SQLException e) 
	{
	System.out.println("Database Coonectin not found"); 
	}
  }
}

