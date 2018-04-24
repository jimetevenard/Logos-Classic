package api.com.logos.data.connexion;

import com.logos.entity.user.Utilisateur;

public interface IDaoConnexionUser {

	Utilisateur checkLoginPassword(String login, String password);
}
