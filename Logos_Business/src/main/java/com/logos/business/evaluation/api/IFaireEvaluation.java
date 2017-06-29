package com.logos.business.evaluation.api;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

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
public interface IFaireEvaluation {
	List<Evaluation> getEvaluationsByChapitre(Chapitre chapitre);
	RealiseEvaluation realiserEvaluation(Evaluation evaluation, Eleve eleve, Set<ReponseEleve> reponses);
	double calculerNoteEvaluation(List<ReponseEleve> reponses,  RealiseEvaluation realiseEval);
	List<Question> getQuestionByEvaluation(Evaluation evaluation);
	List<ReponseEleve> getReponseEleveByEvaluation(Evaluation evaluation);
	Correction getCorrectionByReponseOuverte(ReponseOuverteEleve reponse);
	List<Boolean> corrigerReponseFermeeEleve(List<ReponseFermeeEleve> reponses, RealiseEvaluation realiseEval);
	Boolean corrigerReponseQcm(ReponseQcmEleve reponseQcm, QuestionQcm questionQcm);
	Boolean corrigerReponseATrous(ReponseATrousEleve reponseATrou, QuestionATrous questionATrou);
	Set<RealiseEvaluation> getRealiseEvaluationByEleve(Eleve eleve);
	Set<ReponseEleve> addReponsesEleve(Set<ReponseEleve> reponses, RealiseEvaluation realiseEvaluationEnCours);
	Question getQuestionById(Integer id);
	
}
