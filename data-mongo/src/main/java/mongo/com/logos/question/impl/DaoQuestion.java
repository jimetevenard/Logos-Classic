package mongo.com.logos.question.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.question.Question;
import com.logos.entity.question.QuestionATrous;
import com.logos.entity.question.QuestionDragAndDrop;
import com.logos.entity.question.QuestionOuverte;
import com.logos.entity.question.QuestionQcm;

import api.com.logos.data.question.IDaoQuestion;

@Repository
public class DaoQuestion implements IDaoQuestion {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoQuestion(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Question getQuestionById(Integer id) {
		Question question = mongoOps.findById(id, Question.class);
		return question;
	}
	
	public Question getQuestionById(String id) {
		Question question = mongoOps.findById(id, Question.class);
		return question;
	}

	@Override
	public List<Question> getQuestionByEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question addQuestion(Question question) {
		mongoOps.insert(question);
		return question;
	}

	@Override
	public Question updateQuestion(Question question) {
		Query query = new Query(Criteria.where("_id").is(question.getIdQuestion()));
		mongoOps.updateFirst(query, new Update(), Question.class);
		return question;
	}

	@Override
	public boolean deleteQuestion(Question question) {
		mongoOps.remove(question);
		return false;
	}

	@Override
	public QuestionOuverte getQuestionOuverteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Question getMongoQuestionOuverteById(Integer id) {
		Query query = new Query(Criteria.where("ouverte").is(true).andOperator(Criteria.where("_id").is(id)));
		Question questionOuverte = (Question) mongoOps.find(query, Question.class);
		return questionOuverte;
	}

	@Override
	public QuestionATrous getQuestionATrousById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Question getMongoQuestionATrousById(Integer id) {
		Query query = new Query(Criteria.where("trous").is(true).andOperator(Criteria.where("_id").is(id)));
		Question questionATrou = (Question) mongoOps.find(query, Question.class);
		return questionATrou;
	}

	@Override
	public QuestionQcm getQuestionQcmById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Question getMongoQuestionQcmById(Integer id) {
		Query query = new Query(Criteria.where("qcm").is(true).andOperator(Criteria.where("_id").is(id)));
		Question questionQcm = (Question) mongoOps.find(query, Question.class);
		return questionQcm;
	}

	@Override
	public QuestionDragAndDrop getQuestionDragAndDropById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Question getMongoQuestionDragAndDropById(Integer id) {
		Query query = new Query(Criteria.where("dad").is(true).andOperator(Criteria.where("_id").is(id)));
		Question questionDad = (Question) mongoOps.find(query, Question.class);
		return questionDad;
	}

	@Override
	public List<Integer> getSolutionsByQuestionQcm(QuestionQcm question) {
		List<Integer> solutions = new ArrayList<>();
		QuestionQcm questionFound = (QuestionQcm) mongoOps.findById(question.getIdQuestion(), Question.class);
		solutions = questionFound.getSolutions();
		return solutions;
	}

	@Override
	public List<String> getSolutionsByQuestionATrous(QuestionATrous question) {
		List<String> solutions = new ArrayList<>();
		QuestionATrous questionFound = (QuestionATrous) mongoOps.findById(question.getIdQuestion(), Question.class);
		solutions = questionFound.getSolutions();
		return solutions;
	}

	@Override
	public List<String> getPropositionQuestionQcm(QuestionQcm q) {
		List<String> propositions = new ArrayList<>();
		QuestionQcm questionFound = (QuestionQcm) mongoOps.findById(q.getIdQuestion(), Question.class);
		propositions = questionFound.getPropositions();
		return propositions;
	}

}
