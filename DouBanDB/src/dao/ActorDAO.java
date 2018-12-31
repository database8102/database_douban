package dao;

import java.sql.SQLException;
import java.util.List;

import bean.Actor;

public interface ActorDAO {
	public int insertActor(Actor actor) throws SQLException;
	public int updateActor(Actor actor) throws SQLException;
	public int deleteActor(int actorid) throws SQLException;
	public Actor getActorById(int actorid) throws SQLException;
	public List<Actor> getAllActor() throws SQLException;
}
