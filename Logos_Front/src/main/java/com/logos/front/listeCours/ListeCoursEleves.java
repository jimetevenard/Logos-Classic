package com.logos.front.listeCours;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.logos.business.inscriptionCours.api.IInscriptionCours;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.SuiviCours;
import com.logos.entity.user.Eleve;
import com.logos.front.connexion.LoginMB;
import com.logos.front.inscription.bean.InscriptionCoursManagedBean;

@ManagedBean(name="mbListeCoursEleve")
@SessionScoped
public class ListeCoursEleves {

	@ManagedProperty(value="#{loginMB}")
	private LoginMB loginMb ;
	
	@ManagedProperty(value="#{inscriptionCours}")
	private IInscriptionCours bu ;
	private Eleve eleve;
	private List<Cours> coursEleve;

	
	@PostConstruct
	public void getCoursByEleve(){
		eleve = (Eleve) loginMb.getUserConnected();
		List<SuiviCours> listeSuivi = bu.getSuiviCourByEleve(eleve);
		System.out.println( eleve.getNom() );
		System.out.println( listeSuivi.size() );
		for (SuiviCours suiviCours : listeSuivi) {
			coursEleve.add(suiviCours.getCours());
		}
	}


	public IInscriptionCours getBu() {
		return bu;
	}


	public void setBu(IInscriptionCours bu) {
		this.bu = bu;
	}


	public Eleve getEleve() {
		return eleve;
	}


	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}


	public List<Cours> getCoursEleve() {
		return coursEleve;
	}


	public void setCoursEleve(List<Cours> coursEleve) {
		this.coursEleve = coursEleve;
	}


	public LoginMB getLoginMb() {
		return loginMb;
	}


	public void setLoginMb(LoginMB loginMb) {
		this.loginMb = loginMb;
	}

	

}
