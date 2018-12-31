package dao;

import java.sql.SQLException;
import java.util.List;

import member.cast;

public interface CastDAO {
	public int insertCast(Cast cast) throws SQLException;
	public int updateCast(Cast cast) throws SQLException;
	public int deleteCast(int castid) throws SQLException;
	public List<Cast> getCastByMovieId(int movieid) throws SQLException;
	public List<Cast> getCastByActorId(int actorid) throws SQLException;
}
