package presentator.presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presentator.presentation.constant.PresentatorURLConstants;

/**
 * Servlet implementation class ShowGyakutenQuizServlet
 */
@WebServlet("/ShowGyakutenQuizServlet")
public class ShowGyakutenQuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	// 逆転クイズの画面に遷移
	request.getRequestDispatcher(PresentatorURLConstants.GYAKUTEN_PAGE)
		.forward(request, response);

    }

}
