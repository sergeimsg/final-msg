package by.htp.ex.bean;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
	
	
	private static final long serialVersionUID = -1370684613315378026L;
	
	private Integer userId;
	private String  login;
	private String  password;
	private String  email;
	private String  role;

	
	
	public User() {
		
	}

	

	public User(Integer userId, String login, String password, String email, String role) {
		super();
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
	}


	

	public User(Integer userId, String login, String password, String role) {
		super();
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.role = role;
	}



	public User(String login, String password, String email) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
	}


	public User(Integer userId, String role) {
		super();
		this.userId = userId;
		this.role = role;
	}

	
	
	

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
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


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	


	


	@Override
	public int hashCode() {
		return Objects.hash(email, login, password, role, userId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) &&  Objects.equals(login, other.login) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && Objects.equals(userId, other.userId);
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", login=" + login + ", password=" + password + ", email=" + email + ", role="
				+ role + ", listofNews=" +  "]";
	}


	
	
	

}
