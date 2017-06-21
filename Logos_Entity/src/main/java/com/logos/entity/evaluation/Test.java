package com.logos.entity.evaluation;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "Test")
public class Test extends Evaluation {

    /**
     * Default constructor
     */
    public Test() {
    }

	public Test(Integer idEvaluation, String titre) {
		super(idEvaluation, titre);
		// TODO Auto-generated constructor stub
	}
    
    

}