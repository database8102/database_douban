package dao;

import java.util.List;

import member.user;

public interface userDAO {
	public int insertUser(user user);
	public int updateUser(user user);
	public int deleteUser(int userid);
	public user getUserById(int userid);
	public List<user> getAllUser();
	public user getUserByEmail(String email);
}
