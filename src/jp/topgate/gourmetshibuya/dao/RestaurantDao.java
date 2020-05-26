package jp.topgate.gourmetshibuya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beanList.RestaurantList;
import jp.topgate.gourmetshibuya.beans.RestaurantBean;

public class RestaurantDao {
	private final String JDBC_URL = "jdbc:mysql://127.0.0.1:13306/main?serverTimezone=UTC";

	private final String DB_USER = "root";
	private final String DB_PASS = "kaoru2106";

	public RestaurantBean getRestaurantDetailInfo() {
		RestaurantBean rb = new RestaurantBean();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			Statement st = con.createStatement();
			String sql = "SELECT * FROM main.restaurans_categories";
			ResultSet rs = st.executeQuery(sql);
			System.out.print("concted!");
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
			}
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
					// SELECTを実行
		/*try (Connection con = DriverManager.getConnection(url, user, password)){
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
			System.out.println("SQLError");
		}*/
		return rb;
	}

	public RestaurantList getResutaurantLimit６() {
		RestaurantList rbl = new RestaurantList();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			System.out.println("Secceful");
			Statement st = con.createStatement();
			String sql = "select photo,name from main.restaurans_categories order by evaluation DESC LIMIT 6";
			ResultSet rs = st.executeQuery(sql);
			System.out.print("concted!");
			RestaurantBean rb = new RestaurantBean();
			while(rs.next()) {
				rb.setName(rs.getString("name"));
				rb.setPhoto(rs.getString("photo"));
				rbl.addResutaurantList(rb);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rbl;
	}
}
