package jp.topgate.gourmetshibuya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.topgate.gourmetshibuya.beans.CourseBean;
import jp.topgate.gourmetshibuya.beans.ReservationsBean;
import jp.topgate.gourmetshibuya.beans.RestaurantBean;
import jp.topgate.gourmetshibuya.beans.UserBean;

public class Reservations {
	private final String JDBC_URL = "jdbc:mysql://127.0.0.1:13306/main?serverTimezone=UTC";

	private final String DB_USER = "root";
	private final String DB_PASS = "kaoru2106";

	public void insertReservations(UserBean userBean, RestaurantBean resutaBean,ReservationsBean reservationsBean,CourseBean courseBean) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			String sql = "INSERT INTO `main`.`reservations_categories` (`user_id`, `restaurant_id`, `course_id`, `date`, `howmany`) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,userBean.getUserID());
			st.setInt(2, resutaBean.getRestaurant_id());
			st.setInt(3, courseBean.getCourse_id());
			st.setString(4, reservationsBean.getTime());
			st.setInt(5, reservationsBean.getNumberOfPeople());
			System.out.println(st.executeUpdate());
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
