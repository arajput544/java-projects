

import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ReceiveRebates")
public class ReceiveRebates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReceiveRebates() {
        super();
        
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		String date_formatted = dateFormat.format(new Date());
    	
		if (request.getParameter("id") == null)
		{
			response.sendRedirect("DisplayRebates");
		}else
		{
			int rebate_id = Integer.parseInt(request.getParameter("id"));
			
			
			Connection c = null;
			try {
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu117";
	            String username = "cs3220stu117";
	            String password = "v4q42hKUx7Xv";			
				c = DriverManager.getConnection(url, username, password);
				
				// Prepared Statements: prevent SQL injection attack
				String sql = "UPDATE rebatesfinal SET rebate_details = (?) where rebate_id = (?);";
				PreparedStatement stmtrebaterecv =c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmtrebaterecv.setString(1, date_formatted);
				stmtrebaterecv.setInt(2, rebate_id);
				stmtrebaterecv.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (c != null)
						c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			response.sendRedirect("DisplayRebates");
		}
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
