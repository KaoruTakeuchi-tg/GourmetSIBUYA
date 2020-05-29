package jp.topgate.gourmetshibuya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beanList.CourseList;
import jp.topgate.gourmetshibuya.beans.CourseBean;

public class courseDao {
	private final String JDBC_URL = "jdbc:mysql://127.0.0.1:13306/main?serverTimezone=UTC";

	private final String DB_USER = "root";
	private final String DB_PASS = "kaoru2106";

	public CourseList getCourse(String restaurantID) {

		CourseList cl = new CourseList();
		Connection con = null;
		int id = Integer.parseInt(restaurantID);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			String sql = "SELECT * FROM main.courses_categories where restaurant_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,id);
			ResultSet rs = st.executeQuery();
			System.out.print("concted!");
			while(rs.next()) {
				CourseBean cb = new CourseBean();
				cb.setCourse_id(rs.getInt("course_id"));
				cb.setCourse_name(rs.getString("course_id"));
				cb.setCourse_time(rs.getDouble("course_itime"));
				cb.setExplanation(rs.getString("explanation"));
				cb.setHowmeny(rs.getString("howmany"));
				cb.setImg(rs.getString("img"));
				cb.setPrice(rs.getInt("price"));
				cb.setRestaurant_id(rs.getInt("restaurant_id"));
				cl.addCourseBeanList(cb);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cl;
	}
}
