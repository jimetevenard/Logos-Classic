package com.logos.business.suiviCours.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logos.business.suiviCours.api.ISuiviCoursBu;
import com.logos.data.cours.api.IDaoSuiviCours;
import com.logos.data.evaluation.api.IDaoRealiseEvaluation;
import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.SuiviCours;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.user.Eleve;

@Service
public class SuiviCoursBu implements ISuiviCoursBu{
	
	@Autowired
	IDaoSuiviCours daoSuivi;
	
	@Autowired
	IDaoRealiseEvaluation daoRE;

	@Override
	public List<SuiviCours> getAllSuiviCours(Eleve dude) {
		// TODO Auto-generated method stub
		return daoSuivi.getSuiviByEleve(dude);
	}

	@Override
	public List<RealiseEvaluation> getAllRealiseEvaluation(Eleve dude) {
		Set<RealiseEvaluation> revels = daoRE.getRealiseEvaluationByEleve(dude);
		List<RealiseEvaluation> retour = new ArrayList<>(revels);
		retour.sort(new CompateurEval());
		return retour;
	}
	
	private class CompateurEval implements Comparator<RealiseEvaluation> {

		@Override
		public int compare(RealiseEvaluation o1, RealiseEvaluation o2) {
			return o1.getDateEvaluation().compareTo(o2.getDateEvaluation());
		}
		
	}
	
	public Set<Chapitre> getChapitresLuBySuiviCours(SuiviCours sC){
		return daoSuivi.getChapitresLuBySuiviCours(sC);
	}
	
	

	public IDaoSuiviCours getDaoSuivi() {
		return daoSuivi;
	}

	public void setDaoSuivi(IDaoSuiviCours daoSuivi) {
		this.daoSuivi = daoSuivi;
	}

	public IDaoRealiseEvaluation getDaoRE() {
		return daoRE;
	}

	public void setDaoRE(IDaoRealiseEvaluation daoRE) {
		this.daoRE = daoRE;
	}
	
	

}
