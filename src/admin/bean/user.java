package admin.bean;

public class user {
	private int id;
	private String pnumber;
	private String name;
	private String work;
	private String email;
	private String group;
	private String host;
	
	public user() {
	}
	
	public user(int id, String pnumber, String name, String work, String email, String group, String host) {
		super();
		this.id = id;
		this.pnumber = pnumber;
		this.host = host;
		this.name = name;
		this.work = work;
		this.email = email;
		this.group = group;
	}

	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
}
