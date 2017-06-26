package com.logos.data.cours.api;

import java.util.List;

import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;

public interface IDaoCours {
	
	Cours addCours(Cours cours);
	Cours updateCours(Cours cours);
	boolean deleteCours(Cours cours);
	Cours getCoursByid(Integer id);
	List<Cours> getCoursByLangue(Langue langue);
	List<Cours> getCoursByCategorie(Categorie categorie);
	List<Cours> getCoursByNiveau(Niveau niveau);
	List<Cours> getCoursByNiveauSuperieur(Niveau niveau);
	Double getNoteMoyenneByCours(Cours cours);
	
}
