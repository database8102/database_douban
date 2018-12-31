package dao;

import java.sql.SQLException;
import java.util.List;

import member.user;

public interface userDAO {
	public int insertUser(user user) throws SQLException;
	public int updateUser(user user) throws SQLException;
	public int deleteUser(int userid) throws SQLException;
	public user getUserById(int userid) throws SQLException;
	public List<user> getAllUser() throws SQLException;
	public user getUserByEmail(String email) throws SQLException;
}
