package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Topic;

public class TopicDAOMSI extends DAOBase implements TopicDAO {

	/**
	 * ����topic
	 * @param topic ����Ҫ�����topic
	 * @return ���뵽���ݿ�ļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	private static final String insertTopic_SQL = "INSERT INTO topicinfo(topic,count) VALUES(?,?)";
	@Override
	public int insertTopic(Topic topic) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(insertTopic_SQL);
		ps.setString(1, topic.getTopic());
		ps.setInt(2, topic.getCount());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * ����topic
	 * @param topic ����Ҫ���µ�topic
	 * @return �����ݿ���µļ�¼��--���������һ����¼�ͷ���1������û�гɹ������򷵻�0
	 */
	private static final String updateTopic_SQL = "UPDATE topicinfo SET topic =?,count =? WHERE topicid =?";
	@Override
	public int updateTopic(Topic topic) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(updateTopic_SQL);
		ps.setString(1, topic.getTopic());
		ps.setInt(2, topic.getCount());
		ps.setInt(3, topic.getTopicid());
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * ɾ��topic
	 * @param topicid 
	 * @return ɾ���ļ�¼��--���ɾ����һ����¼�ͷ���1������û�гɹ�ɾ���򷵻�0
	 */
	private static final String deleteTopic_SQL = "DELETE FROM topicinfo WHERE topicid =?";
	@Override
	public int deleteTopic(int topicid) throws SQLException {
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		ps = conn.prepareStatement(deleteTopic_SQL);
		ps.setInt(1, topicid);
		i = ps.executeUpdate();
		ps.close();
		conn.close();
		return i;
	}

	/**
	 * ����topicid��Ψһ��ѯ
	 * @param topicid ͨ��topicid��ѯ���ݿ�
	 * @return topic��һ��ʵ��������,������ҵ��˾ͷ��ص������ݿ��е�һ����¼���������null
	 */
	private static final String getTopicById_SQL = "SELECT * FROM topicinfo WHERE topicid =?";
	@Override
	public Topic getTopicById(int topicid) throws SQLException {
		Topic topic = new Topic();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getTopicById_SQL);
		ps.setInt(1, topicid);
		rs = ps.executeQuery();
		while(rs.next()) {
			topic.setTopicid(rs.getInt("topicid"));
			topic.setTopic(rs.getString("topic"));
			topic.setCount(rs.getInt("count"));
		}
		rs.close();
		ps.close();
		conn.close();
		return topic;
	}

	/**
	 * ��ѯ����topic
	 * @return topic��һ��List����,������ҵ��˾ͷ��ص������ݿ��е�һ���������¼���������ListΪ��
	 */
	private static final String getAllTopic_SQL = "SELECT * FROM topicinfo ";
	@Override
	public List<Topic> getAllTopic() throws SQLException {
		List<Topic> topicList=new ArrayList<Topic>();
		Topic topic = new Topic();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		ps = conn.prepareStatement(getAllTopic_SQL);
		rs = ps.executeQuery();
		while(rs.next()) {
			topic.setTopicid(rs.getInt("topicid"));
			topic.setTopic(rs.getString("topic"));
			topic.setCount(rs.getInt("count"));
			topicList.add(topic);
		}
		rs.close();
		ps.close();
		conn.close();
		return topicList;
	}

}
