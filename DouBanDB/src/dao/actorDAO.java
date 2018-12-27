package dao;

import java.sql.SQLException;
import java.util.List;

import member.actor;

public interface actorDAO {
	public int insertActor(actor actor) throws SQLException;
	public int updateActor(actor actor) throws SQLException;
	public int deleteActor(actor actoe) throws SQLException;
	public actor getActorById(int actorid) throws SQLException;
	public List<actor> getAllActor() throws SQLException;
}
