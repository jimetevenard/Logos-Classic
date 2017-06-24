package com.logos.data.cours.api;

import java.util.*;

import org.springframework.stereotype.Service;

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
    
    public SuiviCours addSuivi(SuiviCours suivi);
    
    public SuiviCours updateSuivi(SuiviCours suivi);
        
    public boolean deleteSuivi(SuiviCours suivi);

}