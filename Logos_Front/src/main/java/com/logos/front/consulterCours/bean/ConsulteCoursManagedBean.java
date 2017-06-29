package com.logos.front.consulterCours.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import com.logos.business.evaluation.api.IFaireEvaluation;
import com.logos.business.inscriptionCours.api.IInscriptionCours;
import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.Cours;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.question.Question;
import com.logos.entity.question.QuestionATrous;
import com.logos.entity.question.QuestionQcm;
import com.logos.entity.reponse.ReponseOuverteEleve;
import com.logos.entity.reponse.ReponseQcmEleve;

@ManagedBean(name="mbConsulteCours")
@SessionScoped
public class ConsulteCoursManagedBean {
	private List<Chapitre> listeChapitre ;
	private int indiceChapitreEnCours ;
	private Cours coursEnCours;
	private Chapitre chapitreEnCours;
	private int indexCourant = 0;
	private List<Evaluation> evaluationsChapitre;
	private List<Question> questionsExercice;
	private List<ReponseOuverteEleve> listeReponseOuverte;
	private List<String> propositionsQcm;
	private List<String> propositionQcmVide = new ArrayList<>();
	private String phraseATrous ;
	private List<String> propositionPhraseATrou;


	@ManagedProperty(value="#{inscriptionCours}")
	private IInscriptionCours buInscription ;

	@ManagedProperty(value="#{faireEvaluation}")
	private IFaireEvaluation buFaireEvaluation;

	@PostConstruct
	public void init(){

	}

	public String consulterCours(Cours c){
		listeChapitre = buInscription.getChapitresByCours(c);
		coursEnCours = c ;
		chapitreEnCours = listeChapitre.get(indexCourant);
		indiceChapitreEnCours= listeChapitre.indexOf(chapitreEnCours);
		evaluationByChapitre();
		return "cours.xhtml?faces-redirect=true";

	}

	public void changerChapitre(int i){

		indexCourant += i;

		consulterCours(coursEnCours);
	}

	public void evaluationByChapitre(){
		List<Evaluation> exos =  buFaireEvaluation.getEvaluationsByChapitre(chapitreEnCours);
		if(exos != null && exos.size() != 0){
			evaluationsChapitre = exos;
		}
		for (Evaluation evaluation : exos) {
			getQuestions(evaluation);
		}
	}

	public void getQuestions(Evaluation e){
		questionsExercice = buFaireEvaluation.getQuestionByEvaluation(e);
		
	}

	public void addReponseOuverte(ValueChangeEvent e){
		Object newVal = e.getNewValue();
		ReponseOuverteEleve roe = new ReponseOuverteEleve() ;
		System.out.println( ((Question) ((UIInput) e.getSource()).getAttributes().get("question")).getEnonce() );
		roe.setReponse(newVal.toString());
		listeReponseOuverte=new ArrayList<>();
		listeReponseOuverte.add(roe);
	}
	
	public void addReponseQcm(ValueChangeEvent e){
		Object newVal = e.getNewValue();
		ReponseQcmEleve rqe= new ReponseQcmEleve();
	}
	
	public List<String> getPropositionQcm(QuestionQcm q){
		
		propositionsQcm = q.getPropositions();
		for(String s : propositionsQcm){
		}
		return propositionsQcm;
		
	}
	
	public String getPhraseATrousQuestion(QuestionATrous qat){
		System.out.println(qat.getEnonce());
		phraseATrous = qat.getPhraseATrou();
		System.out.println(phraseATrous);
		propositionPhraseATrou = qat.getSolutions();
		return phraseATrous;
		
	}
	
	public void getChoix(ValueChangeEvent e){
		Object newVal = e.getNewValue();
		System.out.println(newVal.toString());
	}
	
	

	public String getUrlTemplate(Question q){
		return new StringBuilder().append(q.getClass().getSimpleName()).append(".xhtml").toString();
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

	public List<Evaluation> getEvaluationsChapitre() {
		return evaluationsChapitre;
	}

	public void setEvaluationsChapitre(List<Evaluation> evaluationsChapitre) {
		this.evaluationsChapitre = evaluationsChapitre;
	}

	public IFaireEvaluation getBuFaireEvaluation() {
		return buFaireEvaluation;
	}

	public void setBuFaireEvaluation(IFaireEvaluation buFaireEvaluation) {
		this.buFaireEvaluation = buFaireEvaluation;
	}

	public List<Question> getQuestionsExercice() {
		return questionsExercice;
	}

	public void setQuestionsExercice(List<Question> questionsExercice) {
		this.questionsExercice = questionsExercice;
	}
	public List<ReponseOuverteEleve> getListeReponseOuverte() {
		return listeReponseOuverte;
	}

	public void setListeReponseOuverte(List<ReponseOuverteEleve> listeReponseOuverte) {
		this.listeReponseOuverte = listeReponseOuverte;
	}


	public String getPhraseATrous() {
		return phraseATrous;
	}

	public void setPhraseATrous(String phraseATrous) {
		this.phraseATrous = phraseATrous;
	}

	public List<String> getPropositionsQcm() {
		return propositionsQcm;
	}

	public void setPropositionsQcm(List<String> propositionsQcm) {
		this.propositionsQcm = propositionsQcm;
	}

	public List<String> getPropositionQcmVide() {
		return propositionQcmVide;
	}

	public void setPropositionQcmVide(List<String> propositionQcmVide) {
		this.propositionQcmVide = propositionQcmVide;
	}

	public List<String> getPropositionPhraseATrou() {
		return propositionPhraseATrou;
	}

	public void setPropositionPhraseATrou(List<String> propositionPhraseATrou) {
		this.propositionPhraseATrou = propositionPhraseATrou;
	}

	
	

}
