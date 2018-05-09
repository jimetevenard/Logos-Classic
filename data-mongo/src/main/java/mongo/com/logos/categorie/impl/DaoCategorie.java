package mongo.com.logos.categorie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.cours.Categorie;

import api.com.logos.data.cours.IDaoCategorie;
import mongo.com.logos.config.NextSequenceService;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie updateCategory(Categorie category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie deleteCategory(Categorie category) {
		// TODO Auto-generated method stub
		return null;
	}

}
