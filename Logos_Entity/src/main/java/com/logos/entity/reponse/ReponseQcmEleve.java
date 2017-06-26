package com.logos.entity.reponse;

import java.util.*;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.question.Question;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "ReponseQcmEleve")
public class ReponseQcmEleve extends ReponseFermeeEleve {



	/**
	 * 
	 */
	@ElementCollection
	@CollectionTable(name = "reponse_qcm", joinColumns = @JoinColumn(name = "id_reponse"))
	@Column(name = "reponse_qcm")
	private List<Integer> reponseQcm;

	/**
	 * Default constructor
	 */
	public ReponseQcmEleve() {
	}

	public ReponseQcmEleve(Integer idReponse, RealiseEvaluation realiseEvaluation, Question question, List<Integer> reponseQcm) {
		super(idReponse, realiseEvaluation, question);
		this.reponseQcm = reponseQcm;
	}

	public List<Integer> getReponseQcm() {
		return reponseQcm;
	}

	public void setReponseQcm(List<Integer> reponseQcm) {
		this.reponseQcm = reponseQcm;
	}
	
	

}