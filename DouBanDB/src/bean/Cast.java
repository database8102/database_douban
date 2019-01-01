package bean;

public class Cast {
	private int castid;
	private int movieid;
	private int actorid;
	private String role;
	
	public Cast(){}
	
	public Cast(int movieid, int actorid, String role) {
		super();
		this.movieid = movieid;
		this.actorid = actorid;
		this.role = role;
	}
	
	public Cast(int castid, int movieid, int actorid, String role) {
		super();
		this.castid = castid;
		this.movieid = movieid;
		this.actorid = actorid;
		this.role = role;
	}

	public int getCastid() {
		return castid;
	}
	public void setCastid(int castid) {
		this.castid = castid;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public int getActorid() {
		return actorid;
	}
	public void setActorid(int actorid) {
		this.actorid = actorid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
