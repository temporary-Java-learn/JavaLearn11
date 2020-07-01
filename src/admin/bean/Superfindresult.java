package admin.bean;

public class Superfindresult {
	private int id;
	private String name;
	private String information;
	
	
	public Superfindresult() {
		super();
	}
	public Superfindresult(int id, String name, String information) {
		super();
		this.id = id;
		this.name = name;
		this.information = information;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	
	
}
