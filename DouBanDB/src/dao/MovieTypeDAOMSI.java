package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MovieType;

public class MovieTypeDAOMSI extends DAOBase implements MovieTypeDAO {

	
	private static final String insertMovietype_SQL = "INSERT INTO movietype(movieid,typeid) VALUES(?,?)";
	/**
	 * ����movietype
	 * @param movietype ����Ҫ�����movietype
	 * @return ���뵽���ݿ�ļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
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

	
	private static final String updateMovietype_SQL = "UPDATE movietype SET movieid =?,typeid =? WHERE movieid =? AND typeid =?";
	/**
	 * ����movietype
	 * @param newmovieid ����Ҫ���µ�movieid
	 * @param newtypeid ����Ҫ���µ�typeid
	 * @param oldmovieid ����ɵ�movieid������Ѱ��Ҫ�޸ĵļ�¼
	 * @param oldtypeid ����ɵ�typeid������Ѱ��Ҫ�޸ĵļ�¼
	 * @return �����ݿ���µļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	@Override
	public int updateMovietype(int newmovieid,int newtypeid,int oldmovieid,int oldtypeid) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(updateMovietype_SQL);
		ps.setInt(1, newmovieid);
		ps.setInt(2, newtypeid);
		ps.setInt(3, oldmovieid);
		ps.setInt(4, oldtypeid);
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	
	private static final String deleteMovietype_SQL = "DELETE FROM movietype WHERE movieid =? AND typeid =?";
	/**
	 * ɾ��movietype 
	 * @return ɾ���ļ�¼��--���ɾ����һ����¼�ͷ���1������û�гɹ�ɾ���򷵻�0
	 */
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

	
	private static final String getMovietypeByMovieId_SQL = "SELECT * FROM movietype WHERE movieid =?";
	/**
	 * ����movieid�Ĳ�ѯ
	 * @param movieid ͨ��movieid��ѯ���ݿ�
	 * @return movietype��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
	 */
	@Override
	public List<MovieType> getMovietypeByMovieId(int movieid) throws SQLException {
		List<MovieType> all = new ArrayList<MovieType>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getMovietypeByMovieId_SQL);
		ps.setInt(1, movieid);
		rs = ps.executeQuery();
		while(rs.next()) {
			MovieType movietype = new MovieType();
			movietype.setMovieid(rs.getInt("movieid"));
			movietype.setTypeid(rs.getInt("typeid"));
			all.add(movietype);
		}
		rs.close();
		ps.close();
		conn.close();
		return all;
	}

	
	private static final String getMovietypeByTypeId_SQL = "SELECT * FROM movietype WHERE typeid =?";
	/**
	 * ����typeid�Ĳ�ѯ
	 * @param typeid ͨ��typeid��ѯ���ݿ�
	 * @return movietype��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
	 */
	@Override
	public List<MovieType> getMovietypeByTypeId(int typeid) throws SQLException {
		List<MovieType> all = new ArrayList<MovieType>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getMovietypeByTypeId_SQL);
		ps.setInt(1, typeid);
		rs = ps.executeQuery();
		while(rs.next()) {
			MovieType movietype = new MovieType();
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
