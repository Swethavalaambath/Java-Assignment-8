package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Batchstatement {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMtableexamples", "root", "root");
			stmt = con.createStatement();

			stmt.addBatch("insert into table.employee values (104, 'emp4')");
			stmt.addBatch("insert into table.employee values (105, 'emp5')");
			stmt.addBatch("insert into table.employee values (106, 'emp6')");

			stmt.executeBatch();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}}}
