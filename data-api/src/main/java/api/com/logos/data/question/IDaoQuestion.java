package api.com.logos.data.question;

import java.util.List;

import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.question.Question;
import com.logos.entity.question.QuestionATrous;
import com.logos.entity.question.QuestionDragAndDrop;
import com.logos.entity.question.QuestionOuverte;
import com.logos.entity.question.QuestionQcm;

public interface IDaoQuestion {
	Question getQuestionById(Integer id);
	List<Question> getQuestionByEvaluation(Evaluation evaluation);
	Question addQuestion(Question question);
	Question updateQuestion(Question question);
	boolean deleteQuestion(Question question);
	QuestionOuverte getQuestionOuverteById(Integer id);
	QuestionATrous getQuestionATrousById(Integer id);
	QuestionQcm getQuestionQcmById(Integer id);
	QuestionDragAndDrop getQuestionDragAndDropById(Integer id);
	List<Integer> getSolutionsByQuestionQcm(QuestionQcm question);
	List<String> getSolutionsByQuestionATrous(QuestionATrous question);
	List<String> getPropositionQuestionQcm(QuestionQcm q);
}