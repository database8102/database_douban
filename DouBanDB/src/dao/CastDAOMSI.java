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
	 * 插入cast
	 * @param cast 传入要插入的cast
	 * @return 插入到数据库的记录数--如果插入了一条记录就返回1，若是没有成功插入则返回0
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
	 * 更新cast
	 * @param cast 传入要更新的cast
	 * @return 从数据库更新的记录数--如果更新了一条记录就返回1，若是没有成功更新则返回0
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
	 * 删除cast
	 * @param castid 
	 * @return 删除的记录数--如果删除了一条记录就返回1，若是没有成功删除则返回0
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
	 * 根据movieid的查询
	 * @param movieid 通过movieid查询数据库
	 * @return cast的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
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
	 * 根据actorid的查询
	 * @param actorid 通过actorid查询数据库
	 * @return cast的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
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
