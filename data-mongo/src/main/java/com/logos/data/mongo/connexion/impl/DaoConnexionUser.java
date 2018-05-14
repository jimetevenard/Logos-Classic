package com.logos.data.mongo.connexion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.logos.data.api.connexion.IDaoConnexionUser;
import com.logos.entity.user.Utilisateur;

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
