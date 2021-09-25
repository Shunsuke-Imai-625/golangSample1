package presentator.presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presentator.dataaccess.entity.QuizEntity;
import presentator.logic.logic.PresenttatorLogic;
import presentator.presentation.constant.PresentatorURLConstants;

/**
 * Servlet implementation class SelectQuestionServlet
 */
@WebServlet("/SelectQuestionServlet")
public class SelectQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// 問題情報を取得
	String genre = request.getParameter("genre");
	String point = request.getParameter("point");

	PresenttatorLogic presenttatorLogic = new PresenttatorLogic();
	QuizEntity questionDetail = null;

	try {
	    questionDetail = presenttatorLogic.getQuestionDetail(genre, point);
	} catch (SQLException e) {
	    e.printStackTrace();
	    throw new ServletException(e);
	}

	// とれなかったらエラー
	if (questionDetail == null) {
	    String err = "そんな問題はありません";
	    request.setAttribute("errorMessage", err);
	    request.getRequestDispatcher(
		    PresentatorURLConstants.SELECT_QUESTION)
		    .forward(request, response);

	}

	// 残り問題がなければエラー
	if (questionDetail.getRemainQuestionNumber() == 0) {
	    String err = "残りの問題がありません";
	    request.setAttribute("errorMessage", err);
	    request.getRequestDispatcher(
		    PresentatorURLConstants.SELECT_QUESTION)
		    .forward(request, response);

	}

	// 問題番号をアプリケーションスコープにセット
	ServletContext context = getServletContext();
	context.setAttribute("questionId", questionDetail.getQuestionId());

	// 問題を開く
	// // PDFファイルパス
	// String filePath = "C:\\Users\\yu\\book1.pdf";
	// Desktop desktop = Desktop.getDesktop();
	// // 関連付けられたアプリケーションを起動してファイルを開きます。
	// desktop.open(new File(filePath));

	String path = createPath(genre, point);

	try {
	    Runtime rt = Runtime.getRuntime();
	    String cmd = path;
	    rt.exec(cmd);
	} catch (IOException e) {
	    // 例外処理
	}

	// 問題詳細をリクエストに保存
	request.setAttribute("questionDetail", questionDetail);

	// 正解者選択画面に遷移
	request.getRequestDispatcher(
		PresentatorURLConstants.SELECT_CORRECT_TEAM)
		.forward(request, response);
    }

    /**
     * 問題のパスを生成するメソッド
     *
     * @param genreId
     * @param pointId
     * @return 問題のパス
     */
    private String createPath(String genreId, String pointId) {
	String path = "explorer C:\\Users\\yu\\shun\\shogatu\\";
	if (genreId.equals("1")) {
	    path = path + "kokugo\\";
	}
	if (genreId.equals("2")) {
	    path = path + "sugaku\\";
	}
	if (genreId.equals("3")) {
	    path = path + "rika\\";
	}
	if (genreId.equals("4")) {
	    path = path + "shakai\\";
	}
	if (genreId.equals("5")) {
	    path = path + "eigo\\";
	}
	if (genreId.equals("6")) {
	    path = path + "geino\\";
	}
	if (genreId.equals("7")) {
	    path = path + "eiga\\";
	}
	if (genreId.equals("8")) {
	    path = path + "manga\\";
	}
	if (genreId.equals("9")) {
	    path = path + "game\\";
	}
	if (genreId.equals("10")) {
	    path = path + "ore\\";
	}
	if (genreId.equals("11")) {
	    path = path + "sonota\\";
	}

	if (pointId.equals("1")) {
	    path = path + "10";
	}
	if (pointId.equals("2")) {
	    path = path + "20";
	}
	if (pointId.equals("3")) {
	    path = path + "30";
	}
	if (pointId.equals("4")) {
	    path = path + "100";
	}

	return path;

    }

}
