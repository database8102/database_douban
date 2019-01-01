package bean;

public class MovieReviewComment {
	private int moviereviewcommentid;
	private int moviereviewid;
	private int userid;
	private String createtime;
	private String rccontent;
	
	public MovieReviewComment(){}

	public MovieReviewComment(int moviereviewid, int userid, String rccontent) {
		super();
		this.moviereviewid = moviereviewid;
		this.userid = userid;
		this.rccontent = rccontent;
	}

	public MovieReviewComment(int moviereviewcommentid, int moviereviewid,
			int userid, String createtime, String rccontent) {
		super();
		this.moviereviewcommentid = moviereviewcommentid;
		this.moviereviewid = moviereviewid;
		this.userid = userid;
		this.createtime = createtime;
		this.rccontent = rccontent;
	}




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
	public String getRccontent() {
		return rccontent;
	}
	public void setRccontent(String rccontent) {
		this.rccontent = rccontent;
	}
	
}
