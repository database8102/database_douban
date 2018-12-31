package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.movietype;

public class MovieTypeDAOMSI extends DAOBase implements MovieTypeDAO {

	/**
	 * ����movietype
	 * @param movietype ����Ҫ�����movietype
	 * @return ���뵽���ݿ�ļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	private static final String insertMovietype_SQL = "INSERT INTO movietype(movieid,typeid) VALUES(?,?)";
	@Override
	public int insertMovietype(MovieType movietype) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(insertMovietype_SQL);
		ps.setInt(1, movietype.getMovieid());
		ps.setInt(2, movietype.getTypeid());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * ����movietype
	 * @param movietype ����Ҫ���µ�movietype
	 * @return �����ݿ���µļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	private static final String updateMovietype_SQL = "UPDATE movietype SET typeid =? WHERE movieid =?";
	@Override
	public int updateMovietype(MovieType movietype) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(updateMovietype_SQL);
		ps.setInt(1, movietype.getTypeid());
		ps.setInt(2, movietype.getMovieid());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * ɾ��movietype 
	 * @return ɾ���ļ�¼��--���ɾ����һ����¼�ͷ���1������û�гɹ�ɾ���򷵻�0
	 */
	private static final String deleteMovietype_SQL = "DELETE FROM movietype WHERE movieid =? AND typeid =?";
	@Override
	public int deleteMovietype(int movieid, int typeid) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(deleteMovietype_SQL);
		ps.setInt(1, movieid);
		ps.setInt(2, typeid);
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * ����movieid�Ĳ�ѯ
	 * @param movieid ͨ��movieid��ѯ���ݿ�
	 * @return movietype��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
	 */
	private static final String getMovietypeByMovieId_SQL = "SELECT * FROM movietype WHERE movieid =?";
	@Override
	public List<MovieType> getMovietypeByMovieId(int movieid) throws SQLException {
		List<MovieType> all = new ArrayList<MovieType>();
		TovieType movietype = new MovieType();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getMovietypeByMovieId_SQL);
		ps.setInt(1, movieid);
		rs = ps.executeQuery();
		while(rs.next()) {
			movietype.setMovieid(rs.getInt("movieid"));
			movietype.setTypeid(rs.getInt("typeid"));
			all.add(movietype);
		}
		rs.close();
		ps.close();
		conn.close();
		return all;
	}

	/**
	 * ����typeid�Ĳ�ѯ
	 * @param typeid ͨ��typeid��ѯ���ݿ�
	 * @return movietype��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
	 */
	private static final String getMovietypeByActorId_SQL = "SELECT * FROM movietype WHERE typeid =?";
	@Override
	public List<Movietype> getMovietypeByActorId(int typeid) throws SQLException {
		List<MovieType> all = new ArrayList<MovieType>();
		MovieType movietype = new MovieType();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getMovietypeByActorId_SQL);
		ps.setInt(1, typeid);
		rs = ps.executeQuery();
		while(rs.next()) {
			movietype.setMovieid(rs.getInt("movieid"));
			movietype.setTypeid(rs.getInt("typeid"));
			all.add(movietype);
		}
		rs.close();
		ps.close();
		conn.close();
		return all;
	}

}
