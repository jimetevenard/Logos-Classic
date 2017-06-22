package com.logos.front.connexion;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean
@SessionScoped
public class FiltreMB {
	
	@ManagedProperty(value="#{loginMB}")
	private LoginMB logMB;
	
	public void verifierConnectedEleve(ComponentSystemEvent event){
		System.out.println("je vérifie que c'est un éleve");
		FacesContext fc = FacesContext.getCurrentInstance();
		if (logMB.getUserConnected() == null || !logMB.isEleve()){
			if(logMB.getUserConnected() == null) System.out.println("userConnected est nulll");
			System.out.println("j'ai vérifié, c'est pas un éleve");
			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)fc.getApplication().getNavigationHandler();
			nav.performNavigation("login.xhtml?faces-redirect=true");
		}
	}
	public void verifierConnectedProfesseur(ComponentSystemEvent event){
		FacesContext fc = FacesContext.getCurrentInstance();
		if (logMB.getUserConnected() == null || !logMB.isProfesseur()){
			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)fc.getApplication().getNavigationHandler();
			nav.performNavigation("login.xhtml?faces-redirect=true");
		}
	}
	public LoginMB getLogMB() {
		return logMB;
	}
	public void setLogMB(LoginMB logMB) {
		this.logMB = logMB;
	}
	
	
}
