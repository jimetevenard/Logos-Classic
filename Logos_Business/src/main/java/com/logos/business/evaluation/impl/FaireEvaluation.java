package com.logos.business.evaluation.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.logos.business.evaluation.api.IFaireEvaluation;
import com.logos.data.correction.api.IDaoCorrection;
import com.logos.data.evaluation.api.IDaoEvaluation;
import com.logos.data.evaluation.api.IDaoExercice;
import com.logos.data.evaluation.api.IDaoRealiseEvaluation;
import com.logos.data.evaluation.api.IDaoTestDeNiveau;
import com.logos.data.evaluation.api.IDaoTestDeValidation;
import com.logos.data.question.api.IDaoQuestion;
import com.logos.data.reponseeleve.api.IDaoReponseEleve;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Niveau;
import com.logos.entity.evaluation.Correction;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.question.Question;
import com.logos.entity.question.QuestionATrous;
import com.logos.entity.question.QuestionDragAndDrop;
import com.logos.entity.question.QuestionQcm;
import com.logos.entity.reponse.ReponseATrousEleve;
import com.logos.entity.reponse.ReponseDragAndDropEleve;
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.reponse.ReponseFermeeEleve;
import com.logos.entity.reponse.ReponseOuverteEleve;
import com.logos.entity.reponse.ReponseQcmEleve;
import com.logos.entity.user.Eleve;

public class FaireEvaluation implements IFaireEvaluation{
	
	@Autowired
	private IDaoCorrection daoCorrection;
	@Autowired
	private IDaoEvaluation daoEvaluation;
	@Autowired
	private IDaoExercice daoExercice;
	@Autowired
	private IDaoRealiseEvaluation daoRealiseEvaluation;
	@Autowired
	private IDaoTestDeNiveau daoTestDeNiveau;
	@Autowired
	private IDaoTestDeValidation daoTestDeValidation;
	@Autowired
	private IDaoQuestion daoQuestion;
	@Autowired
	private IDaoReponseEleve daoReponseEleve;
	
	


	@Override
	public RealiseEvaluation realiserEvaluation(Evaluation evaluation, Eleve eleve, Set<ReponseEleve> reponses) {
		RealiseEvaluation realiseEval= new RealiseEvaluation(null, new Date(), eleve, evaluation);
		realiseEval.setReponsesEleve(reponses);
		daoRealiseEvaluation.addRealiseEvaluation(realiseEval);
		return realiseEval;
	}



	@Override
	public List<Evaluation> getEvaluationByNiveau(Niveau niveau) {
		return null;
	}

	@Override
	public List<Question> getQuestionByEvaluation(Evaluation evaluation) {
		List<Question> questions = daoQuestion.getQuestionByEvaluation(evaluation);
		return questions;
	}

	@Override
	public List<ReponseEleve> getReponseEleveByEvaluation(Evaluation evaluation) {
		return null;
	}

	@Override
	public Correction getCorrectionByReponseOuverte(ReponseOuverteEleve reponse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evaluation> getEvaluationByCours(Cours cours) {
		
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public List<Boolean> corrigerReponseFermeeEleve(List<ReponseFermeeEleve> reponses, Evaluation evaluation) {
		List<Question> questionsEvaluation = (List<Question>) evaluation.getQuestions();
		List<Boolean> correction=null;
		int numeroQuestion =1;
		for(Question question : questionsEvaluation){
			switch (question.getClass().getSimpleName()) {
			case "QuestionQcm":
				QuestionQcm questionQcm= (QuestionQcm) question;
				ReponseQcmEleve reponseQcm = (ReponseQcmEleve) reponses.get(numeroQuestion);
				correction.add(corrigerReponseQcm(reponseQcm, questionQcm));
				numeroQuestion++;
				break;
			case "QuestionDragAndDrop":
				QuestionDragAndDrop questionDragDrop = (QuestionDragAndDrop) question;
				ReponseDragAndDropEleve reponseDragDrop = (ReponseDragAndDropEleve) reponses.get(numeroQuestion);
				correction.add(corrigerReponseDragAndDrop(reponseDragDrop, questionDragDrop));
				numeroQuestion++;
				break;
			case "QuestionATrous":
				QuestionATrous questionATrou = (QuestionATrous) question;
				ReponseATrousEleve reponseATrou = (ReponseATrousEleve) reponses.get(numeroQuestion);
				correction.add(corrigerReponseATrous(reponseATrou, questionATrou));
				numeroQuestion++;
				break;
			}
		}		
		return correction;
	}
	

	@Override
	public Boolean corrigerReponseQcm(ReponseQcmEleve reponseQcm, QuestionQcm questionQcm) {

//		List<Integer> solutionsQcm = questionQcm.getSolutions();
//		if(repQcm.equals(solutionsQcm)){
//			correction.add(true);
//		}else{
//			correction.add(false);
//		}
		return null;
	}

	@Override
	public Boolean corrigerReponseDragAndDrop(ReponseDragAndDropEleve reponseDragDrop,
			QuestionDragAndDrop questionDragDrop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean corrigerReponseATrous(ReponseATrousEleve reponseATrou, QuestionATrous questionATrou) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculerNoteEvaluation(List<ReponseEleve> reponses) {
		// TODO Auto-generated method stub
		return 0;
	}

}
