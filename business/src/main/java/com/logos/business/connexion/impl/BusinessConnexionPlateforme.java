package com.logos.business.connexion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logos.business.connexion.api.IBusinessConnexionPlateforme;
import com.logos.data.api.connexion.IDaoConnexionUser;
import com.logos.data.api.eleve.IDaoEleve;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;
import com.logos.entity.user.Utilisateur;

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
