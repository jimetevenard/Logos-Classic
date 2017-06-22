package com.logos.business.connexion.api;

import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;
import com.logos.entity.user.Utilisateur;

public interface IBusinessConnexionPlateforme {
	Eleve inscrireEleve(Eleve eleve);
	Professeur inscrireProfesseur(Professeur professeur);
	Utilisateur checkLoginPassword(String login, String mdp);
	
}
