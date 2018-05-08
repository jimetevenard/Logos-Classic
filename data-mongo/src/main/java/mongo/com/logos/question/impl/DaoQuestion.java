package mongo.com.logos.question.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
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
import com.mongodb.WriteResult;

import api.com.logos.data.question.IDaoQuestion;
import mongo.com.logos.config.NextSequenceService;

@Repository
public class DaoQuestion implements IDaoQuestion {
	
	/*@Autowired
	MongoOperations mongoOps;*/
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	private NextSequenceService sequence;
	
	private static final String COLLECTION = "question";
	
	public DaoQuestion(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Question getQuestionById(Integer id) {
		Question question = mongoTemplate.findById(id, Question.class);
		return question;
	}
	
	public Question getQuestionById(long id) {
		Question question = mongoTemplate.findById(id, Question.class);
		return question;
	}

	@Override
	public List<Question> getQuestionByEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question addQuestion(Question question) {
		question.setIdQuestion(sequence.getNextSequence(COLLECTION));
		mongoTemplate.insert(question);
		return question;
	}

	@Override
	public Question updateQuestion(Question question) {
		
		mongoTemplate.save(question, COLLECTION);
		return question;
	}

	@Override
	public boolean deleteQuestion(Question question) {
		System.out.println(question.getIdQuestion());
		Query query = new Query(Criteria.where("_id").is(question.getIdQuestion()));
		WriteResult result = mongoTemplate.remove(query, Question.class, COLLECTION);
		boolean delete = false;
		if(result.getN() != 0) {
			delete = true;
		}
		return delete;
	}

	@Override
	public QuestionOuverte getQuestionOuverteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Question getMongoQuestionOuverteById(Integer id) {
		Query query = new Query(Criteria.where("ouverte").is(true).andOperator(Criteria.where("_id").is(id)));
		Question questionOuverte = (Question) mongoTemplate.find(query, Question.class);
		return questionOuverte;
	}

	@Override
	public QuestionATrous getQuestionATrousById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Question getMongoQuestionATrousById(Integer id) {
		Query query = new Query(Criteria.where("trous").is(true).andOperator(Criteria.where("_id").is(id)));
		Question questionATrou = (Question) mongoTemplate.find(query, Question.class);
		return questionATrou;
	}

	@Override
	public QuestionQcm getQuestionQcmById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Question getMongoQuestionQcmById(Integer id) {
		Query query = new Query(Criteria.where("qcm").is(true).andOperator(Criteria.where("_id").is(id)));
		Question questionQcm = (Question) mongoTemplate.find(query, Question.class);
		return questionQcm;
	}

	@Override
	public QuestionDragAndDrop getQuestionDragAndDropById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Question getMongoQuestionDragAndDropById(Integer id) {
		Query query = new Query(Criteria.where("dad").is(true).andOperator(Criteria.where("_id").is(id)));
		Question questionDad = (Question) mongoTemplate.find(query, Question.class);
		return questionDad;
	}

	@Override
	public List<Integer> getSolutionsByQuestionQcm(QuestionQcm question) {
		List<Integer> solutions = new ArrayList<>();
		QuestionQcm questionFound = (QuestionQcm) mongoTemplate.findById(question.getIdQuestion(), Question.class);
		solutions = questionFound.getSolutions();
		return solutions;
	}

	@Override
	public List<String> getSolutionsByQuestionATrous(QuestionATrous question) {
		List<String> solutions = new ArrayList<>();
		QuestionATrous questionFound = (QuestionATrous) mongoTemplate.findById(question.getIdQuestion(), Question.class);
		solutions = questionFound.getSolutions();
		return solutions;
	}

	@Override
	public List<String> getPropositionQuestionQcm(QuestionQcm q) {
		List<String> propositions = new ArrayList<>();
		QuestionQcm questionFound = (QuestionQcm) mongoTemplate.findById(q.getIdQuestion(), Question.class);
		propositions = questionFound.getPropositions();
		return propositions;
	}
	
	
	public List<Question> getAllQuestion(){
		return (List<Question>) mongoTemplate.findAll(Question.class, COLLECTION);
	}

}
