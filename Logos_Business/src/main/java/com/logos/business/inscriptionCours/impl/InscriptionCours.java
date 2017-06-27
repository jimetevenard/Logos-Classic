package com.logos.business.inscriptionCours.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logos.business.inscriptionCours.api.IInscriptionCours;
import com.logos.data.cours.api.IDaoCategorie;
import com.logos.data.cours.api.IDaoChapitre;
import com.logos.data.cours.api.IDaoCours;
import com.logos.data.cours.api.IDaoSuiviCours;
import com.logos.data.niveauLangue.api.IDaoLangues;
import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;
import com.logos.entity.cours.SuiviCours;
import com.logos.entity.user.Eleve;

@Service
public class InscriptionCours implements IInscriptionCours{
	
	public static final int NB_COURS_MAX_NON_PREMIUM = 3;
	
	@Autowired
	private IDaoCours daoCours;
	
	@Autowired
	private IDaoSuiviCours daoSuiviCours;
	
	@Autowired
	private IDaoLangues daoLangue;
	
	@Autowired
	private IDaoCategorie daoCategorie;
	
	@Autowired
	private IDaoChapitre daoChapitre;

	@Override
	public SuiviCours inscrireEleveACours(Eleve eleve, Cours cours) {
		if(isAutriseASinscrire(eleve, cours)){
			SuiviCours nouveauSuiviCours = new SuiviCours(null, new Date(), eleve, cours);
			daoSuiviCours.addSuivi(nouveauSuiviCours);
			return nouveauSuiviCours;
		} else {
			return null;
		}
		
	}

	@Override
	public boolean isAutriseASinscrire(Eleve eleve, Cours cours) {
		return daoSuiviCours.getSuiviByEleve(eleve).size() < NB_COURS_MAX_NON_PREMIUM;
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
		return daoCours.getCoursByLangue(langue);
	}

	@Override
	public List<Cours> getCoursByCategory(Categorie category, Eleve eleve) {
		List<Cours> cours = daoCours.getCoursByCategorie(category);
		// TODO Auto-generated method stub
		// sans les niveaux inférieurs
		// sans les cours interdits
		return cours;
	}

	@Override
	public List<Cours> getCoursByNiveau(Niveau niveau, Eleve eleve) {
		// TODO SUPÉRIEURS ?
		// sans les niveaux inférieurs
		return daoCours.getCoursByNiveau(niveau);
		
	}

	@Override
	public List<Cours> getCoursRecommandes(Eleve eleve) {
		// TODO Auto-generated method stub
		
		// Cours dans les langues de l'évève,
		// de niveau supérieur supérieur
		// ( les mieux noté en premier ?)
		// 
		
		return daoSuiviCours.getCoursInscritsByEleve(eleve);
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

	@Override
	public List<Categorie> getAllCategorie() {
		return daoCategorie.getAllCategories();
	}

	@Override
	public List<Langue> getAllLangue() {
		return daoLangue.getAllLangues();

	}

	@Override
	public List<Cours> getCoursByCategoryLangue(Categorie category, Eleve eleve, Langue langue) {
		List<Cours> listeLangue = daoCours.getCoursByLangue(langue);
		List<Cours> listeCoursCat = daoCours.getCoursByCategorie(category);
		List<Cours> listeFinale = new ArrayList<>();
		
		for (int i = 0; i < listeLangue.size() ; i++) {
			for (int j = 0; j < listeCoursCat.size() ; j++) {
				if(listeLangue.get(i).getIdCours() == listeCoursCat.get(j).getIdCours()){
					listeFinale.add(listeCoursCat.get(j));
				}
			}
		}
		System.out.println(listeFinale.size());
		
				return listeFinale;
//		List<Cours> listeCoursNiveau;
//		List<Cours> cours = new ArrayList<>(getCoursByCategory(category, eleve)) ;
//		List<Cours>coursLangue=new ArrayList<>();
//		for (Cours cours2 : cours) {
//			if(cours2.getNiveau().getLangue()==langue){
//				coursLangue.add(cours2);
//			}
//			
//		}
		

	}

	@Override
	public List<Chapitre> getChapitresByCours(Cours c) {
		return daoChapitre.getAllChapitresByCours(c);
	}
	
	

}
