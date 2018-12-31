package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.movie;

public class movieDAOMSI extends DAObase implements movieDAO {

	/**
	 * ����movie
	 * @param movie ����Ҫ�����movie
	 * @return ���뵽���ݿ�ļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	private static final String insertMovie_SQL = "INSERT INTO movieinfo(chinesename,name,country,language,chinadate,date,time,othername,IMDb,profile,image) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	@Override
	public int insertMovie(movie movie) throws SQLException {
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
		ps.setString(9, movie.getImdb());
		ps.setString(10, movie.getProfile());
		ps.setString(11, movie.getImage());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * ����movie
	 * @param movie ����Ҫ���µ�movie
	 * @return �����ݿ���µļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	private static final String updateMovie_SQL = "UPDATE movieinfo SET chinesename =?,name =?,country =?,language =?,chinadate =?,date =?,time =?,othername =?,IMDb =?,profile =?,image =? WHERE movieid =?";
	@Override
	public int updateMovie(movie movie) throws SQLException {
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
		ps.setString(9, movie.getImdb());
		ps.setString(10, movie.getProfile());
		ps.setString(11, movie.getImage());
		ps.setInt(12, movie.getMovieid());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * ɾ��movie
	 * @param movieid 
	 * @return ɾ���ļ�¼��--���ɾ����һ����¼�ͷ���1������û�гɹ�ɾ���򷵻�0
	 */
	private static final String deleteMovie_SQL = "DELETE FROM movieinfo WHERE movieid =?";
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

	/**
	 * ����movieid��Ψһ��ѯ
	 * @param movieid ͨ��movieid��ѯ���ݿ�
	 * @return movie��һ��ʵ��������,������ҵ��˾ͷ��ص������ݿ��е�һ����¼���������null
	 */
	private static final String getMovieById_SQL = "SELECT * FROM movieinfo WHERE movieid =?";
	@Override
	public movie getMovieById(int movieid) throws SQLException {
		movie movie = new movie();
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
			movie.setImdb(rs.getString("IMDb"));
			movie.setProfile(rs.getString("profile"));
			movie.setImage(rs.getString("image"));
		}
		rs.close();
		ps.close();
		conn.close();
		return movie;
	}

	/**
	 * ��ѯ����movie
	 * @return movie��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
	 */
	private static final String getAllMovie_SQL = "SELECT * FROM movieinfo ";
	@Override
	public List<movie> getAllMovie() throws SQLException {
		List<movie> movieList=new ArrayList<movie>();
		movie movie = new movie();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getAllMovie_SQL);
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
			movie.setImdb(rs.getString("IMDb"));
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