package com.logos.data.niveauLangue.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.niveauLangue.api.IDaoLangues;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;

@Service
public class DaoLangue implements IDaoLangues {
	@Autowired
	private SessionFactory sf;

	@Transactional
	@Override
	public Langue getLangueById(Integer Id) {
		Session session = sf.getCurrentSession();
		Langue langue = null;
		try {
		Query query = session.createQuery("SELECT l FROM Langue l where l.idLangue = :id")
					.setParameter("id", Id);
		langue = (Langue) query.uniqueResult();
		return langue ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public List<Langue> getAllLangues() {
		Session session = sf.getCurrentSession();
		List<Langue> listeLangue = new ArrayList<>();
		try {
		Query query = session.createQuery("SELECT l FROM Langue l");
		listeLangue = (List<Langue>) query.list();
		return listeLangue ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public Langue addLangue(Langue langue) {
		Session session = sf.getCurrentSession();
		session.persist(langue);
		return langue;
	}

	@Override
	public boolean deleteLangue(Langue langue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Langue updateLangue(Langue langue) {
		// TODO Auto-generated method stub
		return null;
	}

}
