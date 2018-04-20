package com.logos.data.evaluation.api;

import java.util.Set;

import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.user.Eleve;

public interface IDaoRealiseEvaluation {
	Set<RealiseEvaluation> getRealiseEvaluationByEleve(Eleve eleve);
	RealiseEvaluation addRealiseEvaluation(RealiseEvaluation realiseEvaluation);
}
