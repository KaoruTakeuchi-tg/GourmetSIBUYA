package jp.topgate.gourmetshibuya.beens;

public class UserBeen {
	
	private String id;
	private String password;
	public UserBeen(String id, String password){};
	
	public String gerId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String gerPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}


