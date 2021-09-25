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
 * Servlet implementation class GameStartServlet
 */
@WebServlet("/GameStartServlet")
public class GameStartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// startlogicを呼び出してゲーム開始準備を行う
	AnswerPlayerBean answerPlayerBean = null;
	PresenttatorLogic presenttatorLogic = new PresenttatorLogic();
	try {
	    answerPlayerBean = presenttatorLogic.startGame();
	} catch (SQLException e) {
	    e.printStackTrace();
	    throw new ServletException(e);

	}

	// 問題数と回答者をリクエストスコープにセット
	HttpSession session = request.getSession();
	session.setAttribute("answerTeam", answerPlayerBean.getAnswerPlayer());
	session.setAttribute("nowQNumber",
		answerPlayerBean.getNowQuestionNumber());

	// メインメニュー画面に遷移
	request.getRequestDispatcher(PresentatorURLConstants.MAIN_MENU)
		.forward(request, response);

    }

}
