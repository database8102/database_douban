package dao;

import java.sql.SQLException;
import java.util.List;

import member.moviecomment;

public interface moviecommentDAO {
	public int insertMoviecomment(moviecomment moviecomment) throws SQLException;
	public int updateMoviecomment(moviecomment moviecomment) throws SQLException;
	public int deleteMoviecomment(int commentid) throws SQLException;
	public List<moviecomment> getMoviecommentByUserId(int userid) throws SQLException;
	public List<moviecomment> getMoviecommentByMovieId(int movieid) throws SQLException;
}
