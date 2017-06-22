package com.logos.front.connexion;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpSession;

import com.logos.business.connexion.api.IBusinessConnexionPlateforme;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;
import com.logos.entity.user.Utilisateur;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{businessConnexionPlateforme}")
	private IBusinessConnexionPlateforme bu;
	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;

	private String login;
	private String password;
	private Utilisateur userConnected;
	private boolean isLoggedIn;

	public String seConnecter(){
		userConnected = bu.checkLoginPassword(login, password);
		System.out.println("je me connecte en tant que "+userConnected.getLogin());
		if(userConnected != null && isEleve()){
			isLoggedIn=true;
			return navigationBean.redirectToAccueilEleve();
		}else{
			if(userConnected != null){
				isLoggedIn=true;
				return navigationBean.redirectToAccueilProfesseur();
			}
		}
		return navigationBean.redirectToLogin();
	}

	public String seDeconnecter(){
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return navigationBean.redirectToLogin();

	}

	public boolean isEleve(){
		if(userConnected.getClass().equals(Eleve.class)){
			return true;
		}
		return false;
	}
	
	public boolean isProfesseur(){
		if(userConnected.getClass().equals(Professeur.class)){
			return true;
		}
		return false;
	}

//	public void verifierConnectedEleve(ComponentSystemEvent event){
//		System.out.println("je vérifie que c'est un éleve");
//		FacesContext fc = FacesContext.getCurrentInstance();
//		userConnected = bu.checkLoginPassword(login, password);
//		System.out.println("je me connecte en tant que "+userConnected.getLogin());
//		if (userConnected == null || !isEleve()){
//			if(userConnected == null) System.out.println("userConnected est nulll");
//			System.out.println("j'ai vérifié, c'est pas un éleve");
//			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)fc.getApplication().getNavigationHandler();
//			nav.performNavigation("login.xhtml?faces-redirect=true");
//		}
//	}
//	public void verifierConnectedProfesseur(ComponentSystemEvent event){
//		FacesContext fc = FacesContext.getCurrentInstance();
//		if (userConnected == null || !isProfesseur()){
//			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)fc.getApplication().getNavigationHandler();
//			nav.performNavigation("login.xhtml?faces-redirect=true");
//		}
//	}

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

	public Utilisateur getUserConnected() {
		return userConnected;
	}

	public void setUserConnected(Utilisateur userConnected) {
		this.userConnected = userConnected;
	}

	public IBusinessConnexionPlateforme getBu() {
		return bu;
	}

	public void setBu(IBusinessConnexionPlateforme bu) {
		this.bu = bu;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}



}
