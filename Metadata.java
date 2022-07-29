package jdbc;
	import java.sql.Connection;
	import java.sql.DatabaseMetaData;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;

	public class Metadata{

		public static void main(String[] args) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMtableexamples", "root", "root");
				
				DatabaseMetaData dbData = con.getMetaData();
				System.out.println(dbData.getDatabaseProductName());
				System.out.println(dbData.getDatabaseMajorVersion());
				System.out.println(dbData.getDriverName());
				System.out.println(dbData.getSchemas());
				

				pstmt = con.prepareStatement("select * from employee where id =103");
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					ResultSetMetaData rsData = rs.getMetaData();
					System.out.println(rsData.getColumnCount());
					System.out.println(rsData.getColumnName(1) + " " + rsData.getColumnTypeName(1));
					System.out.println(rsData.getColumnName(2) + " " + rsData.getColumnTypeName(2));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();}
				}}}
			
		

