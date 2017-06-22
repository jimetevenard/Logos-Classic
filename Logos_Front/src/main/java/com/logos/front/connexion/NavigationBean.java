package com.logos.front.connexion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationBean {
	
	public String redirectToAccueilEleve(){
		return "/accueil_eleve.xhtml";
	}
	
	public String redirectToAccueilProfesseur(){
		return "/accueil_professeur.xhtml";
	}
	
	public String redirectToLogin(){
		return "/login.xhtml";
	}

}
