package com.logos.rest.utilisateur;

import java.util.HashMap;

import javax.enterprise.inject.Instance;

public class ConnexionsActives extends HashMap<String, RestLoginBean>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ConnexionsActives instance;
	
	private ConnexionsActives(){
		// no constroctor
	}
	
	public static ConnexionsActives getInstance(){
		if(instance == null){
			instance = new ConnexionsActives();
		}
		return instance;
	}

}
