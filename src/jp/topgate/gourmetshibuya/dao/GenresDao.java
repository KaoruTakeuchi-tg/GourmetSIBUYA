package jp.topgate.gourmetshibuya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenresDao {

	public String getName(int id) {
		String url = "jdbc:mysql://127.0.0.1:13306/main?serverTimezone=UTC";
		String user = "root";
		String password = "kaoru2106";
		String genre = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected....");
			Statement st = con.createStatement();
			String sql = "SELECT genre FROM main.genres_categories WHERE genres_id=?;";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, id);

			// SELECT実行
			ResultSet rs = pStmt.executeQuery();

			// 結果をArrayListに格納
			while(rs.next()) {
				genre = rs.getString("genre");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return genre;
	}
}
