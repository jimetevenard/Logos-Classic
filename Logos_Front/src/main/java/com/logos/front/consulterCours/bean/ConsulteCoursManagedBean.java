package com.logos.front.consulterCours.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.logos.business.inscriptionCours.api.IInscriptionCours;
import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.Cours;

@ManagedBean(name="mbConsulteCours")
@SessionScoped
public class ConsulteCoursManagedBean {
	private List<Chapitre> listeChapitre ;
	private int indiceChapitreEnCours ;
	private Cours coursEnCours;
	private Chapitre chapitreEnCours;
	private int indexCourant = 0;
	
	@ManagedProperty(value="#{inscriptionCours}")
	private IInscriptionCours buInscription ;
	
	@PostConstruct
	public void init(){
		
	}

	public String consulterCours(Cours c){
		listeChapitre = buInscription.getChapitresByCours(c);
		coursEnCours = c ;
		chapitreEnCours = listeChapitre.get(indexCourant);
		indiceChapitreEnCours= listeChapitre.indexOf(chapitreEnCours);
		System.out.println(listeChapitre.size());
		return "cours.xhtml?faces-redirect=true";

	}
	
	public void changerChapitre(int i){
	
			indexCourant += i;
	
		consulterCours(coursEnCours);
	}

	public List<Chapitre> getListeChapitre() {
		return listeChapitre;
	}

	public void setListeChapitre(List<Chapitre> listeChapitre) {
		this.listeChapitre = listeChapitre;
	}


	public int getIndiceChapitreEnCours() {
		return indiceChapitreEnCours;
	}

	public void setIndiceChapitreEnCours(int indiceChapitreEnCours) {
		this.indiceChapitreEnCours = indiceChapitreEnCours;
	}

	public Chapitre getChapitreEnCours() {
		return chapitreEnCours;
	}

	public void setChapitreEnCours(Chapitre chapitreEnCours) {
		this.chapitreEnCours = chapitreEnCours;
	}


	public IInscriptionCours getBuInscription() {
		return buInscription;
	}

	public void setBuInscription(IInscriptionCours buInscription) {
		this.buInscription = buInscription;
	}

	public Cours getCoursEnCours() {
		return coursEnCours;
	}

	public void setCoursEnCours(Cours coursEnCours) {
		this.coursEnCours = coursEnCours;
	}

	public int getIndexCourant() {
		return indexCourant;
	}

	public void setIndexCourant(int indexCourant) {
		this.indexCourant = indexCourant;
	}

	
	
}
