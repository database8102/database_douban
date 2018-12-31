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
	 * ����moviereview
	 * @param moviereview ����Ҫ�����moviereview
	 * @return ���뵽���ݿ�ļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
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
	 * ����moviereview
	 * @param moviereview ����Ҫ���µ�moviereview
	 * @return �����ݿ���µļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
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
	 * ɾ��moviereview
	 * @param moviereviewid 
	 * @return ɾ���ļ�¼��--���ɾ����һ����¼�ͷ���1������û�гɹ�ɾ���򷵻�0
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
	 * ����moviereviewid��Ψһ��ѯ
	 * @param moviereviewid ͨ��moviereviewid��ѯ���ݿ�
	 * @return moviereview��һ��ʵ��������,������ҵ��˾ͷ��ص������ݿ��е�һ����¼���������null
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
	 * ����topicid�Ĳ�ѯ
	 * @param topicid ͨ��topicid��ѯ���ݿ�
	 * @return moviereview��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
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
	 * ����userid�Ĳ�ѯ
	 * @param userid ͨ��userid��ѯ���ݿ�
	 * @return moviereview��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
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
