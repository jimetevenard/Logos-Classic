package com.logos.data.api.evaluation;

import java.util.List;

import com.logos.entity.cours.Cours;
import com.logos.entity.evaluation.TestDeValidation;

public interface IDaoTestDeValidation {
	TestDeValidation addTestValidation(TestDeValidation test);
	TestDeValidation updateTestValidation(TestDeValidation test);
	boolean deleteTestValidation(TestDeValidation test);
	List<TestDeValidation> getTestValidationByCours(Cours cours);
}
