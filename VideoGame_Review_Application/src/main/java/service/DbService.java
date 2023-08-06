package service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.VideoGameReview;



public class DbService {

	private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu63";
	private String username = "cs3220stu63";
	private String password = "oyIPFPq725Zm";
	private Connection connection;

	public DbService() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<VideoGameReview> getGameList() {
		List<VideoGameReview> gamesList = new ArrayList<VideoGameReview>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select game_id, game_name, rating from VideoGameReview");
			while (rs.next()) {
				VideoGameReview game = new VideoGameReview();
				game.setGame_id(rs.getInt("game_id"));
				game.setGame_name(rs.getString("game_name"));
				game.setRating(rs.getString("rating"));
				gamesList.add(game);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gamesList;
	}

	public List<VideoGameReview> getGameReviews(int id) {

		List<VideoGameReview> gameReviews = new ArrayList<VideoGameReview>();
		try {
			String sql = "select * from VideoGameReview where game_id =  ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				VideoGameReview game = new VideoGameReview();
				game.setReview_id(rs.getInt("review_id"));
				game.setGame_id(rs.getInt("game_id"));
				game.setGame_name(rs.getString("game_name"));
				game.setUsername(rs.getString("username"));
				game.setReview(rs.getString("review"));
				game.setRating(rs.getString("rating"));
				gameReviews.add(game);
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameReviews;
	}

	public int addGame(String title) {
		int id = 0;
		try {
			String sql = "insert into VideoGame (title) values (?)";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, title);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next())
				id = rs.getInt(1);
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public int addReview(String gameName, String username, String review, int rating, int gameId) {
		int id = 0;
		try {
			String sql = "insert into VideoGameReview (game_id, game_name, username , review, rating) values (?, ? , ? ,? ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, gameId);
			pstmt.setString(2, gameName);
			pstmt.setString(3, username);
			pstmt.setString(4, review);
			pstmt.setInt(5, rating);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next())
				id = rs.getInt(1);
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public String getGameName(int id) {

		String gameName = new String();
		try {
			String sql = "select title from VideoGame where id =  ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				gameName = (rs.getString("title"));
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gameName;
	}

}
