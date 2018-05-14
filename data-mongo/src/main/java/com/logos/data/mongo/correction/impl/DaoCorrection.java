package com.logos.data.mongo.correction.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.logos.data.api.correction.IDaoCorrection;
import com.logos.entity.evaluation.Correction;
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;

@Repository
public class DaoCorrection implements IDaoCorrection {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoCorrection(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public List<Correction> getAllCorrections() {
		// TODO Auto-generated method stub
		return mongoOps.findAll(Correction.class);
	}

	@Override
	public Correction getCorrectionById(Integer id) {
		// TODO Auto-generated method stub
		return mongoOps.findById(id, Correction.class);
	}

	@Override
	public Correction addCorrection(Correction correction) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public Correction updateCorrection(Correction correction) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public boolean deleteCorrection(Correction correction) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public Correction getCorrectionByReponse(ReponseEleve reponse) {
		// TODO Auto-generated method stub
		Query query = new Query(Criteria.where("_id").is(reponse.getIdReponse()));
		ReponseEleve rep = mongoOps.findOne(query, ReponseEleve.class);
		return null;
	}

	@Override
	public List<Correction> getCorrectionByProfesseur(Professeur professeur) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public List<Correction> getCorrectionByEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

}
