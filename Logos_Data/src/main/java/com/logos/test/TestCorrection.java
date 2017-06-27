package com.logos.test;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.data.correction.api.IDaoCorrection;
import com.logos.data.cours.api.IDaoCategorie;
import com.logos.data.cours.api.IDaoCours;
import com.logos.data.cours.impl.DaoCours;
import com.logos.data.niveauLangue.api.IDaoLangues;
import com.logos.data.niveauLangue.api.IDaoNiveau;
import com.logos.data.professeur.api.IDaoProfesseur;
import com.logos.data.reponseeleve.api.IDaoReponseEleve;
import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;
import com.logos.entity.evaluation.Correction;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.question.Question;
import com.logos.entity.reponse.ReponseOuverteEleve;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;

public class TestCorrection {

	private static Logger log = Logger.getLogger(TestCorrection.class);
	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springData.xml");
		IDaoCours dao = bf.getBean(IDaoCours.class);
		IDaoNiveau daoNiveau = bf.getBean(IDaoNiveau.class);
		IDaoLangues daoLangue = bf.getBean(IDaoLangues.class);
		IDaoCategorie daoCategorie = bf.getBean(IDaoCategorie.class);
		IDaoCorrection daoCorrection = bf.getBean(IDaoCorrection.class);
		IDaoProfesseur daoProf = bf.getBean(IDaoProfesseur.class);
		IDaoReponseEleve daoRep = bf.getBean(IDaoReponseEleve.class);

		Professeur prof = new Professeur(null, "gomez", "victor", "victor", "password", "mail");
		Eleve el = new Eleve(null, null, "kj", "lolll", "poppoopo", "mai65464654l");
		Evaluation eval = new Evaluation(null, "comment ramasser des patates");
		RealiseEvaluation re = new RealiseEvaluation(null, new Date(), el, eval);
		Question question = new Question(null, "hello?");
		Correction corrd = new Correction();
		ReponseOuverteEleve repou = new ReponseOuverteEleve(null, re, question, "jhhjhj", corrd);
		Correction corr = new Correction(null, "tres mal", 5, new Date(), prof, repou);
		ReponseOuverteEleve ro = new ReponseOuverteEleve(null, re, question, "blerp", corr);
		Correction correction = new Correction(null, "mal", 10, new Date(), prof, ro);
		
		daoRep.addReponse(repou);

//		daoProf.ajouterProf(prof);
		//daoCorrection.addCorrection(correction);
//		daoCorrection.addCorrection(corr);

//		List<Correction>listeCorr = daoCorrection.getCorrectionByProfesseur(daoProf.getProfById(5));
//
//		for(Correction c : listeCorr) {
//			log.info(c.getCorrige());
//		}
		

//		Correction corroo = daoCorrection.getCorrectionByReponse(repou);
//		System.out.println(corroo.getCorrige());



		//		Langue langue = daoLangue.getLangueById(2);
		//		Niveau niv = daoNiveau.getNiveauById(4);
		//		//		
		//		Cours cours = dao.getCoursByid(5);
		//		
		//		Cours c = new Cours(null, "nouv cours", "cours de ouf malade", new Date(), new Date(), null, null);
		//		Niveau nivbrr = new Niveau(null, "a1000", Niveau.C2, langue);
		//		c.setNiveau(nivbrr);
		//		
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
