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
import com.logos.entity.reponse.ReponseDragAndDropEleve;
import com.logos.entity.reponse.ReponseOuverteEleve;
import com.logos.entity.reponse.ReponseQcmEleve;
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
		IDaoEvaluation daoEval = bf.getBean(IDaoEvaluation.class);
		IDaoRealiseEvaluation daoRE = bf.getBean(IDaoRealiseEvaluation.class);
		
//		Eleve el = new Eleve(1, null, null, null, null, null);
//		Evaluation ev = new Evaluation(null, null);
//		
//		RealiseEvaluation real = new RealiseEvaluation(null, new Date(), el, ev);
		//daoRE.addRealiseEvaluation(real);
		
		
//		Eleve ele = new Eleve(1, null, null, null, null, null);
//		Set<RealiseEvaluation>listiti = daoRE.getRealiseEvaluationByEleve(ele);
//		
//		System.out.println(listiti.size());
//		
//		for(RealiseEvaluation e : listiti) {
//			log.info("le résultat est : " +e.getIdRealiseEvaluation());
//		}
//		
//		ev.setIdEvaluation(1);
//		List<Question> lQuestion = daoQuest.getQuestionByEvaluation(ev);
//		for (Question question : lQuestion) {
//			log.info("énoncé : "+question.getEnonce());
//		}
//		
//		Correction correction1 = new Correction(null, "c'est vraiment nul ce que vous avez écrit, ca me donne mal à la tête", 6, new Date(), null, null);
//		Correction correction2 = new Correction(null, "Très bien", 18, new Date(), null, null);
//		Correction correction3 = new Correction(null, "Non, Bryan is in the kitchen", 10, new Date(), null, null);
//		ReponseOuverteEleve repOuverte1 = new ReponseOuverteEleve(null, null, null, "la la la la je m'en fou", correction1);
//		ReponseOuverteEleve repOuverte2 = new ReponseOuverteEleve(null, null, null, "Bryan is in the kitchen", correction2);
//		ReponseOuverteEleve repOuverte3 = new ReponseOuverteEleve(null, null, null, "Bryan is in the garden", correction3);
		
//		daoRep.addReponse(repOuverte1);
//		daoRep.addReponse(repOuverte2);
//		daoRep.addReponse(repOuverte3);
		
//		Correction c = daoCorrection.getCorrectionByReponse(daoRep.getReponseById(8));
//		log.info("correction rép ouverte : "+c.getCorrige());
//		
//		
//		List<Integer> listeSolutionsQcm = daoQuest.getSolutionsByQuestionQcm(daoQuest.getQuestionQcmById(2));
//		for (Integer integer : listeSolutionsQcm) {
//			log.info("solutions qcm : "+integer.toString());
//		}
//		List<String> listeSolutionsTrous = daoQuest.getSolutionsByQuestionATrous(daoQuest.getQuestionATrousById(4));
//		for (String str : listeSolutionsTrous) {
//			log.info("solutions a trous : "+str.toString());
//		}
//		
//		Chapitre chap = new Chapitre();
//		chap.setIdChapitre(1);
//		List<Evaluation> lEval = daoEval.getEvaluationsByChapitre(chap);
//		for (Evaluation evaluation : lEval) {
//			log.info(evaluation.getTitre());
//		}

		
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
		
		ArrayList<String> solutionsDragDrop= new ArrayList<>();
		Collections.addAll(solutionsDragDrop, "white","black");
		QuestionDragAndDrop qDragDrop = new QuestionDragAndDrop(null,"complétez cette phrase en glissant vos réponses sur les emmplacements indiqués", "the colour of henry's horse is *** and ***", solutionsDragDrop);
		ArrayList<String> responseDragDropfausse= new ArrayList<>();
		Collections.addAll(responseDragDropfausse, "black","white");
		ReponseDragAndDropEleve reponseDragDropfausse = new ReponseDragAndDropEleve(null, null, qDragDrop, responseDragDropfausse);
		ArrayList<String> responseDragDropjuste= new ArrayList<>();
		Collections.addAll(responseDragDropjuste, "white","black");
		ReponseDragAndDropEleve reponseDragDropjuste = new ReponseDragAndDropEleve(null, null, qDragDrop, responseDragDropjuste);
		
		daoQuest.addQuestion(qDragDrop);
//		daoRep.addReponseEleve(reponseQcmjuste);
		
	}
}
