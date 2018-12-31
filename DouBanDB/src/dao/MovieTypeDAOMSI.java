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
	 * 插入movietype
	 * @param movietype 传入要插入的movietype
	 * @return 插入到数据库的记录数--如果插入了一条记录就返回1，若是没有成功插入则返回0
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
	 * 更新movietype
	 * @param movietype 传入要更新的movietype
	 * @return 从数据库更新的记录数--如果更新了一条记录就返回1，若是没有成功更新则返回0
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
	 * 删除movietype 
	 * @return 删除的记录数--如果删除了一条记录就返回1，若是没有成功删除则返回0
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
	 * 根据movieid的查询
	 * @param movieid 通过movieid查询数据库
	 * @return movietype的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
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
	 * 根据typeid的查询
	 * @param typeid 通过typeid查询数据库
	 * @return movietype的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
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
