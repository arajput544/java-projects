package lab8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {	
	private static final long serialVersionUID = 1L;
	
	List<Question> question = new ArrayList<Question>();
    
    public DrivingTestBrowser() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init( config );
		
		try {
			String filename = getServletContext().getRealPath("/WEB-INF/DrivingTest.txt");
			System.out.println(filename);		
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename))); 
			System.out.println(in);
	        String line;
	        while( (line = in.readLine()) != null ) {
	        	if(!line.isBlank()) {
	        		question.add( new Question(line, in.readLine(), in.readLine(), in.readLine(), 
	        				Integer.parseInt( in.readLine() )));
	        		for(Question q: question) {
	    	        	System.out.println(q.description);
	    	        }	        		
	        		
	        	}
	        	for(Question q: question) {
		        	System.out.println(q.correctAnswer);
		        }
	        }
	        
	        
	        in.close();
		}catch(IOException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 0;
		if(request.getParameter("id")!=null) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		request.setAttribute("question", question);
		request.setAttribute("id", id);		
		request.getRequestDispatcher( "/WEB-INF/DrivingTest.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}