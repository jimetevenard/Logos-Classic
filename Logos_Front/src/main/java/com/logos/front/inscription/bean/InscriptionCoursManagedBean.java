package com.logos.front.inscription.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.logos.business.inscriptionCours.api.IInscriptionCours;
import com.logos.business.inscriptionCours.impl.InscriptionCoursTest;
import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;
import com.logos.entity.cours.SuiviCours;
import com.logos.entity.evaluation.TestDeValidation;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;
import com.logos.front.connexion.LoginMB;

@ManagedBean(name="mbInscriptionCours")
@SessionScoped
public class InscriptionCoursManagedBean {
	
//	@ManagedProperty(value="#{inscriptionCours}")
	private IInscriptionCours bu = new InscriptionCoursTest();
	
	@ManagedProperty(value="#{loginMB}")
	private LoginMB logMb;
	
	private Eleve eleve;
	private String message;
	private Double note;
	private Langue langue;
	private Set<Niveau> niveaux;
	private List<Langue>langues;
	private Categorie categorie;
	private List<Cours> coursEleve;
	private List<Cours> coursesR;
	private List<Cours> coursesL;
	private List<Cours> coursesC;
	
	@PostConstruct
	public void init(){
//		coursesR= new ArrayList<>();
//		Cours c=new Cours(null, "grammaire", "introduction", new Date(), new Date(), new Professeur(), new TestDeValidation());
//		coursesR.add(c);
		eleve = new Eleve(null, "toto", null, null, null, null);
		
//		eleve = (Eleve) logMb.getUserConnected();
		coursesR = bu.getCoursRecommandes(eleve);
//		niveaux = eleve.getNiveaux();
//		for(Niveau n : niveaux){
//			langues.add(n.getLangue());
//		}
		
	}
	
	public String inscrireACours(Cours c){
			bu.inscrireEleveACours(eleve, c);
			return "/cours.xhtml?faces-redirect=true";
		
	}
	
	public Double noteCours(Cours c){
//		note = bu.getNoteMoyenneByCours(c);
		return note;
	}
	
	public void getCoursByLangue(){
		coursesL = bu.getCoursByLangue(langue, eleve);
	}
	
	public void getCoursByCategorie(){
		coursesC = bu.getCoursByCategory(categorie, eleve);
	}

	
	public void getCoursByEleve(){
		Set<SuiviCours> suivis = new HashSet<>();
		suivis = eleve.getSuiviCours();
		for(SuiviCours s : suivis){
			coursEleve.add(s.getCours());
		}
	}
	
	public IInscriptionCours getBu() {
		return bu;
	}

	public void setBu(IInscriptionCours bu) {
		this.bu = bu;
	}

	public LoginMB getLogMb() {
		return logMb;
	}

	public void setLogMb(LoginMB logMb) {
		this.logMb = logMb;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	public Langue getLangue() {
		return langue;
	}

	public void setLangue(Langue langue) {
		this.langue = langue;
	}

	public Set<Niveau> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(Set<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

	public List<Langue> getLangues() {
		return langues;
	}

	public void setLangues(List<Langue> langues) {
		this.langues = langues;
	}

	public List<Cours> getCoursesR() {
		return coursesR;
	}

	public void setCoursesR(List<Cours> coursesR) {
		this.coursesR = coursesR;
	}

	public List<Cours> getCoursesL() {
		return coursesL;
	}

	public void setCoursesL(List<Cours> coursesL) {
		this.coursesL = coursesL;
	}

	public List<Cours> getCoursesC() {
		return coursesC;
	}

	public void setCoursesC(List<Cours> coursesC) {
		this.coursesC = coursesC;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Cours> getCoursEleve() {
		return coursEleve;
	}

	public void setCoursEleve(List<Cours> coursEleve) {
		this.coursEleve = coursEleve;
	}
	
	
	

}
