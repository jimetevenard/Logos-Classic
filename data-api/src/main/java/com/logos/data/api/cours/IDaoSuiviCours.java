package com.logos.data.api.cours;

import java.util.*;

import org.springframework.stereotype.Service;

import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.SuiviCours;
import com.logos.entity.user.Eleve;

/**
 * 
 */
 @Service
public interface IDaoSuiviCours {

    /**
     * @param eleve 
     * @return
     */
    public List<Cours> getCoursInscritsByEleve(Eleve eleve);
    
    public List<SuiviCours> getSuiviByEleve(Eleve eleve);
    
    public List<SuiviCours> getSuiviByEleveEtCours(Eleve eleve, Cours cours);
    
    public SuiviCours addSuivi(SuiviCours suivi);
    
    public SuiviCours updateSuivi(SuiviCours suivi);
        
    public boolean deleteSuivi(SuiviCours suivi);
    
    public Set<Chapitre> getChapitresLuBySuiviCours(SuiviCours suivi);

}