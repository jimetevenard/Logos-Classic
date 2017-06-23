package com.logos.front.inscription.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.logos.business.inscriptionCours.api.IInscriptionCours;
import com.logos.entity.cours.Cours;
import com.logos.entity.user.Eleve;
import com.logos.front.connexion.LoginMB;

@ManagedBean(name="mbInscriptionCours")
@SessionScoped
public class InscriptionCoursManagedBean {
	@ManagedProperty(value="#{iInscriptionCours}")
	private IInscriptionCours bu;
	@ManagedProperty(value="#{loginMB}")
	private LoginMB logMb;
	
	private Eleve eleve;
	private Cours cours;
	
	private List<Cours> courses;
	
	@PostConstruct
	public void init(){
		eleve = (Eleve) logMb.getUserConnected();
		courses = bu.getCoursRecommandes(eleve);
	}
	
	public void inscrireACours(){
		bu.inscrireEleveACours(eleve, cours);
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

	public List<Cours> getCourses() {
		return courses;
	}

	public void setCourses(List<Cours> courses) {
		this.courses = courses;
	}
	
	
	

}
