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
@DiscriminatorValue(value = "ReponseFermeeEleve")
public class ReponseFermeeEleve extends ReponseEleve {

    /**
     * Default constructor
     */
    public ReponseFermeeEleve() {
    }

	public ReponseFermeeEleve(Integer idReponse, Evaluation evaluation, Question question) {
		super(idReponse, evaluation, question);
		// TODO Auto-generated constructor stub
	}
    
    

}