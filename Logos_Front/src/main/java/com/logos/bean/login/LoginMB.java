package com.logos.bean.login;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.logos.entity.user.Utilisateur;

@ManagedBean
@SessionScoped
public class LoginMB {
	
	@ManagedProperty(value="{BusinessInscriptionPlateforme}")
	private IBusinessConnexionPlateforme bu;
	
	private String login;
	private String password;
	private Utilisateur userConnected;
	
	public String SeConnecter(){
		userConnected= bu.checkLoginPassword(login, password);
		if(userConnected != null){
			return 
		}
		return null;
		
	}
}
