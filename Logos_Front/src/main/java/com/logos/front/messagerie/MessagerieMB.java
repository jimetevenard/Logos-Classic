package com.logos.front.messagerie;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.logos.business.messagerie.api.IBusinessMessagerie;
import com.logos.business.messagerie.impl.BusinessMessagerie;
import com.logos.entity.messagerie.Conversation;
import com.logos.entity.messagerie.Message;
import com.logos.entity.user.Utilisateur;
import com.logos.front.connexion.LoginMB;

@ManagedBean
@SessionScoped
public class MessagerieMB {
	
	@ManagedProperty(value = "#{businessMessagerie}")
	private IBusinessMessagerie bu;
	
	@ManagedProperty(value = "#{loginMB}")
	private LoginMB loginMB;
	
	private Conversation conversationEnCours;
	private Message message;
	private List<Conversation>conversations;
	private List<Message>messagesConversationSelectionnee;
	
	@PostConstruct
	public void init() {
		conversations = getAllConversationsByUser();
		messagesConversationSelectionnee = getAllMessagesByConversation();
	}
	
	public void envoyerMessage(Message message){
		bu.envoyerMessage(message, conversationEnCours, loginMB.getUserConnected());
	}
	
	public List<Conversation> getAllConversationsByUser() {
		return bu.getAllConversationsByUser(loginMB.getUserConnected());
	}
	
	public List<Message> getAllMessagesByConversation() {
		return bu.getAllMessagesByConversation(conversationEnCours);
	}
	
	
	public IBusinessMessagerie getBu() {
		return bu;
	}
	public void setBu(IBusinessMessagerie bu) {
		this.bu = bu;
	}
	public LoginMB getLoginMB() {
		return loginMB;
	}
	public void setLoginMB(LoginMB loginMB) {
		this.loginMB = loginMB;
	}
	public Conversation getConversationEnCours() {
		return conversationEnCours;
	}
	public void setConversationEnCours(Conversation conversationEnCours) {
		this.conversationEnCours = conversationEnCours;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Conversation> getConversations() {
		return conversations;
	}

	public void setConversations(List<Conversation> conversations) {
		this.conversations = conversations;
	}

	public List<Message> getMessagesConversationSelectionnee() {
		return messagesConversationSelectionnee;
	}

	public void setMessagesConversationSelectionnee(List<Message> messagesConversationSelectionnee) {
		this.messagesConversationSelectionnee = messagesConversationSelectionnee;
	}
	
}
