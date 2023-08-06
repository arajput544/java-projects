package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.service.DbService;


@WebServlet("/ListGames")
public class ListGames extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListGames() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbService dbService = new DbService(); 
        request.setAttribute( "gamesList", dbService.getGameList());
        dbService.close();
        
        request.getRequestDispatcher( "/WEB-INF/ListGames.jsp" )
        .forward( request, response );
	}

}
