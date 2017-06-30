package com.logos.front.consulterCours.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.logos.business.evaluation.api.IFaireEvaluation;
import com.logos.business.inscriptionCours.api.IInscriptionCours;
import com.logos.business.question.api.IBusinessQuestion;
import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.Cours;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.RealiseEvaluation;
import com.logos.entity.question.Question;
import com.logos.entity.question.QuestionATrous;
import com.logos.entity.question.QuestionDragAndDrop;
import com.logos.entity.question.QuestionQcm;
import com.logos.entity.reponse.ReponseATrousEleve;
import com.logos.entity.reponse.ReponseDragAndDropEleve;
import com.logos.entity.reponse.ReponseEleve;
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
	private Set<ReponseEleve> listeReponsesEleve;
	private List<Integer> numReponseQcm ;
	ReponseQcmEleve rqe;
	ReponseATrousEleve rate;
	ReponseDragAndDropEleve rdad;
	Evaluation evalEnCours;


	@ManagedProperty(value="#{inscriptionCours}")
	private IInscriptionCours buInscription ;

	@ManagedProperty(value="#{faireEvaluation}")
	private IFaireEvaluation buFaireEvaluation;

	@ManagedProperty(value="#{businessQuestion}")
	private IBusinessQuestion buQuestion;

	@PostConstruct
	public void init(){
		rqe = new ReponseQcmEleve();
		rate = new ReponseATrousEleve();
		rdad = new ReponseDragAndDropEleve();

	}

	public String consulterCours(Cours c){
		listeChapitre = buInscription.getChapitresByCours(c);
		coursEnCours = c ;
		chapitreEnCours = listeChapitre.get(indexCourant);
		System.out.println("id chapitre "+chapitreEnCours.getIdChapitre());
		indiceChapitreEnCours= listeChapitre.indexOf(chapitreEnCours);
		evaluationByChapitre();
		return "cours.xhtml?faces-redirect=true";

	}

	public void changerChapitre(int i){

		indexCourant += i;

		consulterCours(coursEnCours);
	}

	public List<Evaluation> evaluationByChapitre(){
		List<Evaluation> exos =  buFaireEvaluation.getEvaluationsByChapitre(chapitreEnCours);
		if(exos != null && exos.size() != 0){
			evaluationsChapitre = exos;
			
			for (Evaluation evaluation : exos) {
				getQuestions(evaluation);
				System.out.println("evaluation "+evaluation.getTitre());
				evalEnCours = evaluation ;
			}
		}else{
			evaluationsChapitre.clear();
			questionsExercice.clear();
		}

		return evaluationsChapitre;
	}

	public Evaluation getPremiereEvaluation(){
		if(evaluationsChapitre != null && evaluationsChapitre.size() != 0){
			return evaluationsChapitre.get(0);
		}
		return null;
	}

	public void getQuestions(Evaluation e){
		questionsExercice = new ArrayList<>(buFaireEvaluation.getQuestionByEvaluation(e));

	}

	public void addReponseOuverte(ValueChangeEvent e){
		Object newVal = e.getNewValue();
		ReponseOuverteEleve roe = new ReponseOuverteEleve() ;
		System.out.println( ((Question) ((UIInput) e.getSource()).getAttributes().get("question")).getEnonce() );
		roe.setReponse(newVal.toString());
		listeReponseOuverte=new ArrayList<>();
		listeReponseOuverte.add(roe);
//		listeReponsesEleve.add(roe);

	}

	public void addReponseQcm(ValueChangeEvent e){
		Object newVal = e.getNewValue();
		System.out.println( ((Question) ((UIInput) e.getSource()).getAttributes().get("question")).getEnonce());
		numReponseQcm = new ArrayList<>();
		numReponseQcm.add(propositionsQcm.indexOf(newVal.toString()));
		rqe.setReponseQcm(numReponseQcm);
		QuestionQcm qQcm = (QuestionQcm) ((Question) ((UIInput) e.getSource()).getAttributes().get("question")) ;
		rqe.setQuestion(qQcm);
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
		QuestionATrous questionATrou = (QuestionATrous) ((Question) ((UIInput) e.getSource()).getAttributes().get("question")) ;
		rate.setQuestion(questionATrou);
		reponseQAT.add(newVal.toString());
		

	}

	public void getRepDAD(ValueChangeEvent e){
		Object newVal = e.getNewValue();
		reponseQDAD.add(newVal.toString());
		System.out.println("QUESTION DAD : "+ ((Question) ((UIInput) e.getSource()).getAttributes().get("question")).getEnonce() );

		QuestionDragAndDrop qDAD = (QuestionDragAndDrop) ((Question) ((UIInput) e.getSource()).getAttributes().get("question")) ;
		rdad.setQuestion(qDAD);
		System.out.println(newVal.toString());
		
	}
	
	public void envoiReponses(ActionEvent event){
		listeReponsesEleve = new HashSet<>();
		listeReponsesEleve.add(rqe);
		rate.setReponseATrou(reponseQAT);
		listeReponsesEleve.add(rate);
		rdad.setReponseATrou(reponseQDAD);
		listeReponsesEleve.add(rdad);
		RealiseEvaluation ree = new RealiseEvaluation();
		ree.setReponsesEleve(listeReponsesEleve);
		ree.setEvaluation(evalEnCours);
		buFaireEvaluation.addReponsesEleve(listeReponsesEleve, ree);
		
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

	public Set<ReponseEleve> getListeReponsesEleve() {
		return listeReponsesEleve;
	}

	public void setListeReponsesEleve(Set<ReponseEleve> listeReponsesEleve) {
		this.listeReponsesEleve = listeReponsesEleve;
	}

	public List<Integer> getNumReponseQcm() {
		return numReponseQcm;
	}

	public void setNumReponseQcm(List<Integer> numReponseQcm) {
		this.numReponseQcm = numReponseQcm;
	}

	public ReponseQcmEleve getRqe() {
		return rqe;
	}

	public void setRqe(ReponseQcmEleve rqe) {
		this.rqe = rqe;
	}

	public ReponseATrousEleve getRate() {
		return rate;
	}

	public void setRate(ReponseATrousEleve rate) {
		this.rate = rate;
	}

	public ReponseDragAndDropEleve getRdad() {
		return rdad;
	}

	public void setRdad(ReponseDragAndDropEleve rdad) {
		this.rdad = rdad;
	}

	public Evaluation getEvalEnCours() {
		return evalEnCours;
	}

	public void setEvalEnCours(Evaluation evalEnCours) {
		this.evalEnCours = evalEnCours;
	}







}
