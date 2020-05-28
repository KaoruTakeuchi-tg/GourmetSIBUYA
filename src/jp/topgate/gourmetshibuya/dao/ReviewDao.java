package jp.topgate.gourmetshibuya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beanList.ReviewList;
import jp.topgate.gourmetshibuya.beans.ReviewBean;

public class ReviewDao {
	private final String JDBC_URL = "jdbc:mysql://127.0.0.1:13306/main?serverTimezone=UTC";

	private final String DB_USER = "root";
	private final String DB_PASS = "kaoru2106";

	public ReviewList getReview(String restauranID) {
		ReviewList rl = new ReviewList();
		Connection con = null;
		int id = Integer.parseInt(restauranID);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			String sql = "SELECT * FROM main.reviews_categories Inner JOIN main.users_categories ON main.reviews_categories.user_id = users_categories.user_id where restauran_id = ? ORDER BY create_at DESC Limit 3";


			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,id);
			ResultSet rs = st.executeQuery();
			System.out.print("concted!");
			while(rs.next()) {
				ReviewBean rb = new ReviewBean();
				rb.setUser_id(rs.getInt("user_id"));
				rb.setContent(rs.getString("content"));
				rb.setCreate_at(rs.getDate("create_at"));
				rb.setEvaluation(rs.getInt("evaluation"));
				rb.setTitle(rs.getString("title"));
				rb.setUserName(rs.getString("name"));
				rl.addReviewList(rb);
			}
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rl;
	}
}
