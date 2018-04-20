package com.logos.business.messagerie.api;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.logos.entity.messagerie.Conversation;
import com.logos.entity.messagerie.Message;
import com.logos.entity.user.Utilisateur;

public interface IBusinessMessagerie {
	List<Conversation> getAllConversationsByUser(Utilisateur user);
	Conversation addConversation(Conversation conversation, Utilisateur...utilisateurs);
	boolean deleteConversation(Conversation conversation);
	List<Message> getAllMessagesByConversation(Conversation conversation);
	Message envoyerMessage(Message message, Conversation conversation, Utilisateur auteur);
	int signalerNombreDeNouveauxMessage(Utilisateur userConnected);
	void setMessageLu(Conversation conversation, Utilisateur userConnected);
	Set<Utilisateur> getUsersByConversation(Conversation conversation);
}
