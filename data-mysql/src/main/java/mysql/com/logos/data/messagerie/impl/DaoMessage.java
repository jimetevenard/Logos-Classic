package mysql.com.logos.data.messagerie.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.entity.messagerie.Conversation;
import com.logos.entity.messagerie.Message;

import api.com.logos.data.messagerie.IDaoMessage;

@Service
public class DaoMessage implements IDaoMessage {

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public Message addMessage(Message message, Conversation conversation) {
		Session session= sf.getCurrentSession();
		conversation = (Conversation)session.get(Conversation.class, conversation.getIdConversation());
		conversation.getMessages().size();
		message.setDateEnvoi(new Date());
		message.setConversation(conversation);
		session.save(message);
		return message;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Message> getAllMessages(Conversation conversation) {
		Session session= sf.getCurrentSession();
		System.out.println("LA SESSION => " + session);
		System.out.println("conversation => " + conversation);
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
	public Message updateDateLectureMessage(Message message) {
		Session session= sf.getCurrentSession();
		message.setDateLecture(new Date());
		session.update(message);
		return message;
	}


	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}



}
