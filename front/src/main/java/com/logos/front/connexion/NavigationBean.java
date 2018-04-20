package com.logos.front.connexion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationBean {
	
	public final String linkBoutique = "http://www.jimetevenard.com/tmp/logos/logos-redirect.php?page=boutique";
	public final String linkPremium = "http://www.jimetevenard.com/tmp/logos/logos-redirect.php?page=premium";
	
	
	public String redirectToAccueilEleve(){
		
		return "/suivi_eleve.xhtml?faces-redirect=true";
	}
	
	public String redirectToAccueilProfesseur(){
		return "/accueil_professeur.xhtml?faces-redirect=true";
	}
	
	public String redirectToLogin(){
		return "/login.xhtml?faces-redirect=true";
	}

	public String getLinkBoutique() {
		return linkBoutique;
	}

	public String getLinkPremium() {
		return linkPremium;
	}
	
	

}
