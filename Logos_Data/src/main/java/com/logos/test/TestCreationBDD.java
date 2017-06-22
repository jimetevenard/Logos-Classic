package com.logos.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.data.connexion.api.IDaoConnexionUser;
import com.logos.entity.user.Utilisateur;

public class TestCreationBDD {

	private static Logger log = Logger.getLogger(TestCreationBDD.class);
	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springData.xml");
		
		IDaoConnexionUser dao = bf.getBean(IDaoConnexionUser.class);
		log.debug(dao.checkLoginPassword("loulou75", "loulou75"));
	}

}
