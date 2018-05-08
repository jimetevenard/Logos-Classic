package mongo.com.logos.evaluation.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.logos.entity.cours.Chapitre;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.user.Eleve;

import api.com.logos.data.evaluation.IDaoEvaluation;

@Repository
public class DaoEvaluation implements IDaoEvaluation {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoEvaluation(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Evaluation addEvaluation(Evaluation evaluation) {
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
		List<Eleve> eleves = new ArrayList<>();
		Query query = new Query(Criteria.where("evaluation").exists(true).andOperator(Criteria.where("_id").is(eleve.getIdUtilisateur())));
		eleves = mongoOps.find(query, Eleve.class);
		
		return null;
	}

	@Override
	public List<Evaluation> getEvaluationsByChapitre(Chapitre chapitre) {
		// TODO Auto-generated method stub
		return null;
	}

}
