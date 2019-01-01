package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MovieComment;

public class MovieCommentDAOMSI extends DAOBase implements MovieCommentDAO {

	
	private static final String insertMoviecomment_SQL = "INSERT INTO moviecomment(userid,movieid,score,commentcontent,likecount,date,device,type) VALUES(?,?,?,?,?,?,?,?)";
	@Override
	public int insertMoviecomment(MovieComment moviecomment) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(insertMoviecomment_SQL);
		ps.setInt(1, moviecomment.getUserid());
		ps.setInt(2, moviecomment.getMovieid());
		ps.setDouble(3, moviecomment.getScore());
		ps.setString(4, moviecomment.getCommentcontent());
		ps.setInt(5, moviecomment.getLikecount());
		ps.setString(6, moviecomment.getDate());
		ps.setString(7, moviecomment.getDevice());
		ps.setString(8, moviecomment.getType());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * ����moviecomment
	 * @param moviecomment ����Ҫ���µ�moviecomment
	 * @return �����ݿ���µļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	private static final String updateMoviecomment_SQL = "UPDATE moviecomment SET userid =?,movieid =?,score =?,commentcontent =?,likecount =?,date =?,device =?,type =? WHERE commentid =?";
	/**
	 * ����moviecomment
	 * @param moviecomment ����Ҫ�����moviecomment
	 * @return ���뵽���ݿ�ļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	@Override
	public int updateMoviecomment(MovieComment moviecomment) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(updateMoviecomment_SQL);
		ps.setInt(1, moviecomment.getUserid());
		ps.setInt(2, moviecomment.getMovieid());
		ps.setDouble(3, moviecomment.getScore());
		ps.setString(4, moviecomment.getCommentcontent());
		ps.setInt(5, moviecomment.getLikecount());
		ps.setString(6, moviecomment.getDate());
		ps.setString(7, moviecomment.getDevice());
		ps.setString(8, moviecomment.getType());
		ps.setInt(9, moviecomment.getCommentid());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	
	private static final String deleteMoviecomment_SQL = "DELETE FROM moviecomment WHERE commentid =?";
	/**
	 * ɾ��moviecomment
	 * @param commentid 
	 * @return ɾ���ļ�¼��--���ɾ����һ����¼�ͷ���1������û�гɹ�ɾ���򷵻�0
	 */
	@Override
	public int deleteMoviecomment(int commentid) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(deleteMoviecomment_SQL);
		ps.setInt(1, commentid);
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	
	private static final String getMoviecommentByUserId_SQL = "SELECT * FROM moviecomment WHERE userid =?";
	/**
	 * ��ѯ����moviecomment
	 * @param userid ����userid��ѯ����moviecomment
	 * @return moviecomment��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
	 */
	@Override
	public List<MovieComment> getMoviecommentByUserId(int userid) throws SQLException {
		List<MovieComment> moviecommentList=new ArrayList<MovieComment>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getMoviecommentByUserId_SQL);
		ps.setInt(1, userid);
		rs = ps.executeQuery();
		while(rs.next()) {
			MovieComment moviecomment = new MovieComment();
			moviecomment.setUserid(rs.getInt("userid"));
			moviecomment.setCommentid(rs.getInt("commentid"));
			moviecomment.setMovieid(rs.getInt("movieid"));
			moviecomment.setScore(rs.getDouble("score"));
			moviecomment.setCommentcontent(rs.getString("commentcontent"));
			moviecomment.setLikecount(rs.getInt("likecount"));
			moviecomment.setDate(rs.getString("date"));
			moviecomment.setDevice(rs.getString("device"));
			moviecomment.setType(rs.getString("type"));
			moviecommentList.add(moviecomment);
		}
		rs.close();
		ps.close();
		conn.close();
		return moviecommentList;
	}

	
	private static final String getMoviecommentByMovieId_SQL = "SELECT * FROM moviecomment WHERE movieid =?";
	/**
	 * ��ѯ����moviecomment
	 * @param movieid ����movieid��ѯ����moviecomment
	 * @return moviecomment��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
	 */
	@Override
	public List<MovieComment> getMoviecommentByMovieId(int movieid) throws SQLException {
		List<MovieComment> moviecommentList=new ArrayList<MovieComment>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getMoviecommentByMovieId_SQL);
		ps.setInt(1, movieid);
		rs = ps.executeQuery();
		while(rs.next()) {
			MovieComment moviecomment = new MovieComment();
			moviecomment.setUserid(rs.getInt("userid"));
			moviecomment.setCommentid(rs.getInt("commentid"));
			moviecomment.setMovieid(rs.getInt("movieid"));
			moviecomment.setScore(rs.getDouble("score"));
			moviecomment.setCommentcontent(rs.getString("commentcontent"));
			moviecomment.setLikecount(rs.getInt("likecount"));
			moviecomment.setDate(rs.getString("date"));
			moviecomment.setDevice(rs.getString("device"));
			moviecomment.setType(rs.getString("type"));
			moviecommentList.add(moviecomment);
		}
		rs.close();
		ps.close();
		conn.close();
		return moviecommentList;
	}

}
