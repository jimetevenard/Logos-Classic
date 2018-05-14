package com.logos.entity.question;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 */
@Entity
@DiscriminatorValue(value="QuestionOuverte")
@Document
public class QuestionOuverte extends Question {

    /**
     * Default constructor
     */
    public QuestionOuverte() {
    }

	public QuestionOuverte(Integer idQuestion, String enonce) {
		super(idQuestion, enonce);
		// TODO Auto-generated constructor stub
	}
    
    

}