package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import member.user;

public class UserDAOMSI extends DAOBase implements UserDAO {

	/**
	 * ����user
	 * @param user ����Ҫ�����user
	 * @return ���뵽���ݿ�ļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	private static final String insertUser_SQL = "INSERT INTO userinfo(username,password,nickname,email,areacode,phone,wechat,weibo,qq,image) VALUES(?,?,?,?,?,?,?,?,?,?)";
	@Override
	public int insertUser(User user) throws SQLException{
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(insertUser_SQL);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getNickname());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getAreacode());
		ps.setString(6, user.getPhone());
		ps.setString(7, user.getWechat());
		ps.setString(8, user.getWeibo());
		ps.setString(9, user.getQq());
		ps.setString(10, user.getImage());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}
	
	/**
	 * ����user
	 * @param user ����Ҫ���µ�user
	 * @return �����ݿ���µļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	private static final String updateUser_SQL = "UPDATE userinfo SET username =?,password =?,nickname =?,email =?,areacode =?,phone =?,wechat =?,weibo =?,qq =?,image =? WHERE userid =?";
	@Override
	public int updateUser(User user) throws SQLException{
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(updateUser_SQL);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getNickname());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getAreacode());
		ps.setString(6, user.getPhone());
		ps.setString(7, user.getWechat());
		ps.setString(8, user.getWeibo());
		ps.setString(9, user.getQq());
		ps.setString(10, user.getImage());
		ps.setInt(11, user.getUserid());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * ɾ��user
	 * @param userid 
	 * @return ɾ���ļ�¼��--���ɾ����һ����¼�ͷ���1������û�гɹ�ɾ���򷵻�0
	 */
	private static final String deleteUser_SQL = "DELETE FROM userinfo WHERE userid =?";
	@Override
	public int deleteUser(int userid) throws SQLException{
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(deleteUser_SQL);
		ps.setInt(1, userid);
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * ����userid��Ψһ��ѯ
	 * @param userid ͨ��userid��ѯ���ݿ�
	 * @return user��һ��ʵ��������,������ҵ��˾ͷ��ص������ݿ��е�һ����¼���������null
	 */
	private static final String getUserById_SQL = "SELECT * FROM userinfo WHERE userid =?";
	@Override
	public User getUserById(int userid) throws SQLException{
		User user = new User();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getUserById_SQL);
		ps.setInt(1, userid);
		rs = ps.executeQuery();
		while(rs.next()) {
			user.setUserid(rs.getInt("userid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setNickname(rs.getString("nickname"));
			user.setEmail(rs.getString("email"));
			user.setAreacode(rs.getString("areacode"));
			user.setPhone(rs.getString("phone"));
			user.setWechat(rs.getString("wechat"));
			user.setWeibo(rs.getString("weibo"));
			user.setQq(rs.getString("qq"));
			user.setImage(rs.getString("image"));
		}
		rs.close();
		ps.close();
		conn.close();
		return user;
	}

	/**
	 * ��ѯ����user
	 * @return user��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
	 */
	private static final String getAllUser_SQL = "SELECT * FROM userinfo ";
	@Override
	public List<User> getAllUser() throws SQLException{
		List<User> userList=new ArrayList<User>();
		User user = new User();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getAllUser_SQL);
		rs = ps.executeQuery();
		while(rs.next()) {
			user.setUserid(rs.getInt("userid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setNickname(rs.getString("nickname"));
			user.setEmail(rs.getString("email"));
			user.setAreacode(rs.getString("areacode"));
			user.setPhone(rs.getString("phone"));
			user.setWechat(rs.getString("wechat"));
			user.setWeibo(rs.getString("weibo"));
			user.setQq(rs.getString("qq"));
			user.setImage(rs.getString("image"));
			userList.add(user);
		}
		rs.close();
		ps.close();
		conn.close();
		return userList;
	}

	/**
	 * ����email��Ψһ��ѯ
	 * @param email ͨ��email��ѯ���ݿ�
	 * @return user��һ��ʵ��������,������ҵ��˾ͷ��ص������ݿ��е�һ����¼���������null
	 */
	private static final String getUserByEmail_SQL = "SELECT * FROM userinfo WHERE email =?";
	@Override
	public User getUserByEmail(String email) throws SQLException{
		User user = new User();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getUserByEmail_SQL);
		ps.setString(1, email);
		rs = ps.executeQuery();
		while(rs.next()) {
			user.setUserid(rs.getInt("userid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setNickname(rs.getString("nickname"));
			user.setEmail(rs.getString("email"));
			user.setAreacode(rs.getString("areacode"));
			user.setPhone(rs.getString("phone"));
			user.setWechat(rs.getString("wechat"));
			user.setWeibo(rs.getString("weibo"));
			user.setQq(rs.getString("qq"));
			user.setImage(rs.getString("image"));
		}
		rs.close();
		ps.close();
		conn.close();
		return user;
	}

}
