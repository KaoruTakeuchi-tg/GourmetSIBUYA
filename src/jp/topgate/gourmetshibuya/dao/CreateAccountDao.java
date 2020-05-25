package jp.topgate.gourmetshibuya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.topgate.gourmetshibuya.beans.UserBean;

public class CreateAccountDao {

	private final String JDBC_URL = "jdbc:mysql://127.0.0.1:13306/main?serverTimezone=UTC";

	private final String DB_USER = "root";
	private final String DB_PASS = "kaoru2106";

	public void newUser(UserBean newUser) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			// INSERTを実行
			String sql = "INSERT INTO main.users_categories"
					+ " (email_address, pass_word, name, gender) values (?, ?, ?, ?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, newUser.getId());
			pStmt.setString(2, newUser.getPassword());
			pStmt.setString(3, newUser.getName());
			pStmt.setString(4, newUser.getGender());

			// SELECT実行
			int rs = pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}




}
