package com.logos.entity.messagerie;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

import com.logos.entity.user.Utilisateur;

/**
 * 
 */
@Entity
@Table(name="conversation")
@Document
public class Conversation {

   

    /**
     * 
     */
    @Id
    @org.springframework.data.annotation.Id
    @Column(name = "id_conversation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConversation;

    /**
     * 
     */
    @Column(name = "titre_conversation")
    private String titre;

    /**
     * 
     */
    @ManyToMany(mappedBy = "conversations")
    private Set<Utilisateur> utilisateurs;

    /**
     * 
     */
    @OneToMany(mappedBy = "conversation")
    private Set<Message> messages;
    
    /**
     * Default constructor
     */
    public Conversation() {
    }

	public Conversation(Integer idConversation, String titre) {
		super();
		this.idConversation = idConversation;
		this.titre = titre;
	}

	public Integer getIdConversation() {
		return idConversation;
	}

	public void setIdConversation(Integer idConversation) {
		this.idConversation = idConversation;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
    
    

}