package mongo.com.logos.evaluation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Niveau;
import com.logos.entity.evaluation.TestDeNiveau;

import api.com.logos.data.evaluation.IDaoTestDeNiveau;

public class DaoTestDeNiveau implements IDaoTestDeNiveau {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoTestDeNiveau(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public TestDeNiveau addTestDeNiveau(TestDeNiveau testNiveau) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TestDeNiveau updateTestDeNiveau(TestDeNiveau testNiveau) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTestDeNiveau(TestDeNiveau testNiveau) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TestDeNiveau> getTestNiveauByNiveau(Niveau niveau) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestDeNiveau> getTestNiveauByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}

}
