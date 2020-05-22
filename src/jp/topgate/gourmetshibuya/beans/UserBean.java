package jp.topgate.gourmetshibuya.beans;

<<<<<<< HEAD:src/jp/topgate/gourmetshibuya/beens/UserBeen.java
public class UserBeen {

	private String id;
	private String password;
	public UserBeen(String id, String password) {
		this.id = id;
		this.password = password;
	};



=======
public class UserBean {
	
	private String id;
	private String password;
	public UserBean(String id, String password){};
	
>>>>>>> 2bbef7f... Restaurant.jsp servlet add:src/jp/topgate/gourmetshibuya/beans/UserBean.java
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}


