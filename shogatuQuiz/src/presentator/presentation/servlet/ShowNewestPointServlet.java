package presentator.presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presentator.logic.logic.PresenttatorLogic;
import presentator.presentation.constant.PresentatorURLConstants;
import presentator.presentation.form.PointForm;

/**
 * Servlet implementation class ShowNewestPointServlet
 */
@WebServlet("/ShowNewestPointServlet")
public class ShowNewestPointServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// 最新の得点を取得
	PresenttatorLogic presenttatorLogic = new PresenttatorLogic();
	List<PointForm> newestPoint = null;

	try {
	    newestPoint = presenttatorLogic.getNewestPoint();
	} catch (SQLException e) {
	    throw new ServletException(e);
	}

	// リクエストにセット
	request.setAttribute("newestPoint", newestPoint);

	// 画面遷移
	request.getRequestDispatcher(PresentatorURLConstants.POINT_PAGE)
		.forward(request, response);
    }

}
