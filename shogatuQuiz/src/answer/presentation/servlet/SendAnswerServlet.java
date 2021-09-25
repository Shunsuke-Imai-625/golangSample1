package answer.presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import answer.logic.bean.AnswerBean;
import answer.logic.logic.AnswerLogic;
import answer.presentation.constant.AnswerURLConstants;
import answer.presentation.constant.SessionKyeConstants;

/**
 * 解答を送信するサーブレット
 */
@WebServlet("/SendAnswerServlet")
public class SendAnswerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// 解答を取得
	String answer = request.getParameter("answer");
	// チーム番号を取得
	HttpSession session = request.getSession();
	String teamNumber =
		(String) session.getAttribute(SessionKyeConstants.TEAM_NUMBER);
	if (teamNumber == null) {
	    String message = "もう一度ログインしてください";
	    request.setAttribute("err", message);
	    request.getRequestDispatcher(AnswerURLConstants.LOGIN_JSP)
		    .forward(request, response);
	    return;
	}
	// 問題数を取得
	ServletContext servletContext = request.getServletContext();
	Integer questionId =
		(Integer) servletContext.getAttribute("questionId");

	// 解答をデータベースに登録
	AnswerBean answerBean = new AnswerBean();
	answerBean.setAnswer(answer);
	answerBean.setTeamNumber(teamNumber);
	answerBean.setQuestionNumber(questionId.toString());

	AnswerLogic answerLogic = new AnswerLogic();
	try {
	    answerLogic.sendAnswer(answerBean);
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	// 送信したメッセージを詰める
	String message = "解答を送信しました";
	request.setAttribute("message", message);

	// 画面遷移
	request.getRequestDispatcher(AnswerURLConstants.ANSWER_JSP)
		.forward(request, response);

    }

}
