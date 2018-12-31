package dao;

import java.sql.SQLException;
import java.util.List;

import member.user;

public interface UserDAO {
	public int insertUser(User user) throws SQLException;
	public int updateUser(User user) throws SQLException;
	public int deleteUser(int userid) throws SQLException;
	public User getUserById(int userid) throws SQLException;
	public List<User> getAllUser() throws SQLException;
	public User getUserByEmail(String email) throws SQLException;
}
