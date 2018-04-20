package com.logos.entity.cours;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.logos.entity.evaluation.TestDeNiveau;
import com.logos.entity.user.Eleve;

/**
 * 
 */
@Entity
@Table(name="niveau")
public class Niveau {

	public static final int A1 = 10;
	public static final int A2 = 20;
	public static final int B1 = 30;
	public static final int B2 = 40;
	public static final int C1 = 50;
	public static final int C2 = 60;
   
    /**
     * 
     */
	@Id
	@Column(name="id_niveau")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idNiveau;

    /**
     * 
     */
	@Column(name="libelle_niveau", nullable=false, length=50)
    private String libelle;

    /**
     * 
     */
	@Column(name="valeur_niveau", nullable=false)
    private int valeur;

    /**
     * 
     */
	 @ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "niveau_eleve", joinColumns = { 
				@JoinColumn(name = "fk_niveau") }, inverseJoinColumns = { @JoinColumn(name = "fk_eleve") })
    private Set<Eleve> eleves;

    /**
     * 
     */
	 @ManyToOne
	    @JoinColumn(name = "id_langue", foreignKey = @ForeignKey(name = "fk_niveau_langue"))
    private Langue langue;

    /**
     * 
     */
	 @OneToMany(mappedBy="niveau")
    private Set<TestDeNiveau> testNiveau;
    
    public Niveau() {
    }

	public Niveau(Integer idNiveau, String libelle, int valeur, Langue langue) {
		super();
		this.idNiveau = idNiveau;
		this.libelle = libelle;
		this.valeur = valeur;
		this.langue = langue;
	}

	public Integer getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(Integer idNiveau) {
		this.idNiveau = idNiveau;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Set<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(Set<Eleve> eleves) {
		this.eleves = eleves;
	}

	public Langue getLangue() {
		return langue;
	}

	public void setLangue(Langue langue) {
		this.langue = langue;
	}

	public Set<TestDeNiveau> getTestNiveau() {
		return testNiveau;
	}

	public void setTestNiveau(Set<TestDeNiveau> testNiveau) {
		this.testNiveau = testNiveau;
	}
    
    


}