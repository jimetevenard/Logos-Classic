package com.logos.data.api.connexion;

import com.logos.entity.user.Utilisateur;

public interface IDaoConnexionUser {

	Utilisateur checkLoginPassword(String login, String password);
}
