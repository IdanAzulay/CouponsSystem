package zoolpon.project.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	@NotNull
	@Size(min = 1, max = 10)
	private String phoneNumber;

	@NotNull
	private String code;

	private String company;

	private Calendar start_time;

	private Calendar expire_time;

	private boolean verified = false;

	public Client() {
	}

	public Client(@NotBlank @NotNull @Size(min = 8, max = 10) String phoneNumber, @NotNull String code, String company,
			Calendar start_time, Calendar expire_time, boolean verified) {
		super();
		this.phoneNumber = phoneNumber;
		this.code = code;
		this.company = company;
		this.start_time = start_time;
		this.expire_time = expire_time;
		this.verified = verified;
	}

	public long getId() {
		return id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Calendar getStart_time() {
		return start_time;
	}

	public void setStart_time(Calendar start_time) {
		this.start_time = start_time;
	}

	public Calendar getExpire_time() {
		return expire_time;
	}

	public void setExpire_time(Calendar expire_time) {
		this.expire_time = expire_time;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", phoneNumber=" + phoneNumber + ", code=" + code + ", start_date=" + start_time
				+ ", expire_time=" + expire_time + ", verified=" + verified + "]";
	};

	public static int Random() {

		return (int) (Math.random() * 10 + 0);

	}

	public static String generateCode() {

		String newCode = "";

		for (int i = 0; i < 10; i++) {

			String code = Integer.toString(Random());
			newCode += code;

		}

		return newCode;

	}

}
