package bean;

public class Topic {
	private int topicid;
	private String topic;
	private int count;
	
	public Topic(){}
	
	public Topic(String topic, Integer count) {
		super();
		this.topic = topic;
		if(count==null)
			this.count=0;
		else
			this.count = count;
	}

	public Topic(int topicid, String topic, Integer count) {
		super();
		this.topicid = topicid;
		this.topic = topic;
		if(count==null)
			this.count=0;
		else
			this.count = count;
	}

	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
