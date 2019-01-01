package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Type;

public class TypeDAOMSI extends DAOBase implements TypeDAO {

	
	private static final String insertType_SQL = "INSERT INTO typeinfo(typename) VALUES(?)";
	/**
	 * ����type
	 * @param type ����Ҫ�����type
	 * @return ���뵽���ݿ�ļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
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

	
	private static final String updateType_SQL = "UPDATE typeinfo SET typename =? WHERE typeid =?";
	/**
	 * ����type
	 * @param type ����Ҫ���µ�type
	 * @return �����ݿ���µļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
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

	
	private static final String deleteType_SQL = "DELETE FROM typeinfo WHERE typeid =?";
	/**
	 * ɾ��type
	 * @param typeid 
	 * @return ɾ���ļ�¼��--���ɾ����һ����¼�ͷ���1������û�гɹ�ɾ���򷵻�0
	 */
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

	
	private static final String getTypeById_SQL = "SELECT * FROM typeinfo WHERE typeid =?";
	/**
	 * ����typeid��Ψһ��ѯ
	 * @param typeid ͨ��typeid��ѯ���ݿ�
	 * @return type��һ��ʵ��������,������ҵ��˾ͷ��ص������ݿ��е�һ����¼���������null
	 */
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

	
	private static final String getAllType_SQL = "SELECT * FROM typeinfo ";
	/**
	 * ��ѯ����type
	 * @return type��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
	 */
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
