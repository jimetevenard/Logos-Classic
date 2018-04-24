package com.logos.data.connexion.api;

import com.logos.entity.user.Utilisateur;

public interface IDaoConnexionUser {

	Utilisateur checkLoginPassword(String login, String password);
}
