package com.logos.data.connexion.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logos.data.connexion.api.IDaoConnexionUser;
import com.logos.entity.user.Utilisateur;


@Service
@Transactional
public class DaoConnexionUser implements IDaoConnexionUser {
	@Autowired
	private SessionFactory sf;

	@Override
	public Utilisateur checkLoginPassword(String login, String password) {
		Utilisateur user = null;	
		try {
			user = (Utilisateur) sf.getCurrentSession().createQuery("SELECT u FROM Utilisateur u WHERE u.login = :login AND u.password = :password")
					.setParameter("login", login).setParameter("password", password).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
}
