package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Actor;

public class ActorDAOMSI extends DAOBase implements ActorDAO {

	/**
	 * 插入actor
	 * @param actor 传入要插入的actor
	 * @return 插入到数据库的记录数--如果插入了一条记录就返回1，若是没有成功插入则返回0
	 */
	private static final String insertActor_SQL = "INSERT INTO actorinfo(chinesename,name,IMDbid,sex,birthday,profile,image) VALUES(?,?,?,?,?,?,?)";
	@Override
	public int insertActor(Actor actor) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(insertActor_SQL);
		ps.setString(1, actor.getChinesename());
		ps.setString(2, actor.getName());
		ps.setString(3, actor.getIMDbid());
		ps.setString(4, actor.getSex());
		ps.setString(5, actor.getBirthday());
		ps.setString(6, actor.getProfile());
		ps.setString(7, actor.getImage());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * 更新actor
	 * @param actor 传入要更新的actor
	 * @return 从数据库更新的记录数--如果更新了一条记录就返回1，若是没有成功更新则返回0
	 */
	private static final String updateActor_SQL = "UPDATE actorinfo SET chinesename =?,name =?,IMDbid =?,sex =?,birthday =?,profile =?,image =? WHERE actorid =?";
	@Override
	public int updateActor(Actor actor) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(updateActor_SQL);
		ps.setString(1, actor.getChinesename());
		ps.setString(2, actor.getName());
		ps.setString(3, actor.getIMDbid());
		ps.setString(4, actor.getSex());
		ps.setString(5, actor.getBirthday());
		ps.setString(6, actor.getProfile());
		ps.setString(7, actor.getImage());
		ps.setInt(8, actor.getActorid());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * 删除actor
	 * @param actorid 
	 * @return 删除的记录数--如果删除了一条记录就返回1，若是没有成功删除则返回0
	 */
	private static final String deleteActor_SQL = "DELETE FROM actorinfo WHERE actorid =?";
	@Override
	public int deleteActor(int actorid) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(deleteActor_SQL);
		ps.setInt(1, actorid);
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * 根据actorid的唯一查询
	 * @param actorid 通过actorid查询数据库
	 * @return actor的一个实例化对象,如果查找到了就返回的是数据库中的一条记录，否则就是null
	 */
	private static final String getActorById_SQL = "SELECT * FROM actorinfo WHERE actorid =?";
	@Override
	public Actor getActorById(int actorid) throws SQLException {
		Actor actor = new Actor();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getActorById_SQL);
		ps.setInt(1, actorid);
		rs = ps.executeQuery();
		while(rs.next()) {
			actor.setActorid(rs.getInt("actorid"));
			actor.setChinesename(rs.getString("chinesename"));
			actor.setName(rs.getString("name"));
			actor.setIMDbid(rs.getString("IMDbid"));
			actor.setSex(rs.getString("sex"));
			actor.setBirthday(rs.getString("birthday"));
			actor.setProfile(rs.getString("profile"));
			actor.setImage(rs.getString("image"));
		}
		rs.close();
		ps.close();
		conn.close();
		return actor;
	}

	/**
	 * 查询所有actor
	 * @return actor的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
	 */
	private static final String getAllActor_SQL = "SELECT * FROM actorinfo ";
	@Override
	public ArrayList<Actor> getAllActor() throws SQLException {
		ArrayList<Actor> all = new ArrayList<Actor>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getAllActor_SQL);
		rs = ps.executeQuery();
		while(rs.next()) {
			Actor actor = new Actor();
			actor.setActorid(rs.getInt("actorid"));
			actor.setChinesename(rs.getString("chinesename"));
			actor.setName(rs.getString("name"));
			actor.setIMDbid(rs.getString("IMDbid"));
			actor.setSex(rs.getString("sex"));
			actor.setBirthday(rs.getString("birthday"));
			actor.setProfile(rs.getString("profile"));
			actor.setImage(rs.getString("image"));
			all.add(actor);
		}
		rs.close();
		ps.close();
		conn.close();
		return all;
	}

}
