package com.logos.data.api.professeur;

import java.util.List;

import com.logos.entity.user.Professeur;

public interface IDaoProfesseur {
	Professeur ajouterProf (Professeur prof);
	Professeur getProfById(Integer id);
	Professeur updateProf(Professeur prof);
	boolean deleteProf(Professeur prof);
	List<Professeur> getAllProf();
}
