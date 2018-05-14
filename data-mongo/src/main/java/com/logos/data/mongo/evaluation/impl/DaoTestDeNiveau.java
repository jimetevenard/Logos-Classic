package com.logos.data.mongo.evaluation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.logos.data.api.evaluation.IDaoTestDeNiveau;
import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Niveau;
import com.logos.entity.evaluation.TestDeNiveau;

@Repository
public class DaoTestDeNiveau implements IDaoTestDeNiveau {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoTestDeNiveau(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public TestDeNiveau addTestDeNiveau(TestDeNiveau testNiveau) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public TestDeNiveau updateTestDeNiveau(TestDeNiveau testNiveau) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public boolean deleteTestDeNiveau(TestDeNiveau testNiveau) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public List<TestDeNiveau> getTestNiveauByNiveau(Niveau niveau) {
		// TODO Auto-generated method stub
		Query q = new Query(Criteria.where("niveau._id").is(niveau.getIdNiveau()));
		return mongoOps.find(q, TestDeNiveau.class);
	}

	@Override
	public List<TestDeNiveau> getTestNiveauByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

}
