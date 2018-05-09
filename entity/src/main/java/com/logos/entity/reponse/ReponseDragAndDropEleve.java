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
@DiscriminatorValue(value = "ReponseDragAndDropEleve")
@Document
public class ReponseDragAndDropEleve extends ReponseATrousEleve {

    /**
     * Default constructor
     */
    public ReponseDragAndDropEleve() {
    }

	public ReponseDragAndDropEleve(Integer idReponse, RealiseEvaluation realiseEvaluation, Question question,
			List<String> reponseATrou) {
		super(idReponse, realiseEvaluation, question, reponseATrou);
		// TODO Auto-generated constructor stub
	}
    
    

}