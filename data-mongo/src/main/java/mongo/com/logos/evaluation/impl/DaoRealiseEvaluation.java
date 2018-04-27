package mongo.com.logos.evaluation.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.user.Eleve;

import api.com.logos.data.evaluation.IDaoRealiseEvaluation;

public class DaoRealiseEvaluation implements IDaoRealiseEvaluation {
	@Autowired
	MongoOperations mongoOps;
	
	public DaoRealiseEvaluation(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Set<RealiseEvaluation> getRealiseEvaluationByEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RealiseEvaluation addRealiseEvaluation(RealiseEvaluation realiseEvaluation) {
		// TODO Auto-generated method stub
		return null;
	}

}
