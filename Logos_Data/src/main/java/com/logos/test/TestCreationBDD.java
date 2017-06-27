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
		Niveau niv = daoNiveau.getNiveauById(4);
		//		
		Cours cours = dao.getCoursByid(5);
		
		Cours c1 = new Cours(null, "nouv cours", "cours de ouf malade", new Date(), new Date(), null, null);
		Cours c2 = new Cours(null, "nouv cours", "courgreeeeehde ouf malade", new Date(), new Date(), null, null);
		Cours c3 = new Cours(null, "nouv cours", "coursdssgrg malade", new Date(), new Date(), null, null);
		
//		Niveau nivbrr = new Niveau(null, "a1000", Niveau.C2, langue);
//		c.setNiveau(nivbrr);
		
//		dao.addCours(c);
//		dao.addCours(c);
//		dao.addCours(c);
//		dao.addCours(c);
		
		//		Set<Cours> courses = new HashSet();
		//		courses.add(cours);
		//		cours.setNiveau(niv);
		//		niv.setLangue(langue);
		//		
		//		cours.setCategories(listcat);
		//		
		//		cat.setCourses(courses);

//		List<Cours> lcours = dao.getCoursByNiveauSuperieur(niv);
//		for (Cours c2 : lcours) {
//			log.info(c2.getIdCours());
//			
//		}


				Categorie cat2 = new Categorie(null, "vocabulaire aquatique swahili");
				Categorie cat3 = new Categorie(null, "vocabulaire aquatiquevhjoiu ");
				Categorie cat4 = new Categorie(null, "vocabulaire aquatique popopok");
				Set<Categorie> categories = new HashSet<>();
				categories.add(cat4);
				Set<Categorie> categories1 = new HashSet<>();
				categories1.add(cat3);
				c1.setCategories(categories);
				c2.setCategories(categories);
				c3.setCategories(categories1);
				
//				daoCategorie.addCategory(cat2);
//				daoCategorie.addCategory(cat3);
//				daoCategorie.addCategory(cat4);
				
				dao.addCours(c1);
				dao.addCours(c3);
				dao.addCours(c2);

				List<Cours> listecourscat = dao.getCoursByCategorie(cat4);
				
				for (Cours cours2 : listecourscat) {
					log.info(cours2.getIdCours());
					
				}
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
