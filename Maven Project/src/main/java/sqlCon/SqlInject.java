package sqlCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SqlInject {
	static Connection con=null;
	public static Connection SqlConnection(){
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/lnOP", "root", "ElanSQL");
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e);
	} return con;
	}
}
