package jp.topgate.gourmetshibuya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jp.topgate.gourmetshibuya.beans.RestaurantBean;

public class RestaurantDao {

	public RestaurantBean getRestaurantDetailInfo() {
		RestaurantBean rb = new RestaurantBean();
		try {
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:13306/main?serverTimezone=JST";
			String user = "root";
			String pass = "kaoru2106";
			try {
				con = DriverManager.getConnection(url, user, pass);
				Statement stm = con.createStatement();
				String sql = "SELECT * FROM main.restaurans_categories";
				ResultSet rs = stm.executeQuery(sql);
				rb.setBusiness_hours(rs.getString("business_hours"));
				rb.setContent(rs.getString("content"));
				rb.setEvaluation(rs.getInt("evaluation"));
				rb.setGenres(rs.getString("genres"));
				rb.setName(rs.getString("name"));
				rb.setPhonenum(rs.getString("phonenum"));
				rb.setPhoto(rs.getString("photo"));
				rb.setPlace(rs.getString("place"));
				rb.setRegular_holiday(rs.getString("regular_holiday"));
				rb.setRestaurant_id(rs.getInt("restaurant_id"));
				rb.setUrl(rs.getString("url"));
			}catch (SQLException e) {
				System.out.println("SQL");
			}
		}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		return rb;
	}
}
