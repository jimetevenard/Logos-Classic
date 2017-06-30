package com.logos.front.suiviCours.bean;

import com.logos.entity.evaluation.RealiseEvaluation;

public class EvalDisplay {
	
	private String type;
	private String titre;
	private String note;
	
	EvalDisplay(RealiseEvaluation re){
		titre = re.getEvaluation().getTitre();
		type = re.getEvaluation().getClass().getSimpleName();

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

}
