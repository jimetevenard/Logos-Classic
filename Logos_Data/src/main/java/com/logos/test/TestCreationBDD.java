package com.logos.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.data.connexion.api.IDaoConnexionUser;
import com.logos.data.eleve.api.IDaoEleve;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Utilisateur;

public class TestCreationBDD {

	private static Logger log = Logger.getLogger(TestCreationBDD.class);
	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springData.xml");
		IDaoEleve dao = bf.getBean(IDaoEleve.class);
		
//		Eleve eleve = dao.getEleveById(2);
//		log.debug(dao.ajouterEleve(eleve).getNom());
//		eleve.setStatutPremium(false);
		
//		dao.updateEleve(eleve);
//		dao.deleteEleve(eleve);
//		List<Elev>
//		for( Eleve e : dao.getAllEleve()){
//			log.debug(e.getLogin());
//		}
//		
		
		
	}

}
