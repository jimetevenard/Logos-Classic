package mongo.com.logos.question.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.question.Question;
import com.logos.entity.question.QuestionATrous;
import com.logos.entity.question.QuestionDragAndDrop;
import com.logos.entity.question.QuestionOuverte;
import com.logos.entity.question.QuestionQcm;

import api.com.logos.data.question.IDaoQuestion;

public class DaoQuestion implements IDaoQuestion {
	
	@Autowired
	MongoOperations mongoOps;
	
	public DaoQuestion(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Question getQuestionById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getQuestionByEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteQuestion(Question question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public QuestionOuverte getQuestionOuverteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionATrous getQuestionATrousById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionQcm getQuestionQcmById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionDragAndDrop getQuestionDragAndDropById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getSolutionsByQuestionQcm(QuestionQcm question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSolutionsByQuestionATrous(QuestionATrous question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPropositionQuestionQcm(QuestionQcm q) {
		// TODO Auto-generated method stub
		return null;
	}

}
