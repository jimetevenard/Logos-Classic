package com.logos.business.question.api;

import java.util.List;

import com.logos.entity.question.QuestionATrous;
import com.logos.entity.question.QuestionQcm;

public interface IBusinessQuestion {
	public List<String> getPropositionQuestionQcm(QuestionQcm q);
	public List<String> getSolutionQuestionATrou(QuestionATrous q);
}
