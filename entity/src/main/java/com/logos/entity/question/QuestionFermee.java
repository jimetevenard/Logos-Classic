package com.logos.entity.question;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "QuestionFermee")
@Document
public class QuestionFermee extends Question {

    /**
     * Default constructor
     */
    public QuestionFermee() {
    
    }

	public QuestionFermee(Integer idQuestion, String enonce) {
		super(idQuestion, enonce);
		// TODO Auto-generated constructor stub
	}
    
    

}