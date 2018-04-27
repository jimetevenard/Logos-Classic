package mongo.com.logos.evaluation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

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
		return null;
	}

	@Override
	public TestDeValidation updateTestValidation(TestDeValidation test) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTestValidation(TestDeValidation test) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TestDeValidation> getTestValidationByCours(Cours cours) {
		// TODO Auto-generated method stub
		return null;
	}

}
