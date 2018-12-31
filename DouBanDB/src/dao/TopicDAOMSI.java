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
	 * 插入topic
	 * @param topic 传入要插入的topic
	 * @return 插入到数据库的记录数--如果插入了一条记录就返回1，若是没有成功插入则返回0
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
	 * 更新topic
	 * @param topic 传入要更新的topic
	 * @return 从数据库更新的记录数--如果更新了一条记录就返回1，若是没有成功更新则返回0
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
	 * 删除topic
	 * @param topicid 
	 * @return 删除的记录数--如果删除了一条记录就返回1，若是没有成功删除则返回0
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
	 * 根据topicid的唯一查询
	 * @param topicid 通过topicid查询数据库
	 * @return topic的一个实例化对象,如果查找到了就返回的是数据库中的一条记录，否则就是null
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
	 * 查询所有topic
	 * @return topic的一个List对象,如果查找到了就返回的是数据库中的一条或多条记录，否则就是List为空
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
