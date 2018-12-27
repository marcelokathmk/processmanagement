package br.com.softplan.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback extends BaseDomain implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String descriptionFeedback;
	
	@OneToOne
	@JoinColumn(name = "id_procedure", nullable = false)
	private Procedure procedure;
	
	public Feedback(String descriptionFeedback, Procedure procedure, User userCreator) {
		super(userCreator);
		this.descriptionFeedback = descriptionFeedback;
		this.procedure = procedure;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescriptionFeedback() {
		return descriptionFeedback;
	}

	public void setDescriptionFeedback(String descriptionFeedback) {
		this.descriptionFeedback = descriptionFeedback;
	}

	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}
}
