package bean;

public class MovieType {
	private int movieid;
	private int typeid;
	
	public MovieType(){}
	
	public MovieType(int movieid, int typeid) {
		super();
		this.movieid = movieid;
		this.typeid = typeid;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

}
