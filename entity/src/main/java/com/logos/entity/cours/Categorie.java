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

import com.logos.entity.evaluation.TestDeNiveau;

@Entity
@Table(name="categorie")
@Document
public class Categorie {

	@Id
	@Column(name="id_categorie")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCategorie;

	@Column(name="titre_categorie", nullable=false, length=50)
	private String titre;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "categorie_cours", joinColumns = { 
			@JoinColumn(name = "fk_categorie") }, inverseJoinColumns = { @JoinColumn(name = "fk_cours") })
	private Set<Cours> courses;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "categorie_testNiveau", joinColumns = { 
			@JoinColumn(name = "fk_categorie") }, inverseJoinColumns = { @JoinColumn(name = "fk_testNiveau") })
	private Set<TestDeNiveau> testNiveau;

	public Categorie() {
	}

	public Categorie(Integer idCategorie, String titre) {
		super();
		this.idCategorie = idCategorie;
		this.titre = titre;
	}

	public Integer getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Set<Cours> getCourses() {
		return courses;
	}

	public void setCourses(Set<Cours> courses) {
		this.courses = courses;
	}

	public Set<TestDeNiveau> getTestNiveau() {
		return testNiveau;
	}

	public void setTestNiveau(Set<TestDeNiveau> testNiveau) {
		this.testNiveau = testNiveau;
	}
	
	

}