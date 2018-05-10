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

import com.logos.entity.evaluation.Exercice;
@Entity
@Table(name="chapitre")
@Document
public class Chapitre {

    @Id
    @org.springframework.data.annotation.Id
    @Column(name="id_chapitre")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idChapitre;

    @Column(name="contenu_chapitre", nullable=false, length=10000)
    private String contenu;

    @Column(name="titre_chapitre", nullable=false, length=100)
    private String titre;

    @ManyToMany(cascade = CascadeType.ALL)
   	@JoinTable(name = "chapitre_exercice", joinColumns = { 
   			@JoinColumn(name = "fk_chapitre") }, inverseJoinColumns = { @JoinColumn(name = "fk_exercice") })
    private List<Exercice> exercices;
    
    
    
    public Chapitre() {
    }
    
    
	public Chapitre(Integer idChapitre, String contenu, String titre) {
		super();
		this.idChapitre = idChapitre;
		this.contenu = contenu;
		this.titre = titre;
	}


	public Integer getIdChapitre() {
		return idChapitre;
	}

	public void setIdChapitre(Integer idChapitre) {
		this.idChapitre = idChapitre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Exercice> getExercices() {
		return exercices;
	}

	public void setExercices(List<Exercice> exercices) {
		this.exercices = exercices;
	}
    
    

}