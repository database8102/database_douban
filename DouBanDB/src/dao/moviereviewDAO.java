package dao;

import java.sql.SQLException;
import java.util.List;

import member.moviereview;

public interface moviereviewDAO {
	public int insertMoviereview(moviereview moviereview) throws SQLException;
	public int updateMoviereview(moviereview moviereview) throws SQLException;
	public int deleteMoviereview(int moviereviewid) throws SQLException;
	public moviereview getMoviereviewById(int moviereviewid) throws SQLException;
	public List<moviereview> getMoviereviewByTopicId(int topicid) throws SQLException;
	public List<moviereview> getMoviereviewByUserId(int userid) throws SQLException;
}
