package com.logos.business.inscriptionCours.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logos.business.inscriptionCours.api.IInscriptionCours;
import com.logos.data.cours.api.IDaoCours;
import com.logos.data.cours.api.IDaoSuiviCours;
import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;
import com.logos.entity.cours.SuiviCours;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;


public class InscriptionCoursTest implements IInscriptionCours{
	
	private Professeur prof = new Professeur(1, "dédé", "didier", "", "", "");
	private Eleve elv = new Eleve(34, "Dupont", "Jean", "", "", "");
	
	private Cours c1 = new Cours(1, "Le vocabulaire pour les nuls", "Introduction du cours...", new Date(), new Date(), prof , null);
	private Cours c2 = new Cours(2, "Le vocabulaire pour les noobs", "Introduction du cours...", new Date(), new Date(), prof , null);
	private Cours c3 = new Cours(3, "La grammaire pour les nuls", "Introduction du cours...", new Date(), new Date(), prof , null);
	private Cours c4 = new Cours(4, "Le conjugaison pour les nuls", "Introduction du cours...", new Date(), new Date(), prof , null);
	private Cours c5 = new Cours(5, "Le triche pour les nuls", "Introduction du cours...", new Date(), new Date(), prof , null);
	private Cours c6 = new Cours(6, "Le vie quotidienne pour les nuls", "Introduction du cours...", new Date(), new Date(), prof , null);
	private Cours c7 = new Cours(7, "L'amour pour les nuls", "Introduction du cours...", new Date(), new Date(), prof , null);
	private Cours c8 = new Cours(8, "Les supermarchés pour les nuls", "Introduction du cours...", new Date(), new Date(), prof , null);
	private Cours c9 = new Cours(9, "Le automobiles pour les nuls", "Introduction du cours...", new Date(), new Date(), prof , null);

	
	private Categorie cat1 = new Categorie(23, "Vocabulaire");
	private Categorie cat2 = new Categorie(25, "Conjugaision");
	private Categorie cat3 = new Categorie(230, "Grammaire");
	
	private Langue en = new Langue(123, "Anglais", "en");
	private Langue fr = new Langue(133, "Français", "fr");
	private Langue es = new Langue(23, "Espagnol", "es");
	private Langue ge = new Langue(1213, "Allemand", "ge");
	
	private Set<Categorie> cats = new HashSet<>( Arrays.asList(cat1, cat2, cat3) );
	
	private SuiviCours sc1 = new SuiviCours(32, new Date(), elv, c1);
	private SuiviCours sc2 = new SuiviCours(33, new Date(), elv, c2);
	private SuiviCours sc3 = new SuiviCours(67, new Date(), elv, c3);
	private SuiviCours sc4 = new SuiviCours(3243, new Date(), elv, c4);
	private SuiviCours sc5 = new SuiviCours(332, new Date(), elv, c5);
	
	

	public InscriptionCoursTest() {
		
		c1.setCategories(cats);
		c2.setCategories(cats);
		cat1.setCourses( new HashSet<Cours>( Arrays.asList( c1, c1) ));	
		
	}

	@Override
	public SuiviCours inscrireEleveACours(Eleve eleve, Cours cours) {
		return sc1;
		
	}

	@Override
	public boolean isAutriseASinscrire(Eleve eleve, Cours cours) {
		// TODO completer
		return true;
	}
	
	@Override
	public boolean donnerNote(Eleve eleve, Cours cours, int note) {
		
		return true;
		
	}

	@Override
	public Integer getNoteDonnee(Cours cours, Eleve eleve) {
		return (int) Math.floor(Math.random() * 3 + 2);
	}

	@Override
	public List<Cours> getCoursByLangue(Langue langue, Eleve eleve) {
		return Arrays.asList(c3,c4,c5,c6,c7);
	}

	@Override
	public List<Cours> getCoursByCategory(Categorie category, Eleve eleve) {
		return Arrays.asList(c1,c9,c6,c6,c7);
	
	}

	@Override
	public List<Cours> getCoursByNiveau(Niveau niveau, Eleve eleve) {
		return Arrays.asList(c1,c7,c9,c2,c7);
	}

	@Override
	public List<Cours> getCoursRecommandes(Eleve eleve) {
		return Arrays.asList(c3,c7,c2,c1,c8);
	}

	@Override
	public Double getNoteMoyenneByCours(Cours cours) {
		return Math.random() * 3 + 2;
	}

	@Override
	public List<SuiviCours> getSuiviCourByEleve(Eleve eleve) {
		return Arrays.asList(sc1, sc2, sc3, sc4, sc5);
	}

	@Override
	public List<Categorie> getAllCategorie() {
		return Arrays.asList(cat1, cat2, cat3);
	}

	@Override
	public List<Langue> getAllLangue( ) {
		return Arrays.asList(en, fr, es, ge);
	}

	@Override
	public List<Cours> getCoursByCategory(Categorie category, Eleve eleve, Langue langue) {
		List<Cours> cours = new ArrayList<>(getCoursByCategory(category, eleve)) ;
		for (Cours cours2 : cours) {
			cours2.setTitre(cours2.getTitre()+" en "+langue.getLibelle());
		}
		
		return cours;
	}

	@Override
	public List<Chapitre> getChapitresByCours(Cours c) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
