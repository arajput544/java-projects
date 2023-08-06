package servlet;
import service.DbService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.service.DbService;

@WebServlet("/CreateReview")
public class CreateReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateReview() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		DbService dbService = new DbService();
		request.setAttribute("gamesReview", dbService.getGameReviews(Integer.parseInt(id)));
		request.setAttribute("game", dbService.getGameName(Integer.parseInt(id)));
		request.setAttribute("gameID", (Integer.parseInt(id)));
		dbService.close();
		request.getRequestDispatcher("/WEB-INF/CreateReview.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int gameId = Integer.parseInt(request.getParameter("id"));
		String gameName = request.getParameter("game");
		String userName = request.getParameter("name");
		String review = request.getParameter("review");
		int rating = Integer.parseInt(request.getParameter("rating"));

		DbService dbService = new DbService();
		request.setAttribute("gamesReview", dbService.addReview(gameName, userName, review, rating, gameId));
		dbService.close();
		request.getRequestDispatcher("/WEB-INF/CreateReview.jsp").forward(request, response);
	}

}
