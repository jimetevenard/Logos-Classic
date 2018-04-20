package com.logos.front.connexion;

import javax.annotation.PostConstruct;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class FiltreMB {
	
	@ManagedProperty(value="#{loginMB}")
	private LoginMB logMB;
	
	
	public void verifierConnectedEleve(){
		FacesContext fc = FacesContext.getCurrentInstance();
		if (logMB == null || logMB.getUserConnected() == null || !logMB.isEleve()){
			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)fc.getApplication().getNavigationHandler();
			nav.performNavigation("login.xhtml?faces-redirect=true");
		}
	}
	public void verifierConnectedProfesseur(){
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
