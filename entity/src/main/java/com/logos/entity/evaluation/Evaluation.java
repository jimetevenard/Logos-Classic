package com.logos.entity.evaluation;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.logos.entity.question.Question;
import com.logos.entity.reponse.ReponseEleve;

/**
 * 
 */
@Entity
@Table(name="evaluation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_evaluation")
public class Evaluation {

    /**
     * 
     */
	@Id
    @Column(name = "id_evaluation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvaluation;

    /**
     * 
     */
	@Column(name = "titre_evaluation", nullable=false, length=200)
    private String titre;


    /**
     * 
     */
	

    /**
     * 
     */
	@ManyToMany(mappedBy="evaluations")
    private Set<Question> questions;

    /**
     * 
     */
	 @OneToMany(mappedBy = "evaluation")
    private Set<RealiseEvaluation> realisationEvaluations;
    
    /**
     * Default constructor
     */
    public Evaluation() {
    }

	public Evaluation(Integer idEvaluation, String titre) {
		super();
		this.idEvaluation = idEvaluation;
		this.titre = titre;
	}

	public Integer getIdEvaluation() {
		return idEvaluation;
	}

	public void setIdEvaluation(Integer idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Set<RealiseEvaluation> getRealisationEvaluations() {
		return realisationEvaluations;
	}

	public void setRealisationEvaluations(Set<RealiseEvaluation> realisationEvaluations) {
		this.realisationEvaluations = realisationEvaluations;
	}
    
    

}