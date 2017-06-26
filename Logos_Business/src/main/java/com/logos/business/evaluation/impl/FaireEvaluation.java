package com.logos.business.evaluation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.reponse.ReponseFermeeEleve;
import com.logos.entity.reponse.ReponseOuverteEleve;
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
	public List<Evaluation> getEvaluationByCours(Cours cours) {
		
		return null;
	}

	@Override
	public RealiseEvaluation realiserEvaluation(Evaluation evaluation, Eleve eleve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculerNoteEvaluation(List<ReponseEleve> reponses) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Evaluation> getEvaluationByNiveau(Niveau niveau) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestionByEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReponseEleve> getReponseEleveByEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Correction getCorrectionByReponseOuverte(ReponseOuverteEleve reponse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boolean> corrigerReponseFermeeEleve(List<ReponseFermeeEleve> reponses) {
		// TODO Auto-generated method stub
		return null;
	}

}
