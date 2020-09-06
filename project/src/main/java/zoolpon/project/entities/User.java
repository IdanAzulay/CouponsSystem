package zoolpon.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String phoneNumber;

	private String contactName;

	@NotNull
	@NotBlank
	@Size(min = 5)
	private String userName;

	@NotNull
	@NotBlank
	@Size(min = 6)
	private String password;

	@Email
	private String email;

	private boolean active = false;

	private String[] companies;

	private String subCompany = null;

	public User() {
	}

	public User(String phoneNumber, String contactName, @NotNull @NotBlank @Size(min = 5) String userName,
			@NotNull @NotBlank @Size(min = 6) String password, @Email String email, boolean active, String[] companies,
			String subCompany) {
		super();
		this.phoneNumber = phoneNumber;
		this.contactName = contactName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.active = active;
		this.companies = companies;
		this.subCompany = subCompany;
	}

	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String[] getCompanies() {
		return companies;
	}

	public void setCompanies(String[] companies) {
		this.companies = companies;
	}

	public String getSubCompany() {
		return subCompany;
	}

	public void setSubCompany(String subCompany) {
		this.subCompany = subCompany;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + ", active="
				+ active + ", company=" + companies + ", subCompany=" + subCompany + "]";
	}

}