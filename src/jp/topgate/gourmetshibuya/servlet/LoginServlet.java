package jp.topgate.gourmetshibuya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.topgate.gourmetshibuya.beans.UserBean;
import jp.topgate.gourmetshibuya.dao.LoginDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("./Login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("email_address");
		String password = request.getParameter("password");

		UserBean user = new UserBean(id, password, null, null);
		String nextUrl = null;
		// ログイン処理
		UserBean isLogin = execute(user);

		// ログイン成功時の処理
		if (isLogin != null) {

			HttpSession session = request.getSession();
			session.setAttribute("loginUser", id);
			session.setAttribute("User", isLogin);
			nextUrl = "IndexServlet";
		}else {
			nextUrl = "/Login.jsp";
		}

		// トップページにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextUrl);
		dispatcher.forward(request, response);
	}

	UserBean execute(UserBean user) {
			var loginDao = new LoginDao();
			UserBean user2 = loginDao.findUser(user.getId());

			if (user2 != null && user2.getPassword().equals(user.getPassword())) {
				return user2;
			}
			return null;
		}



}
