package jp.topgate.gourmetshibuya.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.topgate.gourmetshibuya.beans.RestaurantBean;
import jp.topgate.gourmetshibuya.dao.SearchDao;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String text;
		SearchDao sd = new SearchDao();
		List<RestaurantBean> searchResult = new ArrayList<RestaurantBean>();
		searchResult = sd.Search(text);
		int index_num = searchResult.size();
		RequestDispatcher rd = request.getRequestDispatcher("./Search.jsp");
		request.setAttribute("indexNum", index_num);
		for(int i = 0; i < index_num; i++) {
			request.setAttribute(String.format("name%d", i), searchResult.get(i).getName());
			request.setAttribute(String.format("place%d", i) ,searchResult.get(i).getPlace());
			request.setAttribute(String.format("phonenum%d", i), searchResult.get(i).getPhonenum());
			request.setAttribute(String.format("genres", i), searchResult.get(i).getGenres());
			request.setAttribute(String.format("photo%d", i), searchResult.get(i).getPhoto());
			request.setAttribute(String.format("evaluation%d", i), searchResult.get(i).getEvaluation());
			request.setAttribute(String.format("business_hours", i), searchResult.get(i).getBusiness_hours());
			request.setAttribute(String.format("content", i), searchResult.get(i).getContent());
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
