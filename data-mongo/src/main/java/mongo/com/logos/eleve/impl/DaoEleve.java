package mongo.com.logos.eleve.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.logos.entity.user.Eleve;

import api.com.logos.data.eleve.IDaoEleve;

@Repository
public class DaoEleve implements IDaoEleve {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoEleve(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Eleve ajouterEleve(Eleve eleve) {
		mongoOps.insert(eleve);
		return eleve;
	}

	@Override
	public Eleve getEleveById(Integer id) {
		return null;
	}
	
	public Eleve getEleveById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		Eleve eleve = (Eleve) mongoOps.findById(id, Eleve.class);
		return eleve;
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
