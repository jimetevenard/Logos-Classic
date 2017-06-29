package com.logos.business.evaluation.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.business.evaluation.api.IFaireEvaluation;
import com.logos.data.cours.api.IDaoCours;
import com.logos.data.question.impl.DaoQuestion;
import com.logos.entity.cours.Chapitre;
import com.logos.entity.evaluation.Correction;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.question.Question;
import com.logos.entity.question.QuestionATrous;
import com.logos.entity.question.QuestionDragAndDrop;
import com.logos.entity.question.QuestionOuverte;
import com.logos.entity.question.QuestionQcm;
import com.logos.entity.reponse.ReponseATrousEleve;
import com.logos.entity.reponse.ReponseDragAndDropEleve;
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.reponse.ReponseFermeeEleve;
import com.logos.entity.reponse.ReponseOuverteEleve;
import com.logos.entity.reponse.ReponseQcmEleve;
import com.logos.entity.user.Eleve;
import com.logos.test.TestCreationBDD;

public class FaireEvaluationTest {
	
	private static Logger log = Logger.getLogger(FaireEvaluationTest.class);
	
	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springBusiness.xml");
		IFaireEvaluation bu = bf.getBean(IFaireEvaluation.class);
		
		ArrayList<String> solutionsATrous= new ArrayList<>();
		Collections.addAll(solutionsATrous, "kitchen","garden");
		QuestionATrous qTrou = new QuestionATrous(null, "compléter cette phrase", "Bryan is in the *** and wants to go in the ***", solutionsATrous);
		ArrayList<String> responseATrousfausse= new ArrayList<>();
		Collections.addAll(responseATrousfausse, "garden","garage");
		ReponseATrousEleve reponseATroufausse = new ReponseATrousEleve(null, null, qTrou, responseATrousfausse);
		ArrayList<String> responseATrousjuste= new ArrayList<>();
		Collections.addAll(responseATrousjuste, "kitchen","garden");
		ReponseATrousEleve reponseATroujuste = new ReponseATrousEleve(null, null, qTrou, responseATrousjuste);
		
		ArrayList<String> solutionsDragDrop= new ArrayList<>();
		Collections.addAll(solutionsDragDrop, "white","black");
		QuestionDragAndDrop qDragDrop = new QuestionDragAndDrop(null,"complétez cette phrase en glissant vos réponses sur les emmplacements indiqués", "the colour of henry's horse is *** and ***", solutionsDragDrop);
		ArrayList<String> responseDragDropfausse= new ArrayList<>();
		Collections.addAll(responseDragDropfausse, "black","white");
		ReponseDragAndDropEleve reponseDragDropfausse = new ReponseDragAndDropEleve(null, null, qDragDrop, responseDragDropfausse);
		ArrayList<String> responseDragDropjuste= new ArrayList<>();
		Collections.addAll(responseDragDropjuste, "white","black");
		ReponseDragAndDropEleve reponseDragDropjuste = new ReponseDragAndDropEleve(null, null, qDragDrop, responseDragDropjuste);
		
		ArrayList<String> propositionsQcm= new ArrayList<>();
		Collections.addAll(propositionsQcm, "blue","yellow","purple","orange","green");
		ArrayList<Integer> solutionsQcm= new ArrayList<>();
		Collections.addAll(solutionsQcm, 1,5);
		QuestionQcm qQcm = new QuestionQcm(null, "what are Samantha's favourite colours ?", propositionsQcm, solutionsQcm);
		ArrayList<Integer> responseQcmfausse= new ArrayList<>();
		Collections.addAll(responseQcmfausse, 2,3);
		ReponseQcmEleve reponseQcmfausse = new ReponseQcmEleve(null, null, qQcm, responseQcmfausse);
		ArrayList<Integer> responseQcmjuste= new ArrayList<>();
		Collections.addAll(responseQcmjuste, 1,5);
		ReponseQcmEleve reponseQcmjuste = new ReponseQcmEleve(null, null, qQcm, responseQcmjuste);
		
