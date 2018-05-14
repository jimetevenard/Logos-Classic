package com.logos.entity.question;

import java.util.*;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "QuestionQcm")
@Document
public class QuestionQcm extends QuestionFermee {

    

    /**
     * 
     */
    @ElementCollection
    @CollectionTable(name = "proposition_question_qcm", joinColumns = @JoinColumn(name = "id_question"))
    @Column(name = "proposition_question_qcm")
    private List<String> propositions;

    /**
     * 
     */
    @ElementCollection
    @CollectionTable(name = "solution_question_qcm", joinColumns = @JoinColumn(name = "id_question"))
    @Column(name = "solution_question_qcm")
    private List<Integer> solutions;
    
    /**
     * Default constructor
     */
    public QuestionQcm() {
    }

	public QuestionQcm(Integer idQuestion, String enonce, List<String> propositions, List<Integer> solutions) {
		super(idQuestion, enonce);
		this.propositions = propositions;
		this.solutions = solutions;
	}

	public List<String> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<String> propositions) {
		this.propositions = propositions;
	}

	public List<Integer> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Integer> solutions) {
		this.solutions = solutions;
	}
    
}