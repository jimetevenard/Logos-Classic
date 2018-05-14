package com.logos.entity.question;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "QuestionDragAndDrop")
@Document
public class QuestionDragAndDrop extends QuestionATrous {

    /**
     * Default constructor
     */
    public QuestionDragAndDrop() {
    }

	public QuestionDragAndDrop(Integer idQuestion, String enonce, String phraseATrou, List<String> solutions) {
		super(idQuestion, enonce, phraseATrou, solutions);
		// TODO Auto-generated constructor stub
	}
    
    

}