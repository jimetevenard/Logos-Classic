package com.logos.entity.user;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.evaluation.Correction;

/**
 * 
 */
@Entity
@DiscriminatorValue(value="Professeur")
public class Professeur extends Utilisateur {

    

    /**
     * 
     */
	@JsonIgnore
    @OneToMany(mappedBy="auteur")
    private Set<Cours> coursEcrits;

    /**
     * 
     */
	@JsonIgnore
    @ManyToMany(mappedBy="superviseurs")
    private Set<Cours> coursSupervises;

    /**
     * 
     */
	@JsonIgnore
    @OneToMany(mappedBy="professeur")
    private Set<Correction> corrections;

    /**
     * 
     */
	@JsonIgnore
    @ManyToMany(mappedBy="professeurs")
    private Set<Langue> langues;

    
    /**
     * Default constructor
     */
    public Professeur() {
    }


	public Professeur(Integer idUtilisateur, String nom, String prenom, String login, String password, String mail) {
		super(idUtilisateur, nom, prenom, login, password, mail);
	}


	public Set<Cours> getCoursEcrits() {
		return coursEcrits;
	}


	public void setCoursEcrits(Set<Cours> coursEcrits) {
		this.coursEcrits = coursEcrits;
	}


	public Set<Cours> getCoursSupervises() {
		return coursSupervises;
	}


	public void setCoursSupervises(Set<Cours> coursSupervises) {
		this.coursSupervises = coursSupervises;
	}


	public Set<Correction> getCorrections() {
		return corrections;
	}


	public void setCorrections(Set<Correction> corrections) {
		this.corrections = corrections;
	}


	public Set<Langue> getLangues() {
		return langues;
	}


	public void setLangues(Set<Langue> langues) {
		this.langues = langues;
	}
    
    
}