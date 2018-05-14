package com.logos.data.mysql.evaluation.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.api.evaluation.IDaoTestDeValidation;
import com.logos.entity.cours.Cours;
import com.logos.entity.evaluation.TestDeNiveau;
import com.logos.entity.evaluation.TestDeValidation;

@Service
public class DaoTestDeValidation implements IDaoTestDeValidation {
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public TestDeValidation addTestValidation(TestDeValidation test) {
		Session session = sf.getCurrentSession();
		session.persist(test);
		return test;
	}

	@Override
	@Transactional
	public TestDeValidation updateTestValidation(TestDeValidation test) {
		Session session = sf.getCurrentSession();
		session.update(test);
		return test;
	}

	@Override
	@Transactional
	public boolean deleteTestValidation(TestDeValidation test) {
		Session session = sf.getCurrentSession();
		session.delete(test);
		return sf.getCurrentSession().get(TestDeValidation.class, test.getIdEvaluation()) == null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TestDeValidation> getTestValidationByCours(Cours cours) {
		List<TestDeValidation> listeTests = new ArrayList<>();
		Session session = sf.getCurrentSession();
		try {
			Query query = session.createQuery("SELECT c FROM TestDeValidation c where c.cours.idCors = :cours")
					.setParameter("cours", cours.getIdCours());
			listeTests = query.list();
			return listeTests ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	

}
