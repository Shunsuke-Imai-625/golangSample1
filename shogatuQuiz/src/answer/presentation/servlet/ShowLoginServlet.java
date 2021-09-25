package answer.presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import answer.presentation.constant.AnswerURLConstants;

/**
 * Servlet implementation class ShowLoginServlet
 */
@WebServlet("/ShowLoginServlet")
public class ShowLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ログイン画面を表示
		request.getRequestDispatcher(AnswerURLConstants.LOGIN_JSP).forward(request, response);

	}

}
