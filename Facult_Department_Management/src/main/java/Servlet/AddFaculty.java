package Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Faculty;
//import Servlet.Department;



@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddFaculty()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "/WEB-INF/AddFaculty.jsp" )
            .forward( request, response );
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	String departmentName = request.getParameter( "department" );

        Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu117";
            String username = "cs3220stu117";
            String password = "v4q42hKUx7Xv";

            String sql = "insert into faculty values (?, ?, ?)";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, departmentName );
            pstmt.setString( 2, request.getParameter( "faculty" ) );
            if( request.getParameter( "chair" ) != null ) {
            	pstmt.setBoolean( 3, true);
            }
            else {
            	pstmt.setBoolean( 3, false);
            }
            
            pstmt.executeUpdate();
            c.close();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }
        
        response.sendRedirect( "DisplayFaculty" );
    }
    }

