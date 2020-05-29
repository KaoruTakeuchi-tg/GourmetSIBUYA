package jp.topgate.gourmetshibuya.beans;

public class InsertReview {
	private String title;
	private String content;
	private String evaluation;
	private String sdf;
	private UserBean user;
	private String restauranID;

	public String getRestauranID() {
		return restauranID;
	}
	public void setRestauranID(String restauranID) {
		this.restauranID = restauranID;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public String getSdf() {
		return sdf;
	}
	public void setSdf(String sdf) {
		this.sdf = sdf;
	}
}
