package com.logos.entity.reponse;

import java.util.*;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.question.Question;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "ReponseATrousEleve")
public class ReponseATrousEleve extends ReponseFermeeEleve {



    /**
     * 
     */
    @ElementCollection
    @CollectionTable(name = "reponse_trous", joinColumns = @JoinColumn(name = "id_reponse"))
    @Column(name = "reponse_trous")
    private List<String> reponseATrou;
    
    /**
     * Default constructor
     */
    public ReponseATrousEleve() {
    }

	public ReponseATrousEleve(Integer idReponse, Evaluation evaluation, Question question, List<String> reponseATrou) {
		super(idReponse, evaluation, question);
		this.reponseATrou = reponseATrou;
	}

	public List<String> getReponseATrou() {
		return reponseATrou;
	}

	public void setReponseATrou(List<String> reponseATrou) {
		this.reponseATrou = reponseATrou;
	}
    
	
    

}