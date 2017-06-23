package com.logos.front.inscription.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.hibernate.exception.ConstraintViolationException;

import com.logos.business.connexion.api.IBusinessConnexionPlateforme;
import com.logos.entity.user.Eleve;
import com.logos.front.connexion.LoginMB;

@ManagedBean(name="mbInscription")
@SessionScoped
public class InsciptionManagedBean {
	@ManagedProperty(value="#{businessConnexionPlateforme}")
	private IBusinessConnexionPlateforme bu;
	
	@ManagedProperty(value="#{loginMB}")
	private LoginMB logMb;
	
	private String nom;
	private String prenom;
	private String mail;
	private String password;
	private String password2;
	private String login;
	private String violationMailLogin;
	
	public String ajouterEleve(){
		String redirect = null;
		Eleve eleve = null;
		try{
			System.out.println("passes tu là ?");
			eleve = new Eleve(null, nom, prenom, login, password, mail);
			bu.inscrireEleve(eleve);		
		} catch (ConstraintViolationException e) {
			violationMailLogin = "Mail ou login déjà utilisé";
		} catch (Exception e2) {
			// TODO: autre erreur
		} finally {
			System.out.println(logMb == null);
			logMb.setUserConnected(eleve);
			System.out.println("après");
			logMb.setLoggedIn(true);
			
			redirect = "/accueil_eleve.xhtml?faces-redirect=true";
		}
		return redirect;
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

	public String getViolationMailLogin() {
		return violationMailLogin;
	}

	public void setViolationMailLogin(String violationMailLogin) {
		this.violationMailLogin = violationMailLogin;
	}

	public LoginMB getLogMb() {
		return logMb;
	}

	public void setLogMb(LoginMB logMb) {
		this.logMb = logMb;
	}
	
	
	
	

}
