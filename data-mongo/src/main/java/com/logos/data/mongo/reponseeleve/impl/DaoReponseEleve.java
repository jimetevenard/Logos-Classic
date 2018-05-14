package com.logos.data.mongo.reponseeleve.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.data.api.reponseeleve.IDaoReponseEleve;
import com.logos.data.mongo.config.NextSequenceService;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.reponse.ReponseATrousEleve;
import com.logos.entity.reponse.ReponseDragAndDropEleve;
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.reponse.ReponseOuverteEleve;
import com.logos.entity.reponse.ReponseQcmEleve;
import com.logos.entity.user.Eleve;

public class DaoReponseEleve implements IDaoReponseEleve {
	
	@Autowired
	MongoOperations mongoOps;
	
	@Autowired
	private NextSequenceService sequence;
	
	private static final String COLLECTION = "reponseEleve";
	
	public DaoReponseEleve(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public ReponseEleve getReponseById(Integer id) {
		// TODO Auto-generated method stub
		return mongoOps.findById(id, ReponseEleve.class);
	}

	@Override
	public List<ReponseEleve> getReponseByEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public ReponseEleve addReponseEleve(ReponseEleve reponse) {
		reponse.setIdReponse(sequence.getNextSequence(COLLECTION));
		mongoOps.insert(reponse);
		return reponse;
	}

	@Override
	public ReponseEleve updateReponse(ReponseEleve reponse) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public boolean deleteReponse(ReponseEleve reponse) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public ReponseOuverteEleve getReponseOuverteById(Integer id) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public ReponseQcmEleve getReponseQcmById(Integer id) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public ReponseATrousEleve getReponseATrousById(Integer id) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public ReponseDragAndDropEleve getReponseDragDropById(Integer id) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public List<ReponseEleve> getReponseByEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public List<ReponseEleve> getReponseByRealiseEvaluation(RealiseEvaluation realiseEval) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

}
