package com.logos.entity.question;

import java.util.*;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "QuestionATrous")
public class QuestionATrous extends QuestionFermee {

    /**
     * 
     */
    @Column(name = "phrase_a_trou")
    private String phraseATrou;

    /**
     * 
     */
    @ElementCollection
    @CollectionTable(name = "solution_question_trous", joinColumns = @JoinColumn(name = "id_question"))
    @Column(name = "solution_question_trous")
    private List<String> solutions;
    

    /**
     * Default constructor
     */
    public QuestionATrous() {
    }


	public QuestionATrous(Integer idQuestion, String enonce, String phraseATrou, List<String> solutions) {
		super(idQuestion, enonce);
		this.phraseATrou = phraseATrou;
		this.solutions = solutions;
	}


	public String getPhraseATrou() {
		return phraseATrou;
	}


	public void setPhraseATrou(String phraseATrou) {
		this.phraseATrou = phraseATrou;
	}


	public List<String> getSolutions() {
		return solutions;
	}


	public void setSolutions(List<String> solutions) {
		this.solutions = solutions;
	}


    

}