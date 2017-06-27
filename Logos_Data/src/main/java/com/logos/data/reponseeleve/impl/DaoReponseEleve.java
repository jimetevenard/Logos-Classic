package com.logos.data.reponseeleve.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.reponseeleve.api.IDaoReponseEleve;
import com.logos.entity.evaluation.Correction;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.reponse.ReponseATrousEleve;
import com.logos.entity.reponse.ReponseDragAndDropEleve;
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.reponse.ReponseOuverteEleve;
import com.logos.entity.reponse.ReponseQcmEleve;
import com.logos.entity.user.Eleve;

@Service
public class DaoReponseEleve implements IDaoReponseEleve{
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public ReponseEleve getReponseById(Integer id) {
		Session session = sf.getCurrentSession();
		ReponseEleve resp = null;
		try {
		Query query = session.createQuery("SELECT r FROM ReponseEleve r where r.idReponse = :id")
					.setParameter("id", id);
		resp = (ReponseEleve) query.uniqueResult();
		return resp ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<ReponseEleve> getReponseByEvaluation(Evaluation evaluation) {
		Session session = sf.getCurrentSession();
		List<ReponseEleve> listeReponses = new ArrayList<>();
		try {
			Query query = session.createQuery("SELECT r FROM ReponseEleve r where r.realiseEvaluation.evaluation.idEvaluation = :evaluation")
					.setParameter("evaluation", evaluation.getIdEvaluation());
			listeReponses = (List<ReponseEleve>) query.list();
			return listeReponses ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public ReponseEleve addReponse(ReponseEleve reponse) {
		Session session = sf.getCurrentSession();
		session.persist(reponse);
		return reponse;
	}

	@Override
	@Transactional
	public ReponseEleve updateReponse(ReponseEleve reponse) {
		Session session = sf.getCurrentSession();
		session.update(reponse);
		return reponse;
	}

	@Override
	@Transactional
	public boolean deleteReponse(ReponseEleve reponse) {
		Session session = sf.getCurrentSession();
		session.delete(reponse);
		return sf.getCurrentSession().get(ReponseEleve.class, reponse.getIdReponse()) == null;
	}

	@Override
	@Transactional
	public ReponseOuverteEleve getReponseOuverteById(Integer id) {
		Session session = sf.getCurrentSession();
		ReponseOuverteEleve resp = null;
		try {
		Query query = session.createQuery("SELECT r FROM ReponseOuverteEleve r where r.idReponse = :id")
					.setParameter("id", id);
		resp = (ReponseOuverteEleve) query.uniqueResult();
		return resp ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public ReponseQcmEleve getReponseQcmById(Integer id) {
		Session session = sf.getCurrentSession();
		ReponseQcmEleve resp = null;
		try {
		Query query = session.createQuery("SELECT r FROM ReponseQcmEleve r where r.idReponse = :id")
					.setParameter("id", id);
		resp = (ReponseQcmEleve) query.uniqueResult();
		return resp ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public ReponseATrousEleve getReponseATrousById(Integer id) {
		Session session = sf.getCurrentSession();
		ReponseATrousEleve resp = null;
		try {
		Query query = session.createQuery("SELECT r FROM ReponseATrousEleve r where r.idReponse = :id")
					.setParameter("id", id);
		resp = (ReponseATrousEleve) query.uniqueResult();
		return resp ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public ReponseDragAndDropEleve getReponseDragDropById(Integer id) {
		Session session = sf.getCurrentSession();
		ReponseDragAndDropEleve resp = null;
		try {
		Query query = session.createQuery("SELECT r FROM ReponseDragAndDropEleve r where r.idReponse = :id")
					.setParameter("id", id);
		resp = (ReponseDragAndDropEleve) query.uniqueResult();
		return resp ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ReponseEleve> getReponseByEleve(Eleve eleve) {
		Session session = sf.getCurrentSession();
		List<ReponseEleve> listeReponses = new ArrayList<>();
		try {
			Query query = session.createQuery("SELECT r FROM ReponseEleve r where r.realiseEvaluation.eleve.idUtilisateur = :eleve")
					.setParameter("eleve", eleve.getIdUtilisateur());
			listeReponses = (List<ReponseEleve>) query.list();
			return listeReponses ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	

}
