package com.logos.data.mysql.cours.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.api.cours.IDaoChapitre;
import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.Cours;

@Service
public class DaoChapitre implements IDaoChapitre{

	@Autowired
	private SessionFactory sf ;

	@Override
	public Chapitre addChapitre(Cours cours) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chapitre updateChapitre(Cours cours) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chapitre deleteChapitre(Cours cours) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Chapitre> getAllChapitresByCours(Cours cours) {
		Session session = sf.getCurrentSession();
		cours = (Cours) session.get(Cours.class, cours.getIdCours());
		List<Chapitre> chapitres = cours.getChapitres();
		cours.getChapitres().size();
		return chapitres;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}



}
