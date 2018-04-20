package com.logos.front.suiviCours.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.logos.business.evaluation.api.IFaireEvaluation;
import com.logos.business.inscriptionCours.api.IInscriptionCours;
import com.logos.business.question.api.IBusinessQuestion;
import com.logos.business.suiviCours.api.ISuiviCoursBu;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.SuiviCours;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.user.Eleve;
import com.logos.front.connexion.LoginMB;
import com.logos.front.consulterCours.bean.ConsulteCoursManagedBean;

@ManagedBean
@RequestScoped
public class SuiviCoursMB {
	
	@ManagedProperty(value = "#{suiviCoursBu}")
	private ISuiviCoursBu businessSuivi;
	
	@ManagedProperty(value = "#{faireEvaluation}")
	private IFaireEvaluation businessEval;
	
	@ManagedProperty(value="#{loginMB}")
	private LoginMB logMb;
	
	@ManagedProperty(value="#{inscriptionCours}")
	private IInscriptionCours coursBU;
	
	@ManagedProperty(value="#{mbConsulteCours}")
	private ConsulteCoursManagedBean mbConsulter;
	
	private String test = "TEST";
	
	private List<RealiseEvaluation> reals;
	

	
	private List<SuiviCours> suivis;
	
	private List<CoursDisplay> coursDisplay = new ArrayList<>();
	private List<EvalDisplay> evalsDisplay = new ArrayList<>();
	
	@PostConstruct
	public void initialisation(){
		reals = businessSuivi.getAllRealiseEvaluation((Eleve) logMb.getUserConnected());
		suivis = businessSuivi.getAllSuiviCours((Eleve) logMb.getUserConnected());	
		for(SuiviCours s : suivis){
			s.getCours().setChapitres( coursBU.getChapitresByCours( s.getCours() ));
			s.setChapitresLus(businessSuivi.getChapitresLuBySuiviCours(s));
			coursDisplay.add(new CoursDisplay(s));
		}
		for(RealiseEvaluation re : reals){
			EvalDisplay ed = new EvalDisplay(re);
			ed.setNote(Double.toString(Math.round(businessEval.calculerNoteEvaluation(re))) + " / 20");
			evalsDisplay.add(ed);
		}
				
		
	}
	
	public String allerAuCours(Cours c){
		return mbConsulter.consulterCours(c);
	}

	public ISuiviCoursBu getBusinessSuivi() {
		return businessSuivi;
	}

	public void setBusinessSuivi(ISuiviCoursBu businessSuivi) {
		this.businessSuivi = businessSuivi;
	}

	public LoginMB getLogMb() {
		return logMb;
	}

	public void setLogMb(LoginMB logMb) {
		this.logMb = logMb;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public List<RealiseEvaluation> getReals() {
		return reals;
	}

	public void setReals(List<RealiseEvaluation> reals) {
		this.reals = reals;
	}

	public List<SuiviCours> getSuivis() {
		return suivis;
	}

	public void setSuivis(List<SuiviCours> suivis) {
		this.suivis = suivis;
	}

	public IInscriptionCours getCoursBU() {
		return coursBU;
	}

	public void setCoursBU(IInscriptionCours coursBU) {
		this.coursBU = coursBU;
	}

	public List<CoursDisplay> getCoursDisplay() {
		return coursDisplay;
	}

	public void setCoursDisplay(List<CoursDisplay> coursDisplay) {
		this.coursDisplay = coursDisplay;
	}

	public ConsulteCoursManagedBean getMbConsulter() {
		return mbConsulter;
	}

	public void setMbConsulter(ConsulteCoursManagedBean mbConsulter) {
		this.mbConsulter = mbConsulter;
	}

	public IFaireEvaluation getBusinessEval() {
		return businessEval;
	}

	public void setBusinessEval(IFaireEvaluation businessEval) {
		this.businessEval = businessEval;
	}

	public List<EvalDisplay> getEvalsDisplay() {
		return evalsDisplay;
	}

	public void setEvalsDisplay(List<EvalDisplay> evalsDisplay) {
		this.evalsDisplay = evalsDisplay;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
