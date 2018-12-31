package bean;

public class User {
	private int userid;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private String areacode;
	private String phone;
	private String wechat;
	private String weibo;
	private String qq;
	private String image;
	
	public User(){}
	
	public User(String username, String password, String nickname,
			String email, String areacode, String phone, String wechat,
			String weibo, String qq, String image) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.areacode = areacode;
		this.phone = phone;
		this.wechat = wechat;
		this.weibo = weibo;
		this.qq = qq;
		this.image = image;
	}

	public User(int userid, String username, String password, String nickname,
			String email, String areacode, String phone, String wechat,
			String weibo, String qq, String image) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.areacode = areacode;
		this.phone = phone;
		this.wechat = wechat;
		this.weibo = weibo;
		this.qq = qq;
		this.image = image;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getWeibo() {
		return weibo;
	}
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
