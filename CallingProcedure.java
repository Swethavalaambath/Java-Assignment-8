package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CallingProcedure{

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMtableexamples", "root", "root");

			CallableStatement cstmt = con.prepareCall("{call empprocedure(?,?)}");
			cstmt.setInt(1, 301);
			cstmt.setString(2, "name301");
			
			cstmt.execute();
			
			System.out.println("Success.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}}}
		
	



