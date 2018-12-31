package bean;

public class Movie {
	private int movieid;
	private String chinesename;
	private String name;
	private String country;
	private String language;
	private String chinadate;
	private String date;
	private int time;
	private String othername;
	private String IMDb;
	private String profile;
	private String image;
	
	public Movie(){}
	
	public Movie(String chinesename, String name, String country,
			String language, String chinadate, String date, int time,
			String othername, String iMDb, String profile, String image) {
		super();
		this.chinesename = chinesename;
		this.name = name;
		this.country = country;
		this.language = language;
		this.chinadate = chinadate;
		this.date = date;
		this.time = time;
		this.othername = othername;
		IMDb = iMDb;
		this.profile = profile;
		this.image = image;
	}

	public Movie(int movieid, String chinesename, String name, String country,
			String language, String chinadate, String date, int time,
			String othername, String iMDb, String profile, String image) {
		super();
		this.movieid = movieid;
		this.chinesename = chinesename;
		this.name = name;
		this.country = country;
		this.language = language;
		this.chinadate = chinadate;
		this.date = date;
		this.time = time;
		this.othername = othername;
		IMDb = iMDb;
		this.profile = profile;
		this.image = image;
	}

	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getChinesename() {
		return chinesename;
	}
	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getChinadate() {
		return chinadate;
	}
	public void setChinadate(String chinadate) {
		this.chinadate = chinadate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getOthername() {
		return othername;
	}
	public void setOthername(String othername) {
		this.othername = othername;
	}
	public String getIMDb() {
		return IMDb;
	}
	public void setIMDb(String iMDb) {
		IMDb = iMDb;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
