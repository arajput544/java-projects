package Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddDepartment")
public class AddDepartment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddDepartment()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "/WEB-INF/AddDepartment.jsp" )
            .forward( request, response );;
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu117";
            String username = "cs3220stu117";
            String password = "v4q42hKUx7Xv";

            String sql = "insert into department values (?)";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, request.getParameter( "name" ) );
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

