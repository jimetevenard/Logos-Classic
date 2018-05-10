package com.logos.entity.cours;

import java.util.*;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.gson.annotations.SerializedName;
import com.logos.entity.evaluation.TestDeValidation;
import com.logos.entity.user.Professeur;

@Entity
@Table(name="cours")
@Document(collection="cours")
public class Cours {

	@Id
	@javax.persistence.Id
	@SerializedName("_id")
	//@Column(name="id_cours")
	//@GeneratedValue(strategy=GenerationType.IDENTITY, generator= "uuid")
    private Integer idCours;

   // @Column(name="titre_cours", nullable=false, length=100)
    private String titre;

    //@Column(name="introduction_cours", nullable=false, length=1000)
    private String introduction;

   // @Column(name="dateCreation_cours", nullable=false)
    //@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateCreation;

   // @Column(name="dateMiseAJour_cours", nullable=false)
    //@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateMiseAJour;

    @ManyToOne
    @JoinColumn(name = "id_auteur", foreignKey = @ForeignKey(name = "fk_auteur_cours"))
    private Professeur auteur;

    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cours_professeur", joinColumns = { 
			@JoinColumn(name = "fk_cours_supervise") }, inverseJoinColumns = { @JoinColumn(name = "fk_professeur_superviseur") })
    private Set<Professeur> superviseurs;

    @ManyToOne
    @JoinColumn(name = "id_niveau", foreignKey = @ForeignKey(name = "fk_niveau_cours"))
    private Niveau niveau;

    @ManyToMany(mappedBy = "courses")
    private Set<Categorie> categories;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_cours", foreignKey = @ForeignKey(name="fk_cours_chapitre"))
    private List<Chapitre> chapitres;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cours")
    private TestDeValidation testDeValidation;

    @OneToMany(mappedBy = "cours")
    private Set<SuiviCours> suiviCours;
    
    public Cours() {
    }

	public Cours(Integer idCours, String titre, String introduction, Date dateCreation, Date dateMiseAJour,
			Professeur auteur, TestDeValidation testDeValidation) {
		super();
		this.idCours = idCours;
		this.titre = titre;
		this.introduction = introduction;
		this.dateCreation = dateCreation;
		this.dateMiseAJour = dateMiseAJour;
		this.auteur = auteur;
		this.testDeValidation = testDeValidation;
	}
	
	
	

	public Cours(Integer idCours, String titre, String introduction) {
		super();
		this.idCours = idCours;
		this.titre = titre;
		this.introduction = introduction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCours == null) ? 0 : idCours.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cours other = (Cours) obj;
		if (idCours == null) {
			if (other.idCours != null)
				return false;
		} else if (!idCours.equals(other.idCours))
			return false;
		return true;
	}

	public Integer getIdCours() {
		return idCours;
	}

	public void setIdCours(Integer idCours) {
		this.idCours = idCours;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public java.util.Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(java.util.Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public java.util.Date getDateMiseAJour() {
		return dateMiseAJour;
	}

	public void setDateMiseAJour(java.util.Date dateMiseAJour) {
		this.dateMiseAJour = dateMiseAJour;
	}

	public Professeur getAuteur() {
		return auteur;
	}

	public void setAuteur(Professeur auteur) {
		this.auteur = auteur;
	}

	public Set<Professeur> getSuperviseurs() {
		return superviseurs;
	}

	public void setSuperviseurs(Set<Professeur> superviseurs) {
		this.superviseurs = superviseurs;
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

	public List<Chapitre> getChapitres() {
		return chapitres;
	}

	public void setChapitres(List<Chapitre> chapitres) {
		this.chapitres = chapitres;
	}

	public TestDeValidation getTestDeValidation() {
		return testDeValidation;
	}

	public void setTestDeValidation(TestDeValidation testDeValidation) {
		this.testDeValidation = testDeValidation;
	}

	public Set<SuiviCours> getSuiviCours() {
		return suiviCours;
	}

	public void setSuiviCours(Set<SuiviCours> suiviCours) {
		this.suiviCours = suiviCours;
	}

	@Override
	public String toString() {
		return "Cours [idCours=" + idCours + ", titre=" + titre + ", introduction=" + introduction + "]";
	}
	
	

    
}