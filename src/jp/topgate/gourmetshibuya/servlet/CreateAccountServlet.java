package jp.topgate.gourmetshibuya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.topgate.gourmetshibuya.beans.UserBean;
import jp.topgate.gourmetshibuya.dao.CreateAccountDao;
import jp.topgate.gourmetshibuya.dao.LoginDao;


/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("./CreateAccount.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("email_address");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String Message = null;
		String returnUrl = null;

		UserBean user = new UserBean(id, password, name, gender);

		//reateAccountDao createAccountDao = new CreateAccountDao();
		LoginDao loginDao = new LoginDao();
		UserBean user2 = loginDao.findUser(user.getId());
		//int isSuccess = createAccountDao.newUser(user);
		if(user2 == null) {
			CreateAccountDao createAccountDao = new CreateAccountDao();
			createAccountDao.newUser(user);
			returnUrl = "index.jsp";
		}else {
			Message = "すでにこのメールアドレスは登録されています";
			returnUrl = "/CreateAccount.jsp";
		}
		request.setAttribute("Message", Message);

		RequestDispatcher dispatcher = request.getRequestDispatcher(returnUrl);
		dispatcher.forward(request, response);

	}

}
