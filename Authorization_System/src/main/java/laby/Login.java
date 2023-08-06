package laby;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public Login() {
		super();
		   System.out.println("hello2");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		

		doPost(request, response);
		
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String uname= request.getParameter("userid");
		   System.out.println("hello1"+uname);
		String pass=request.getParameter("passwrd");
		
		HttpSession session = request.getSession();
		
		if(uname.equals("cysun") && pass.equals("abcd"))
		{
	       session.setAttribute("username", uname);
	       System.out.println("hello"+uname);	

	       response.sendRedirect("Welcome");		

		}
		
		else
		{
			response.sendRedirect("Login.html");
		}
		
	}


}
