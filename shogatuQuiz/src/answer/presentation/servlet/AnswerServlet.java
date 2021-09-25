package answer.presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import answer.logic.logic.AnswerLogic;
import answer.presentation.constant.AnswerURLConstants;
import answer.presentation.constant.SessionKyeConstants;

/**
 * 解答確認画面に遷移するサーブレット
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// 解答済みかチェック
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

	AnswerLogic answerLogic = new AnswerLogic();
	try {
	    if (answerLogic.isAnswered(teamNumber)) {
		request.setAttribute("errorMessage", "この問題には解答済みです");
		request.getRequestDispatcher(AnswerURLConstants.ANSWER_JSP)
			.forward(request, response);
		return;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	// パラメータを取得
	String selectedAnswer = request.getParameter("selected");
	String writedAnswer = request.getParameter("writed");

	// 両方書いてしまった場合
	if (!StringUtils.isEmpty(selectedAnswer)
		&& !StringUtils.isEmpty(writedAnswer)) {
	    request.setAttribute("errorMessage", "どちらか一方に解答して下さい");
	    request.getRequestDispatcher(AnswerURLConstants.ANSWER_JSP)
		    .forward(request, response);
	    return;
	}
	// 両方書いていない場合
	if (StringUtils.isEmpty(selectedAnswer)
		&& StringUtils.isEmpty(writedAnswer)) {
	    request.setAttribute("errorMessage", "解答を入力して下さい");
	    request.getRequestDispatcher(AnswerURLConstants.ANSWER_JSP)
		    .forward(request, response);
	    return;
	}

	// 選択式のみの場合
	if (!StringUtils.isEmpty(selectedAnswer)
		&& StringUtils.isEmpty(writedAnswer)) {
	    request.setAttribute("answer", selectedAnswer);
	}

	// 記述式のみの場合
	if (StringUtils.isEmpty(selectedAnswer)
		&& !StringUtils.isEmpty(writedAnswer)) {
	    request.setAttribute("answer", writedAnswer);
	}

	// 解答確認画面に遷移
	request.getRequestDispatcher(AnswerURLConstants.ANSWER_CONFIRM_JSP)
		.forward(request, response);

    }

}
