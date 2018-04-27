package mongo.com.logos.evaluation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.cours.Cours;
import com.logos.entity.evaluation.Exercice;

import api.com.logos.data.evaluation.IDaoExercice;

public class DaoExercice implements IDaoExercice {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoExercice(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Exercice addExercice(Exercice exercice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exercice updateExercice(Exercice exercice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteExercice(Exercice exercice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Exercice> getExerciceByCours(Cours cours) {
		// TODO Auto-generated method stub
		return null;
	}

}
