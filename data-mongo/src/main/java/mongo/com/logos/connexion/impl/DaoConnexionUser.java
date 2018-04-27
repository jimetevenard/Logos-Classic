package mongo.com.logos.connexion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.user.Utilisateur;

import api.com.logos.data.connexion.IDaoConnexionUser;

public class DaoConnexionUser implements IDaoConnexionUser {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoConnexionUser(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Utilisateur checkLoginPassword(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
