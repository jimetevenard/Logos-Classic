package com.logos.business.question.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logos.business.question.api.IBusinessQuestion;
import com.logos.data.api.question.IDaoQuestion;
import com.logos.entity.question.QuestionATrous;
import com.logos.entity.question.QuestionQcm;

@Service
public class BusinessQuestion implements IBusinessQuestion{
	@Autowired
	private IDaoQuestion daoQuestion;
	

	@Override
	public List<String> getPropositionQuestionQcm(QuestionQcm q) {
		
		return daoQuestion.getPropositionQuestionQcm(q);
	}

	public List<String> getSolutionQuestionATrou(QuestionATrous qat){
		return daoQuestion.getSolutionsByQuestionATrous(qat);
	}

	public IDaoQuestion getDaoQuestion() {
		return daoQuestion;
	}

	
	public void setDaoQuestion(IDaoQuestion daoQuestion) {
		this.daoQuestion = daoQuestion;
	}

	
}