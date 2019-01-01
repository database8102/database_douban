package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Movie;

public class MovieDAOMSI extends DAOBase implements MovieDAO {

	
	private static final String insertMovie_SQL = "INSERT INTO movieinfo(chinesename,name,country,language,chinadate,date,time,othername,IMDb,profile,image) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	/**
	 * 插入movie
	 * @param movie 传入要插入的movie
	 * @return 插入到数据库的记录数--如果插入了一条记录就返回1，若是没有成功插入则返回0
	 */
	@Override
	public int insertMovie(Movie movie) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(insertMovie_SQL);
		ps.setString(1, movie.getChinesename());
		ps.setString(2, movie.getName());
		ps.setString(3, movie.getCountry());
		ps.setString(4, movie.getLanguage());
		ps.setString(5, movie.getChinadate());
		ps.setString(6, movie.getDate());
		ps.setInt(7, movie.getTime());
		ps.setString(8, movie.getOthername());
		ps.setString(9, movie.getIMDb());
		ps.setString(10, movie.getProfile());
		ps.setString(11, movie.getImage());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	
	private static final String updateMovie_SQL = "UPDATE movieinfo SET chinesename =?,name =?,country =?,language =?,chinadate =?,date =?,time =?,othername =?,IMDb =?,profile =?,image =? WHERE movieid =?";
	/**
	 * 更新movie
	 * @param movie 传入要更新的movie
	 * @return 从数据库更新的记录数--如果更新了一条记录就返回1，若是没有成功更新则返回0
	 */
	@Override
	public int updateMovie(Movie movie) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(updateMovie_SQL);
		ps.setString(1, movie.getChinesename());
		ps.setString(2, movie.getName());
		ps.setString(3, movie.getCountry());
		ps.setString(4, movie.getLanguage());
		ps.setString(5, movie.getChinadate());
		ps.setString(6, movie.getDate());
		ps.setInt(7, movie.getTime());
		ps.setString(8, movie.getOthername());
		ps.setString(9, movie.getIMDb());
		ps.setString(10, movie.getProfile());
		ps.setString(11, movie.getImage());
		ps.setInt(12, movie.getMovieid());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	
	private static final String deleteMovie_SQL = "DELETE FROM movieinfo WHERE movieid =?";
	/**
	 * 删除movie
	 * @param movieid 
	 * @return 删除的记录数--如果删除了一条记录就返回1，若是没有成功删除则返回0
	 */
	@Override
	public int deleteMovie(int movieid) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(deleteMovie_SQL);
		ps.setInt(1, movieid);
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	
	private static final String getMovieById_SQL = "SELECT * FROM movieinfo WHERE movieid =?";
	/**
	 * 根据movieid的唯一查询
	 * @param movieid 通过movieid查询数据库
	 * @return movie的一个实例化对象,如果查找到了就返回的是数据库中的一条记录，否则就是null
	 */
	@Override
	public Movie getMovieById(int movieid) throws SQLException {
		Movie movie = new Movie();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getMovieById_SQL);
		ps.setInt(1, movieid);
		rs = ps.executeQuery();
		while(rs.next()) {
			movie.setMovieid(rs.getInt("movieid"));
			movie.setChinesename(rs.getString("chinesename"));
			movie.setName(rs.getString("name"));
			movie.setCountry(rs.getString("country"));
			movie.setLanguage(rs.getString("language"));
			movie.setChinadate(rs.getString("chinadate"));
			movie.setDate(rs.getString("date"));
			movie.setTime(rs.getInt("time"));
			movie.setOthername(rs.getString("othername"));
			movie.setIMDb(rs.getString("IMDb"));
			movie.setProfile(rs.getString("profile"));
			movie.setImage(rs.getString("image"));
		}
		rs.close();
		ps.close();
		conn.close();
		return movie;
	}

	
	private static final String getAllMovie_SQL = "SELECT * FROM movieinfo ";
	/**
	 * 查询所有movie
	 * @return movie的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
	 */
	@Override
	public List<Movie> getAllMovie() throws SQLException {
		List<Movie> movieList=new ArrayList<Movie>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getAllMovie_SQL);
		rs = ps.executeQuery();
		while(rs.next()) {
			Movie movie = new Movie();
			movie.setMovieid(rs.getInt("movieid"));
			movie.setChinesename(rs.getString("chinesename"));
			movie.setName(rs.getString("name"));
			movie.setCountry(rs.getString("country"));
			movie.setLanguage(rs.getString("language"));
			movie.setChinadate(rs.getString("chinadate"));
			movie.setDate(rs.getString("date"));
			movie.setTime(rs.getInt("time"));
			movie.setOthername(rs.getString("othername"));
			movie.setIMDb(rs.getString("IMDb"));
			movie.setProfile(rs.getString("profile"));
			movie.setImage(rs.getString("image"));
			movieList.add(movie);
		}
		rs.close();
		ps.close();
		conn.close();
		return movieList;
	}

}
