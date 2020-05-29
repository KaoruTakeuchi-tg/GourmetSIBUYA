package jp.topgate.gourmetshibuya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanList.CourseList;
import beanList.ReviewList;
import jp.topgate.gourmetshibuya.beans.RestaurantBean;
import jp.topgate.gourmetshibuya.dao.EvaluationDao;
import jp.topgate.gourmetshibuya.dao.RestaurantDao;
import jp.topgate.gourmetshibuya.dao.ReviewDao;
import jp.topgate.gourmetshibuya.dao.courseDao;

/**
 * Servlet implementation class RestaurantServlet
 */
@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String id = null;
		if(request.getParameter("restaurant_id") == null) {
			id = session.getAttribute("restaurantID").toString();
		}else {
			id = request.getParameter("restaurant_id");
			session.setAttribute("restaurantID", id);
		}
		RestaurantBean rb = new RestaurantBean();
		RestaurantDao rdao = new RestaurantDao();
		ReviewDao reviewdao = new ReviewDao();
		ReviewList rl = new ReviewList();
		courseDao cd = new courseDao();
		CourseList cl = new CourseList();
		EvaluationDao ed = new EvaluationDao();

		rl = reviewdao.getReview(id);//レビュー取得
		rb = rdao.getRestaurantDetailInfo(id);//レストラン詳細情報
		cl = cd.getCourse(id);//コース情報
		double evalution = ed.getEvaluation(id);//レビューから評価を取得

		session.setAttribute("restaurantBean", rb);
		request.setAttribute("evalution", evalution);
		request.setAttribute("course", cl);
		request.setAttribute("rb", rb);
		request.setAttribute("review", rl);
		RequestDispatcher rd = request.getRequestDispatcher("/Restaurant.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
