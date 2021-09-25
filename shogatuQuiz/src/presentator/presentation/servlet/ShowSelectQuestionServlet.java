package presentator.presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presentator.dataaccess.entity.GenreEntity;
import presentator.logic.logic.PresenttatorLogic;
import presentator.presentation.constant.PresentatorSessionKeyConstants;
import presentator.presentation.constant.PresentatorURLConstants;

/**
 * Servlet implementation class ShowSelectQuestionServlet
 */
@WebServlet("/ShowSelectQuestionServlet")
public class ShowSelectQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	HttpSession session = request.getSession();
	if (session.getAttribute(
		PresentatorSessionKeyConstants.GENRE_LIST) == null) {

	    // ジャンルの一覧を取得
	    PresenttatorLogic presenttatorLogic = new PresenttatorLogic();
	    List<GenreEntity> genreList = null;
	    try {
		genreList = presenttatorLogic.getGenreList();
	    } catch (SQLException e) {
		e.printStackTrace();
		throw new ServletException(e);
	    }

	    // ジャンル一覧をセッションにセット

	    session.setAttribute(PresentatorSessionKeyConstants.GENRE_LIST,
		    genreList);

	}

	// ページ遷移
	request.getRequestDispatcher(PresentatorURLConstants.SELECT_QUESTION)
		.forward(request, response);
    }

}
