package mongo.com.logos.professeur.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.logos.entity.user.Professeur;

import api.com.logos.data.professeur.IDaoProfesseur;

@Repository
public class DaoProfesseur implements IDaoProfesseur {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoProfesseur(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Professeur ajouterProf(Professeur prof) {
		mongoOps.insert(prof);
		return prof;
	}

	@Override
	public Professeur getProfById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professeur updateProf(Professeur prof) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProf(Professeur prof) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Professeur> getAllProf() {
		// TODO Auto-generated method stub
		return null;
	}

}
