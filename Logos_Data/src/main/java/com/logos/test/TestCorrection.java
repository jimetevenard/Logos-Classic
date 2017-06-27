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

import com.logos.data.correction.api.IDaoCorrection;
import com.logos.data.cours.api.IDaoCategorie;
import com.logos.data.cours.api.IDaoCours;
import com.logos.data.cours.impl.DaoCours;
import com.logos.data.eleve.api.IDaoEleve;
import com.logos.data.evaluation.api.IDaoEvaluation;
import com.logos.data.evaluation.api.IDaoRealiseEvaluation;
import com.logos.data.niveauLangue.api.IDaoLangues;
import com.logos.data.niveauLangue.api.IDaoNiveau;
import com.logos.data.professeur.api.IDaoProfesseur;
import com.logos.data.question.api.IDaoQuestion;
import com.logos.data.reponseeleve.api.IDaoReponseEleve;
import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;
import com.logos.entity.evaluation.Correction;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.question.Question;
import com.logos.entity.question.QuestionATrous;
import com.logos.entity.question.QuestionDragAndDrop;
import com.logos.entity.question.QuestionQcm;
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
		IDaoEvaluation daoEval = bf.getBean(IDaoEvaluation.class);
		IDaoRealiseEvaluation daoRE = bf.getBean(IDaoRealiseEvaluation.class);
		
		Eleve el = new Eleve(1, null, null, null, null, null);
		Evaluation ev = new Evaluation(null, null);
		
		RealiseEvaluation real = new RealiseEvaluation(null, new Date(), el, ev);
		//daoRE.addRealiseEvaluation(real);
		
		ArrayList<String> solutionsATrous= new ArrayList<>();
		Collections.addAll(solutionsATrous, "kitchen","garden");
		QuestionATrous qTrou = new QuestionATrous(null, "compléter cette phrase", "Bryan is in the *** and wants to go in the ***", solutionsATrous);
		
		ArrayList<String> solutionsDragDrop= new ArrayList<>();
		Collections.addAll(solutionsDragDrop, "white","black");
		QuestionDragAndDrop qDragDrop = new QuestionDragAndDrop(null,"complétez cette phrase en glissant vos réponses sur les emmplacements indiqués", "the colour of henry's horse is *** and ***", solutionsDragDrop);
		
		ArrayList<String> propositionsQcm= new ArrayList<>();
		Collections.addAll(propositionsQcm, "blue","yellow","purple","orange","green");
		ArrayList<Integer> solutionsQcm= new ArrayList<>();
		Collections.addAll(solutionsQcm, 1,5);
		QuestionQcm qQcm = new QuestionQcm(null, "what are Samantha's favourite colours ?", propositionsQcm, solutionsQcm);
		
//		Set<Question> questions = new HashSet<>();
//		Collections.addAll(questions, qTrou, qDragDrop, qQcm);
//		
//		daoQuest.addQuestion(qQcm);
//		daoQuest.addQuestion(qTrou);
//		daoQuest.addQuestion(qDragDrop);
//		
//		daoEval.addEvaluation(ev);
//		ev.setQuestions(questions);
		
		Eleve ele = new Eleve(1, null, null, null, null, null);
		Set<RealiseEvaluation>listiti = daoRE.getRealiseEvaluationByEleve(ele);
		
		System.out.println(listiti.size());
		
		for(RealiseEvaluation e : listiti) {
			log.info(e.getIdRealiseEvaluation());
		}
	}
}
