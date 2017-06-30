package com.logos.business.messagerie.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.business.evaluation.api.IFaireEvaluation;
import com.logos.business.evaluation.impl.FaireEvaluationTest;
import com.logos.business.messagerie.api.IBusinessMessagerie;
import com.logos.data.eleve.api.IDaoEleve;
import com.logos.data.messagerie.api.IDaoConversation;
import com.logos.data.messagerie.api.IDaoMessage;
import com.logos.entity.messagerie.Conversation;
import com.logos.entity.messagerie.Message;
import com.logos.entity.user.Utilisateur;

public class TestMessagerie {

private static Logger log = Logger.getLogger(TestMessagerie.class);
	
	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springBusiness.xml");
		IBusinessMessagerie bu = bf.getBean(IBusinessMessagerie.class);
		IDaoEleve daoEleve = bf.getBean(IDaoEleve.class);
		IDaoConversation daoConv = bf.getBean(IDaoConversation.class);
		IDaoMessage daoMess = bf.getBean(IDaoMessage.class);
		
		
		Utilisateur el = daoEleve.getEleveById(1);
//		List<Conversation>conversations = bu.getAllConversationsByUser(el);
//
//		for (Conversation conversation : conversations) {
//			log.info(conversation.getTitre());
//		}
		
		Conversation conv = daoConv.getConversationById(3);
//		List<Message>messages = bu.getAllMessagesByConversation(conv);
//		for (Message message : messages) {
//			log.info(message.getContenu());
//		}
		
		Message msg = new Message(null, "je suis le super message qui marche trop bien");
		
		Message mensaje = daoMess.getMessageById(11);
		//bu.envoyerMessage(msg, conv, el);
		
		//log.info(bu.signalerNombreDeNouveauxMessage(el));
		
		//bu.setMessageLu(conv, el);
		
		Set<Utilisateur>users = bu.getUsersByConversation(conv);
		
		for (Utilisateur utilisateur : users) {
			log.info(utilisateur.getNom());
		}
		
		
		
		
		
	}

}
