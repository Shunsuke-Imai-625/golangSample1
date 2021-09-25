package presentator.presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presentator.logic.logic.PresenttatorLogic;
import presentator.presentation.constant.PresentatorURLConstants;
import presentator.presentation.form.AnswerForm;

/**
 * Servlet implementation class UpdateNewestAnswerServlet
 */
@WebServlet("/UpdateNewestAnswerServlet")
public class UpdateNewestAnswerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// 現在の問題のIDを取得
	ServletContext servletContext = request.getServletContext();
	Integer intQuestionId =
		(Integer) servletContext.getAttribute("questionId");

	// 最新の答えのリストを取得
	PresenttatorLogic presenttatorLogic = new PresenttatorLogic();
	List<AnswerForm> newestAnswer = null;
	try {
	    newestAnswer = presenttatorLogic.getNewestAnswer(intQuestionId);
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	// リスエストにセット
	request.setAttribute("newestAnswer", newestAnswer);

	// 画面遷移
	request.getRequestDispatcher(
		PresentatorURLConstants.SELECT_CORRECT_TEAM)
		.forward(request, response);
    }

}
