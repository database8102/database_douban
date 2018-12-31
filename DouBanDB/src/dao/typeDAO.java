package dao;

import java.sql.SQLException;
import java.util.List;

import member.type;

public interface typeDAO {
	public int insertType(type type) throws SQLException;
	public int updateType(type type) throws SQLException;
	public int deleteType(int typeid) throws SQLException;
	public type getTypeById(int typeid) throws SQLException;
	public List<type> getAllType() throws SQLException;
}
