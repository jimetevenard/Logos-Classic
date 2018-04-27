package mongo.com.logos.niveauLangue.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Niveau;

import api.com.logos.data.niveauLangue.IDaoNiveau;

public class DaoNiveau implements IDaoNiveau {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoNiveau(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Niveau getNiveauById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Niveau> getAllNiveaux() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Niveau addNiveau(Niveau niveau) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Niveau updateNiveau(Cours niveau) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteNiveau(Niveau niveau) {
		// TODO Auto-generated method stub
		return false;
	}

}
