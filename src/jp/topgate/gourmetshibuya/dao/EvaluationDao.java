package jp.topgate.gourmetshibuya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EvaluationDao {
	private final String JDBC_URL = "jdbc:mysql://127.0.0.1:13306/main?serverTimezone=UTC";

	private final String DB_USER = "root";
	private final String DB_PASS = "kaoru2106";

	public double getEvaluation(String restaurantID) {
		double sum = 0;
		int i = 0;
		Connection con = null;
		int id = Integer.parseInt(restaurantID);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			String sql = "SELECT evaluation FROM main.reviews_categories where restauran_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,id);
			ResultSet rs = st.executeQuery();
			System.out.print("concted!");
			while(rs.next()) {
				sum += rs.getInt("evaluation");
				i++;
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sum / (double)i;
	}
}
