package sqlTest;

import static org.junit.Assert.*;

import org.junit.Test;
import java.sql.*;
import java.util.*;

import sqlCon.SqlInject;

public class testingCode {

	@Test
	public final void test() {
		try {
	    System.out.println("Test 1:  \n");
		Connection con = SqlInject.SqlConnection();
		Statement st=con.createStatement();
		PreparedStatement statement =null;
		Scanner scan=new Scanner(System.in);
		
		   System.out.println("Enter Customer Name for Testing ");
		   String Name1=scan.next();
		   String q1="select * from customer where name=?";
		   statement = con.prepareStatement(q1);
		   statement.setString(1,Name1);
		   ResultSet rs1=statement.executeQuery();
		   rs1.next();
		   System.out.println("\n \n");
		   int actualResult= rs1.getInt("accno");
		   assertEquals(10000,actualResult,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	@Test
	public final void test1() {
		try {
		System.out.println("Test 2:  \n");
		Connection con = SqlInject.SqlConnection();
		Statement st=con.createStatement();
		PreparedStatement statement =null;
		Scanner scan=new Scanner(System.in);
		   System.out.println("Enter Customer Name: ");
		   String Name1=scan.next();
		   String q1="select * from customer where name=?";
		   statement = con.prepareStatement(q1);
		   statement.setString(1,Name1);
		   ResultSet rs1=statement.executeQuery();
		   rs1.next();
		   System.out.println("\n \n");
		   int actualResult= rs1.getInt("accno");
		   assertEquals(30000,actualResult,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	@Test
	public final void test2() {
		try {
		System.out.println("Test 3:  \n");
		Connection con = SqlInject.SqlConnection();
		Statement st=con.createStatement();
		PreparedStatement statement =null;
		Scanner scan=new Scanner(System.in);
		   System.out.println("Enter Customer Name: ");
		   String Name1=scan.next();
		   String q1="select * from customer where name=?";
		   statement = con.prepareStatement(q1);
		   statement.setString(1,Name1);
		   ResultSet rs1=statement.executeQuery();
		   rs1.next();
		   System.out.println("\n \n");
		   int actualResult= rs1.getInt("mobile");
		   assertEquals(567890,actualResult,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	@Test
	public final void test3() {
		try {
		System.out.println("Test 4:  \n");
		Connection con = SqlInject.SqlConnection();
		Statement st=con.createStatement();
		PreparedStatement statement =null;
		Scanner scan=new Scanner(System.in);
		   System.out.println("Enter Customer Name: ");
		   String Name1=scan.next();
		   String q1="select * from customer where name=?";
		   statement = con.prepareStatement(q1);
		   statement.setString(1,Name1);
		   ResultSet rs1=statement.executeQuery();
		   rs1.next();
		   System.out.println("\n");
		   String actualResult= rs1.getString("acctype");
		   assertEquals("current",actualResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
