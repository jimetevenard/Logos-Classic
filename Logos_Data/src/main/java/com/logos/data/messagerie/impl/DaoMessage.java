package com.logos.data.messagerie.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.messagerie.api.IDaoMessage;
import com.logos.entity.messagerie.Conversation;
import com.logos.entity.messagerie.Message;

@Service
public class DaoMessage implements IDaoMessage {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public Message addMessage(Message message) {
		Session session= sf.getCurrentSession();
		session.save(message);
		return message;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Message> getAllMessages(Conversation conversation) {
		Session session= sf.getCurrentSession();
		Query query = session.createQuery("SELECT c.messages FROM Conversation c WHERE c.idConversation = :param").setParameter("param", conversation.getIdConversation());
		List<Message> liste=query.list();
		return liste;
	}

	@Override
	@Transactional
	public Message getMessageById(Integer id) {
		Session session= sf.getCurrentSession();
		Query query = session.createQuery("SELECT m FROM Message m WHERE m.idMessage = :param").setParameter("param", id);
		Message message=(Message) query.uniqueResult();
		return message;
	}

	@Override
	@Transactional
	public Boolean deleteMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Message updateMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}


	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	

}
