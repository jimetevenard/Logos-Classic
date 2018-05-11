package mongo.com.logos.evaluation.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.user.Eleve;

import api.com.logos.data.evaluation.IDaoRealiseEvaluation;

@Repository
public class DaoRealiseEvaluation implements IDaoRealiseEvaluation {
	@Autowired
	MongoOperations mongoOps;
	
	public DaoRealiseEvaluation(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<RealiseEvaluation> getRealiseEvaluationByEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		Query q = new Query(Criteria.where("eleve._id").is(eleve.getIdUtilisateur()));
		return (Set<RealiseEvaluation>) mongoOps.find(q, RealiseEvaluation.class);
	}

	@Override
	public RealiseEvaluation addRealiseEvaluation(RealiseEvaluation realiseEvaluation) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

}
