package mongo.com.logos.niveauLangue.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.cours.Langue;

import api.com.logos.data.niveauLangue.IDaoLangues;

public class DaoLangue implements IDaoLangues {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoLangue(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Langue getLangueById(Integer Id) {
		// TODO Auto-generated method stub
		return mongoOps.findById(Id, Langue.class);
	}

	@Override
	public List<Langue> getAllLangues() {
		// TODO Auto-generated method stub
		return mongoOps.findAll(Langue.class);
	}

	@Override
	public Langue addLangue(Langue langue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteLangue(Langue langue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Langue updateLangue(Langue langue) {
		// TODO Auto-generated method stub
		return null;
	}

}
