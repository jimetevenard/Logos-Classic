package com.logos.business.evaluation.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.business.evaluation.api.IFaireEvaluation;
import com.logos.data.cours.api.IDaoCours;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.question.Question;
import com.logos.entity.question.QuestionATrous;
import com.logos.entity.question.QuestionDragAndDrop;
import com.logos.entity.question.QuestionQcm;
import com.logos.entity.reponse.ReponseATrousEleve;
import com.logos.entity.reponse.ReponseDragAndDropEleve;
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.reponse.ReponseFermeeEleve;
import com.logos.entity.reponse.ReponseQcmEleve;
import com.logos.test.TestCreationBDD;

public class FaireEvaluationTest {
	
	private static Logger log = Logger.getLogger(FaireEvaluationTest.class);
	
	public static void main(String[] args) {
		FaireEvaluation bu = new FaireEvaluation();
		
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
		ReponseDragAndDropEleve reponseDragDropfausse = new ReponseDragAndDropEleve(null, null, qTrou, responseDragDropfausse);
		ArrayList<String> responseDragDropjuste= new ArrayList<>();
		Collections.addAll(responseDragDropjuste, "white","black");
		ReponseDragAndDropEleve reponseDragDropjuste = new ReponseDragAndDropEleve(null, null, qTrou, responseDragDropjuste);
		
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
				
		log.info("corrigé de la question à trou fausse : "+bu.corrigerReponseATrous(reponseATroufausse, qTrou));
		log.info("corrigé de la question drag and drop fausse: "+bu.corrigerReponseATrous(reponseDragDropfausse, qDragDrop));
		log.info("corrigé de la question qcm fausse : "+bu.corrigerReponseQcm(reponseQcmfausse, qQcm));
		
		log.info("corrigé de la question à trou juste : "+bu.corrigerReponseATrous(reponseATroujuste, qTrou));
		log.info("corrigé de la question drag and drop juste: "+bu.corrigerReponseATrous(reponseDragDropjuste, qDragDrop));
		log.info("corrigé de la question qcm juste : "+bu.corrigerReponseQcm(reponseQcmjuste, qQcm));
		
		List<ReponseFermeeEleve> reponses = new ArrayList<>();
		Collections.addAll(reponses, reponseATroufausse,reponseDragDropfausse,reponseATroujuste,reponseDragDropjuste,reponseQcmfausse,reponseQcmjuste);
		Evaluation evaluation = new Evaluation();
//		Set<Question> questions = new HashSet<>();
//		Collections.addAll(questions, qTrou,qDragDrop,qQcm);
//		evaluation.setQuestions(questions);
		log.info("je corrige les réponses de l'élève à l'évaluation : "+bu.corrigerReponseFermeeEleve(reponses, evaluation).toString());
				
	}


}
