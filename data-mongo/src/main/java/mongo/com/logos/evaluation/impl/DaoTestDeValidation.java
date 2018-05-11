package mongo.com.logos.evaluation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.logos.entity.cours.Cours;
import com.logos.entity.evaluation.TestDeValidation;

import api.com.logos.data.evaluation.IDaoTestDeValidation;

public class DaoTestDeValidation implements IDaoTestDeValidation {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoTestDeValidation(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public TestDeValidation addTestValidation(TestDeValidation test) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public TestDeValidation updateTestValidation(TestDeValidation test) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public boolean deleteTestValidation(TestDeValidation test) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public List<TestDeValidation> getTestValidationByCours(Cours cours) {
		// TODO Auto-generated method stub
		Query q = new Query(Criteria.where("cours._id").is(cours.getIdCours()));
		return mongoOps.find(q, TestDeValidation.class);
	}

}
