package com.logos.entity.reponse;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.question.Question;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "ReponseDragAndDropEleve")
public class ReponseDragAndDropEleve extends ReponseATrousEleve {

    /**
     * Default constructor
     */
    public ReponseDragAndDropEleve() {
    }

	public ReponseDragAndDropEleve(Integer idReponse, Evaluation evaluation, Question question,
			List<String> reponseATrou) {
		super(idReponse, evaluation, question, reponseATrou);
		// TODO Auto-generated constructor stub
	}
    
    

}