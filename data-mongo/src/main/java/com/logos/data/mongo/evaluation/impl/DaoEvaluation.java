package com.logos.data.mongo.evaluation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.logos.data.api.evaluation.IDaoEvaluation;
import com.logos.data.mongo.config.NextSequenceService;
import com.logos.entity.cours.Chapitre;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.user.Eleve;

@Repository
public class DaoEvaluation implements IDaoEvaluation {
	
	@Autowired
	MongoOperations mongoOps;
	
	@Autowired
	private NextSequenceService sequence;
	
	private static final String COLLECTION = "evaluation";
	
	public DaoEvaluation(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Evaluation addEvaluation(Evaluation evaluation) {
		evaluation.setIdEvaluation(sequence.getNextSequence(COLLECTION));
		mongoOps.insert(evaluation);
		return evaluation;
	}

	@Override
	public Evaluation updateEvaluation(Evaluation evaluation) {
		Query query = new Query(Criteria.where("_id").is(evaluation.getIdEvaluation()));
		Evaluation eval = mongoOps.findAndModify(query, new Update(), Evaluation.class);
		return eval;
	}

	@Override
	public boolean deleteEvaluation(Evaluation evaluation) {
		mongoOps.remove(evaluation);
		return false;
	}

	@Override
	public List<Evaluation> getEvaluationByEleve(Eleve eleve) {
		List<Evaluation> evaluations = new ArrayList<>();
		
		Query query = new Query(Criteria.where("realiseEvaluations.evaluation").exists(true).andOperator(Criteria.where("_id").is(eleve.getIdUtilisateur())));
		Eleve eleveFound = mongoOps.findOne(query, Eleve.class);
		Set<RealiseEvaluation> realise = eleveFound.getRealisationEvaluations();
		for (RealiseEvaluation realiseEvaluation : realise) {
			evaluations.add(realiseEvaluation.getEvaluation());
		}
		return evaluations;
	}

	@Override
	public List<Evaluation> getEvaluationsByChapitre(Chapitre chapitre) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

}
