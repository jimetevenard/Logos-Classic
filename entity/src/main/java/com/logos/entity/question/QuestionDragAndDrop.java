package com.logos.entity.question;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "QuestionDragAndDrop")
public class QuestionDragAndDrop extends QuestionATrous {

    /**
     * Default constructor
     */
    public QuestionDragAndDrop() {
    }

	public QuestionDragAndDrop(long idQuestion, String enonce, String phraseATrou, List<String> solutions) {
		super(idQuestion, enonce, phraseATrou, solutions);
		// TODO Auto-generated constructor stub
	}
    
    

}