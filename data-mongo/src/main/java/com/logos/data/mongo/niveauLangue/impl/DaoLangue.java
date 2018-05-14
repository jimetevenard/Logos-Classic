package com.logos.data.mongo.niveauLangue.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.data.api.niveauLangue.IDaoLangues;
import com.logos.entity.cours.Langue;

public class DaoLangue implements IDaoLangues {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoLangue(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Langue getLangueById(Integer Id) {
		// TODO Auto-generated method stub
		return mongoOps.findById(Id, Langue.class);
	}

	@Override
	public List<Langue> getAllLangues() {
		// TODO Auto-generated method stub
		return mongoOps.findAll(Langue.class);
	}

	@Override
	public Langue addLangue(Langue langue) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public boolean deleteLangue(Langue langue) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public Langue updateLangue(Langue langue) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

}