		QuestionOuverte qo1 = new QuestionOuverte(null, "lalala");
		QuestionOuverte qo2 = new QuestionOuverte(null, "lalola");
		QuestionOuverte qo3 = new QuestionOuverte(null, "lalula");
		Correction correction1 = new Correction(null, "c'est vraiment nul ce que vous avez écrit, ca me donne mal à la tête", 6, new Date(), null, null);
		Correction correction2 = new Correction(null, "Très bien", 18, new Date(), null, null);
		Correction correction3 = new Correction(null, "Non, Bryan is in the kitchen", 10, new Date(), null, null);
		ReponseOuverteEleve repOuverte1 = new ReponseOuverteEleve(null, null, qo1, "la la la la je m'en fou", correction1);
		ReponseOuverteEleve repOuverte2 = new ReponseOuverteEleve(null, null, qo2, "Bryan is in the kitchen", correction2);
		ReponseOuverteEleve repOuverte3 = new ReponseOuverteEleve(null, null, qo3, "Bryan is in the garden", correction3);
				
//		log.info("corrigé de la question à trou fausse : "+bu.corrigerReponseATrous(reponseATroufausse, qTrou));
//		log.info("corrigé de la question drag and drop fausse: "+bu.corrigerReponseATrous(reponseDragDropfausse, qDragDrop));
//		log.info("corrigé de la question qcm fausse : "+bu.corrigerReponseQcm(reponseQcmfausse, qQcm));
//		
//		log.info("corrigé de la question à trou juste : "+bu.corrigerReponseATrous(reponseATroujuste, qTrou));
//		log.info("corrigé de la question drag and drop juste: "+bu.corrigerReponseATrous(reponseDragDropjuste, qDragDrop));
//		log.info("corrigé de la question qcm juste : "+bu.corrigerReponseQcm(reponseQcmjuste, qQcm));
//		
//		List<ReponseFermeeEleve> reponsesFermees = new ArrayList<>();
//		Collections.addAll(reponsesFermees, reponseATroufausse,reponseDragDropfausse,reponseQcmfausse,reponseATroujuste,reponseDragDropjuste,reponseQcmjuste);
//		log.info("je corrige les réponses de l'élève à l'évaluation : "+bu.corrigerReponseFermeeEleve(reponsesFermees).toString());
		
//		List<ReponseOuverteEleve> reponsesOuvertes = new ArrayList<>();
//		Collections.addAll(reponsesOuvertes, repOuverte1,repOuverte2,repOuverte3);
		Set<ReponseEleve> reponses = new HashSet<>();
//		Collections.addAll(reponses, reponseATroufausse,reponseDragDropfausse,repOuverte2,reponseQcmfausse,repOuverte3,reponseATroujuste,reponseDragDropjuste,reponseQcmjuste,repOuverte1);
//		
//		log.info("note moyenne des questions fermées de l'éval est : "+bu.calculNoteMoyenneQuestionsFermees(reponsesFermees));
//		log.info("note moyenne des questions ouvertes de l'éval est : "+bu.calculNoteMoyenneQuestionsOuvertes(reponsesOuvertes));
//		log.info("note moyenne des questions ouvertes de l'éval est : "+bu.calculerNoteEvaluation(reponses));
		
//		Chapitre chap = new Chapitre();
//		chap.setIdChapitre(1);
//		List<Evaluation> lEval = bu.getEvaluationsByChapitre(chap);
//		for (Evaluation evaluation : lEval) {
//			log.info(evaluation.getTitre());
//		}
		
		Eleve e= new Eleve();
		e.setIdUtilisateur(1);
		Evaluation eval = new Evaluation();
		eval.setIdEvaluation(1);
//		bu.realiserEvaluation(eval, e, reponses);
		
//		List<Question> questions = bu.getQuestionByEvaluation(eval);
//		for (Question question : questions) {
//			log.info(question.getEnonce());
//		}
		
//		List<ReponseEleve> lrep = bu.getReponseEleveByEvaluation(eval);
//		for (ReponseEleve reponseEleve : lrep) {
//			log.info(reponseEleve.getIdReponse());
//		}
		
//		ReponseOuverteEleve repOuv = new ReponseOuverteEleve();
//		repOuv.setIdReponse(8);
//		Correction correction = bu.getCorrectionByReponseOuverte(repOuv);
//		log.info(correction.getCorrige());
		
//		ReponseQcmEleve rep1 = new ReponseQcmEleve();
//		rep1.setIdReponse(2);
//		ReponseATrousEleve rep2 = new ReponseATrousEleve();
//		rep2.setIdReponse(3);
//		ReponseDragAndDropEleve rep3 = new ReponseDragAndDropEleve();
//		rep3.setIdReponse(4);
		List<ReponseEleve> reponsesAll = bu.getReponseEleveByEvaluation(eval);
		List<ReponseFermeeEleve> liste = new ArrayList<>();
		List<ReponseOuverteEleve> li = new ArrayList<>();
		RealiseEvaluation reall = new RealiseEvaluation();
		reall.setIdRealiseEvaluation(1);
		
		
//		for(ReponseEleve r : reponsesAll){
//			if(r.getClass().getSimpleName().equals("ReponseOuverteEleve")){
//				li.add((ReponseOuverteEleve) r);
//			}else{
//				liste.add((ReponseFermeeEleve) r);
//			}
//		}
//		
//		List<Boolean> corrige = bu.corrigerReponseFermeeEleve(liste, reall);
//		for (Boolean boolean1 : corrige) {
//			log.info(boolean1);
//		}
		
//		log.info(bu.calculerNoteEvaluation(reponsesAll, reall));
		
		
//		ReponseOuverteEleve repOuverte4 = new ReponseOuverteEleve(null, null, null, "test1", correction1);
//		ReponseOuverteEleve repOuverte5 = new ReponseOuverteEleve(null, null, null, "test2", correction2);
//		ReponseOuverteEleve repOuverte6 = new ReponseOuverteEleve(null, null, null, "test3", correction3);
//		ReponseOuverteEleve repOuverte7 = new ReponseOuverteEleve(idReponse, realiseEvaluation, question, reponse, correction)
		Question q1 = bu.getQuestionById(3);
		ArrayList<String> responseATrousjuste1= new ArrayList<>();
		Collections.addAll(responseATrousjuste1, "kitchen","garden");
		ReponseATrousEleve reponseATroujuste1 = new ReponseATrousEleve(null, null, q1, responseATrousjuste1);
		
		Question q2 = bu.getQuestionById(2);
		ArrayList<Integer> responseQcmjuste2= new ArrayList<>();
		Collections.addAll(responseQcmjuste2, 1,5);
		ReponseQcmEleve reponseQcmjuste1 = new ReponseQcmEleve(null, null, q2, responseQcmjuste2);
		
		Question q3 = bu.getQuestionById(4);
		ArrayList<String> responseDragDropjuste3= new ArrayList<>();
		Collections.addAll(responseDragDropjuste3, "white","black");
		ReponseDragAndDropEleve reponseDragDropjuste1 = new ReponseDragAndDropEleve(null, null, q3, responseDragDropjuste3);
		
		Set<ReponseEleve> reponsesEncore = new HashSet<>();
		Collections.addAll(reponsesEncore, reponseATroujuste1,reponseQcmjuste1,reponseDragDropjuste1);
		bu.addReponsesEleve(reponsesEncore, reall);
		
	}


}
