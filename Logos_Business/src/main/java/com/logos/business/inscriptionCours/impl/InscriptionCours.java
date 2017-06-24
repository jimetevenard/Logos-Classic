package com.logos.business.inscriptionCours.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logos.business.inscriptionCours.api.IInscriptionCours;
import com.logos.data.cours.api.IDaoCours;
import com.logos.data.cours.api.IDaoSuiviCours;
import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;
import com.logos.entity.cours.SuiviCours;
import com.logos.entity.user.Eleve;

@Service
public class InscriptionCours implements IInscriptionCours{
	
	//@Autowired
	private IDaoCours daoCours;
	
//	@Autowired
	private IDaoSuiviCours daoSuiviCours;

	@Override
	public SuiviCours inscrireEleveACours(Eleve eleve, Cours cours) {
		if(isAutriseASinscrire(eleve, cours)){
			SuiviCours nouveauSuiviCours = new SuiviCours(null, new Date(), eleve, cours);
			return nouveauSuiviCours;
		} else {
			return null;
		}
		
	}

	@Override
	public boolean isAutriseASinscrire(Eleve eleve, Cours cours) {
		// TODO completer
		return true;
	}
	
	@Override
	public boolean donnerNote(Eleve eleve, Cours cours, int note) {
		// un élévève peut suivre plusieur fois le même cours
		// mais il ne donne qu'une note au cours
		// s'il a déjà noté le cours lors d'un suivi précédent
		// la note est mise à jour
		
		Integer noteDejaDonnee = getNoteDonnee(cours, eleve);
		List<SuiviCours> suivis = daoSuiviCours.getSuiviByEleveEtCours(eleve, cours);
		
		if(suivis.size() == 0){
			// l'élève n'a jamais suivi ce cours
			return false;		
		}
		
		if(noteDejaDonnee != null){
			for(SuiviCours s : suivis){
				s.setNoteCours(null);		
			}
		}
		suivis.get(suivis.size() - 1).setNoteCours(note);	
		return true;
		
	}

	@Override
	public Integer getNoteDonnee(Cours cours, Eleve eleve) {
		Integer noteDonnee = null;
		List<SuiviCours> suivis = daoSuiviCours.getSuiviByEleveEtCours(eleve, cours);
		for (SuiviCours suiviCours : suivis) {
			noteDonnee = suiviCours.getNoteCours();
			if(noteDonnee != null) {
				return noteDonnee;
			}
		}
		return noteDonnee;
	}

	@Override
	public List<Cours> getCoursByLangue(Langue langue, Eleve eleve) {
		// TODO Auto-generated method stub
		// sans les niveaux inférieurs
		// sans les cours interdits
		return null;
	}

	@Override
	public List<Cours> getCoursByCategory(Categorie category, Eleve eleve) {
		// TODO Auto-generated method stub
		// sans les niveaux inférieurs
		// sans les cours interdits
		return null;
	}

	@Override
	public List<Cours> getCoursByNiveau(Niveau niveau, Eleve eleve) {
		// TODO Auto-generated method stub
		// sans les niveaux inférieurs
		return null;
	}

	@Override
	public List<Cours> getCoursRecommandes(Eleve eleve) {
		// TODO Auto-generated method stub
		// langues de l'évève 
		// niveau supérieur
		return null;
	}

	@Override
	public Double getNoteMoyenneByCours(Cours cours) {
		return daoCours.getNoteMoyenneByCours(cours);
	}

	@Override
	public List<SuiviCours> getSuiviCourByEleve(Eleve eleve) {
		return daoSuiviCours.getSuiviByEleve(eleve);
	}

	public IDaoCours getDaoCours() {
		return daoCours;
	}

	public void setDaoCours(IDaoCours daoCours) {
		this.daoCours = daoCours;
	}

	public IDaoSuiviCours getDaoSuiviCours() {
		return daoSuiviCours;
	}

	public void setDaoSuiviCours(IDaoSuiviCours daoSuiviCours) {
		this.daoSuiviCours = daoSuiviCours;
	}
	
	

}
