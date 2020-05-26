package jp.topgate.gourmetshibuya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jp.topgate.gourmetshibuya.beans.RestaurantBean;

public class SearchDao {


	public List<RestaurantBean> Search(String text) {
		RestaurantBean rb = new RestaurantBean();
		String servername = "13306";
		String databasename = "main";
		String user = "root";
		String password = "0000";
		String url = "jdbc:mysql://" + servername + "/" + databasename +"?serverTimezone=JST";
		String input = text;
		int count;
		List<RestaurantBean> searchResult = new ArrayList<RestaurantBean>();
		try (Connection con = DriverManager.getConnection(url, user, password)){
			System.out.println("Connected....");
			try (Statement st = con.createStatement()){
				String sql1 = "SELECT COUNT(*)FROM main.restaurans_categories WHERE CONCAT(name, place, phonenum, genres) LIKE \"%%%\";";
				PreparedStatement pStmt1 = con.prepareStatement(sql1);
				pStmt1.setString(2,text);
				try (ResultSet rs1 = pStmt1.executeQuery()){
					count = rs1.getInt("COUNT(*)");
				}
				String sql2 = "SELECT * FROM main.restaurans_categories WHERE CONCAT(name, place, phonenum, genres) LIKE \"%%%\";";
				PreparedStatement pStmt2 = con.prepareStatement(sql2);
				pStmt2.setString(2, text);
				try (ResultSet rs = pStmt2.executeQuery()) {
					while(rs.next()) {
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
						searchResult.add(rb);
					}

				}
			}
		}catch (SQLException e) {
			System.out.println("SQL");
		}


		return searchResult;

	}




}