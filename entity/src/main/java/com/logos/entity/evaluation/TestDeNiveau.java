package com.logos.entity.evaluation;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.data.mongodb.core.mapping.Document;

import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Niveau;

/**
 * 
 */
@Entity
@DiscriminatorValue(value = "TestDeNiveau")
@Document
public class TestDeNiveau extends Test {



    /**
     * 
     */
	@ManyToOne
    @JoinColumn(name = "id_niveau", foreignKey = @ForeignKey(name = "fk_niveau_test_niveau"))
    private Niveau niveau;

    /**
     * 
     */
	@ManyToMany(mappedBy="testNiveau")
    private Set<Categorie> categories;
    
    
    
    /**
     * Default constructor
     */
    public TestDeNiveau() {
    }



	public TestDeNiveau(Integer idEvaluation, String titre, Niveau niveau, Set<Categorie> categories) {
		super(idEvaluation, titre);
		this.niveau = niveau;
		this.categories = categories;
	}



	public Niveau getNiveau() {
		return niveau;
	}



	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}



	public Set<Categorie> getCategories() {
		return categories;
	}



	public void setCategories(Set<Categorie> categories) {
		this.categories = categories;
	}




    
    

}