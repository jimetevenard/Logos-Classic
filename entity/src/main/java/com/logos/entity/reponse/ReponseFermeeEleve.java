package com.logos.entity.reponse;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.question.Question;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "ReponseFermeeEleve")
@Document
public class ReponseFermeeEleve extends ReponseEleve {

    /**
     * Default constructor
     */
    public ReponseFermeeEleve() {
    }

	public ReponseFermeeEleve(Integer idReponse, RealiseEvaluation realiseEvaluation, Question question) {
		super(idReponse, realiseEvaluation, question);
		// TODO Auto-generated constructor stub
	}

	
    
    

}