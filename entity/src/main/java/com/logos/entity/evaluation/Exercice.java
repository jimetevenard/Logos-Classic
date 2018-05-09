package com.logos.entity.evaluation;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.data.mongodb.core.mapping.Document;

import com.logos.entity.cours.Chapitre;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "Exercice")
@Document
public class Exercice extends Evaluation {



    /**
     * 
     */
	@ManyToMany(mappedBy="exercices")
    private Set<Chapitre> chapitres;
    
    /**
     * Default constructor
     */
    public Exercice() {
    }

	public Exercice(Integer idEvaluation, String titre, Set<Chapitre> chapitres) {
		super(idEvaluation, titre);
		this.chapitres = chapitres;
	}

	public Set<Chapitre> getChapitres() {
		return chapitres;
	}

	public void setChapitres(Set<Chapitre> chapitres) {
		this.chapitres = chapitres;
	}
    
    

}