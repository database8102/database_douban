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
	 * ����moviereviewcomment
	 * @param moviereviewcomment ����Ҫ�����moviereviewcomment
	 * @return ���뵽���ݿ�ļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
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
	 * ����moviereviewcomment
	 * @param moviereviewcomment ����Ҫ���µ�moviereviewcomment
	 * @return �����ݿ���µļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
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
	 * ɾ��moviereviewcomment
	 * @param moviereviewcommentid 
	 * @return ɾ���ļ�¼��--���ɾ����һ����¼�ͷ���1������û�гɹ�ɾ���򷵻�0
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
	 * ����moviereviewcommentid��Ψһ��ѯ
	 * @param moviereviewcommentid ͨ��moviereviewcommentid��ѯ���ݿ�
	 * @return moviereviewcomment��һ��ʵ��������,������ҵ��˾ͷ��ص������ݿ��е�һ����¼���������null
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
	 * ����moviereviewid�Ĳ�ѯ
	 * @param moviereviewid ͨ��moviereviewid��ѯ���ݿ�
	 * @return moviereviewcomment��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
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
	 * ����userid�Ĳ�ѯ
	 * @param userid ͨ��userid��ѯ���ݿ�
	 * @return moviereviewcomment��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
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
