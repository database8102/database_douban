package bean;

public class Actor {
	private int actorid;
	private String chinesename;
	private String name;
	private String IMDbid;
	private String sex;
	private String birthday;
	private String profile;
	private String image;
	
	public Actor(){}
	
	public Actor(String chinesename, String name, String iMDbid, String sex,
			String birthday, String profile, String image) {
		super();
		this.chinesename = chinesename;
		this.name = name;
		IMDbid = iMDbid;
		this.sex = sex;
		this.birthday = birthday;
		this.profile = profile;
		this.image = image;
	}
	
	public Actor(int actorid, String chinesename, String name, String iMDbid,
			String sex, String birthday, String profile, String image) {
		super();
		this.actorid = actorid;
		this.chinesename = chinesename;
		this.name = name;
		IMDbid = iMDbid;
		this.sex = sex;
		this.birthday = birthday;
		this.profile = profile;
		this.image = image;
	}

	public int getActorid() {
		return actorid;
	}
	public void setActorid(int actorid) {
		this.actorid = actorid;
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
	public String getIMDbid() {
		return IMDbid;
	}
	public void setIMDbid(String iMDbid) {
		IMDbid = iMDbid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
