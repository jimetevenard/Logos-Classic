package com.logos.data.cours.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.cours.api.IDaoCours;
import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;


@Service
public class DaoCours implements IDaoCours{

	@Autowired
	private SessionFactory sf;

	@Transactional
	@Override
	public Cours addCours(Cours cours) {

		Session session = sf.getCurrentSession();
		session.persist(cours);
		return cours;
	}

	@Transactional
	@Override
	public Cours updateCours(Cours cours) {
		try {
			Session session = sf.getCurrentSession();
			session.update(cours);
			return cours;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public boolean deleteCours(Cours cours) {
		Session session = sf.getCurrentSession();
		try {
			session.delete(cours);
			return true ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	@Override
	public Cours getCoursByid(Integer id) {
		Session session = sf.getCurrentSession();
		Cours cours = null;
		try {
		Query query = session.createQuery("SELECT c FROM Cours c where c.idCours = :id")
					.setParameter("id", id);
		cours = (Cours) query.uniqueResult();
		return cours ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public List<Cours> getCoursByLangue(Langue langue) {
		Session session = sf.getCurrentSession();
		List<Cours> listeCours = new ArrayList<>();
		try {
		Query query = session.createQuery("SELECT c FROM Cours c where c.niveau.langue = :langue")
					.setParameter("langue", langue);
		listeCours = (List<Cours>) query.uniqueResult();
		return listeCours ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public List<Cours> getCoursByCategorie(Categorie categorie) {
		List<Cours> listeCours = new ArrayList<>();
		Session session = sf.getCurrentSession();
		try {
			Query query = session.createQuery("SELECT c FROM Cours c where c.categories = :categorie")
					.setParameter("categorie", categorie);
			listeCours = query.list();
			return listeCours ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public List<Cours> getCoursByNiveau(Niveau niveau) {
		List<Cours> listeCours = new ArrayList<>();
		Session session = sf.getCurrentSession();
		try {
			Query query = session.createQuery("SELECT c FROM Cours c where c.niveau = :niveau")
					.setParameter("niveau", niveau);
			listeCours = query.list();
			return listeCours ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public Double getNoteMoyenneByCours(Cours cours) {
		return null;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	

}
