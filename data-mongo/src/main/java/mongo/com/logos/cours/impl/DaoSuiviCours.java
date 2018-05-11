package mongo.com.logos.cours.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.SuiviCours;
import com.logos.entity.user.Eleve;

import api.com.logos.data.cours.IDaoSuiviCours;

@Repository
public class DaoSuiviCours implements IDaoSuiviCours{
	
	@Autowired
	MongoOperations mongoOps;

	@Override
	public List<Cours> getCoursInscritsByEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		List<Cours> cours = new ArrayList<>();
		Query q = new Query(Criteria.where("eleve._id").is(eleve.getIdUtilisateur()));
		List<SuiviCours> suivis = mongoOps.find(q, SuiviCours.class);
		for (SuiviCours suiviCours : suivis) {
			cours.add(suiviCours.getCours());
		}
		return cours;
	}

	@Override
	public List<SuiviCours> getSuiviByEleve(Eleve eleve) {
		// TODO Auto-generated method stub
		Query q = new Query(Criteria.where("eleve._id").is(eleve.getIdUtilisateur()));
		return mongoOps.find(q, SuiviCours.class);
	}

	@Override
	public List<SuiviCours> getSuiviByEleveEtCours(Eleve eleve, Cours cours) {
		Query q = new Query(Criteria.where("eleve._id").is(eleve.getIdUtilisateur()).andOperator(Criteria.where("cours._id").is(cours.getIdCours())));
		// TODO Auto-generated method stub
		return mongoOps.find(q, SuiviCours.class);
	}

	@Override
	public SuiviCours addSuivi(SuiviCours suivi) {
		
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public SuiviCours updateSuivi(SuiviCours suivi) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public boolean deleteSuivi(SuiviCours suivi) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Méthode nom implémentée");
	}

	@Override
	public Set<Chapitre> getChapitresLuBySuiviCours(SuiviCours suivi) {
		// TODO Auto-generated method stub
		Query q = new Query(Criteria.where("_id").is(suivi.getIdSuiviCours()));
		SuiviCours suiviFound = mongoOps.findOne(q, SuiviCours.class);
		return suiviFound.getChapitresLus();
	}

}
