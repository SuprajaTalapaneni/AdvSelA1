package datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class WriteToDatabase {
	public static void main(String[] args) throws SQLException {
		   //Step 1: Create an instance for jdbc driver
		   //Driver should be imported from com.mysql.cj.jdbc
		   Driver dbDriver=new Driver();
		   //Step 2: Register to dbDriver
		   DriverManager.registerDriver(dbDriver);
		   //Step 3: Establish connection to mysql
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advselenium","root","root");
		   //Step 4:Create Statement
		   Statement statement = con.createStatement();
		   //Step 5: Modify database
		   //int result=statement.executeUpdate("insert into employee(EmpID,EmpName,Salary,phonenumber) values(104,'EFG','60000','6524543289');");
		   int result1=statement.executeUpdate("delete from employee where EmpID='104';");
		   //System.out.println(result);
		   System.out.println(result1);
		   //Step 6: Close database
		   con.close();
	}
}
