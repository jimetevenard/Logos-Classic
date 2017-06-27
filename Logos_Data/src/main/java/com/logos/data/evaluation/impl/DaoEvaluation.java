package com.logos.data.evaluation.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.evaluation.api.IDaoEvaluation;
import com.logos.entity.cours.Chapitre;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.user.Eleve;

@Service
public class DaoEvaluation implements IDaoEvaluation{
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public Evaluation addEvaluation(Evaluation evaluation) {
		Session session = sf.getCurrentSession();
		session.persist(evaluation);
		return evaluation;
	}

	@Override
	@Transactional
	public Evaluation updateEvaluation(Evaluation evaluation) {
		Session session = sf.getCurrentSession();
		session.update(evaluation);
		return evaluation;
	}

	@Override
	@Transactional
	public boolean deleteEvaluation(Evaluation evaluation) {
		Session session = sf.getCurrentSession();
		session.delete(evaluation);
		return sf.getCurrentSession().get(Evaluation.class, evaluation.getIdEvaluation()) == null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Evaluation> getEvaluationByEleve(Eleve eleve) {
		Session session = sf.getCurrentSession();
		List<Evaluation> listeEvaluations = new ArrayList<>();
		try {
			Query query = session.createQuery("SELECT r.evaluation FROM RealiseEvaluation r where r.eleve = :eleve")
					.setParameter("eleve", eleve.getIdUtilisateur());
			listeEvaluations = (List<Evaluation>) query.list();
			return listeEvaluations ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Evaluation> getEvaluationsByChapitre(Chapitre chapitre) {
		Session session = sf.getCurrentSession();
		List<Evaluation> listeEvaluations = new ArrayList<>();
		try {
			Query query = session.createQuery("SELECT c.exercices FROM Chapitre c where c.idChapitre = :chapitre")
					.setParameter("chapitre", chapitre.getIdChapitre());
			listeEvaluations = (List<Evaluation>) query.list();
			return listeEvaluations ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

}
