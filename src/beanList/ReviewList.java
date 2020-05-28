package beanList;

import java.util.ArrayList;
import java.util.List;

import jp.topgate.gourmetshibuya.beans.ReviewBean;

public class ReviewList {
	private List<ReviewBean> reviewList;

	public ReviewList() {
		// TODO 自動生成されたコンストラクター・スタブ
		reviewList = new ArrayList<ReviewBean>();
	}

	public List<ReviewBean> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<ReviewBean> reviewList) {
		this.reviewList = reviewList;
	}

	public void addReviewList(ReviewBean rb) {
		reviewList.add(rb);
	}

}
