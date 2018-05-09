package com.logos.entity.cours;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

import com.logos.entity.user.Professeur;

@Entity
@Table(name="langue")
@Document
public class Langue {

    
    
    /**
     * 
     */
	@Id
	@Column(name="id_langue")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idLangue;

    /**
     * 
     */
	@Column(name="libelle_langue", nullable=false, length=50)
    private String libelle;

    /**
     * 
     */
	@Column(name="code_iso", nullable=false, length=50)
    private String codeIso;

    /**
     * 
     */
	 @ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "langue_professeur", joinColumns = { 
				@JoinColumn(name = "fk_langue") }, inverseJoinColumns = { @JoinColumn(name = "fk_professeur") })
    private Set<Professeur> professeurs;
    
    public Langue() {
    }

	public Langue(Integer idLangue, String libelle, String codeIso) {
		super();
		this.idLangue = idLangue;
		this.libelle = libelle;
		this.codeIso = codeIso;
	}

	public Integer getIdLangue() {
		return idLangue;
	}

	public void setIdLangue(Integer idLangue) {
		this.idLangue = idLangue;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCodeIso() {
		return codeIso;
	}

	public void setCodeIso(String codeIso) {
		this.codeIso = codeIso;
	}

	public Set<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(Set<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

    
    

}