package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Type;

public class TypeDAOMSI extends DAOBase implements TypeDAO {

	/**
	 * 插入type
	 * @param type 传入要插入的type
	 * @return 插入到数据库的记录数--如果插入了一条记录就返回1，若是没有成功插入则返回0
	 */
	private static final String insertType_SQL = "INSERT INTO typeinfo(typename) VALUES(?)";
	@Override
	public int insertType(Type type) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(insertType_SQL);
		ps.setString(1, type.getTypename());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * 更新type
	 * @param type 传入要更新的type
	 * @return 从数据库更新的记录数--如果更新了一条记录就返回1，若是没有成功更新则返回0
	 */
	private static final String updateType_SQL = "UPDATE typeinfo SET typename =? WHERE typeid =?";
	@Override
	public int updateType(Type type) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(updateType_SQL);
		ps.setString(1, type.getTypename());
		ps.setInt(2, type.getTypeid());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * 删除type
	 * @param typeid 
	 * @return 删除的记录数--如果删除了一条记录就返回1，若是没有成功删除则返回0
	 */
	private static final String deleteType_SQL = "DELETE FROM typeinfo WHERE typeid =?";
	@Override
	public int deleteType(int typeid) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(deleteType_SQL);
		ps.setInt(1, typeid);
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * 根据typeid的唯一查询
	 * @param typeid 通过typeid查询数据库
	 * @return type的一个实例化对象,如果查找到了就返回的是数据库中的一条记录，否则就是null
	 */
	private static final String getTypeById_SQL = "SELECT * FROM typeinfo WHERE typeid =?";
	@Override
	public Type getTypeById(int typeid) throws SQLException {
		Type type = new Type();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getTypeById_SQL);
		ps.setInt(1, typeid);
		rs = ps.executeQuery();
		while(rs.next()) {
			type.setTypeid(rs.getInt("typeid"));
			type.setTypename(rs.getString("typename"));
		}
		rs.close();
		ps.close();
		conn.close();
		return type;
	}

	/**
	 * 查询所有type
	 * @return type的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
	 */
	private static final String getAllType_SQL = "SELECT * FROM typeinfo ";
	@Override
	public List<Type> getAllType() throws SQLException {
		List<Type> typeList=new ArrayList<Type>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getAllType_SQL);
		rs = ps.executeQuery();
		while(rs.next()) {
			Type type = new Type();
			type.setTypeid(rs.getInt("typeid"));
			type.setTypename(rs.getString("typename"));
			typeList.add(type);
		}
		rs.close();
		ps.close();
		conn.close();
		return typeList;
	}

}
