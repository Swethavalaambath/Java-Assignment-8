
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
import java.sql.Statement;
import java.sql.ResultSet;

public class StatementEx{
	public static void main(String[]args) {
	
		Connection conn=null;
	
		try { 
			
			Statement stmt=conn.createStatement();
			int count=stmt.executeUpdate("insert into employee values("+ args[0]+","+(select*from user)+"")");
					System.out.println(cnt);
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/CMtableexamples","root","root");
			count=stmt.executeUpdate("update employee name where id=4");
			System.out.println(count);
		ResultSet rs=stmt.executeQuery("select * from employee");
	
		while (rs.next())
		{System.out.println(rs.getInt(1)+rs.getString(2));}
		}
		catch(SQLException e) {e.printStackTrace();}
		finally {
		try
		{conn.close();
		}
		catch(SQLException e) {e.printStackTrace();}
	}}}
		
