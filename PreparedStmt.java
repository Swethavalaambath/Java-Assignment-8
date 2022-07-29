

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStmt {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMtableexamples", "root", "root");

			pstmt = con.prepareStatement("insert into CMtableexamples.employee values (?, ?)");

			pstmt.setInt(1, 103);
			pstmt.setString(2, "emp3");

			System.out.println(pstmt.executeUpdate());

			pstmt = con.prepareStatement("select * from employee where id =103");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

}



