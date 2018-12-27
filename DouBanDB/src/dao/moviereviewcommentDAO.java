package dao;

import java.sql.SQLException;
import java.util.List;

import member.moviereviewcomment;

public interface moviereviewcommentDAO {
	public int insertMoviereviewcomment(moviereviewcomment moviereviewcomment) throws SQLException;
	public int updateMoviereviewcomment(moviereviewcomment moviereviewcomment) throws SQLException;
	public int deleteMoviereviewcomment(int moviereviewcommentid) throws SQLException;
	public moviereviewcomment getMoviereviewcommentById(int moviereviewcommentid) throws SQLException;
	public List<moviereviewcomment> getMoviereviewcommentByMovieReviewidId(int moviereviewid) throws SQLException;
	public List<moviereviewcomment> getMoviereviewcommentByUserId(int userid) throws SQLException;
}
