package com.logos.business.connexion.impl;

import org.springframework.stereotype.Service;

import com.logos.business.connexion.api.IBusinessConnexionPlateforme;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;
import com.logos.entity.user.Utilisateur;

@Service
public class BusinessConnexionPlateforme implements IBusinessConnexionPlateforme {

	@Override
	public Eleve inscrireEleve(Eleve eleve) {
		return null;
	}

	@Override
	public Professeur inscrireProfesseur(Professeur professeur) {
		return null;
	}

	@Override
	public Utilisateur checkLoginPassword(String login, String mdp) {
		return null;
	}

}
