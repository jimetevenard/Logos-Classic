package com.logos.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.data.cours.api.IDaoCours;
import com.logos.data.cours.api.IDaoSuiviCours;
import com.logos.data.eleve.api.IDaoEleve;
import com.logos.entity.user.Eleve;

public class TestSuivi {
	private static Logger log = Logger.getLogger(TestSuivi.class);
	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springData.xml");
		IDaoEleve daoEleve = bf.getBean(IDaoEleve.class);
		IDaoSuiviCours daoSuivi = bf.getBean(IDaoSuiviCours.class);
		IDaoCours daoCours = bf.getBean(IDaoCours.class);
		Eleve el = daoEleve.getEleveById(1);
		log.info(daoCours.getCoursByid(1).getTitre());
		log.info(daoEleve.getEleveById(1).getNom());
		
		log.info(daoSuivi.getSuiviByEleve(el));
	log.info(daoSuivi.getCoursInscritsByEleve(el));
//		log.info(el.getSuiviCours());
	}

}
