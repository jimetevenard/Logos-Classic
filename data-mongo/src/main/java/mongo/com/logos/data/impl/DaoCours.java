package mongo.com.logos.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;

import api.com.logos.data.cours.IDaoCours;

public class DaoCours implements IDaoCours{
	
	@Autowired
	MongoOperations mongoOp;

	@Override
	public com.logos.entity.cours.Cours addCours(com.logos.entity.cours.Cours cours) {
		mongoOp.insert(cours);
		return cours ;
	}

	@Override
	public com.logos.entity.cours.Cours updateCours(com.logos.entity.cours.Cours cours) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCours(com.logos.entity.cours.Cours cours) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public com.logos.entity.cours.Cours getCoursByid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.logos.entity.cours.Cours> getAllCours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.logos.entity.cours.Cours> getCoursByLangue(Langue langue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.logos.entity.cours.Cours> getCoursByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.logos.entity.cours.Cours> getCoursByNiveau(Niveau niveau) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.logos.entity.cours.Cours> getCoursByNiveauSuperieur(Niveau niveau) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getNoteMoyenneByCours(com.logos.entity.cours.Cours cours) {
		// TODO Auto-generated method stub
		return null;
	}

}
