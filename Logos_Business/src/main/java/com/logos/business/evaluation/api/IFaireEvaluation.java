package com.logos.business.evaluation.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Niveau;
import com.logos.entity.evaluation.Correction;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.question.Question;
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.reponse.ReponseFermeeEleve;
import com.logos.entity.reponse.ReponseOuverteEleve;
import com.logos.entity.user.Eleve;

@Service
public interface IFaireEvaluation {
	List<Evaluation> getEvaluationByCours(Cours cours); 
	RealiseEvaluation realiserEvaluation(Evaluation evaluation, Eleve eleve);
	double calculerNoteEvaluation(List<ReponseEleve> reponses);
	List<Evaluation> getEvaluationByNiveau(Niveau niveau);
	List<Question> getQuestionByEvaluation(Evaluation evaluation);
	List<ReponseEleve> getReponseEleveByEvaluation(Evaluation evaluation);
	Correction getCorrectionByReponseOuverte(ReponseOuverteEleve reponse);
	List<Boolean> corrigerReponseFermeeEleve(List<ReponseFermeeEleve> reponses);
}
