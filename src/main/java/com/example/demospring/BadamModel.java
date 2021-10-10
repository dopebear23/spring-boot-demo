package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userany")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	private String user_name;
	private String user_email;
	private String user_type;
	private String user_address;
	private String user_gender;
	private String user_password;
	private String user_aadhar;
	private String user_cno;
	private int user_cash;
	public int getUser_cash() {
		return user_cash;
	}
	
	public void setUser_cash(int user_cash) {
		this.user_cash = user_cash;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_aadhar() {
		return user_aadhar;
	}
	public void setUser_aadhar(String user_aadhar) {
		this.user_aadhar = user_aadhar;
	}
	public String getUser_cno() {
		return user_cno;
	}
	public void setUser_cno(String user_cno) {
		this.user_cno = user_cno;
	}
	
	
	
}
