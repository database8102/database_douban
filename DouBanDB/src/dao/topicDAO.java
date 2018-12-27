package dao;

import java.sql.SQLException;
import java.util.List;

import member.topic;

public interface topicDAO {
	public int insertTopic(topic topic) throws SQLException;
	public int updateTopic(topic topic) throws SQLException;
	public int deleteTopic(int topicid) throws SQLException;
	public topic getTopicById(int topicid) throws SQLException;
	public List<topic> getAllTopic() throws SQLException;
}
