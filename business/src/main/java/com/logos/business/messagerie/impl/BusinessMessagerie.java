package com.logos.business.messagerie.impl;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.context.support.UiApplicationContextUtils;

import com.logos.business.messagerie.api.IBusinessMessagerie;
import com.logos.entity.messagerie.Conversation;
import com.logos.entity.messagerie.Message;
import com.logos.entity.user.Utilisateur;

import api.com.logos.data.messagerie.IDaoConversation;
import api.com.logos.data.messagerie.IDaoMessage;

@Service
public class BusinessMessagerie implements IBusinessMessagerie {

	@Autowired
	private IDaoMessage daoMessage;
	@Autowired
	private IDaoConversation daoConversation;	

	@Override
	public List<Conversation> getAllConversationsByUser(Utilisateur user) {
		List<Conversation> listeC = daoConversation.getAllConversation(user);		
		return listeC;
	}

	@Override
	public Conversation addConversation(Conversation conversation, Utilisateur...utilisateurs) {
		daoConversation.addConversation(conversation, utilisateurs);
		return conversation;
	}

	@Override
	public boolean deleteConversation(Conversation conversation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Message> getAllMessagesByConversation(Conversation conversation) {
		List<Message>listeM = daoMessage.getAllMessages(conversation);
		listeM.sort(new CompareDate());
		return listeM;
	}

	@Override
	public Message envoyerMessage(Message message, Conversation conversation, Utilisateur auteur) {
		message.setAuteur(auteur);
		daoMessage.addMessage(message, conversation);
		return message;
	}

	@Override
	public int signalerNombreDeNouveauxMessage(Utilisateur userConnected) {
		List<Conversation> conversations = daoConversation.getAllConversation(userConnected);
		int nouveauxMessages = 0;
		for (Conversation conversation : conversations) {
			List<Message>messages = daoMessage.getAllMessages(conversation);
			for (Message msg : messages) {
				if(msg.getAuteur().getIdUtilisateur() != userConnected.getIdUtilisateur() && msg.getDateLecture() == null){
					nouveauxMessages++;
				}
			}
		}
		return nouveauxMessages;
	}

	@Override
	public void setMessageLu(Conversation conversation, Utilisateur userConnected) {
		List<Message>listeM = daoMessage.getAllMessages(conversation);
		for (Message msg : listeM) {
			if(msg.getAuteur().getIdUtilisateur() != userConnected.getIdUtilisateur()){
				daoMessage.updateDateLectureMessage(msg);
			}
		}
	}
	
	public Set<Utilisateur> getUsersByConversation(Conversation conversation) {
		return daoConversation.getUsersByConversation(conversation);
	}

	public IDaoMessage getDaoMessage() {
		return daoMessage;
	}

	public void setDaoMessage(IDaoMessage daoMessage) {
		this.daoMessage = daoMessage;
	}

	public IDaoConversation getDaoConversation() {
		return daoConversation;
	}

	public void setDaoConversation(IDaoConversation daoConversation) {
		this.daoConversation = daoConversation;
	}

	public class CompareDate implements Comparator<Message> {

		@Override
		public int compare(Message msg1, Message msg2) {
			return msg1.getDateEnvoi().compareTo(msg2.getDateEnvoi());
		}
	}
}
