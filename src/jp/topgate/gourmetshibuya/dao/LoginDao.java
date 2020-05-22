package jp.topgate.gourmetshibuya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.topgate.gourmetshibuya.beans.UserBean;

public class LoginDao {
	private final String JDBC_URL = "jdbc:mysql://127.0.0.1:13306/GourmetSHIBUYADB?serverTimezone=UTC";

	private final String DB_USER = "root";
	private final String DB_PASS = "pass";

		public UserBean findUser(String emailAddress) {
			Connection conn = null;
			UserBean user = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

				// SELECTを実行
				String sql = "SELECT * FROM GourmetSHIBUYADB.user_categories WHERE email_address=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, emailAddress);

				// SELECT実行
				ResultSet rs = pStmt.executeQuery();

				// 結果をArrayListに格納
				while(rs.next()) {
					String password = rs.getString("pass_word");
					user = new UserBean(emailAddress, password, null, null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			} finally {
				// データベース切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						return null;
					}
				}
			}
			return user;
		}



}
