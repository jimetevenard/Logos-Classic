package mongo.com.logos.eleve.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.logos.entity.question.Question;
import com.logos.entity.user.Eleve;

import api.com.logos.data.eleve.IDaoEleve;
import mongo.com.logos.config.NextSequenceService;

@Repository
public class DaoEleve implements IDaoEleve {
	
	@Autowired
	MongoOperations mongoOps;
	
	@Autowired
	private NextSequenceService sequence;
	
	private static final String COLLECTION = "eleve";
	
	public DaoEleve(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Eleve ajouterEleve(Eleve eleve) {
		eleve.setIdUtilisateur(sequence.getNextSequence(COLLECTION));
		mongoOps.insert(eleve);
		return eleve;
	}

	@Override
	public Eleve getEleveById(Integer id) {
		return mongoOps.findById(id, Eleve.class);
	}
	
//	public Eleve getEleveById(String id) {
//		Query query = new Query(Criteria.where("_id").is(id));
//		Eleve eleve = (Eleve) mongoOps.findById(id, Eleve.class);
//		return eleve;
//	}

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
		return mongoOps.findAll(Eleve.class);
	}

}
