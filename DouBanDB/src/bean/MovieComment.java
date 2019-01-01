package bean;

public class MovieComment {
	private int commentid;
	private int userid;
	private int movieid;
	private double score;
	private String commentcontent;
	private Integer likecount;
	private String date;
	private String device;
	private String type;
	
	public MovieComment(){}
	
	public MovieComment(int userid, int movieid, double score,
			String commentcontent, Integer likecount, String device,
			String type) {
		super();
		this.userid = userid;
		this.movieid = movieid;
		this.score = score;
		this.commentcontent = commentcontent;
		if(likecount==null)
			this.likecount=0;
		else
			this.likecount = likecount;
		this.device = device;
		this.type = type;
	}

	public MovieComment(int commentid, int userid, int movieid, double score,
			String commentcontent, Integer likecount, String date, String device,
			String type) {
		super();
		this.commentid = commentid;
		this.userid = userid;
		this.movieid = movieid;
		this.score = score;
		this.commentcontent = commentcontent;
		if(likecount==null)
			this.likecount=0;
		else
			this.likecount = likecount;
		this.date = date;
		this.device = device;
		this.type = type;
	}

	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public Integer getLikecount() {
		return likecount;
	}
	public void setLikecount(Integer likecount) {
		this.likecount = likecount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
