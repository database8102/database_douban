package dao;

import java.sql.SQLException;
import java.util.List;

import member.movie;

public interface MovieDAO {
	public int insertMovie(Movie movie) throws SQLException;
	public int updateMovie(Movie movie) throws SQLException;
	public int deleteMovie(int movieid) throws SQLException;
	public Movie getMovieById(int movieid) throws SQLException;
	public List<Movie> getAllMovie() throws SQLException;
}
