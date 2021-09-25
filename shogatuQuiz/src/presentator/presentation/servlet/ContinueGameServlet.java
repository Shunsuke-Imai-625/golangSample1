package presentator.presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presentator.logic.bean.AnswerPlayerBean;
import presentator.logic.logic.PresenttatorLogic;
import presentator.presentation.constant.PresentatorURLConstants;

/**
 * Servlet implementation class ContinueGameServlet
 */
@WebServlet("/ContinueGameServlet")
public class ContinueGameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void service(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// 現在の問題数と回答者を取得
	PresenttatorLogic presenttatorLogic = new PresenttatorLogic();
	AnswerPlayerBean answerPlayerBean = null;
	try {
	    answerPlayerBean = presenttatorLogic.getQNumberAndAnswerPlayer();
	} catch (SQLException e) {

	    throw new ServletException(e);
	}

	// 情報をセット
	HttpSession session = request.getSession();
	session.setAttribute("answerTeam", answerPlayerBean.getAnswerPlayer());
	session.setAttribute("nowQNumber",
		answerPlayerBean.getNowQuestionNumber());

	// メインメニュー画面に遷移
	request.getRequestDispatcher(PresentatorURLConstants.MAIN_MENU)
		.forward(request, response);
    }

}
