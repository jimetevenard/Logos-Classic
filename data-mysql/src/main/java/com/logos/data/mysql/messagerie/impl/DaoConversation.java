package com.logos.data.mysql.messagerie.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.api.messagerie.IDaoConversation;
import com.logos.entity.messagerie.Conversation;
import com.logos.entity.user.Utilisateur;

@Service
public class DaoConversation implements IDaoConversation{
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public List<Conversation> getAllConversation(Utilisateur user) {
		Session session= sf.getCurrentSession();
		Query query = session.createQuery("SELECT u.conversations FROM Utilisateur u WHERE u.idUtilisateur = :param").setParameter("param", user.getIdUtilisateur());
		List<Conversation> liste=query.list();
		return liste;
	}

	@Override
	@Transactional
	public Conversation addConversation(Conversation conversation) {
		Session session= sf.getCurrentSession();
		session.save(conversation);
		return conversation;
	}
	
	@Override
	@Transactional
	public Conversation addConversation(Conversation conversation, Utilisateur... utilisateurs) {
		Session session= sf.getCurrentSession();
		for (Utilisateur utilisateur : utilisateurs) {
			utilisateur = (Utilisateur)session.get(Utilisateur.class, utilisateur.getIdUtilisateur());
			Set<Conversation> listConv = utilisateur.getConversations();
			utilisateur.getConversations().size();
			utilisateur.getConversations().add(conversation);
		}
		session.save(conversation);
		return conversation;
	}

	@Override
	@Transactional
	public Conversation getConversationById(Integer id) {
		Session session= sf.getCurrentSession();
		Query query = session.createQuery("SELECT c FROM Conversation c WHERE c.idConversation = :param").setParameter("param", id);
		Conversation conversation=(Conversation) query.uniqueResult();
		return conversation;
	}

	@Override
	@Transactional
	public Boolean deleteConversation(Conversation conversation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Conversation updateConversation(Conversation chawa) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Utilisateur> getUsersByConversation(Conversation conversation) {
		Session session= sf.getCurrentSession();
		Query query = session.createQuery("SELECT c.utilisateurs FROM Conversation c WHERE c.idConversation = :param").setParameter("param", conversation.getIdConversation());
		List<Utilisateur> users = (List<Utilisateur>) query.list();
		Set<Utilisateur> liste = new HashSet<>(users);
		return liste;
	}
	
}
