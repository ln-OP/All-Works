import java.sql.*;
import java.util.*;

import sqlCon.SqlInject;

public class MainCode {
	public static void main(String[] args) {
		try {
			Statement st=null;
			ResultSet rs=null;
			ResultSet rs2=null;
			Connection con = SqlInject.SqlConnection();
			
			System.out.println("Banking System: ");
			Scanner scan=new Scanner(System.in);
			System.out.println("Who is Accessing? \n 1.Manager \n 2.Employee \n");
			String options=scan.next();
			st=con.createStatement();
			PreparedStatement statement =null;
			   switch(options) {
			   
			   case "1":
				   rs=st.executeQuery("select Name,is_admin from users");
				   rs.next();
				   System.out.println("Enter the Username : ");
				   String nam=scan.next();
				      if(rs.getString("Name").equalsIgnoreCase(nam) && rs.getInt("is_admin") == 1) {
				    	  System.out.println("Verified as Manager, Proceed with any of the following options: \n 1.Customer Details \n 2.Employee Details \n 3.Tier 1 Customers \n 4.All Customer Names \n 5.Add new Customer \n 6.Full DataBase of this Bank \n 7.Exit");
				    	  String manager=scan.next();
				    	  switch(manager) {
				    	  case "1":
				    		  CusDetails cus=new CusDetails();
				    		  System.out.println(cus);
								  break;
				    	  case "2":
				    		  EmpDetails emp=new EmpDetails();
				    		  System.out.println(emp);
								  break;
				    	  case "3":
				    		  rs = st.executeQuery("select * from tierOneCus");
				    		  while(rs.next()) {
				    			  System.out.println(" \n ID: "+rs.getInt("id")
				    			  +" \n Name: "+rs.getString("Name")
				    			  +" \n Email: "+rs.getString("Email")
				    			  +" \n Job: "+rs.getString("Job")
				    			  +"\n Account Type: "+rs.getString("AccountType")
				    			  +"\n Mobile No.: " +rs.getLong("MobileNo")
				    			  +"\n Balance : " +rs.getLong("Approx_Balance"));
				    		  }
				    		   break;
				    	  case "4":
				    		  rs=st.executeQuery("select * from customer");
							  while(rs.next()) {
								  System.out.println(" \n Customer Name: "+rs.getString("name"));
								   }
								  break;
				    	  case "5":
				    		  newCus nc=new newCus();
				    		  System.out.println(nc);
								  break;
				    	  case "6" :
				    		  rs = st.executeQuery("select * from users");
				    		  while(rs.next()) {
				    			  System.out.println(" \n ID: "+rs.getInt("id")
				    			  +" \n Name: "+rs.getString("Name")
				    			  +" \n Email: "+rs.getString("Email")
				    			  +" \n Access Level (0/1): "+rs.getInt("is_admin")+
				    			  "\n");
				    		  }
				    		 break;
				    	  case "7":
				    		  System.out.println("Will be added Soon");
				    		  for(int clear = 0; clear < 1000; clear++) {
				    			    System.out.println(" ") ;
				    			}
								  
				    	  }
				      }
				      else {
				    	  System.out.println("Not a Manager., Please Log in as \"Employee\" or kindly Sign-in again");
				      }
				      break;
			   
			   case "2":
				   rs=st.executeQuery("select Name,is_admin from users where is_admin=0");
				   rs.next();
				   System.out.println("Enter the Username : ");
				   String name=scan.next();
				   if(rs.getString("Name").equalsIgnoreCase(name) && rs.getInt("is_admin") == 0) {
					   System.out.println("Welcome Employee, Proceed with any of the following options: \n 1.Customer Details \n 2.Tier 1 Customers \n 3.All Customer Names \n 4.Exit");
				    	  String employee=scan.next();
				    	  switch(employee) {
				    	  case "1":
				    		  CusDetails cus=new CusDetails();
				    		  System.out.println(cus);
								  break;
				    	  case "2":
				    		  rs = st.executeQuery("select * from tierOneCus");
				    		  while(rs.next()) {
				    			  System.out.println(" \n ID: "+rs.getInt("id")
				    			  +" \n Name: "+rs.getString("Name")
				    			  +"\n Account Type: "+rs.getString("AccountType")
				    			  +"\n Balance : " +rs.getLong("Approx_Balance"));
				    		  }
				    		   break;
				    	  case "3":
				    		  rs=st.executeQuery("select * from customer");
							  while(rs.next()) {
								  System.out.println(" \n Customer Name: "+rs.getString("name"));
								   }
								  break;
				    	  case "4":
				    		  System.out.println("Will be added Soon");
				    		  for(int clear = 0; clear < 1000; clear++) {
				    			    System.out.println(" ") ;
				    			}
							  break;  
				    	  }
				   }else {
					   System.out.println("Not an Employee., Please Log in as \"Manager\" or kindly Sign-in again");
				   }
			   }
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
