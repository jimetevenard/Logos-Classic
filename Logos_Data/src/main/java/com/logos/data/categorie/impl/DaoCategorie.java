package com.logos.data.categorie.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.cours.api.IDaoCategorie;
import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Niveau;

@Service
public class DaoCategorie implements IDaoCategorie{

	@Autowired
	private SessionFactory sf ;

	@Transactional
	@Override
	public Categorie getCategoryById(Integer Id) {
		Session session = sf.getCurrentSession();
		Categorie categorie = null;
		try {
			Query query = session.createQuery("SELECT c FROM Categorie c where c.idCategorie = :id")
					.setParameter("id", Id);
			categorie = (Categorie) query.uniqueResult();
			return categorie ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public List<Categorie> getAllCategories() {
		Session session = sf.getCurrentSession();
		List<Categorie> listeCategorie = new ArrayList<>();
		try {
			Query query = session.createQuery("SELECT c FROM Categorie c");
			listeCategorie = (List<Categorie>) query.list();
			return listeCategorie ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public Categorie addCategory(Categorie category) {
		Session session = sf.getCurrentSession();
		session.persist(category);
		return category;
	}


	@Override
	public Categorie updateCategory(Categorie category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie deleteCategory(Categorie category) {
		// TODO Auto-generated method stub
		return null;
	}


}
