package com.logos.data.reponseeleve.api;

import java.util.List;

import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.reponse.ReponseATrousEleve;
import com.logos.entity.reponse.ReponseDragAndDropEleve;
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.reponse.ReponseFermeeEleve;
import com.logos.entity.reponse.ReponseOuverteEleve;
import com.logos.entity.reponse.ReponseQcmEleve;
import com.logos.entity.user.Eleve;

public interface IDaoReponseEleve {
	ReponseEleve getReponseById(Integer id);
	List<ReponseEleve> getReponseByEvaluation(Evaluation evaluation);
	ReponseEleve addReponseEleve(ReponseEleve reponse);
//	ReponseDragAndDropEleve addReponseDragAndDropEleve(ReponseDragAndDropEleve reponse);
//	ReponseATrousEleve addReponseATrou(ReponseATrousEleve reponse);
//	ReponseQcmEleve addReponseFermeeQcmEleve (ReponseQcmEleve reponse);
	ReponseEleve updateReponse(ReponseEleve reponse);
	boolean deleteReponse(ReponseEleve reponse);
	ReponseOuverteEleve getReponseOuverteById(Integer id);
	ReponseQcmEleve getReponseQcmById(Integer id);
	ReponseATrousEleve getReponseATrousById(Integer id);
	ReponseDragAndDropEleve getReponseDragDropById(Integer id);
	List<ReponseEleve> getReponseByEleve(Eleve eleve);
	List<ReponseEleve> getReponseByRealiseEvaluation(RealiseEvaluation realiseEval);
}
