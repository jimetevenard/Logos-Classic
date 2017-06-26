package com.logos.entity.evaluation;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.user.Eleve;

/**
 * 
 */
@Entity
@Table(name="realise_evaluation")
public class RealiseEvaluation {


	@Id
	@Column(name="id_realise_evaluation")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idRealiseEvaluation;

    /**
     * 
     */
	@Column(name="date_evaluation")
	@Temporal(TemporalType.TIMESTAMP)
    private Date dateEvaluation;


    /**
     * 
     */
	@ManyToOne
    @JoinColumn(name = "id_eleve", foreignKey = @ForeignKey(name = "fk_eleve_realise_evaluation"))
    private Eleve eleve;

    /**
     * 
     */
	@ManyToOne
    @JoinColumn(name = "id_evaluation", foreignKey = @ForeignKey(name = "fk_realise_evaluation_evaluation"))
    private Evaluation evaluation;
	
	 @OneToMany(mappedBy = "realiseEvaluation")
	    private Set<ReponseEleve> reponsesEleve;
    
    /**
     * Default constructor
     */
    public RealiseEvaluation() {
    }

	public RealiseEvaluation(Integer idRealiseEvaluation, Date dateEvaluation, Eleve eleve, Evaluation evaluation) {
		super();
		this.idRealiseEvaluation = idRealiseEvaluation;
		this.dateEvaluation = dateEvaluation;
		this.eleve = eleve;
		this.evaluation = evaluation;
	}

	public Integer getIdRealiseEvaluation() {
		return idRealiseEvaluation;
	}

	public void setIdRealiseEvaluation(Integer idRealiseEvaluation) {
		this.idRealiseEvaluation = idRealiseEvaluation;
	}

	public Date getDateEvaluation() {
		return dateEvaluation;
	}

	public void setDateEvaluation(Date dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public Set<ReponseEleve> getReponsesEleve() {
		return reponsesEleve;
	}

	public void setReponsesEleve(Set<ReponseEleve> reponsesEleve) {
		this.reponsesEleve = reponsesEleve;
	}
	
    
    
    

}