package com.logos.rest;

/**
 * Juste un bean pour tester le service REST, 
 * il représente un message avec un titre et un contenu.
 * 
 * @author jetevenard
 *
 */
public class TestServiceBean {
	
	
	private String titre;
	private String message;
	
	
	public TestServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestServiceBean(String titre, String message) {
		super();
		this.titre = titre;
		this.message = message;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
