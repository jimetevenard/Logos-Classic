package mongo.com.logos.cours.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;

import api.com.logos.data.cours.IDaoCours;

@Repository
public class DaoCours implements IDaoCours {
	
	@Autowired
	MongoOperations mongoOps;

	@Override
	public Cours addCours(Cours cours) {
		// TODO Auto-generated method stub
		mongoOps.insert(cours);
		return cours;
	}

	@Override
	public Cours updateCours(Cours cours) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCours(Cours cours) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cours getCoursByid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cours> getAllCours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cours> getCoursByLangue(Langue langue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cours> getCoursByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cours> getCoursByNiveau(Niveau niveau) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cours> getCoursByNiveauSuperieur(Niveau niveau) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getNoteMoyenneByCours(Cours cours) {
		// TODO Auto-generated method stub
		return null;
	}

}
