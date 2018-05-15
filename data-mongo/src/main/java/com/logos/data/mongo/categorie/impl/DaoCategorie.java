package com.logos.data.mongo.categorie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.logos.data.api.cours.IDaoCategorie;
import com.logos.data.mongo.config.NextSequenceService;
import com.logos.entity.cours.Categorie;

@Repository
public class DaoCategorie implements IDaoCategorie {
	
	@Autowired
	MongoOperations mongoOps;
	
//	@Autowired
//	private NextSequenceService sequence;
	
	public DaoCategorie(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Categorie getCategoryById(Integer Id) {
		Categorie cat = mongoOps.findById(Id, Categorie.class);
		return cat;
	}

	@Override
	public List<Categorie> getAllCategories() {
		List<Categorie> categories = mongoOps.findAll(Categorie.class);
		return categories;
	}

	@Override
	public Categorie addCategory(Categorie category) {
		throw new RuntimeException("Méthode nom implémentée");
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categorie updateCategory(Categorie category) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public Categorie deleteCategory(Categorie category) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

}
