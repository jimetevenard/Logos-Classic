package com.logos.entity.messagerie;

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

import org.springframework.data.mongodb.core.mapping.Document;

import com.logos.entity.user.Utilisateur;

/**
 * 
 */
@Entity
@Table(name = "message")
@Document
public class Message {


    /**
     * 
     */
    @Id
    @org.springframework.data.annotation.Id
    @Column(name = "id_message")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idMessage;

    /**
     * 
     */
    @Column(name = "contenu_message")
    private String contenu;

    /**
     * 
     */
    @Column(name = "date_envoi_message")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateEnvoi;

    /**
     * 
     */
    @Column(name = "date_lecture_message")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLecture;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name = "id_conversation", foreignKey = @ForeignKey(name = "fk_conversation_message"))
    private Conversation conversation;
    
    @OneToOne
    @JoinColumn(name = "id_auteur_message", foreignKey = @ForeignKey(name = "fk_auteur_message"))
    private Utilisateur auteur;
    
    
    /**
     * Default constructor
     */
    public Message() {
    }


	public Message(Integer idMessage, String contenu) {
		super();
		this.idMessage = idMessage;
		this.contenu = contenu;
	}


	public Integer getIdMessage() {
		return idMessage;
	}


	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}


	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	public java.util.Date getDateEnvoi() {
		return dateEnvoi;
	}


	public void setDateEnvoi(java.util.Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}


	public Date getDateLecture() {
		return dateLecture;
	}


	public void setDateLecture(Date dateLecture) {
		this.dateLecture = dateLecture;
	}


	public Conversation getConversation() {
		return conversation;
	}


	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}


	public Utilisateur getAuteur() {
		return auteur;
	}


	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
	
	
    
    

}