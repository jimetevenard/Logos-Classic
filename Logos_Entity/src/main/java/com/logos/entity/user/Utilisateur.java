package com.logos.entity.user;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.logos.entity.messagerie.Conversation;


/**
 * 
 */
@Entity
@Table(name= "utilisateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_utilisateur")
public class Utilisateur {

    
   

    /**
     * 
     */
    @Id
	@Column(name = "id_utilisateur")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUtilisateur;

    /**
     * 
     */
	@Column(name = "nom_utilisateur", length = 50)
    private String nom;

    /**
     * 
     */
	@Column(name = "prenom_utilisateur", length = 50)
    private String prenom;

    /**
     * 
     */
	@Column(name = "login_utilisateur", nullable = false, length = 50)
    private String login;

    /**
     * 
     */
	@Column(name = "password_utilisateur", nullable = false, length = 50)
    private String password;

    /**
     * 
     */
	@Column(name = "mail_utilisateur", nullable = false, length = 150)
    private String mail;

    /**
     * 
     */
	@Column(name = "photo_utilisateur", length = 250)
    private String photoUrl;

    /**
     * 
     */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "utilisateur_conversation", joinColumns = { 
			@JoinColumn(name = "fk_utilisateur") }, inverseJoinColumns = { @JoinColumn(name = "fk_conversation") })
    private Set<Conversation> conversations;
	
	 public Utilisateur() {
	    }

	public Utilisateur(Integer idUtilisateur, String nom, String prenom, String login, String password, String mail) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.mail = mail;
	}

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Set<Conversation> getConversations() {
		return conversations;
	}

	public void setConversations(Set<Conversation> conversations) {
		this.conversations = conversations;
	}
	 
	 

}