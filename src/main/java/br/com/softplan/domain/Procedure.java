package br.com.softplan.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "procedure")
public class Procedure extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String descriptionProcedure;
	
	private Boolean feedbackPendent;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "PROCEDURE_USER",
				joinColumns = @JoinColumn(name = "id_procedure"),
				inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> users = new ArrayList<User>();
	
	public Procedure() {
		super(null);
	}
	
	public Procedure(String descriptionProcedure, Boolean isFeedbackPendent, User userCreator) {
		super(userCreator);
		this.descriptionProcedure = descriptionProcedure;
		this.feedbackPendent = isFeedbackPendent;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescriptionProcedure() {
		return descriptionProcedure;
	}

	public void setDescriptionProcedure(String descriptionProcedure) {
		this.descriptionProcedure = descriptionProcedure;
	}

	public Boolean getFeedbackPendent() {
		return feedbackPendent;
	}

	public void setFeedbackPendent(Boolean feedbackPendent) {
		this.feedbackPendent = feedbackPendent;
	}

	public List<User> getUsers() {
		if	(users == null) {
			users = new ArrayList<User>();
		}
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
