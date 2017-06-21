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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.logos.entity.user.Eleve;

/**
 * 
 */
@Entity
@Table(name="suivi_cours")
public class SuiviCours {

  
   

    /**
     * 
     */
	@Id
	@Column(name="id_suivi_cours")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSuiviCours;

    /**
     * 
     */
	@Column(name="date_inscription", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date dateInscription;

    /**
     * 
     */
	@Column(name="note_cours")
    private Integer noteCours;

    /**
     * 
     */
	@Column(name="commentaire", length=1000)
    private String commentaire;

    /**
     * 
     */
	@Column(name="date_fin_suivi", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date dateFinSuivi;

    /**
     * 
     */
	@Column(name="acquis", columnDefinition="TINYINT(1)")
    private boolean acquis;

    /**
     * 
     */
	 @ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "suivi_cours_chapitre", joinColumns = { 
				@JoinColumn(name = "fk_suivi_cours") }, inverseJoinColumns = { @JoinColumn(name = "fk_chapitre") })
    private Set<Chapitre> chapitresLus;

    /**
     * 
     */
	 @ManyToOne
	    @JoinColumn(name = "id_eleve", foreignKey = @ForeignKey(name = "fk_suivi_cours_eleve"))
    private Eleve eleve;

    /**
     * 
     */
	 @ManyToOne
	    @JoinColumn(name = "id_cours", foreignKey = @ForeignKey(name = "fk_suivi_cours_cours"))
    private Cours cours;
    
    public SuiviCours() {
    }

	public SuiviCours(Integer idSuiviCours, Date dateInscription, Eleve eleve, Cours cours) {
		super();
		this.idSuiviCours = idSuiviCours;
		this.dateInscription = dateInscription;
		this.eleve = eleve;
		this.cours = cours;
	}

	public Integer getIdSuiviCours() {
		return idSuiviCours;
	}

	public void setIdSuiviCours(Integer idSuiviCours) {
		this.idSuiviCours = idSuiviCours;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Integer getNoteCours() {
		return noteCours;
	}

	public void setNoteCours(Integer noteCours) {
		this.noteCours = noteCours;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDateFinSuivi() {
		return dateFinSuivi;
	}

	public void setDateFinSuivi(Date dateFinSuivi) {
		this.dateFinSuivi = dateFinSuivi;
	}

	public boolean isAcquis() {
		return acquis;
	}

	public void setAcquis(boolean acquis) {
		this.acquis = acquis;
	}

	public Set<Chapitre> getChapitresLus() {
		return chapitresLus;
	}

	public void setChapitresLus(Set<Chapitre> chapitresLus) {
		this.chapitresLus = chapitresLus;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}
    
    

}