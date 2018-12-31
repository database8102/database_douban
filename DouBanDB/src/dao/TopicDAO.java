package dao;

import java.sql.SQLException;
import java.util.List;

import bean.Topic;

public interface TopicDAO {
	public int insertTopic(Topic topic) throws SQLException;
	public int updateTopic(Topic topic) throws SQLException;
	public int deleteTopic(int topicid) throws SQLException;
	public Topic getTopicById(int topicid) throws SQLException;
	public List<Topic> getAllTopic() throws SQLException;
}
