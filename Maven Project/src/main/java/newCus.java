
import java.sql.*;
import java.util.*;

import sqlCon.*;
public class newCus{
	
	public newCus() {
		try {
		   Connection con = SqlInject.SqlConnection();
		   Statement st=con.createStatement();
		   PreparedStatement statement =null;
		   Scanner scan=new Scanner(System.in);
		   System.out.println("Enter Customer Details to Insert:");
		   int AccNo=scan.nextInt();
		   String Name=scan.next();
		   int Mobile=scan.nextInt();
		   String AccountType=scan.next();
		   int Balance=scan.nextInt();
		   String sql = "INSERT INTO customer (accno,name,mobile,acctype,balance) VALUES (?, ?, ?, ?, ?)";
		   statement = con.prepareStatement(sql);
		   statement.setInt(1, AccNo);
		   statement.setString(2, Name);
		   statement.setInt(3, Mobile);
		   statement.setString(4, AccountType);
		   statement.setInt(5, Balance);
		   int rowsInserted = statement.executeUpdate();
		   if (rowsInserted > 0) {
		       System.out.println("Customer inserted Successfuly \n");
		   }
			  con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
		
