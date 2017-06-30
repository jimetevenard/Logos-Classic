package com.logos.business.evaluation.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import com.logos.entity.cours.Chapitre;
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

@Service
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
		realiseEval=daoRealiseEvaluation.addRealiseEvaluation(realiseEval);
		return realiseEval;
	}
	
	public Question getQuestionById(Integer id){
		Question question = daoQuestion.getQuestionById(id);
		return question;
	}

	@Override
	public Set<ReponseEleve> addReponsesEleve(Set<ReponseEleve> reponses, RealiseEvaluation realiseEvaluationEnCours) {
		for(ReponseEleve r: reponses){
			r.setRealiseEvaluation(realiseEvaluationEnCours);
			Question q1 = getQuestionById(r.getQuestion().getIdQuestion());
			r.setQuestion(q1);
			daoReponseEleve.addReponseEleve(r);
		}
		return reponses;
	}
	
	@Override
	public List<Question> getQuestionByEvaluation(Evaluation evaluation) {
		List<Question> questions = daoQuestion.getQuestionByEvaluation(evaluation);
		return questions;
	}

	@Override
	public List<ReponseEleve> getReponseEleveByEvaluation(Evaluation evaluation) {
		List<ReponseEleve> reponses = daoReponseEleve.getReponseByEvaluation(evaluation);
		return reponses;
	}

	@Override
	public Correction getCorrectionByReponseOuverte(ReponseOuverteEleve reponse) {
		Correction correction = daoCorrection.getCorrectionByReponse(reponse);
		return correction;
	}

	@Override
	public List<Evaluation> getEvaluationsByChapitre(Chapitre chapitre) {
		List<Evaluation> listeEval= daoEvaluation.getEvaluationsByChapitre(chapitre);
		return listeEval;
	}

	@Override
	public List<Boolean> corrigerReponseFermeeEleve(List<ReponseFermeeEleve> reponses, RealiseEvaluation realiseEval) {
		List<Boolean> correction=new ArrayList<>();
		List<ReponseEleve> reponsesAll = getReponseByRealiseEvaluation(realiseEval);
		for (ReponseEleve r : reponsesAll) {
			if(r.getClass().getSimpleName().equals("ReponseFermeeEleve")){
				reponses.add((ReponseFermeeEleve) r);
			}
		}
		for(ReponseFermeeEleve reponse : reponses){
			switch (reponse.getQuestion().getClass().getSimpleName()) {
			case "QuestionQcm":
				QuestionQcm questionQcm= (QuestionQcm) reponse.getQuestion();
				ReponseQcmEleve reponseQcm = (ReponseQcmEleve) reponse;
				correction.add(corrigerReponseQcm(reponseQcm, questionQcm));
				break;
			case "QuestionDragAndDrop":
				QuestionATrous questionDragAndDrop = (QuestionATrous)reponse.getQuestion();
				ReponseATrousEleve reponseDragAndDrop = (ReponseATrousEleve) reponse;
				correction.add(corrigerReponseATrous(reponseDragAndDrop, questionDragAndDrop));
				break;
			case "QuestionATrous":
				QuestionATrous questionATrou = (QuestionATrous)reponse.getQuestion();
				ReponseATrousEleve reponseATrou = (ReponseATrousEleve) reponse;
				correction.add(corrigerReponseATrous(reponseATrou, questionATrou));
				break;
			}
		}
		return correction;
	}

	@Override
	public Boolean corrigerReponseQcm(ReponseQcmEleve reponseQcm, QuestionQcm questionQcm) {
		//		List<Integer> solutionsQcm = questionQcm.getSolutions(); // à enlever après le test bidon
		List<Integer> solutionsQcm = daoQuestion.getSolutionsByQuestionQcm(questionQcm);
		for(int i = 0; i < solutionsQcm.size(); i++){
			if(! solutionsQcm.get(i).equals(reponseQcm.getReponseQcm().get(i) )){
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean corrigerReponseATrous(ReponseATrousEleve reponseATrou, QuestionATrous questionATrou) {
		//		List<String> solutions = questionATrou.getSolutions(); // à enlever après le test bidon
		List<String> solutions = daoQuestion.getSolutionsByQuestionATrous(questionATrou);
		for(int i = 0; i < solutions.size(); i++){
			if(! solutions.get(i).equals(reponseATrou.getReponseATrou().get(i) )){
				return false;
			}
		}
		return true;
	}

	public List<ReponseEleve> getReponseByRealiseEvaluation(RealiseEvaluation realiseEval) {
		return daoReponseEleve.getReponseByRealiseEvaluation(realiseEval);
	}

	@Override
	public double calculerNoteEvaluation(List<ReponseEleve> reponses, RealiseEvaluation realiseEval) {
		List<ReponseFermeeEleve> reponsesFermmeesEleve = new ArrayList<>();
		List<ReponseOuverteEleve> reponsesOuvertesEleve = new ArrayList<>();
		for(ReponseEleve r : reponses){
			if(r.getClass().getSimpleName().equals("ReponseOuverteEleve")){
				ReponseOuverteEleve r2 = (ReponseOuverteEleve)r;
				if(r2.getCorrection() != null) {
					reponsesOuvertesEleve.add((ReponseOuverteEleve) r2);
				}
			}else{
				reponsesFermmeesEleve.add((ReponseFermeeEleve) r);
			}
		}
		double noteMoyenneQuestionsFermees = calculNoteMoyenneQuestionsFermees(reponsesFermmeesEleve, realiseEval);
		if(reponsesOuvertesEleve.size() != 0) {
			double noteMoyenneQuestionsOuvertes = calculNoteMoyenneQuestionsOuvertes(reponsesOuvertesEleve);
			return (noteMoyenneQuestionsFermees+noteMoyenneQuestionsOuvertes)/2;
		}
		return noteMoyenneQuestionsFermees;
	}
	
	@Override
	public double calculerNoteEvaluation(RealiseEvaluation realiseEval) {
		List<ReponseEleve> reponses = daoReponseEleve.getReponseByRealiseEvaluation(realiseEval);
		
		return calculerNoteEvaluation(reponses, realiseEval);
	}

	public double calculNoteMoyenneQuestionsFermees(List<ReponseFermeeEleve> reponsesFermmeesEleve, RealiseEvaluation realiseEval){
		List<Boolean> reponsesFermmeesEleveCorrige = corrigerReponseFermeeEleve(reponsesFermmeesEleve, realiseEval);
		int nbrReponsesFermeesJustes = 0;
		for(Boolean b : reponsesFermmeesEleveCorrige){
			if(b){
				nbrReponsesFermeesJustes++;
			}
		}
		double nbrReponsesFermees = reponsesFermmeesEleveCorrige.size();
		double noteMoyenneSur20QuestionsFermees =  (20*nbrReponsesFermeesJustes)/nbrReponsesFermees;
		return noteMoyenneSur20QuestionsFermees;
	}

	public double calculNoteMoyenneQuestionsOuvertes(List<ReponseOuverteEleve> reponsesOuvertesEleve){
		double noteMoyenneQuestionsOuvertes=0;
		List<Integer> notes = new ArrayList<>();
		for(ReponseOuverteEleve r: reponsesOuvertesEleve){
			//			Integer note = r.getCorrection().getNote(); // à enlever après le test bidon
			Integer note = daoCorrection.getCorrectionByReponse(r).getNote();
			notes.add(note);
		}
		for(Integer note: notes){
			noteMoyenneQuestionsOuvertes+=note;
		}
		noteMoyenneQuestionsOuvertes=noteMoyenneQuestionsOuvertes/notes.size();
		return noteMoyenneQuestionsOuvertes;
	}


	@Override
	public Set<RealiseEvaluation> getRealiseEvaluationByEleve(Eleve eleve) {
		Set<RealiseEvaluation> listeRE = daoRealiseEvaluation.getRealiseEvaluationByEleve(eleve);
		return listeRE;
	}


	public IDaoCorrection getDaoCorrection() {
		return daoCorrection;
	}


	public void setDaoCorrection(IDaoCorrection daoCorrection) {
		this.daoCorrection = daoCorrection;
	}


	public IDaoEvaluation getDaoEvaluation() {
		return daoEvaluation;
	}


	public void setDaoEvaluation(IDaoEvaluation daoEvaluation) {
		this.daoEvaluation = daoEvaluation;
	}


	public IDaoExercice getDaoExercice() {
		return daoExercice;
	}


	public void setDaoExercice(IDaoExercice daoExercice) {
		this.daoExercice = daoExercice;
	}


	public IDaoRealiseEvaluation getDaoRealiseEvaluation() {
		return daoRealiseEvaluation;
	}


	public void setDaoRealiseEvaluation(IDaoRealiseEvaluation daoRealiseEvaluation) {
		this.daoRealiseEvaluation = daoRealiseEvaluation;
	}


	public IDaoTestDeNiveau getDaoTestDeNiveau() {
		return daoTestDeNiveau;
	}


	public void setDaoTestDeNiveau(IDaoTestDeNiveau daoTestDeNiveau) {
		this.daoTestDeNiveau = daoTestDeNiveau;
	}


	public IDaoTestDeValidation getDaoTestDeValidation() {
		return daoTestDeValidation;
	}


	public void setDaoTestDeValidation(IDaoTestDeValidation daoTestDeValidation) {
		this.daoTestDeValidation = daoTestDeValidation;
	}


	public IDaoQuestion getDaoQuestion() {
		return daoQuestion;
	}


	public void setDaoQuestion(IDaoQuestion daoQuestion) {
		this.daoQuestion = daoQuestion;
	}


	public IDaoReponseEleve getDaoReponseEleve() {
		return daoReponseEleve;
	}


	public void setDaoReponseEleve(IDaoReponseEleve daoReponseEleve) {
		this.daoReponseEleve = daoReponseEleve;
	}


	


}
