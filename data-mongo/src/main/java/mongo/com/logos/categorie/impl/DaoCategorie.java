package mongo.com.logos.categorie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.cours.Categorie;

import api.com.logos.data.cours.IDaoCategorie;

public class DaoCategorie implements IDaoCategorie {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoCategorie(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Categorie getCategoryById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
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