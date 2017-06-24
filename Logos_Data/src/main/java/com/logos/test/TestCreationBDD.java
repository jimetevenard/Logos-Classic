package com.logos.test;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.data.cours.api.IDaoCategorie;
import com.logos.data.cours.api.IDaoCours;
import com.logos.data.cours.impl.DaoCours;
import com.logos.data.niveauLangue.api.IDaoLangues;
import com.logos.data.niveauLangue.api.IDaoNiveau;
import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;

public class TestCreationBDD {

	private static Logger log = Logger.getLogger(TestCreationBDD.class);
	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springData.xml");
		IDaoCours dao = bf.getBean(IDaoCours.class);
		IDaoNiveau daoNiveau = bf.getBean(IDaoNiveau.class);
		IDaoLangues daoLangue = bf.getBean(IDaoLangues.class);
		IDaoCategorie daoCategorie = bf.getBean(IDaoCategorie.class);
		
		
		Langue langue = daoLangue.getLangueById(2);
		Niveau niv = daoNiveau.getNiveauById(5);
//		
		Cours cours = new Cours(null, "cours cours", "petit cours mytho", new Date(), new Date(), null, null);
//		Set<Cours> courses = new HashSet();
//		courses.add(cours);
		Set<Categorie> listcat = new HashSet();
//		cours.setNiveau(niv);
//		niv.setLangue(langue);
//		
//		cours.setCategories(listcat);
//		
//		cat.setCourses(courses);
		List<Cours> lcours = new ArrayList<>();
		for (Cours c : lcours) {
		log.info(c.getIntroduction());
	}
	
		
		Categorie cat = new Categorie(null, "syntaxe japonaise antique");
		listcat.add(cat);
		cours.setCategories(listcat);
		dao.addCours(cours);
		
		
//		Categorie cat2 = new Categorie(null, "vocabulaire aquatique swahili");
//		daoCategorie.addCategory(cat);
//		daoCategorie.addCategory(cat2);
//		List<Categorie> listeCate = new ArrayList<>();
//		
//		listeCate = daoCategorie.getAllCategories();
//		
//		for (Categorie cat : listeCate) {
//			log.info(cat.getTitre());
//		}
//		
		
		
//		List<Niveau> listeNiveau = new ArrayList<>();
//		List<Langue> listeLangue = new ArrayList<>();
//		listeNiveau = daoNiveau.getAllNiveaux();
//		listeLangue = daoLangue.getAllLangues();
//		
//		for (Langue langue : listeLangue) {
//			log.info(langue.getIdLangue());
//		}
//		
//		for (Niveau niveau : listeNiveau) {
//			log.info(niveau.getIdNiveau());
//		}

		
//		Langue l1 = new Langue(null, "Allemand", "DEU");
//		Langue l2 = new Langue(null, "Espagnol", "ESP");
//		daoLangue.addLangue(l1);
//		daoLangue.addLangue(l2);
//		
//		Niveau niveau  = new Niveau(null, "C1", Niveau.C1, l1);
//		Niveau niveau2  = new Niveau(null, "A2", Niveau.A2, l2);
//		daoNiveau.addNiveau(niveau);
//		daoNiveau.addNiveau(niveau2);

		

		
		
		
		
		
		
	
		
		
	}

}
