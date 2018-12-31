package dao;

import java.sql.SQLException;
import java.util.List;

import bean.MovieReview;

public interface MovieReviewDAO {
	public int insertMoviereview(MovieReview moviereview) throws SQLException;
	public int updateMoviereview(MovieReview moviereview) throws SQLException;
	public int deleteMoviereview(int moviereviewid) throws SQLException;
	public MovieReview getMoviereviewById(int moviereviewid) throws SQLException;
	public List<MovieReview> getMoviereviewByTopicId(int topicid) throws SQLException;
	public List<MovieReview> getMoviereviewByUserId(int userid) throws SQLException;
}
