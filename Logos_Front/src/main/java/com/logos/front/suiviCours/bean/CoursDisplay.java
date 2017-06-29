package com.logos.front.suiviCours.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.logos.entity.cours.Cours;
import com.logos.entity.cours.SuiviCours;

public class CoursDisplay {
	
	private static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	private String titre;
	private Date dateDebut;
	private Date dateFin;
	private boolean fini;
	private String dateDisplay;
	private int nbChapitresTotal;
	private int nbChapitresLus;
	private Cours leCours;
	private int pourcentageLu;
	
	CoursDisplay(SuiviCours s){
		titre = s.getCours().getTitre();
		dateDebut = s.getDateInscription();
		dateFin = s.getDateFinSuivi();
		leCours = s.getCours();
		if(dateFin == null){
			fini = false;
			dateDisplay = df.format(dateDebut);
		} else {
			fini = true;
			dateDisplay = df.format(dateFin);
		}
		nbChapitresTotal = s.getCours().getChapitres().size();
		nbChapitresLus = s.getChapitresLus().size();
		pourcentageLu = (int) Math.floor( ((double) nbChapitresLus / (double) nbChapitresTotal) * 100);
	}

	public String getTitre() {
		return titre;
	}

	public boolean isFini() {
		return fini;
	}

	public String getDateDisplay() {
		return dateDisplay;
	}

	public int getNbChapitresTotal() {
		return nbChapitresTotal;
	}

	public int getNbChapitresLus() {
		return nbChapitresLus;
	}

	public Cours getLeCours() {
		return leCours;
	}

	public void setLeCours(Cours leCours) {
		this.leCours = leCours;
	}

	public int getPourcentageLu() {
		return pourcentageLu;
	}

	public void setPourcentageLu(int pourcentageLu) {
		this.pourcentageLu = pourcentageLu;
	}
	
	
	
	
	

}
