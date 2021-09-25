package presentator.presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presentator.logic.logic.PresenttatorLogic;

/**
 * Servlet implementation class AddPointServlet
 */
@WebServlet("/AddPointServlet")
public class AddPointServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// 問題数を取得
	ServletContext servletContext = request.getServletContext();
	Integer intQuestionId =
		(Integer) servletContext.getAttribute("questionId");

	String questionId = intQuestionId.toString();
	// パラメータを取得
	String[] parameterValues = request.getParameterValues("team");

	// 正解処理
	PresenttatorLogic presenttatorLogic = new PresenttatorLogic();
	try {
	    presenttatorLogic.dealCorrectTeam(parameterValues, questionId);
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	// メインメニューに戻る
	request.getRequestDispatcher("ContinueGameServlet").forward(request,
		response);
    }

}
