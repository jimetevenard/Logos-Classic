package com.logos.entity.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.logos.entity.cours.Niveau;
import com.logos.entity.cours.SuiviCours;
import com.logos.entity.evaluation.RealiseEvaluation;
/**
 * 
 */
@Entity
@DiscriminatorValue(value = "Eleve")
public class Eleve extends Utilisateur {

    

    /**
     * 
     */
    @Column(name = "premium_eleve",columnDefinition="TINYINT(1)")
    private boolean statutPremium;

    /**
     * 
     */
    @JsonIgnore
    @OneToMany(mappedBy= "eleve")
    private Set<SuiviCours> suiviCours;

    /**
     * 
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "eleves")
    private Set<Niveau> niveaux;

    /**
     * 
     */
    @JsonIgnore
    @OneToMany(mappedBy="eleve")
    private Set<RealiseEvaluation> realisationEvaluations;

    /**
     * Default constructor
     */
    public Eleve() {
    }

	public Eleve(Integer idUtilisateur, String nom, String prenom, String login, String password, String mail) {
		super(idUtilisateur, nom, prenom, login, password, mail);
	}

	public boolean isStatutPremium() {
		return statutPremium;
	}

	public void setStatutPremium(boolean statutPremium) {
		this.statutPremium = statutPremium;
	}

	public Set<SuiviCours> getSuiviCours() {
		return suiviCours;
	}

	public void setSuiviCours(Set<SuiviCours> suiviCours) {
		this.suiviCours = suiviCours;
	}

	public Set<Niveau> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(Set<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

	public Set<RealiseEvaluation> getRealisationEvaluations() {
		return realisationEvaluations;
	}

	public void setRealisationEvaluations(Set<RealiseEvaluation> realisationEvaluations) {
		this.realisationEvaluations = realisationEvaluations;
	}
    
    
}