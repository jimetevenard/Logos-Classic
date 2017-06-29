package com.logos.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.data.cours.api.IDaoCours;
import com.logos.data.eleve.api.IDaoEleve;
import com.logos.data.messagerie.api.IDaoConversation;
import com.logos.data.messagerie.api.IDaoMessage;
import com.logos.data.professeur.api.IDaoProfesseur;
import com.logos.entity.messagerie.Conversation;
import com.logos.entity.messagerie.Message;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;
import com.logos.entity.user.Utilisateur;

public class TestMessagerie {

	private static Logger log = Logger.getLogger(TestMessagerie.class);
	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springData.xml");
		IDaoMessage daoMessage = bf.getBean(IDaoMessage.class);
		IDaoConversation daoConversation = bf.getBean(IDaoConversation.class);
		IDaoEleve daoEleve = bf.getBean(IDaoEleve.class);
		IDaoProfesseur daoProfesseur = bf.getBean(IDaoProfesseur.class);
		
		Conversation c1 = new Conversation(null, "lololo");
		Set<Conversation> listeConv = new HashSet<>();
		Collections.addAll(listeConv, c1);
		Utilisateur e1 = daoEleve.getEleveById(1);
		log.info(" élève "+e1.getIdUtilisateur());
		Utilisateur p1 = daoProfesseur.getProfById(2);
//		daoConversation.addConversation(c1,p1,e1);
		
		Message m1= new Message(null, "salut1");
		m1.setDateEnvoi(new Date());
		Message m2= new Message(null, "salut2");
		m2.setDateEnvoi(new Date());
		Message m3= new Message(null, "salut3");
		m3.setDateEnvoi(new Date());
		Message m4= new Message(null, "salut4");
		m4.setDateEnvoi(new Date());
		Message m5= new Message(null, "salut5");
		m5.setDateEnvoi(new Date());
		Set<Message> messages = new HashSet<>();
		Collections.addAll(messages, m1,m2,m3,m4,m5);
//		for (Message message : messages) {
//			message.setConversation(c1);
//			daoMessage.addMessage(message);
//
//		}
		
//		log.info(daoConversation.getConversationById(11).getTitre());
//		log.info(daoMessage.getMessageById(18).getContenu());
		
		List<Conversation> listConversation = daoConversation.getAllConversation(e1);
		for (Conversation conversation : listConversation) {
			log.info("liste conversations "+conversation.getIdConversation());
		}
		Conversation c2 = daoConversation.getConversationById(7);
		List<Message> listeMessage = daoMessage.getAllMessages(c2);
		for (Message message : listeMessage) {
			log.info("liste messages : "+message.getIdMessage());
		}
		
		
		

	}

}
