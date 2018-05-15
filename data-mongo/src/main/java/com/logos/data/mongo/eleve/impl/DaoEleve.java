package com.logos.data.mongo.eleve.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.logos.data.api.eleve.IDaoEleve;
import com.logos.data.mongo.config.NextSequenceService;
import com.logos.entity.question.Question;
import com.logos.entity.user.Eleve;

@Repository
public class DaoEleve implements IDaoEleve {
	
	@Autowired
	MongoOperations mongoOps;
	
	@Autowired
	private NextSequenceService sequence;
	
	//private static final String COLLECTION = "eleve";
	
	public DaoEleve(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Eleve ajouterEleve(Eleve eleve) {
		throw new RuntimeException("Méthode nom implémentée");
//		eleve.setIdUtilisateur(sequence.getNextSequence(COLLECTION));
//		mongoOps.insert(eleve);
//		return eleve;
	}

	@Override
	public Eleve getEleveById(Integer id) {
		return mongoOps.findById(id, Eleve.class);
	}
	

	@Override
	public Eleve updateEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public boolean deleteEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public List<Eleve> getAllEleve() {
		// TODO Auto-generated method stub
		return mongoOps.findAll(Eleve.class);
	}

}
