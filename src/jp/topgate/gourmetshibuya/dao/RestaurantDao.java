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
		String servername = "13306";
		String databasename = "main";
		String user = "root";
		String password = "0000";
		String url = "jdbc:mysql://" + servername + "/" + databasename +"?serverTimezone=JST";

		try (Connection con = DriverManager.getConnection(url, user, password)){
			System.out.println("Connected....");
			try (Statement st = con.createStatement()){
				String sql = "SELECT * FROM main.restaurans_categories";
				try (ResultSet rs = st.executeQuery(sql)) {
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
				}
			}
		}catch (SQLException e) {
			System.out.println("SQL");
		}
		return rb;
	}
}
