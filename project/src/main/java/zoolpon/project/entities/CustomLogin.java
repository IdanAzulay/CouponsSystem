package zoolpon.project.entities;

public class CustomLogin {

	private long id;
	private String[] companies;

	public String[] getCompany() {
		return companies;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CustomLogin(long id, String[] companies) {
		this.id = id;
		this.companies = companies;
	}

}
