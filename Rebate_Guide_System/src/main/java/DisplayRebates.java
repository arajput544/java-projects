

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DisplayRebates")
public class DisplayRebates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public DisplayRebates() {
        super();
        
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Rebates> rebates = new ArrayList<Rebates>();
		
		// get data from DB
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu117";
            String username = "cs3220stu117";
            String password = "v4q42hKUx7Xv";
			
			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();

			ResultSet rsrebates = stmt.executeQuery("select * from rebatesfinal");

			while (rsrebates.next()) {
					  
				rebates.add(new Rebates(rsrebates.getInt("rebate_id"), rsrebates.getString("rebate_name"), rsrebates.getInt("rebate_amnt"), rsrebates.getString("rebate_details")));
						
					}

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
		
		System.out.println("rebates " + rebates);
		
		// send data to view
		request.setAttribute("rebates", rebates);
		request.getRequestDispatcher("/WEB-INF/rebateview.jsp").forward(request, response);
		
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
