package dao;

import java.sql.SQLException;
import java.util.List;

import member.movie;

public interface movieDAO {
	public int insertMovie(movie movie) throws SQLException;
	public int updateMovie(movie movie) throws SQLException;
	public int deleteMovie(int movieid) throws SQLException;
	public movie getMovieById(int movieid) throws SQLException;
	public List<movie> getAllMovie() throws SQLException;
}
