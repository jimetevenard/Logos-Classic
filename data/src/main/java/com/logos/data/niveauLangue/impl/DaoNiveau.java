package com.logos.data.niveauLangue.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.niveauLangue.api.IDaoNiveau;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Niveau;

@Service
public class DaoNiveau implements IDaoNiveau {
	@Autowired
	private SessionFactory sf;

	@Transactional
	@Override
	public Niveau getNiveauById(Integer Id) {
		Session session = sf.getCurrentSession();
		Niveau niveau = null;
		try {
		Query query = session.createQuery("SELECT n FROM Niveau n where n.idNiveau = :id")
					.setParameter("id", Id);
		niveau = (Niveau) query.uniqueResult();
		return niveau ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public List<Niveau> getAllNiveaux() {
		Session session = sf.getCurrentSession();
		List<Niveau> listeNiveau = new ArrayList<>();
		try {
		Query query = session.createQuery("SELECT n FROM Niveau n");
		listeNiveau = (List<Niveau>) query.list();
		return listeNiveau ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public Niveau addNiveau(Niveau niveau) {
		Session session = sf.getCurrentSession();
		session.persist(niveau);
		
		
		return niveau;
	}

	@Override
	public Niveau updateNiveau(Cours niveau) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteNiveau(Niveau niveau) {
		// TODO Auto-generated method stub
		return false;
	}

}
