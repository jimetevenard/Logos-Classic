package com.logos.data.mongo.niveauLangue.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.logos.data.api.niveauLangue.IDaoNiveau;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Niveau;

@Repository
public class DaoNiveau implements IDaoNiveau {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoNiveau(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Niveau getNiveauById(Integer Id) {
		// TODO Auto-generated method stub
		return mongoOps.findById(Id, Niveau.class);
	}

	@Override
	public List<Niveau> getAllNiveaux() {
		// TODO Auto-generated method stub
		return mongoOps.findAll(Niveau.class);
	}

	@Override
	public Niveau addNiveau(Niveau niveau) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public Niveau updateNiveau(Cours niveau) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public boolean deleteNiveau(Niveau niveau) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

}
