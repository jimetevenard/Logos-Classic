package mongo.com.logos.evaluation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.cours.Chapitre;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.user.Eleve;

import api.com.logos.data.evaluation.IDaoEvaluation;

public class DaoEvaluation implements IDaoEvaluation {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoEvaluation(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Evaluation addEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evaluation updateEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Evaluation> getEvaluationByEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evaluation> getEvaluationsByChapitre(Chapitre chapitre) {
		// TODO Auto-generated method stub
		return null;
	}

}
