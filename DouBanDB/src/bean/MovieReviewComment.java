package bean;

public class MovieReviewComment {
	private int moviereviewcommentid;
	private int moviereviewid;
	private int userid;
	private String createtime;
	
	
	public int getMoviereviewcommentid() {
		return moviereviewcommentid;
	}
	public void setMoviereviewcommentid(int moviereviewcommentid) {
		this.moviereviewcommentid = moviereviewcommentid;
	}
	public int getMoviereviewid() {
		return moviereviewid;
	}
	public void setMoviereviewid(int moviereviewid) {
		this.moviereviewid = moviereviewid;
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
	
}
