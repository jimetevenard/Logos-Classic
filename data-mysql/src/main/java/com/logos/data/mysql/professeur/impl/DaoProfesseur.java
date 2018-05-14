package com.logos.data.mysql.professeur.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.api.professeur.IDaoProfesseur;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;

@Service
public class DaoProfesseur implements IDaoProfesseur {
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public Professeur ajouterProf(Professeur prof) {
		Session session = sf.getCurrentSession();
		session.save(prof);
		return prof;
	}

	@Override
	@Transactional
	public Professeur getProfById(Integer id) {
		Session session = sf.getCurrentSession();
		Query query = session.createQuery("select e from Utilisateur e where e.idUtilisateur = :pid").setParameter("pid", id);
		Professeur prof =(Professeur) query.uniqueResult();
		return prof;
	}

	@Override
	public Professeur updateProf(Professeur prof) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProf(Professeur prof) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Professeur> getAllProf() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	

}
