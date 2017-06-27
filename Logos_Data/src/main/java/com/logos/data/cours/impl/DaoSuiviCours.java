package com.logos.data.cours.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logos.data.cours.api.IDaoSuiviCours;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.SuiviCours;
import com.logos.entity.user.Eleve;

@Service
public class DaoSuiviCours implements IDaoSuiviCours {
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public List<Cours> getCoursInscritsByEleve(Eleve eleve) {
		Session session = sf.getCurrentSession();
		List<Cours> cours = new ArrayList<>();
		try{
			Query query = session.createQuery("SELECT s.cours FROM SuiviCours s where s.eleve = :peleve").setParameter("peleve", eleve);
			cours = query.list();
			return cours;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public List<SuiviCours> getSuiviByEleve(Eleve eleve) {
		Session session = sf.getCurrentSession();
		List<SuiviCours> suivis = new ArrayList<>();
		try {
			Query query = session.createQuery("SELECT s FROM SuiviCours s where s.eleve = :peleve")
					.setParameter("peleve", eleve);
			suivis = query.list();
			return suivis ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public List<SuiviCours> getSuiviByEleveEtCours(Eleve eleve, Cours cours) {
		Session session = sf.getCurrentSession();
		List<SuiviCours> suivis = new ArrayList<>();
		try {
			Query query = session.createQuery("SELECT s FROM SuiviCours s where s.eleve = :peleve and s.cours = :pcours")
					.setParameter("peleve", eleve).setParameter("pcours", cours);
			suivis = query.list();
			return suivis ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public SuiviCours addSuivi(SuiviCours suivi) {
		Session session = sf.getCurrentSession();
		session.save(suivi);
		return suivi;
	}

	@Override
	@Transactional
	public SuiviCours updateSuivi(SuiviCours suivi) {
		try{
			Session session = sf.getCurrentSession();
			session.update(suivi);
			return suivi;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public boolean deleteSuivi(SuiviCours suivi) {
		try{
			Session session = sf.getCurrentSession();
			session.delete(suivi);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}



	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}



}
