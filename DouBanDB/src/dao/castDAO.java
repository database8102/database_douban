package dao;

import java.sql.SQLException;
import java.util.List;

import member.cast;

public interface castDAO {
	public int insertCast(cast cast) throws SQLException;
	public int updateCast(cast cast) throws SQLException;
	public int deleteCast(int castid) throws SQLException;
	public List<cast> getCastByMovieId(int movieid) throws SQLException;
	public List<cast> getCastByActorId(int actorid) throws SQLException;
}
