package jp.topgate.gourmetshibuya.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.topgate.gourmetshibuya.beens.UserBeen;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//ログイン処理
		//LoginDao loguindao = new LoginDao();
		//boolean isLogin = logindao.execute(id, password);
		
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
