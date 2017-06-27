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
import com.logos.data.eleve.api.IDaoEleve;
import com.logos.data.niveauLangue.api.IDaoLangues;
import com.logos.data.niveauLangue.api.IDaoNiveau;
import com.logos.data.professeur.api.IDaoProfesseur;
import com.logos.data.question.api.IDaoQuestion;
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
		IDaoEleve daoElev = bf.getBean(IDaoEleve.class);
		IDaoQuestion daoQuest = bf.getBean(IDaoQuestion.class);
		IDaoReponseEleve daoResp = bf.getBean(IDaoReponseEleve.class);
		
		Professeur prof = new Professeur(null, "Pericard", "Sebastien", "usuario", "contrasena", "mailio77");
		//daoProf.ajouterProf(prof);
		Eleve ele = new Eleve(null, "Prehaud", "Priscillia", "judo", "kata", "huehue878");
		//daoElev.ajouterEleve(ele);
		Question q = new Question(null, "ola k ase?");
		//daoQuest.addQuestion(q);
		


	}
}
