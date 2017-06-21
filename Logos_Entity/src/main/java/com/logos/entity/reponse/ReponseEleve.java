package com.logos.entity.reponse;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.question.Question;

/**
 * 
 */
@Entity
@Table(name="reponse_eleve")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_reponse_eleve")
public class ReponseEleve {

	/**
	 * 
	 */
	@Id
	@Column(name = "id_reponse_eleve")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReponse;

	/**
	 * 
	 */
	@ManyToOne
    @JoinColumn(name = "id_evaluation", foreignKey = @ForeignKey(name = "fk_evaluation_reponse_eleve"))
	private Evaluation evaluation;

	/**
	 * 
	 */
	@ManyToOne
    @JoinColumn(name = "id_question", foreignKey = @ForeignKey(name = "fk_question_reponse_eleve"))
	private Question question;

	/**
	 * Default constructor
	 */
	public ReponseEleve() {
	}

	public ReponseEleve(Integer idReponse, Evaluation evaluation, Question question) {
		super();
		this.idReponse = idReponse;
		this.evaluation = evaluation;
		this.question = question;
	}

	public Integer getIdReponse() {
		return idReponse;
	}

	public void setIdReponse(Integer idReponse) {
		this.idReponse = idReponse;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	 

}