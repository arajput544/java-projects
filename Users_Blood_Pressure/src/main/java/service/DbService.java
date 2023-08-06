package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MODEL.Shoplist;
import model.VaccinationEntry;
import model.bpvalues;
import model.users;

import java.sql.Statement;
import java.sql.PreparedStatement;

public class DbService {
		

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu117";
	        String username = "cs3220stu117";
	        String password = "v4q42hKUx7Xv";

		    private Connection connection;

		    public DbService()
		    {
		        try
		        {
		            connection = DriverManager.getConnection( url, username, password );
		        }
		        catch( SQLException e )
		        {
		            e.printStackTrace();
		        }
		    }

		    public void close()
		    {
		        if( connection != null )
		        {
		            try
		            {
		                connection.close();
		            }
		            catch( SQLException e )
		            {
		                e.printStackTrace();
		            }
		        }
		    }
		    
		    public List<bpvalues> getbpvalues(){
		    	
		    	List<bpvalues> entries = new ArrayList<bpvalues>();

		        try
		        {
		            Statement stmt = connection.createStatement();
		            ResultSet rs = stmt.executeQuery( "select * from bp" );
		            while( rs.next() )
		            	entries.add( new bpvalues( rs.getInt( "systolic" ), rs.getInt( "diastolic" ), rs.getString( "timeframe" ) ) );
		            stmt.close();
		        }
		        catch( SQLException e )
		        {
		            e.printStackTrace();
		        }

		        return entries;
		    	
		    	
		    }
             public List<users> getusers(){
		    	
            	 List<users> users = new ArrayList<users>();

		        try
		        {
		            Statement stmt = connection.createStatement();
		            ResultSet r = stmt.executeQuery( "select * from users" );
		            while( r.next() )
		            	users.add( new users( r.getInt( "id" ),r.getString( "name" ) ) );
		            stmt.close();
		        }
		        catch( SQLException e )
		        {
		            e.printStackTrace();
		        }
		        

		        return users;
		    	
		    	
		    }
             public void addUser( String name)
     	    {
     	        int id = 0;
     	        try
     	        {
     	            String sql = "insert into users (name) value (?)";
     	            PreparedStatement pstmt = connection.prepareStatement( sql,
     	                Statement.RETURN_GENERATED_KEYS );
     	            pstmt.setString( 1, name);
     	            
     	            pstmt.executeUpdate();
     	            ResultSet rs = pstmt.getGeneratedKeys();
     	            if( rs.next() ) id = rs.getInt( 1 );
     	            pstmt.close();
     	        }
     	        catch( SQLException e )
     	        {
     	            e.printStackTrace();
     	        }
     	    }
             
            
}
