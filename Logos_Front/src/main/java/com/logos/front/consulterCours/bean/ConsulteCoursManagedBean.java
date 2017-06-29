package com.logos.front.consulterCours.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.stat.QueryStatistics;

import com.logos.business.evaluation.api.IFaireEvaluation;
import com.logos.business.inscriptionCours.api.IInscriptionCours;
import com.logos.business.question.api.IBusinessQuestion;
import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.Cours;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.question.Question;
import com.logos.entity.question.QuestionATrous;
import com.logos.entity.question.QuestionDragAndDrop;
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
	private String phraseDAD ;
	private List<String> propositionPhraseATrou;
	private List<String> propositionPhraseDAD;
	private List<String> reponseQAT = new ArrayList<>() ;
	private List<String> reponseQDAD = new ArrayList<>() ;


	@ManagedProperty(value="#{inscriptionCours}")
	private IInscriptionCours buInscription ;

	@ManagedProperty(value="#{faireEvaluation}")
	private IFaireEvaluation buFaireEvaluation;
	
	@ManagedProperty(value="#{businessQuestion}")
	private IBusinessQuestion buQuestion;

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
		System.out.println( ((Question) ((UIInput) e.getSource()).getAttributes().get("question")).getEnonce() );

	}
	
	public List<String> getPropositionQcm(QuestionQcm q){
		propositionsQcm = buQuestion.getPropositionQuestionQcm(q);
		return propositionsQcm;
		
	}
	
	public String getPhraseATrousQuestion(QuestionATrous qat){
		System.out.println(qat.getEnonce());
		phraseATrous = qat.getPhraseATrou();
		System.out.println(phraseATrous);
		propositionPhraseATrou =  buQuestion.getSolutionQuestionATrou(qat);
		return phraseATrous;
		
	}
	
	public String getQuestionDAD (QuestionDragAndDrop q){
		phraseDAD = q.getPhraseATrou();
		System.out.println(phraseDAD);
		propositionPhraseDAD = buQuestion.getSolutionQuestionATrou(q);
		return phraseDAD;
		
	}
	
	public void getRepATrouEleve(ValueChangeEvent e){
		Object newVal = e.getNewValue();
		reponseQAT.add(newVal.toString());
		System.out.println("QUESTION A TROU : "+ ((Question) ((UIInput) e.getSource()).getAttributes().get("question")).getEnonce() );

		System.out.println(newVal.toString());
		
	}
	
	public void getRepDAD(ValueChangeEvent e){
		Object newVal = e.getNewValue();
		reponseQDAD.add(newVal.toString());
		System.out.println("QUESTION DAD : "+ ((Question) ((UIInput) e.getSource()).getAttributes().get("question")).getEnonce() );

		System.out.println(newVal.toString());
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

	public IBusinessQuestion getBuQuestion() {
		return buQuestion;
	}

	public void setBuQuestion(IBusinessQuestion buQuestion) {
		this.buQuestion = buQuestion;
	}

	public List<String> getReponseQAT() {
		return reponseQAT;
	}

	public void setReponseQAT(List<String> reponseQAT) {
		this.reponseQAT = reponseQAT;
	}

	public String getPhraseDAD() {
		return phraseDAD;
	}

	public void setPhraseDAD(String phraseDAD) {
		this.phraseDAD = phraseDAD;
	}

	public List<String> getPropositionPhraseDAD() {
		return propositionPhraseDAD;
	}

	public void setPropositionPhraseDAD(List<String> propositionPhraseDAD) {
		this.propositionPhraseDAD = propositionPhraseDAD;
	}

	public List<String> getReponseQDAD() {
		return reponseQDAD;
	}

	public void setReponseQDAD(List<String> reponseQDAD) {
		this.reponseQDAD = reponseQDAD;
	}


	
	
	
	

}
