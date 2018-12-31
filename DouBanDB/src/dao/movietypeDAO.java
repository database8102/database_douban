package dao;

import java.sql.SQLException;
import java.util.List;

import member.movietype;

public interface movietypeDAO {
	public int insertMovietype(movietype movietype) throws SQLException;
	public int updateMovietype(movietype movietype) throws SQLException;
	public int deleteMovietype(int movieid,int typeid) throws SQLException;
	public List<movietype> getMovietypeByMovieId(int movieid) throws SQLException;
	public List<movietype> getMovietypeByActorId(int typeid) throws SQLException;
}
