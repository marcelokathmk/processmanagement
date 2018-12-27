package br.com.softplan.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_user_creator", nullable = true)
	private User userCreator;
	
	@Column(nullable = true)
	private Calendar dateCreation;
	
	public BaseDomain(User userCreator) {
		this.userCreator = userCreator;
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		this.dateCreation = c;
	}
	
	public User getUserCreator() {
		return userCreator;
	}

	public void setUserCreator(User userCreator) {
		this.userCreator = userCreator;
	}

	public Calendar getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Calendar dateCreation) {
		this.dateCreation = dateCreation;
	}
}
