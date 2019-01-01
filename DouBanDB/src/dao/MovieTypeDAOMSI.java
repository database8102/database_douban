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
	 * 插入movietype
	 * @param movietype 传入要插入的movietype
	 * @return 插入到数据库的记录数--如果插入了一条记录就返回1，若是没有成功插入则返回0
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
	 * 更新movietype
	 * @param newmovieid 传入要更新的movieid
	 * @param newtypeid 传入要更新的typeid
	 * @param oldmovieid 传入旧的movieid，用于寻找要修改的记录
	 * @param oldtypeid 传入旧的typeid，用于寻找要修改的记录
	 * @return 从数据库更新的记录数--如果更新了一条记录就返回1，若是没有成功更新则返回0
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
	 * 删除movietype 
	 * @return 删除的记录数--如果删除了一条记录就返回1，若是没有成功删除则返回0
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
	 * 根据movieid的查询
	 * @param movieid 通过movieid查询数据库
	 * @return movietype的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
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
	 * 根据typeid的查询
	 * @param typeid 通过typeid查询数据库
	 * @return movietype的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
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
