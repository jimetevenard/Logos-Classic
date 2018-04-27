package mongo.com.logos.eleve.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.user.Eleve;

import api.com.logos.data.eleve.IDaoEleve;

public class DaoEleve implements IDaoEleve {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoEleve(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Eleve ajouterEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eleve getEleveById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eleve updateEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Eleve> getAllEleve() {
		// TODO Auto-generated method stub
		return null;
	}

}
