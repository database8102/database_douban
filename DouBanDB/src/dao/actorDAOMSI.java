package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.actor;

public class actorDAOMSI extends DAObase implements actorDAO {

	/**
	 * ����actor
	 * @param actor ����Ҫ�����actor
	 * @return ���뵽���ݿ�ļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	private static final String insertActor_SQL = "INSERT INTO actorinfo(chinesename,name,IMDbid,sex,birthday,profile,image) VALUES(?,?,?,?,?,?,?)";
	@Override
	public int insertActor(actor actor) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(insertActor_SQL);
		ps.setString(1, actor.getChinesename());
		ps.setString(2, actor.getName());
		ps.setString(3, actor.getImdbid());
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
	 * ����actor
	 * @param actor ����Ҫ���µ�actor
	 * @return �����ݿ���µļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	private static final String updateActor_SQL = "UPDATE actorinfo SET chinesename =?,name =?,IMDbid =?,sex =?,birthday =?,profile =?,image =?";
	@Override
	public int updateActor(actor actor) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(updateActor_SQL);
		ps.setString(1, actor.getChinesename());
		ps.setString(2, actor.getName());
		ps.setString(3, actor.getImdbid());
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
	 * ɾ��actor
	 * @param actorid 
	 * @return ɾ���ļ�¼��--���ɾ����һ����¼�ͷ���1������û�гɹ�ɾ���򷵻�0
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
	 * ����actorid��Ψһ��ѯ
	 * @param actorid ͨ��actorid��ѯ���ݿ�
	 * @return actor��һ��ʵ��������,������ҵ��˾ͷ��ص������ݿ��е�һ����¼���������null
	 */
	private static final String getActorById_SQL = "SELECT * FROM actorinfo WHERE actorid =?";
	@Override
	public actor getActorById(int actorid) throws SQLException {
		actor actor = new actor();
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
			actor.setImdbid(rs.getString("IMDbid"));
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
	 * ��ѯ����actor
	 * @return actor��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
	 */
	private static final String getAllActor_SQL = "SELECT * FROM actorinfo ";
	@Override
	public List<actor> getAllActor() throws SQLException {
		List<actor> all = new ArrayList<actor>();
		actor actor = new actor();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getAllActor_SQL);
		rs = ps.executeQuery();
		while(rs.next()) {
			actor.setActorid(rs.getInt("actorid"));
			actor.setChinesename(rs.getString("chinesename"));
			actor.setName(rs.getString("name"));
			actor.setImdbid(rs.getString("IMDbid"));
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
