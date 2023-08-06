package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@WebServlet(urlPatterns = "/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Add() {
		super();		
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		StringBuilder html = new StringBuilder();
		Random rnd = new Random();
		int a = rnd.nextInt(9) + 1;
		int b = rnd.nextInt(9) + 1;
		int answer = a + b;
//		String userinput = "";
		html.append("<!DOCTYPE html>");
		html.append("<html lang='en'>");
		html.append("<head><meta charset='UTF-8'>");
		html.append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		html.append("<title>  </title>");
		html.append("</head>");
		html.append("<body>");
		html.append("<p hidden>" + String.valueOf(answer) + " </p>");
		html.append("<form> <label for='answer'>" + String.valueOf(a) + " + " + String.valueOf(b) + " = </label> ");
		html.append("<input type='text' id='answer' name='answer'>");
		html.append("<input hidden type='text' name='a' value='"+ String.valueOf(a)+ "'>");
		html.append("<input hidden type='text' name='b' value='"+ String.valueOf(b)+ "'>");
		html.append("<button action='submit' formmethod='post' >Sumbit</button> </input> </form>");
		html.append("</body>");
		html.append("</html>");
		response.getWriter().println(html);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		System.out.println("<html><head><title>Add</title></head><body>");
		String pa = request.getParameter("a");
		String pb = request.getParameter("b");
		String answer = request.getParameter("answer");
		int a = pa == null || pa.trim().length() == 0 ? 0 : Integer.parseInt(pa);
		int b = pb == null || pb.trim().length() == 0 ? 0 : Integer.parseInt(pb);
		int ans = answer == null || answer.trim().length() == 0 ? 0 : Integer.parseInt(answer);
		int sum = a + b;
		out.println("<p>");
		out.println( a + " + " + b + " = " + sum + "<br>");
		if(sum == ans) {
			out.println("<p>Correct, You answered "+ answer + "<br></p>");
		}
		else {
			out.println("<p>Incorrect, You answered " + answer + "<br></p>");
		}		
		out.println("<a href='Add'>Try Again?</a>");
		out.println("<a href='UserRecord'>Back to Record</a>");
		out.println("</p>");
		out.println("</body></html>");
	}

}
