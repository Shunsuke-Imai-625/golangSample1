package presentator.presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presentator.logic.logic.PresenttatorLogic;

/**
 * Servlet implementation class DealGyakutenServlet
 */
@WebServlet("/DealGyakutenServlet")
public class DealGyakutenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// 問題数を一増やす
	PresenttatorLogic presenttatorLogic = new PresenttatorLogic();
	try {
	    presenttatorLogic.plusQuizNumber();
	} catch (SQLException e) {
	    e.printStackTrace();
	    throw new ServletException(e);

	}

	// 結果パラメータを受け取る
	String result = request.getParameter("result");
	// 勝利していたら処理をする
	if (result.equals("0")) {

	    // 各種パラメータを取得
	    String point = request.getParameter("point");
	    String winer = request.getParameter("winer");
	    String loser = request.getParameter("loser");

	    try {
		presenttatorLogic.dealGyakutenQuiz(point, winer, loser);
	    } catch (SQLException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
		throw new ServletException(e);
	    }

	}

	// メインメニューに戻る
	request.getRequestDispatcher("ContinueGameServlet").forward(request,
		response);
    }

}
