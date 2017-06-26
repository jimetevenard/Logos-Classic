package com.logos.entity.reponse;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.logos.entity.evaluation.Correction;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.question.Question;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "ReponseOuverteEleve")
public class ReponseOuverteEleve extends ReponseEleve {



    /**
     * 
     */
	@Column(name="reponse_ouverte_eleve", nullable=false, length=10000)
    private String reponse;

    /**
     * 
     */
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reponse_ouverte")
    private Correction correction;
    
    /**
     * Default constructor
     */
    public ReponseOuverteEleve() {
    }

	

	public ReponseOuverteEleve(Integer idReponse, RealiseEvaluation realiseEvaluation, Question question, String reponse, Correction correction) {
		super(idReponse, realiseEvaluation, question);
		this.reponse = reponse;
		this.correction = correction;
	}



	



	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Correction getCorrection() {
		return correction;
	}

	public void setCorrection(Correction correction) {
		this.correction = correction;
	}
    
    

}