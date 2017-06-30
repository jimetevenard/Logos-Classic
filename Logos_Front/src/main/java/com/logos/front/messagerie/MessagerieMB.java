package com.logos.front.messagerie;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.logos.business.messagerie.api.IBusinessMessagerie;
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
	private List<Conversation>conversations;
	private List<Message>messagesConversationSelectionnee;
	private String messageAEnvoyer;

	@PostConstruct
	public void init() {
		conversations = getAllConversationsByUser();
		for (Conversation conversation : conversations) {
			conversation.setUtilisateurs(bu.getUsersByConversation(conversation) );
		}
		if(conversations.size() != 0) {
			conversationEnCours = conversations.get(0);
			messagesConversationSelectionnee = getAllMessagesByConversation();
		}
	}

	public void changerConversation(Conversation conversation) {
		conversationEnCours = conversation;
		messagesConversationSelectionnee = getAllMessagesByConversation();
	}

	public void envoyerMessage(){
		Message message = new Message();
		message.setContenu(messageAEnvoyer);
		bu.envoyerMessage(message, conversationEnCours, loginMB.getUserConnected());
		messageAEnvoyer="";
		
	}
	
	public void rafraichirMessages(){
		messagesConversationSelectionnee = getAllMessagesByConversation();
	}
	
	public String afficherDateEnvoi(Message message){
		SimpleDateFormat pattern = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String str = pattern.format(message.getDateEnvoi());
		return str;
	}

	public List<Conversation> getAllConversationsByUser() {
		return bu.getAllConversationsByUser(loginMB.getUserConnected());
	}

	public List<Message> getAllMessagesByConversation() {
		return bu.getAllMessagesByConversation(conversationEnCours);
	}
	
	public List<Utilisateur> getListeUtilisateur(Conversation c){
		return new ArrayList<>( c.getUtilisateurs() );
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

	public String getMessageAEnvoyer() {
		return messageAEnvoyer;
	}

	public void setMessageAEnvoyer(String messageAEnvoyer) {
		this.messageAEnvoyer = messageAEnvoyer;
	}
	
	

}
