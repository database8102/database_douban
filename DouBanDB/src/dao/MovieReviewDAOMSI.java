package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.moviereview;

public class MovieReviewDAOMSI extends DAOBase implements MovieReviewDAO {

	/**
	 * 插入moviereview
	 * @param moviereview 传入要插入的moviereview
	 * @return 插入到数据库的记录数--如果插入了一条记录就返回1，若是没有成功插入则返回0
	 */
	private static final String insertMoviereview_SQL = "INSERT INTO moviereview(topicid,userid,createtime,reviewcontent,likecount,unlikecount) VALUES(?,?,?,?,?,?)";
	@Override
	public int insertMoviereview(MovieReview moviereview) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(insertMoviereview_SQL);
		ps.setInt(1, moviereview.getTopicid());
		ps.setInt(2, moviereview.getUserid());
		ps.setString(3, moviereview.getCreatetime());
		ps.setString(4, moviereview.getReviewcontent());
		ps.setInt(5, moviereview.getLikecount());
		ps.setInt(6, moviereview.getUnlikecount());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * 更新moviereview
	 * @param moviereview 传入要更新的moviereview
	 * @return 从数据库更新的记录数--如果更新了一条记录就返回1，若是没有成功更新则返回0
	 */
	private static final String updateMoviereview_SQL = "UPDATE moviereview SET topicid =?,userid =?,createtime =?,reviewcontent =?,likecount =?,unlikecount =? WHERE moviereviewid =?";
	@Override
	public int updateMoviereview(MovieReview moviereview) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(updateMoviereview_SQL);
		ps.setInt(1, moviereview.getTopicid());
		ps.setInt(2, moviereview.getUserid());
		ps.setString(3, moviereview.getCreatetime());
		ps.setString(4, moviereview.getReviewcontent());
		ps.setInt(5, moviereview.getLikecount());
		ps.setInt(6, moviereview.getUnlikecount());
		ps.setInt(7, moviereview.getMoviereviewid());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * 删除moviereview
	 * @param moviereviewid 
	 * @return 删除的记录数--如果删除了一条记录就返回1，若是没有成功删除则返回0
	 */
	private static final String deleteMoviereview_SQL = "DELETE FROM moviereview WHERE moviereviewid =?";
	@Override
	public int deleteMoviereview(int moviereviewid) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(deleteMoviereview_SQL);
		ps.setInt(1, moviereviewid);
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * 根据moviereviewid的唯一查询
	 * @param moviereviewid 通过moviereviewid查询数据库
	 * @return moviereview的一个实例化对象,如果查找到了就返回的是数据库中的一条记录，否则就是null
	 */
	private static final String getMoviereviewById_SQL = "SELECT * FROM moviereview WHERE moviereviewid =?";
	@Override
	public MovieReview getMoviereviewById(int moviereviewid) throws SQLException {
		MovieReview moviereview = new MovieReview();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getMoviereviewById_SQL);
		ps.setInt(1, moviereviewid);
		rs = ps.executeQuery();
		while(rs.next()) {
			moviereview.setMoviereviewid(rs.getInt("moviereviewid"));
			moviereview.setTopicid(rs.getInt("topicid"));
			moviereview.setUserid(rs.getInt("userid"));
			moviereview.setCreatetime(rs.getString("createtime"));
			moviereview.setReviewcontent(rs.getString("reviewcontent"));
			moviereview.setLikecount(rs.getInt("likecount"));
			moviereview.setUnlikecount(rs.getInt("unlikecount"));
		}
		rs.close();
		ps.close();
		conn.close();
		return moviereview;
	}

	/**
	 * 根据topicid的查询
	 * @param topicid 通过topicid查询数据库
	 * @return moviereview的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
	 */
	private static final String getMoviereviewByTopicId_SQL = "SELECT * FROM moviereview WHERE topicid =?";
	@Override
	public List<MovieReview> getMoviereviewByTopicId(int topicid) throws SQLException {
		List<MovieReview> all = new ArrayList<MovieReview>();
		MovieReview moviereview = new MovieReview();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getMoviereviewByTopicId_SQL);
		ps.setInt(1, topicid);
		rs = ps.executeQuery();
		while(rs.next()) {
			moviereview.setMoviereviewid(rs.getInt("moviereviewid"));
			moviereview.setTopicid(rs.getInt("topicid"));
			moviereview.setUserid(rs.getInt("userid"));
			moviereview.setCreatetime(rs.getString("createtime"));
			moviereview.setReviewcontent(rs.getString("reviewcontent"));
			moviereview.setLikecount(rs.getInt("likecount"));
			moviereview.setUnlikecount(rs.getInt("unlikecount"));
			all.add(moviereview);
		}
		rs.close();
		ps.close();
		conn.close();
		return all;
	}

	/**
	 * 根据userid的查询
	 * @param userid 通过userid查询数据库
	 * @return moviereview的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
	 */
	private static final String getMoviereviewByUserId_SQL = "SELECT * FROM moviereview WHERE userid =?";
	@Override
	public List<MovieReview> getMoviereviewByUserId(int userid) throws SQLException {
		List<MovieReview> all = new ArrayList<MovieReview>();
		MovieReview moviereview = new MovieReview();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getMoviereviewByUserId_SQL);
		ps.setInt(1, userid);
		rs = ps.executeQuery();
		while(rs.next()) {
			moviereview.setMoviereviewid(rs.getInt("moviereviewid"));
			moviereview.setTopicid(rs.getInt("topicid"));
			moviereview.setUserid(rs.getInt("userid"));
			moviereview.setCreatetime(rs.getString("createtime"));
			moviereview.setReviewcontent(rs.getString("reviewcontent"));
			moviereview.setLikecount(rs.getInt("likecount"));
			moviereview.setUnlikecount(rs.getInt("unlikecount"));
			all.add(moviereview);
		}
		rs.close();
		ps.close();
		conn.close();
		return all;
	}

}
