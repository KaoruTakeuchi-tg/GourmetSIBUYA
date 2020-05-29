package jp.topgate.gourmetshibuya.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.topgate.gourmetshibuya.beans.InsertReview;
import jp.topgate.gourmetshibuya.beans.UserBean;
import jp.topgate.gourmetshibuya.dao.ReviewDao;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
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
		String url = "";
		if(session.getAttribute("User") != null) {
			InsertReview ir = new InsertReview();
			//System.out.print(request.getAttribute("title"));
			ir.setTitle(request.getParameter("title").toString());
			ir.setContent(request.getParameter("content").toString());
			ir.setEvaluation(request.getParameter("evaluation").toString());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        String str = sdf.format(timestamp);
			ir.setSdf(str);
			ir.setUser((UserBean)session.getAttribute("User"));
			ir.setRestauranID(session.getAttribute("restaurantID").toString());

			ReviewDao rd = new ReviewDao();
			rd.insertReview(ir);
			url = "RestaurantServlet";
		}else {
			url = "Review.jsp";
			request.setAttribute("message", "ログインしてください");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
