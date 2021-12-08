
import java.sql.*;
import java.util.*;

import sqlCon.*;
public class EmpDetails{
	
	public EmpDetails() {
		try {
		   Connection con = SqlInject.SqlConnection();
		   Statement st=con.createStatement();
		   PreparedStatement statement =null;
		   Scanner scan=new Scanner(System.in);
		   System.out.println(" Enter Employee Name: ");
		   String Name1=scan.next();
		   String q1="select * from users where name=?";
		   statement = con.prepareStatement(q1);
		   statement.setString(1,Name1);
		   ResultSet rs1=statement.executeQuery();
			  if(rs1.next()) {
			  System.out.println(" \n ID: "+rs1.getInt("id")
			  +" \n Name: "+rs1.getString("Name")
			  +" \n Email: "+rs1.getString("Email")
			  +" \n Access Level (0/1): "+rs1.getInt("is_admin")+
			  "\n");
			   }
			  con.close();
			  scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
		
