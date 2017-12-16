package com.logos.rest.login;

import com.logos.entity.user.Utilisateur;

/**
 * Bean renvoyé au consommateur de service après une tentative de connexion
 * 
 * @author jetevenard
 *
 */
public class RestLoginBean {
	
	/**
	 * Vaut true si la connexion s'est bien passée
	 */
	private boolean ok;
	
	/**
	 * Le jeton associé à la connexion si Ok
	 */
	private String token;
	
	
	/**
	 * L'utilisateur qu'on transporte
	 * s
	 */
	private Utilisateur utilisateur;


	public boolean isOk() {
		return ok;
	}


	public void setOk(boolean ok) {
		this.ok = ok;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
