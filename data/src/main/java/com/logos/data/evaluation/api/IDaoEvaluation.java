package com.logos.data.evaluation.api;

import java.util.List;

import com.logos.entity.cours.Chapitre;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.user.Eleve;

public interface IDaoEvaluation {
	Evaluation addEvaluation(Evaluation evaluation);
	Evaluation updateEvaluation(Evaluation evaluation);
	boolean deleteEvaluation(Evaluation evaluation);
	List<Evaluation> getEvaluationByEleve(Eleve eleve);
	List<Evaluation> getEvaluationsByChapitre(Chapitre chapitre);
}
