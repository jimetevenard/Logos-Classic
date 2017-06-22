package com.logos.data.eleve.api;

import java.util.List;

import com.logos.entity.user.Eleve;

public interface IDaoEleve {
	Eleve ajouterEleve (Eleve eleve);
	Eleve getEleveById(Integer id);
	Eleve updateEleve(Eleve eleve);
	boolean deleteEleve(Eleve eleve);
	List<Eleve> getAllEleve();

}
