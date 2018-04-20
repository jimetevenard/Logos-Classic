package com.logos.business.suiviCours.api;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.SuiviCours;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.user.Eleve;

@Service
public interface ISuiviCoursBu {
	public List<SuiviCours> getAllSuiviCours(Eleve dude);
	public List<RealiseEvaluation> getAllRealiseEvaluation(Eleve dude);
	
	public Set<Chapitre> getChapitresLuBySuiviCours(SuiviCours sC);
}
