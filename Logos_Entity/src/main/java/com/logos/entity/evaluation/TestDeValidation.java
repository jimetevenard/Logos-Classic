package com.logos.entity.evaluation;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.logos.entity.cours.Cours;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "TestDeValidation")
public class TestDeValidation extends Test {

    /**
     * 
     */
	@OneToOne(mappedBy="testDeValidation")
    private Cours cours;
    
    /**
     * Default constructor
     */
    public TestDeValidation() {
    }

	public TestDeValidation(Integer idEvaluation, String titre, Cours cours) {
		super(idEvaluation, titre);
		this.cours = cours;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}
    
    

}