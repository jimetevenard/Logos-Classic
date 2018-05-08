package com.logos.entity.question;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.reponse.ReponseEleve;

/**
 * 
 */
//@Entity
//@Table(name= "question")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type_question")

@Document
public class Question {

    
    /**
     * 
     */
    @Id
   // @Column(name = "id_question")
    @GeneratedValue(generator= "uuid")
    private String idQuestion;

    /**
     * 
     */
    @Column(name = "enonce_question")
    private String enonce;


    /**
     * 
     */
    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "question_evaluation", joinColumns = { 
			@JoinColumn(name = "fk_question") }, inverseJoinColumns = { @JoinColumn(name = "fk_evaluation") })
    private Set<Evaluation> evaluations;

    /**
     * 
     */
    @OneToMany(mappedBy = "question")
    private List<ReponseEleve> reponsesEleve;
    
    /**
     * Default constructor
     */
    public Question() {
    }

	public Question(String idQuestion, String enonce) {
		super();
		this.idQuestion = idQuestion;
		this.enonce = enonce;
	}
	
	

	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", enonce=" + enonce + "]";
	}

	public String getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(String idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public List<ReponseEleve> getReponsesEleve() {
		return reponsesEleve;
	}

	public void setReponsesEleve(List<ReponseEleve> reponsesEleve) {
		this.reponsesEleve = reponsesEleve;
	}


    

}