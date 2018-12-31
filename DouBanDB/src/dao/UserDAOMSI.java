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
	 * 插入user
	 * @param user 传入要插入的user
	 * @return 插入到数据库的记录数--如果插入了一条记录就返回1，若是没有成功插入则返回0
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
	 * 更新user
	 * @param user 传入要更新的user
	 * @return 从数据库更新的记录数--如果更新了一条记录就返回1，若是没有成功更新则返回0
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
	 * 删除user
	 * @param userid 
	 * @return 删除的记录数--如果删除了一条记录就返回1，若是没有成功删除则返回0
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
	 * 根据userid的唯一查询
	 * @param userid 通过userid查询数据库
	 * @return user的一个实例化对象,如果查找到了就返回的是数据库中的一条记录，否则就是null
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
	 * 查询所有user
	 * @return user的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
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
	 * 根据email的唯一查询
	 * @param email 通过email查询数据库
	 * @return user的一个实例化对象,如果查找到了就返回的是数据库中的一条记录，否则就是null
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
