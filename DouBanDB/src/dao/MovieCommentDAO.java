package dao;

import java.sql.SQLException;
import java.util.List;

import bean.MovieComment;

public interface MovieCommentDAO {
	public int insertMoviecomment(MovieComment moviecomment) throws SQLException;
	public int updateMoviecomment(MovieComment moviecomment) throws SQLException;
	public int deleteMoviecomment(int commentid) throws SQLException;
	public List<MovieComment> getMoviecommentByUserId(int userid) throws SQLException;
	public List<MovieComment> getMoviecommentByMovieId(int movieid) throws SQLException;
}
