package jp.topgate.gourmetshibuya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.topgate.gourmetshibuya.beens.UserBeen;

public class LoginDao {
	private final String JDBC_URL = "jdbc:mysql://127.0.0.1:13306/GourmetSHIBUYADB?serverTimezone=UTC";

	private final String DB_USER = "root";
	private final String DB_PASS = "pass";

	public boolean findUser(String email_address, String password) {
		Connection conn = null;
		UserBeen user = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			//conn = DriverManager.getConnection(url,"root","JW!mgc99wrd");

			// SELECTを実行
			String sql = "SELECT PASSWORD FROM USER WHERE email_address='" + email_address + "'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECT実行
			ResultSet rs = pStmt.executeQuery();

			// 結果をArrayListに格納
			while(rs.next()) {
				user = new UserBeen(email_address, password);
				if (user != null && user.getPassword().equals(password)) {
					return true;
				}
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return false;
	}



}
