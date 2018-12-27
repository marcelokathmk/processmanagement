package br.com.softplan.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseDomain implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private Integer typeUser;
	
	@Column(nullable = false, unique = true)
	private String loginUser;
	
	@Column(nullable = false)
	private String password;
	
	public User() {
		super(null);
	}
	
	public User(Integer typeUser, String loginUser, String password, User userCreator) {
		super(userCreator);
		this.typeUser = typeUser;
		this.loginUser = loginUser;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(Integer typeUser) {
		this.typeUser = typeUser;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
