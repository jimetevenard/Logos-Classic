package com.logos.front.connexion;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.logos.business.connexion.api.IBusinessConnexionPlateforme;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Utilisateur;

@ManagedBean
@SessionScoped
public class LoginMB {
	
	@ManagedProperty(value="{BusinessInscriptionPlateforme}")
	private IBusinessConnexionPlateforme bu;
	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;
	
	private String login;
	private String password;
	private Utilisateur userConnected;
	
	public String SeConnecter(){
		userConnected= bu.checkLoginPassword(login, password);
		if(userConnected != null && isEleve()){
			return navigationBean.redirectToAccueilEleve();
		}else{
			if(userConnected != null){
				return navigationBean.redirectToAccueilProfesseur();
			}
		}
		return navigationBean.redirectToLogin();
	}
	
	public String SeDeconnecter(){
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
	
	
	
}
