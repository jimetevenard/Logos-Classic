package com.logos.data.api.correction;

import java.util.List;

import com.logos.entity.evaluation.Correction;
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;

public interface IDaoCorrection {
	List<Correction>getAllCorrections();
	Correction getCorrectionById(Integer id);
	Correction addCorrection(Correction correction);
	Correction updateCorrection(Correction correction);
	boolean deleteCorrection(Correction correction);
	Correction getCorrectionByReponse(ReponseEleve reponse);
	List<Correction> getCorrectionByProfesseur(Professeur professeur);
	List<Correction> getCorrectionByEleve(Eleve eleve);
}
