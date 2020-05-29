package jp.topgate.gourmetshibuya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beanList.RestaurantList;
import jp.topgate.gourmetshibuya.beans.RestaurantBean;

public class SearchDao {


	public RestaurantList Search(String text) {
		String url = "jdbc:mysql://127.0.0.1:13306/main?serverTimezone=UTC";
		String user = "root";
		String password = "kaoru2106";
		String input = text;
		RestaurantList searchResult = new RestaurantList();
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected....");
			try (Statement st = con.createStatement()){
				String sql2 = "SELECT * FROM main.restaurans_categories WHERE CONCAT(name, place, phonenum, genres) LIKE ?;";
				PreparedStatement pStmt2 = con.prepareStatement(sql2);
				pStmt2.setString(1, "%" + input + "%");
				ResultSet rs = pStmt2.executeQuery();
				while(rs.next()) {
					RestaurantBean rb = new RestaurantBean();
					GenresDao gd = new GenresDao();
					rb.setBusiness_hours(rs.getString("business_hours"));
					rb.setContent(rs.getString("content"));
					rb.setEvaluation(rs.getInt("evaluation"));
					rb.setGenres(gd.getName(rs.getInt("genres")));
					rb.setName(rs.getString("name"));
					rb.setPhonenum(rs.getString("phonenum"));
					rb.setPhoto(rs.getString("photo"));
					rb.setPlace(rs.getString("place"));
					rb.setRegular_holiday(rs.getString("regular_holiday"));
					rb.setRestaurant_id(rs.getInt("restaurant_id"));
					rb.setUrl(rs.getString("url"));
					searchResult.addResutaurantList(rb);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return searchResult;

	}




}