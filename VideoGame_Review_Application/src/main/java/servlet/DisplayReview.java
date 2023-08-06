package servlet;
import service.DbService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.service.DbService;

@WebServlet("/DisplayReview")
public class DisplayReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayReview() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		DbService dbService = new DbService();
		request.setAttribute("gamesReview", dbService.getGameReviews(Integer.parseInt(id)));
		request.setAttribute("game", dbService.getGameName(Integer.parseInt(id)));
		dbService.close();
		request.getRequestDispatcher("/WEB-INF/DisplayReview.jsp").forward(request, response);
	}

}
