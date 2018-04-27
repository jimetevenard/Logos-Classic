package mongo.com.logos.correction.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.evaluation.Correction;
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;

import api.com.logos.data.correction.IDaoCorrection;

public class DaoCorrection implements IDaoCorrection {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoCorrection(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public List<Correction> getAllCorrections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Correction getCorrectionById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Correction addCorrection(Correction correction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Correction updateCorrection(Correction correction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCorrection(Correction correction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Correction getCorrectionByReponse(ReponseEleve reponse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Correction> getCorrectionByProfesseur(Professeur professeur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Correction> getCorrectionByEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		return null;
	}

}
