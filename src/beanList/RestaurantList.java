package beanList;

import java.util.ArrayList;
import java.util.List;

import jp.topgate.gourmetshibuya.beans.RestaurantBean;

public class RestaurantList {
	private List<RestaurantBean> resutaurantList;

	public RestaurantList() {
		// TODO 自動生成されたコンストラクター・スタブ
		resutaurantList = new ArrayList<RestaurantBean>();
	}

	public List<RestaurantBean> getResutaurantList() {
		return resutaurantList;
	}

	public void addResutaurantList(RestaurantBean rb) {
		resutaurantList.add(rb);
	}

	public void setResutaurantList(List<RestaurantBean> resutaurantList) {
		this.resutaurantList = resutaurantList;
	}


}
