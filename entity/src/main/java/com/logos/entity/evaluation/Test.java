package com.logos.entity.evaluation;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "Test")
@Document
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