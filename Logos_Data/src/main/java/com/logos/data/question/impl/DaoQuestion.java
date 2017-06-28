package com.logos.data.question.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.data.question.api.IDaoQuestion;
import com.logos.entity.cours.Cours;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.question.Question;
import com.logos.entity.question.QuestionATrous;
import com.logos.entity.question.QuestionDragAndDrop;
import com.logos.entity.question.QuestionOuverte;
import com.logos.entity.question.QuestionQcm;
import com.logos.entity.reponse.ReponseEleve;
import com.logos.entity.reponse.ReponseOuverteEleve;

@Service
public class DaoQuestion implements IDaoQuestion{
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public Question getQuestionById(Integer id) {
		Session session = sf.getCurrentSession();
		Question question = null;
		try {
			Query query = session.createQuery("SELECT q FROM Question q where q.idQuestion = :id")
					.setParameter("id", id);
			question = (Question) query.uniqueResult();
			return question;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Question> getQuestionByEvaluation(Evaluation evaluation) {
		List<Question> listeQuestions = new ArrayList<>();
		Session session = sf.getCurrentSession();
		try {
			Query query = session.createQuery("SELECT q FROM Question q "
					+ "inner join q.evaluations qeval where :peval = qeval.idEvaluation").setParameter("peval", evaluation.getIdEvaluation());
			listeQuestions = query.list();
			return listeQuestions ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public Question addQuestion(Question question) {
		Session session = sf.getCurrentSession();
		session.persist(question);
		return question;
	}

	@Override
	@Transactional
	public Question updateQuestion(Question question) {
		Session session = sf.getCurrentSession();
		session.update(question);
		return question;
	}

	@Override
	@Transactional
	public boolean deleteQuestion(Question question) {
		Session session = sf.getCurrentSession();
		session.delete(question);
		return sf.getCurrentSession().get(Question.class, question.getIdQuestion()) == null;
	}

	@Override
	@Transactional
	public QuestionOuverte getQuestionOuverteById(Integer id) {
		Session session = sf.getCurrentSession();
		QuestionOuverte question = null;
		try {
			Query query = session.createQuery("SELECT q FROM QuestionOuverte q where q.idQuestion = :id")
					.setParameter("id", id);
			question = (QuestionOuverte) query.uniqueResult();
			return question;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public QuestionATrous getQuestionATrousById(Integer id) {
		Session session = sf.getCurrentSession();
		QuestionATrous question = null;
		try {
			Query query = session.createQuery("SELECT q FROM QuestionATrous q where q.idQuestion = :id")
					.setParameter("id", id);
			question = (QuestionATrous) query.uniqueResult();
			return question;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public QuestionQcm getQuestionQcmById(Integer id) {
		Session session = sf.getCurrentSession();
		QuestionQcm question = null;
		try {
			Query query = session.createQuery("SELECT q FROM QuestionQcm q where q.idQuestion = :id")
					.setParameter("id", id);
			question = (QuestionQcm) query.uniqueResult();
			return question;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public QuestionDragAndDrop getQuestionDragAndDropById(Integer id) {
		Session session = sf.getCurrentSession();
		QuestionDragAndDrop question = null;
		try {
			Query query = session.createQuery("SELECT q FROM QuestionDragAndDrop q where q.idQuestion = :id")
					.setParameter("id", id);
			question = (QuestionDragAndDrop) query.uniqueResult();
			return question;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Integer> getSolutionsByQuestionQcm(QuestionQcm question) {
		List<Integer> solutions = new ArrayList<>();
		Session session = sf.getCurrentSession();
		try {
			Query query = session.createSQLQuery("SELECT s.solution_question_qcm FROM solution_question_qcm s INNER JOIN question q ON s.id_question = q.id_question WHERE s.id_question=?").setParameter(0, question.getIdQuestion());
			solutions = query.list();
			return solutions;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<String> getSolutionsByQuestionATrous(QuestionATrous question) {
		List<String> solutions = new ArrayList<>();
		Session session = sf.getCurrentSession();
		try {
			Query query = session.createSQLQuery("SELECT s.solution_question_trous FROM solution_question_trous s INNER JOIN question q ON s.id_question = q.id_question WHERE s.id_question=?").setParameter(0, question.getIdQuestion());
			solutions = query.list();
			return solutions;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

}
