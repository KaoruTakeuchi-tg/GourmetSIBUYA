package jp.topgate.gourmetshibuya.beans;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ReservationsBean {
	private String time;
	private int numberOfPeople;
	private String reserve;

	public ReservationsBean() {
		// TODO 自動生成されたコンストラクター・スタブ
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        reserve = sdf.format(timestamp);
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

}
