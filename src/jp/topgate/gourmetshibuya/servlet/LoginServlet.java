package jp.topgate.gourmetshibuya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.topgate.gourmetshibuya.beens.UserBeen;
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

		UserBeen user = new UserBeen(id, password);
		String nextUrl = null;
		// ログイン処理
		boolean isLogin = execute(user);

		// ログイン成功時の処理
		if (isLogin) {
			// ユーザー情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", id);
			nextUrl = "/index.jsp";
		}else {
			nextUrl = "/Login.jsp";
		}

		// トップページにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextUrl);
		dispatcher.forward(request, response);
	}

	boolean execute(UserBeen user) {
			var loginDao = new LoginDao();
			user = loginDao.findUser(user.getId());

			if (user != null && user.getPassword().equals(user.getPassword())) {
				return true;
			}
			return false;
		}



}
