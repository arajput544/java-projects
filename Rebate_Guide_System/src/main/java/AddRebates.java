

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddRebates")
public class AddRebates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddRebates() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String rebate_name = request.getParameter("rebate");
		int rebate_amnt = Integer.parseInt(request.getParameter("amount"));
			
			
			Connection c = null;
			try {
				String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu117";
	            String username = "cs3220stu117";
	            String password = "v4q42hKUx7Xv";		
				c = DriverManager.getConnection(url, username, password);
				
				// Prepared Statements: prevent SQL injection attack
				String sql = "insert into rebatesfinal (rebate_name, rebate_amnt, rebate_details) values  (?, ?, 'Not Received');";
				PreparedStatement stmtaddrebate =c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmtaddrebate.setString(1, rebate_name);
				stmtaddrebate.setInt(2, rebate_amnt);
				stmtaddrebate.executeUpdate();
				
				
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
