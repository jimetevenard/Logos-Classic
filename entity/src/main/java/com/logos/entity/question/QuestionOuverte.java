package com.logos.entity.question;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 */
@Entity
@DiscriminatorValue(value="QuestionOuverte")
public class QuestionOuverte extends Question {

    /**
     * Default constructor
     */
    public QuestionOuverte() {
    }

	public QuestionOuverte(long idQuestion, String enonce) {
		super(idQuestion, enonce);
		// TODO Auto-generated constructor stub
	}
    
    

}