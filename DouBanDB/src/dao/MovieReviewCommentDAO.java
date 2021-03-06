package dao;

import java.sql.SQLException;
import java.util.List;

import bean.MovieReviewComment;

public interface MovieReviewCommentDAO {
	public int insertMoviereviewcomment(MovieReviewComment moviereviewcomment) throws SQLException;
	public int updateMoviereviewcomment(MovieReviewComment moviereviewcomment) throws SQLException;
	public int deleteMoviereviewcomment(int moviereviewcommentid) throws SQLException;
	public MovieReviewComment getMoviereviewcommentById(int moviereviewcommentid) throws SQLException;
	public List<MovieReviewComment> getMoviereviewcommentByMovieReviewidId(int moviereviewid) throws SQLException;
	public List<MovieReviewComment> getMoviereviewcommentByUserId(int userid) throws SQLException;
}
