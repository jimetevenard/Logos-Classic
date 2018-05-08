package com.logos.entity.question;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "QuestionFermee")
public class QuestionFermee extends Question {

    /**
     * Default constructor
     */
    public QuestionFermee() {
    
    }

	public QuestionFermee(long idQuestion, String enonce) {
		super(idQuestion, enonce);
		// TODO Auto-generated constructor stub
	}
    
    

}