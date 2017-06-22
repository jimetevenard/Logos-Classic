package com.logos.front.inscription.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.logos.business.connexion.api.IBusinessConnexionPlateforme;
import com.logos.entity.user.Eleve;

@ManagedBean(name="mbInscription")
@ViewScoped
public class InsciptionManagedBean {
	@ManagedProperty(value="businessConnexionPlateforme")
	private IBusinessConnexionPlateforme bu;
	
	private String nom;
	private String prenom;
	private String mail;
	private String password;
	private String password2;
	private String login;
	
	public void ajouterEleve(){
		Eleve e = new Eleve(null, nom, prenom, login, password, mail);
		bu.inscrireEleve(e);
	}

	public IBusinessConnexionPlateforme getBu() {
		return bu;
	}

	public void setBu(IBusinessConnexionPlateforme bu) {
		this.bu = bu;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
	
	

}
