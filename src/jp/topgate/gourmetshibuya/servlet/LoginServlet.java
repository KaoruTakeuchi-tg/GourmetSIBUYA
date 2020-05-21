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
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		//ログイン処理
		LoginDao logindao = new LoginDao();

		boolean isLogin = logindao.findUser(id, password);

		//ログイン成功時の処理
		if (isLogin) {
			UserBeen userbeen = new UserBeen(id, password);
			//ユーザ情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", id);
		}

		//トップページにフォワード
		//RequestDispatchar dispatcher = request.getRequestDispatcher("");
		//dispatcher.forward(request, response);
	}

}
