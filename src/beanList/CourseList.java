package beanList;

import java.util.ArrayList;
import java.util.List;

import jp.topgate.gourmetshibuya.beans.CourseBean;

public class CourseList {
	private List<CourseBean> courseBeanList;

	public CourseList() {
		// TODO 自動生成されたコンストラクター・スタブ
		courseBeanList = new ArrayList<CourseBean>();
	}

	public List<CourseBean> getCourseBeanList() {
		return courseBeanList;
	}

	public void setCourseBeanList(List<CourseBean> courseBeanList) {
		this.courseBeanList = courseBeanList;
	}
	public void addCourseBeanList(CourseBean cb) {
		courseBeanList.add(cb);
	}
}
