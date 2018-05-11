package mongo.com.logos.evaluation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.logos.entity.cours.Cours;
import com.logos.entity.evaluation.Exercice;

import api.com.logos.data.evaluation.IDaoExercice;

@Repository
public class DaoExercice implements IDaoExercice {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoExercice(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Exercice addExercice(Exercice exercice) {
		mongoOps.insert(exercice);
		return exercice;
	}

	@Override
	public Exercice updateExercice(Exercice exercice) {
		Query query = new Query(Criteria.where("_id").is(exercice.getIdEvaluation()));
		Exercice exerciceUpdated = mongoOps.findAndModify(query, new Update(), Exercice.class);
		return exerciceUpdated;
	}

	@Override
	public boolean deleteExercice(Exercice exercice) {
		mongoOps.remove(exercice);
		return false;
	}

	@Override
	public List<Exercice> getExerciceByCours(Cours cours) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

}
