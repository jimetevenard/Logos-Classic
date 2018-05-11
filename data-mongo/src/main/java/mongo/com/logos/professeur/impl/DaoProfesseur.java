package mongo.com.logos.professeur.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.logos.entity.user.Professeur;

import api.com.logos.data.professeur.IDaoProfesseur;
import mongo.com.logos.config.NextSequenceService;

@Repository
public class DaoProfesseur implements IDaoProfesseur {
	
	@Autowired
	MongoOperations mongoOps;
	
	@Autowired
	private NextSequenceService sequence;
	
	private static final String COLLECTION = "professeur";
	
	public DaoProfesseur(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Professeur ajouterProf(Professeur prof) {
		prof.setIdUtilisateur(sequence.getNextSequence(COLLECTION));
		mongoOps.insert(prof);
		return prof;
	}

	@Override
	public Professeur getProfById(Integer id) {
		// TODO Auto-generated method stub
		return mongoOps.findById(id, Professeur.class);
	}

	@Override
	public Professeur updateProf(Professeur prof) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public boolean deleteProf(Professeur prof) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public List<Professeur> getAllProf() {
		// TODO Auto-generated method stub
		return mongoOps.findAll(Professeur.class);
	}

}
