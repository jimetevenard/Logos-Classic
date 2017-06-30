package com.logos.data.messagerie.api;

import java.util.List;
import java.util.Set;

import com.logos.entity.messagerie.Conversation;
import com.logos.entity.user.Utilisateur;

public interface IDaoConversation {
	
	List<Conversation> getAllConversation(Utilisateur user);
	Conversation addConversation(Conversation conversation);
	public Conversation addConversation(Conversation conversation, Utilisateur... utilisateurs);
	Conversation getConversationById(Integer id);
	Boolean deleteConversation(Conversation conversation);
	Conversation updateConversation(Conversation chawa);
	Set<Utilisateur> getUsersByConversation(Conversation conversation);

}
