package com.logos.data.evaluation.api;

import java.util.List;

import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.user.Eleve;

public interface IDaoRealiseEvaluation {
	List<RealiseEvaluation> getRealiseEvaluationByEleve(Eleve eleve);
	RealiseEvaluation addRealiseEvaluation(RealiseEvaluation realiseEvaluation);
}
