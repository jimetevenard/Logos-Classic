package com.logos.front.inscription.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
import com.logos.front.consulterCours.bean.ConsulteCoursManagedBean;

@ManagedBean(name="mbInscriptionCours")
@SessionScoped
public class InscriptionCoursManagedBean {
	
	@ManagedProperty(value="#{inscriptionCours}")
	private IInscriptionCours bu ;
	
	@ManagedProperty(value="#{loginMB}")
	private LoginMB logMb;
	
	@ManagedProperty(value="#{mbConsulteCours}")
	private ConsulteCoursManagedBean buConsulter;
	
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
	private Map<Categorie, List<Cours>> coursCategorie;
	private List<Categorie> categories;
	private Langue langueCourante;
	
	@PostConstruct
	public void init(){
		eleve = (Eleve) logMb.getUserConnected();
		categories =bu.getAllCategorie();
		coursesR = bu.getCoursRecommandes(eleve);
		langues = bu.getAllLangue();
		changerLangue(langues.get(0));
		coursEleve = getCoursByEleve();
	}
	
	public String inscrireACours(Cours c){
			bu.inscrireEleveACours(eleve, c);
			init(); // hé oui, il faut mettre à jour les données du Bean
			System.out.println(buConsulter.consulterCours(c));
			return buConsulter.consulterCours(c);
		
	}
	
	public Double noteCours(Cours c){
//		note = bu.getNoteMoyenneByCours(c);
		return note;
	}
	
	public void getCoursByLangue(){
		coursesL = bu.getCoursByLangue(langue, eleve);
	}
	
	public Map<Categorie, List<Cours>> getCoursByCategorie(){
		Map<Categorie, List<Cours>> cats = new HashMap<>();
		for(Categorie c : categories){
			cats.put(c, bu.getCoursByCategory(c, eleve));
		}
		return cats;
	}
	
	public void changerLangue(Langue langue){
		System.out.println(langue);
		Map<Categorie, List<Cours>> cats = new HashMap<>();
		for(Categorie c : categories){
			System.out.println("catégories : "+c);
			cats.put(c, bu.getCoursByCategoryLangue(c, eleve,langue));
		}
		coursCategorie = cats;
		langueCourante = langue;
	}
	
	
	
	
	public List<Cours> getCoursByEleve(){
		List<SuiviCours> suivis = new ArrayList<>();
		suivis = bu.getSuiviCourByEleve(eleve);
		List<Cours> coursEleve =new ArrayList<>();
		for (SuiviCours s : suivis){
			coursEleve.add(s.getCours());
		}
		return coursEleve;
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

	public Map<Categorie, List<Cours>> getCoursCategorie() {
		return coursCategorie;
	}

	public void setCoursCategorie(Map<Categorie, List<Cours>> coursCategorie) {
		this.coursCategorie = coursCategorie;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public Langue getLangueCourante() {
		return langueCourante;
	}

	public void setLangueCourante(Langue langueCourante) {
		this.langueCourante = langueCourante;
	}

	public ConsulteCoursManagedBean getBuConsulter() {
		return buConsulter;
	}

	public void setBuConsulter(ConsulteCoursManagedBean buConsulter) {
		this.buConsulter = buConsulter;
	}
	
	
	
	

}
