package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Statement;

import model.Faculty;



@WebServlet(urlPatterns = "/DisplayFaculty", loadOnStartup = 1)
public class DisplayFaculty extends HttpServlet {



    private static final long serialVersionUID = 1L;

    public DisplayFaculty()
    {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	List<Department> departments = new ArrayList<Department>();
    	Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu117";
            String username = "cs3220stu117";
            String password = "v4q42hKUx7Xv";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = ((java.sql.Statement) stmt).executeQuery( "select * from department" );

            while( rs.next() )
            	departments.add( new Department( rs.getString( "name" ) ) );
            
            rs = ((java.sql.Statement) stmt).executeQuery( "select * from faculty" );

            while( rs.next() ) {
            	Faculty faculty = new Faculty( rs.getString("faculty_name") );
            	if(rs.getBoolean("isChair")) faculty.setChair(true);
            	for( Department department : departments )
                    if( department.getName().equals( rs.getString("dept_name") ) )
                        department.getFaculty().add( faculty );
            }

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

		getServletContext().setAttribute( "departments", departments );
        request.getRequestDispatcher( "/WEB-INF/DisplayFaculty.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }
}