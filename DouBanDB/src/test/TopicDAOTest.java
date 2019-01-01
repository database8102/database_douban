package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import bean.Topic;
import dao.TopicDAOMSI;

public class TopicDAOTest {

	@Test
	public void testInsertTopic() {
		Topic topic=new Topic("《海王》中有哪些令你印象深刻的片段？",null);
		TopicDAOMSI dao=new TopicDAOMSI();
		try {
			dao.insertTopic(topic);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateTopic() {
		Topic topic=new Topic(4,"udatetest《海王》中有哪些令你印象深刻的片段？",300);
		TopicDAOMSI dao=new TopicDAOMSI();
		try {
			dao.updateTopic(topic);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteTopic() {
		TopicDAOMSI dao=new TopicDAOMSI();
		try {
			dao.deleteTopic(4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetTopicById() {
		TopicDAOMSI dao=new TopicDAOMSI();
		try {
			Topic topic=dao.getTopicById(1);
			System.out.println("topicid: "+topic.getTopicid());
			System.out.println("topic: "+topic.getTopic());
			System.out.println("count: "+topic.getCount());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllTopic() {
		TopicDAOMSI dao=new TopicDAOMSI();
		try {
			List<Topic> topics=dao.getAllTopic();
			for(int i=0;i<topics.size();i++)
			{
				System.out.print("topicid: "+topics.get(i).getTopicid());
				System.out.print("\ttopic: "+topics.get(i).getTopic());
				System.out.println("\tcount: "+topics.get(i).getCount());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
