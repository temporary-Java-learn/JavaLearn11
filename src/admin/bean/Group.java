package admin.bean;

public class Group {
	private String host;
	private String group;
	
	
	public Group() {
		super();
	}
	
	public Group(String host, String group) {
		super();
		this.host = host;
		this.group = group;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
}
