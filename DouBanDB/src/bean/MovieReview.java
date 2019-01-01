package bean;

public class MovieReview {
	private int moviereviewid;
	private int topicid;
	private int userid;
	private String createtime;
	private String reviewcontent;
	private int likecount;
	private int dislikecount;
	
	public MovieReview(){}
	
	public MovieReview(int topicid, int userid, String reviewcontent) {
		super();
		this.topicid = topicid;
		this.userid = userid;
		this.reviewcontent = reviewcontent;
	}

	public MovieReview(int moviereviewid, int topicid, int userid,
			String createtime, String reviewcontent, int likecount,
			int dislikecount) {
		super();
		this.moviereviewid = moviereviewid;
		this.topicid = topicid;
		this.userid = userid;
		this.createtime = createtime;
		this.reviewcontent = reviewcontent;
		this.likecount = likecount;
		this.dislikecount = dislikecount;
	}



	public int getMoviereviewid() {
		return moviereviewid;
	}
	public void setMoviereviewid(int moviereviewid) {
		this.moviereviewid = moviereviewid;
	}
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getReviewcontent() {
		return reviewcontent;
	}
	public void setReviewcontent(String reviewcontent) {
		this.reviewcontent = reviewcontent;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
	public int getDislikecount() {
		return dislikecount;
	}
	public void setDislikecount(int dislikecount) {
		this.dislikecount = dislikecount;
	}
	
}
