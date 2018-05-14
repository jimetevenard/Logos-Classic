package com.logos.data.mongo.cours.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.logos.data.api.cours.IDaoCours;
import com.logos.data.mongo.config.AppConfig;
import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;

@Repository

public class DaoCours implements IDaoCours {
	
	@Autowired
	MongoOperations mongoOps;
	
	/*@Autowired
	MongoTemplate mongoTemplate;*/
	
	public DaoCours(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Cours addCours(Cours cours) {
		// TODO Auto-generated method stub
		mongoOps.insert(cours);
		return cours;
	}

	@Override
	public Cours updateCours(Cours cours) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public boolean deleteCours(Cours cours) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public Cours getCoursByid(Integer id) {
		// TODO Auto-generated method stub
		return mongoOps.findById(id, Cours.class);
	}

	@Override
	public List<Cours> getAllCours() {
		// TODO Auto-generated method stub
		return mongoOps.findAll(Cours.class);
	}

	@Override
	public List<Cours> getCoursByLangue(Langue langue) {
		// TODO Auto-generated method stub
		Query q = new Query(Criteria.where("niveau.langue._id").is(langue.getIdLangue()));
		return mongoOps.find(q,Cours.class);
	}
	


	@Override
	public List<Cours> getCoursByCategorie(Categorie categorie) {
		//TODO a refaire
		Query query = new Query(Criteria.where("categories").elemMatch(Criteria.where("_id").is(categorie.getIdCategorie())));
		return mongoOps.find(query, Cours.class);
	}

	@Override
	public List<Cours> getCoursByNiveau(Niveau niveau) {
		Query q = new Query(Criteria.where("niveau._id").is(niveau.getIdNiveau()));
		return mongoOps.find(q,Cours.class);
	}
	
	

	@Override
	public List<Cours> getCoursByNiveauSuperieur(Niveau niveau) {
		// TODO completer
		return getCoursByLangue(niveau.getLangue());
	}

	@Override
	public Double getNoteMoyenneByCours(Cours cours) {
		// TODO oupsy !
		return 6.66;
	}

}
