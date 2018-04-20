package com.logos.entity.evaluation;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.logos.entity.reponse.ReponseOuverteEleve;
import com.logos.entity.user.Professeur;

/**
 * 
 */
@Entity
@Table(name="correction")
public class Correction {

	/**
	 * 
	 */
	@Id
	@Column(name="id_correction")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCorrection;

	/**
	 * 
	 */
	@Column(name="corrige_correction", nullable=false, length=1000)
	private String corrige;

	/**
	 * 
	 */
	@Column(name="note_correction")
	private int note;

	/**
	 * 
	 */
	@Column(name="date_correction")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCorrection;

	/**
	 * 
	 */
	@ManyToOne
    @JoinColumn(name = "id_professeur", foreignKey = @ForeignKey(name = "fk_professeur_correction"))
	private Professeur professeur;

	/**
	 * 
	 */
	@OneToOne(mappedBy="correction")
	private ReponseOuverteEleve reponseOuverteEleve;

	/**
	 * Default constructor
	 */
	public Correction() {
	}

	public Correction(Integer idCorrection, String corrige, int note, Date dateCorrection, Professeur professeur,
			ReponseOuverteEleve reponseOuverteEleve) {
		super();
		this.idCorrection = idCorrection;
		this.corrige = corrige;
		this.note = note;
		this.dateCorrection = dateCorrection;
		this.professeur = professeur;
		this.reponseOuverteEleve = reponseOuverteEleve;
	}

	public Integer getIdCorrection() {
		return idCorrection;
	}

	public void setIdCorrection(Integer idCorrection) {
		this.idCorrection = idCorrection;
	}

	public String getCorrige() {
		return corrige;
	}

	public void setCorrige(String corrige) {
		this.corrige = corrige;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Date getDateCorrection() {
		return dateCorrection;
	}

	public void setDateCorrection(Date dateCorrection) {
		this.dateCorrection = dateCorrection;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public ReponseOuverteEleve getReponseOuverteEleve() {
		return reponseOuverteEleve;
	}

	public void setReponseOuverteEleve(ReponseOuverteEleve reponseOuverteEleve) {
		this.reponseOuverteEleve = reponseOuverteEleve;
	}
	
	

}