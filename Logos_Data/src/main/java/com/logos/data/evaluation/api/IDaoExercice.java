package com.logos.data.evaluation.api;

import java.util.List;

import com.logos.entity.cours.Cours;
import com.logos.entity.evaluation.Exercice;

public interface IDaoExercice {
	Exercice addExercice(Exercice exercice);
	Exercice updateExercice(Exercice exercice);
	boolean deleteExercice(Exercice exercice);
	List<Exercice> getExerciceByCours(Cours cours);
}
