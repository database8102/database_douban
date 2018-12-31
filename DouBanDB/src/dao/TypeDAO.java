package dao;

import java.sql.SQLException;
import java.util.List;

import member.type;

public interface TypeDAO {
	public int insertType(Type type) throws SQLException;
	public int updateType(Type type) throws SQLException;
	public int deleteType(int typeid) throws SQLException;
	public Type getTypeById(int typeid) throws SQLException;
	public List<Type> getAllType() throws SQLException;
}
