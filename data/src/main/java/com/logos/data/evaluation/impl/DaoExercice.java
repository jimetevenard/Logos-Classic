package com.logos.data.evaluation.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.evaluation.api.IDaoExercice;
import com.logos.entity.cours.Cours;
import com.logos.entity.evaluation.Exercice;

@Service
public class DaoExercice implements IDaoExercice{
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public Exercice addExercice(Exercice exercice) {
		Session session = sf.getCurrentSession();
		session.persist(exercice);
		return exercice;
	}

	@Override
	@Transactional
	public Exercice updateExercice(Exercice exercice) {
		Session session = sf.getCurrentSession();
		session.update(exercice);
		return exercice;
	}

	@Override
	@Transactional
	public boolean deleteExercice(Exercice exercice) {
		Session session = sf.getCurrentSession();
		session.delete(exercice);
		return sf.getCurrentSession().get(Exercice.class, exercice.getIdEvaluation()) == null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Exercice> getExerciceByCours(Cours cours) {
		Session session = sf.getCurrentSession();
		List<Exercice> listeExercices = new ArrayList<>();
		try {
			Query query = session.createQuery("SELECT r.exercices FROM Chapitre r where r.cours.idCours = :cours")
					.setParameter("cours", cours.getIdCours());
			listeExercices = (List<Exercice>) query.list();
			return listeExercices ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

}
