import java.sql.*;
import java.util.*;

import sqlCon.*;
public class CusDetails{
	
	public CusDetails() {
		try {
		   Connection con = SqlInject.SqlConnection();
		   Statement st=con.createStatement();
		   PreparedStatement statement =null;
		   Scanner scan=new Scanner(System.in);
		   System.out.println(" Enter Customer Name: ");
		   String Name1=scan.next();
		   String q1="select * from customer where name=?";
		   statement = con.prepareStatement(q1);
		   statement.setString(1,Name1);
		   ResultSet rs1=statement.executeQuery();
			  if(rs1.next()) {
			  System.out.println(" \n Account No.: "+rs1.getInt("accno")
			  +" \n Name: "+rs1.getString("name")
			  +" \n Mobile: "+rs1.getString("mobile")
			  +" \n Account Type: "+rs1.getString("acctype")
			  + " \n Balance: "+rs1.getInt("balance")+"\n");
			   }
			  con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
		
