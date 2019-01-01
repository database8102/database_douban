package dao;

import java.sql.SQLException;
import java.util.List;

import bean.MovieType;

public interface MovieTypeDAO {
	public int insertMovietype(MovieType movietype) throws SQLException;
	public int updateMovietype(int newmovieid,int newtypeid,int oldmovieid,int oldtypeid) throws SQLException;
	public int deleteMovietype(int movieid,int typeid) throws SQLException;
	public List<MovieType> getMovietypeByMovieId(int movieid) throws SQLException;
	public List<MovieType> getMovietypeByActorId(int typeid) throws SQLException;
}
