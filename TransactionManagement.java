package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionManagement {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMtableexamples", "root", "root");

			con.setAutoCommit(false);

			pstmt = con.prepareStatement("insert into table.employee values (?, ?)");

			pstmt.setInt(1, 211);
			pstmt.setString(2, "emp201");

			System.out.println(pstmt.executeUpdate());

			pstmt = con.prepareStatement("insert into table.file_table values (?, ?)");

			pstmt.setInt(1, 202);
			pstmt.setString(2, "emp202");

			System.out.println(pstmt.executeUpdate());

			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}}}



