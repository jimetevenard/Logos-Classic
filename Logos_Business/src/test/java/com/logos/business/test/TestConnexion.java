package com.logos.business.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.business.connexion.api.IBusinessConnexionPlateforme;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Utilisateur;

public class TestConnexion {
	public static Logger log = Logger.getLogger(TestConnexion.class);

	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:SpringBusiness.xml");
		
		IBusinessConnexionPlateforme dao = bf.getBean(IBusinessConnexionPlateforme.class);
		
		Eleve el = new Eleve(null, "Pablez", "Victor", "login", "password", "lol@com");
		
		dao.inscrireEleve(el);
		
		Utilisateur ut = dao.checkLoginPassword(el.getLogin(), "pppp");
		
		log.info(ut.getNom());
				
		
	}
}
