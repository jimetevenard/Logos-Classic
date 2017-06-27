package com.logos.front.consulterCours.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.logos.entity.cours.Chapitre;

@ManagedBean(name="mbConsulteCours")
@SessionScoped
public class ConsulteCoursManagedBean {
	private List<Chapitre> listeChapitre ;
	private int chapitreEnCours ;
	private String titre ;


	private void consulterCours(){

	}

}
