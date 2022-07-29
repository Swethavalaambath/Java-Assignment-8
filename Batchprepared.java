package jdbc;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class Batchprepared {

		public static void main(String[] args) {
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMtableexamples", "root", "root");

				PreparedStatement pstmt = con.prepareCall("insert into table.employee values (?, ?)");

				pstmt.setInt(1, 110);
				pstmt.setString(2, "emp7");
				pstmt.addBatch();

				pstmt.setInt(1, 111);
				pstmt.setString(2, "emp8");
				pstmt.addBatch();

				pstmt.setInt(1, 112);
				pstmt.setString(2, "emp9");
				pstmt.addBatch();
				
				pstmt.executeBatch();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();}
			}}}
				