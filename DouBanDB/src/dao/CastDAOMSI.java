package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Cast;


public class CastDAOMSI extends DAOBase implements CastDAO {

	
	private static final String insertCast_SQL = "INSERT INTO cast(movieid,actorid,role) VALUES(?,?,?)";
	/**
	 * ����cast
	 * @param cast ����Ҫ�����cast
	 * @return ���뵽���ݿ�ļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	@Override
	public int insertCast(Cast cast) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(insertCast_SQL);
		ps.setInt(1, cast.getMovieid());
		ps.setInt(2, cast.getActorid());
		ps.setString(3, cast.getRole());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	
	private static final String updateCast_SQL = "UPDATE cast SET movieid =?,actorid =?,role =? WHERE castid =?";
	/**
	 * ����cast
	 * @param cast ����Ҫ���µ�cast
	 * @return �����ݿ���µļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	@Override
	public int updateCast(Cast cast) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(updateCast_SQL);
		ps.setInt(1, cast.getMovieid());
		ps.setInt(2, cast.getActorid());
		ps.setString(3, cast.getRole());
		ps.setInt(4, cast.getCastid());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	
	private static final String deleteCast_SQL = "DELETE FROM cast WHERE castid =?";
	/**
	 * ɾ��cast
	 * @param castid 
	 * @return ɾ���ļ�¼��--���ɾ����һ����¼�ͷ���1������û�гɹ�ɾ���򷵻�0
	 */
	@Override
	public int deleteCast(int castid) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(deleteCast_SQL);
		ps.setInt(1, castid);
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	
	private static final String getCastByMovieId_SQL = "SELECT * FROM cast WHERE movieid =?";
	/**
	 * ����movieid�Ĳ�ѯ
	 * @param movieid ͨ��movieid��ѯ���ݿ�
	 * @return cast��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
	 */
	@Override
	public List<Cast> getCastByMovieId(int movieid) throws SQLException {
		List<Cast> all = new ArrayList<Cast>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getCastByMovieId_SQL);
		ps.setInt(1, movieid);
		rs = ps.executeQuery();
		while(rs.next()) {
			Cast cast = new Cast();
			cast.setCastid(rs.getInt("castid"));
			cast.setActorid(rs.getInt("actorid"));
			cast.setMovieid(rs.getInt("movieid"));
			cast.setRole(rs.getString("role"));
			all.add(cast);
		}
		rs.close();
		ps.close();
		conn.close();
		return all;
	}

	
	private static final String getCastByActorId_SQL = "SELECT * FROM cast WHERE actorid =?";
	/**
	 * ����actorid�Ĳ�ѯ
	 * @param actorid ͨ��actorid��ѯ���ݿ�
	 * @return cast��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
	 */
	@Override
	public List<Cast> getCastByActorId(int actorid) throws SQLException {
		List<Cast> all = new ArrayList<Cast>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getCastByActorId_SQL);
		ps.setInt(1, actorid);
		rs = ps.executeQuery();
		while(rs.next()) {
			Cast cast = new Cast();
			cast.setCastid(rs.getInt("castid"));
			cast.setActorid(rs.getInt("actorid"));
			cast.setMovieid(rs.getInt("movieid"));
			cast.setRole(rs.getString("role"));
			all.add(cast);
		}
		rs.close();
		ps.close();
		conn.close();
		return all;
	}

}
