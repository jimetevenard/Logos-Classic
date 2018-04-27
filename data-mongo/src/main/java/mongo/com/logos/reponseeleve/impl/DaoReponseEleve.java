package mongo.com.logos.reponseeleve.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.reponse.ReponseATrousEleve;
import com.logos.entity.reponse.ReponseDragAndDropEleve;
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.reponse.ReponseOuverteEleve;
import com.logos.entity.reponse.ReponseQcmEleve;
import com.logos.entity.user.Eleve;

import api.com.logos.data.reponseeleve.IDaoReponseEleve;

public class DaoReponseEleve implements IDaoReponseEleve {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoReponseEleve(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public ReponseEleve getReponseById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReponseEleve> getReponseByEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReponseEleve addReponseEleve(ReponseEleve reponse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReponseEleve updateReponse(ReponseEleve reponse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteReponse(ReponseEleve reponse) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ReponseOuverteEleve getReponseOuverteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReponseQcmEleve getReponseQcmById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReponseATrousEleve getReponseATrousById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReponseDragAndDropEleve getReponseDragDropById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReponseEleve> getReponseByEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReponseEleve> getReponseByRealiseEvaluation(RealiseEvaluation realiseEval) {
		// TODO Auto-generated method stub
		return null;
	}

}
