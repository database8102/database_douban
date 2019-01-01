package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MovieReviewComment;

public class MovieReviewCommentDAOMSI extends DAOBase implements MovieReviewCommentDAO {

	
	private static final String insertMoviereviewcomment_SQL = "INSERT INTO moviereviewcomment(moviereviewid,userid,createtime) VALUES(?,?,?)";
	/**
	 * 插入moviereviewcomment
	 * @param moviereviewcomment 传入要插入的moviereviewcomment
	 * @return 插入到数据库的记录数--如果插入了一条记录就返回1，若是没有成功插入则返回0
	 */
	@Override
	public int insertMoviereviewcomment(MovieReviewComment moviereviewcomment) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(insertMoviereviewcomment_SQL);
		ps.setInt(1, moviereviewcomment.getMoviereviewid());
		ps.setInt(2, moviereviewcomment.getUserid());
		ps.setString(3, moviereviewcomment.getCreatetime());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	
	private static final String updateMoviereviewcomment_SQL = "UPDATE moviereviewcomment SET moviereviewid =?,userid =?,createtime =? WHERE moviereviewcommentid =?";
	/**
	 * 更新moviereviewcomment
	 * @param moviereviewcomment 传入要更新的moviereviewcomment
	 * @return 从数据库更新的记录数--如果更新了一条记录就返回1，若是没有成功更新则返回0
	 */
	@Override
	public int updateMoviereviewcomment(MovieReviewComment moviereviewcomment) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(updateMoviereviewcomment_SQL);
		ps.setInt(1, moviereviewcomment.getMoviereviewid());
		ps.setInt(2, moviereviewcomment.getUserid());
		ps.setString(3, moviereviewcomment.getCreatetime());
		ps.setInt(4, moviereviewcomment.getMoviereviewcommentid());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	
	private static final String deleteMoviereviewcomment_SQL = "DELETE FROM moviereviewcomment WHERE moviereviewcommentid =?";
	/**
	 * 删除moviereviewcomment
	 * @param moviereviewcommentid 
	 * @return 删除的记录数--如果删除了一条记录就返回1，若是没有成功删除则返回0
	 */
	@Override
	public int deleteMoviereviewcomment(int moviereviewcommentid) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(deleteMoviereviewcomment_SQL);
		ps.setInt(1, moviereviewcommentid);
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	
	private static final String getMoviereviewcommentById_SQL = "SELECT * FROM moviereviewcomment WHERE moviereviewcommentid =?";
	/**
	 * 根据moviereviewcommentid的唯一查询
	 * @param moviereviewcommentid 通过moviereviewcommentid查询数据库
	 * @return moviereviewcomment的一个实例化对象,如果查找到了就返回的是数据库中的一条记录，否则就是null
	 */
	@Override
	public MovieReviewComment getMoviereviewcommentById(int moviereviewcommentid) throws SQLException {
		MovieReviewComment moviereviewcomment = new MovieReviewComment();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getMoviereviewcommentById_SQL);
		ps.setInt(1, moviereviewcommentid);
		rs = ps.executeQuery();
		while(rs.next()) {
			moviereviewcomment.setMoviereviewcommentid(rs.getInt("moviereviewcommentid"));
			moviereviewcomment.setMoviereviewid(rs.getInt("moviereviewid"));
			moviereviewcomment.setUserid(rs.getInt("userid"));
			moviereviewcomment.setCreatetime(rs.getString("createtime"));
		}
		rs.close();
		ps.close();
		conn.close();
		return moviereviewcomment;
	}

	
	private static final String getMoviereviewcommentByMovieReviewidId_SQL = "SELECT * FROM moviereviewcomment WHERE moviereviewid =?";
	/**
	 * 根据moviereviewid的查询
	 * @param moviereviewid 通过moviereviewid查询数据库
	 * @return moviereviewcomment的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
	 */
	@Override
	public List<MovieReviewComment> getMoviereviewcommentByMovieReviewidId(int moviereviewid) throws SQLException {
		List<MovieReviewComment> all = new ArrayList<MovieReviewComment>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getMoviereviewcommentByMovieReviewidId_SQL);
		ps.setInt(1, moviereviewid);
		rs = ps.executeQuery();
		while(rs.next()) {
			MovieReviewComment moviereviewcomment = new MovieReviewComment();
			moviereviewcomment.setMoviereviewcommentid(rs.getInt("moviereviewcommentid"));
			moviereviewcomment.setMoviereviewid(rs.getInt("moviereviewid"));
			moviereviewcomment.setUserid(rs.getInt("userid"));
			moviereviewcomment.setCreatetime(rs.getString("createtime"));
			all.add(moviereviewcomment);
		}
		rs.close();
		ps.close();
		conn.close();
		return all;
	}

	
	private static final String getMoviereviewcommentByUserId_SQL = "SELECT * FROM moviereviewcomment WHERE userid =?";
	/**
	 * 根据userid的查询
	 * @param userid 通过userid查询数据库
	 * @return moviereviewcomment的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
	 */
	@Override
	public List<MovieReviewComment> getMoviereviewcommentByUserId(int userid) throws SQLException {
		List<MovieReviewComment> all = new ArrayList<MovieReviewComment>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getMoviereviewcommentByUserId_SQL);
		ps.setInt(1, userid);
		rs = ps.executeQuery();
		while(rs.next()) {
			MovieReviewComment moviereviewcomment = new MovieReviewComment();
			moviereviewcomment.setMoviereviewcommentid(rs.getInt("moviereviewcommentid"));
			moviereviewcomment.setMoviereviewid(rs.getInt("moviereviewid"));
			moviereviewcomment.setUserid(rs.getInt("userid"));
			moviereviewcomment.setCreatetime(rs.getString("createtime"));
			all.add(moviereviewcomment);
		}
		rs.close();
		ps.close();
		conn.close();
		return all;
	}

}
