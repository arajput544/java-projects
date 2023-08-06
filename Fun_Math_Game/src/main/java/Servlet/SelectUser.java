package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AddEntry;


@WebServlet("/SelectUser")
public class SelectUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectUser() {
        super();
       
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		AddEntry entry= new AddEntry("John");
		List<AddEntry> entries = new ArrayList<AddEntry>();
		entries.add(entry);
		getServletContext().setAttribute("entries", entries);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<AddEntry> entries=(List<AddEntry>) getServletContext().getAttribute("entries");
		
		request.getRequestDispatcher("/WEB-INF/SelectUser.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<AddEntry> entries= (List<AddEntry>) getServletContext().getAttribute("entries");
//		String name = (String) getServletContext().getAttribute("name");
		String name= request.getParameter("name");
		
		
		
		AddEntry entry= new AddEntry(name);
//		List<AddEntry> entries= (List<AddEntry>) getServletContext().getAttribute("entries");
		entries.add(entry);
		doGet(request,response);
		response.sendRedirect("SelectUser");
	}

}
