package mongo.com.logos.connexion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.logos.entity.user.Utilisateur;

import api.com.logos.data.connexion.IDaoConnexionUser;

@Repository
public class DaoConnexionUser implements IDaoConnexionUser {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoConnexionUser(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Utilisateur checkLoginPassword(String login, String password) {
		Query query = new Query(Criteria.where("login").is(login).andOperator(Criteria.where("password").is(password)));
		return mongoOps.findOne(query, Utilisateur.class);
	}

}
