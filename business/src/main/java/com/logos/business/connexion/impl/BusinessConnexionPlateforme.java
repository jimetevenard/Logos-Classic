package com.logos.business.connexion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logos.business.connexion.api.IBusinessConnexionPlateforme;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;
import com.logos.entity.user.Utilisateur;

import api.com.logos.data.connexion.IDaoConnexionUser;
import api.com.logos.data.eleve.IDaoEleve;

@Service
public class BusinessConnexionPlateforme implements IBusinessConnexionPlateforme {
	@Autowired
	private IDaoConnexionUser daoConnexion;
	@Autowired
	private IDaoEleve daoEleve;
	
	@Override
	public Eleve inscrireEleve(Eleve eleve) {
		return daoEleve.ajouterEleve(eleve);
	}

	@Override
	public Professeur inscrireProfesseur(Professeur professeur) {
		return null;
	}

	@Override
	public Utilisateur checkLoginPassword(String login, String password) {
		return daoConnexion.checkLoginPassword(login, password);
	}

	@Override
	public Eleve refreshEleve(Eleve eleve) {
		
		return daoEleve.getEleveById(eleve.getIdUtilisateur());

	}
	
	

}
