package com.logos.data.correction.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.correction.api.IDaoCorrection;
import com.logos.entity.evaluation.Correction;
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;

@Service
public class DaoCorrection implements IDaoCorrection {
	@Autowired
	private SessionFactory sf;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Correction> getAllCorrections() {
		Session session = sf.getCurrentSession();
		List<Correction> listeCorrections = new ArrayList<>();
		try {
		Query query = session.createQuery("SELECT c FROM Correction c");
		listeCorrections = (List<Correction>) query.list();
		return listeCorrections ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public Correction getCorrectionById(Integer id) {
		Session session = sf.getCurrentSession();
		Correction correction = null;
		try {
		Query query = session.createQuery("SELECT c FROM Correction c where c.idCorrection = :id")
					.setParameter("id", id);
		correction = (Correction) query.uniqueResult();
		return correction ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public Correction addCorrection(Correction correction) {
		Session session = sf.getCurrentSession();
		session.persist(correction);
		return correction;
	}

	@Override
	@Transactional
	public Correction updateCorrection(Correction correction) {
		Session session = sf.getCurrentSession();
		session.update(correction);
		return correction;
	}

	@Override
	@Transactional
	public boolean deleteCorrection(Correction correction) {
		Session session = sf.getCurrentSession();
		session.delete(correction);
		return sf.getCurrentSession().get(Correction.class, correction.getIdCorrection()) == null;
	}

	@Override
	@Transactional
	public Correction getCorrectionByReponse(ReponseEleve reponse) {
		Session session = sf.getCurrentSession();
		Correction correction = null;
		try {
			Query query = session.createQuery("SELECT c FROM Correction c where c.reponseOuverteEleve.idReponse = :reponse ")
					.setParameter("reponse", reponse);
			correction = (Correction) query.uniqueResult();
			return correction;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Correction> getCorrectionByProfesseur(Professeur professeur) {
		Session session = sf.getCurrentSession();
		List<Correction> listeCorrections = new ArrayList<>();
		try {
			Query query = session.createQuery("SELECT c FROM Correction c where c.professeur.idUtilisateur = :professeur")
					.setParameter("professeur", professeur.getIdUtilisateur());
			listeCorrections = (List<Correction>) query.list();
			return listeCorrections ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Correction> getCorrectionByEleve(Eleve eleve) {
		Session session = sf.getCurrentSession();
		List<Correction> listeCorrections = new ArrayList<>();
		try {
			Query query = session.createQuery("SELECT c FROM Correction c where c.reponseOuverteEleve.realiseEvaluation.eleve.idUtilisateur = :eleve")
					.setParameter("eleve", eleve.getIdUtilisateur());
			listeCorrections = (List<Correction>) query.list();
			return listeCorrections ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	

}
