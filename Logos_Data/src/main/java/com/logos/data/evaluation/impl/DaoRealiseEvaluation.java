package com.logos.data.evaluation.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.evaluation.api.IDaoRealiseEvaluation;
import com.logos.entity.cours.Cours;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.user.Eleve;

@Service
public class DaoRealiseEvaluation implements IDaoRealiseEvaluation {
	@Autowired
	private SessionFactory sf;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<RealiseEvaluation> getRealiseEvaluationByEleve(Eleve eleve) {
		Session session = sf.getCurrentSession();
		List<RealiseEvaluation> listeREvals = new ArrayList<>();
		try {
			Query query = session.createQuery("SELECT c FROM RealiseEvaluation c where c.eleve.idUtilisateur = :eleve")
					.setParameter("eleve", eleve.getIdUtilisateur());
			listeREvals = (List<RealiseEvaluation>) query.list();
			return listeREvals ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public RealiseEvaluation addRealiseEvaluation(RealiseEvaluation realiseEvaluation) {
		Session session = sf.getCurrentSession();
		session.persist(realiseEvaluation);
		return realiseEvaluation;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

}
