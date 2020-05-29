package jp.topgate.gourmetshibuya.beans;

public class CourseBean {
	private int course_id;
	private int restaurant_id;
	private String course_name;
	private int price;
	private String howmeny;
	private double course_time;
	private String img;
	private String explanation;
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getHowmeny() {
		return howmeny;
	}
	public void setHowmeny(String howmeny) {
		this.howmeny = howmeny;
	}
	public double getCourse_time() {
		return course_time;
	}
	public void setCourse_time(double course_time) {
		this.course_time = course_time;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

}