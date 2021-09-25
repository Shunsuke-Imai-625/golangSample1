package answer.presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import answer.presentation.constant.AnswerURLConstants;
import answer.presentation.constant.SessionKyeConstants;

/**
 * ログイン処理を行うサーブレット
 * 
 * @author shun
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// パラメータを取得
		String number = request.getParameter("number");

		// セッションを作成
		// セッションスコープにチーム番号を保存
		HttpSession session = request.getSession();
		session.setAttribute(SessionKyeConstants.TEAM_NUMBER, number);

		// 解答画面に遷移
		request.getRequestDispatcher(AnswerURLConstants.ANSWER_JSP).forward(request, response);

	}

}
