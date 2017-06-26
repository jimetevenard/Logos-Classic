package com.logos.business.inscriptionCours.api;

import java.util.*;

import org.springframework.stereotype.Service;

import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;
import com.logos.entity.cours.SuiviCours;
import com.logos.entity.user.Eleve;

/**
 * 
 */
@Service
public interface IInscriptionCours {

    /**
     * @param eleve 
     * @param cours 
     * @return
     */
    public SuiviCours inscrireEleveACours(Eleve eleve, Cours cours);

    /**
     * @param eleve 
     * @param cours 
     * @return
     */
    public boolean isAutriseASinscrire(Eleve eleve, Cours cours);

    /**
     * @param eleve 
     * @param cours 
     * @param note 
     * @return
     */
    public boolean donnerNote(Eleve eleve, Cours cours, int note);

    /**
     * @param cours 
     * @param eleve 
     * @return
     */
    public Integer getNoteDonnee(Cours cours, Eleve eleve);

    /**
     * @param langue 
     * @param eleve 
     * @return
     */
    public List<Cours> getCoursByLangue(Langue langue, Eleve eleve);

    /**
     * @param category 
     * @param eleve 
     * @return
     */
    public List<Cours> getCoursByCategory(Categorie category, Eleve eleve);

    /**
     * @param niveau 
     * @param eleve 
     * @return
     */
    public List<Cours> getCoursByNiveau(Niveau niveau, Eleve eleve);

    /**
     * @param eleve 
     * @return
     */
    public List<Cours> getCoursRecommandes(Eleve eleve);

    /**
     * @param cours 
     * @return
     */
    public Double getNoteMoyenneByCours(Cours cours);

    /**
     * @param eleve 
     * @return
     */
    public List<SuiviCours> getSuiviCourByEleve(Eleve eleve);
    
    
    public List<Categorie> getAllCategorie();
    
    public List<Langue> getAllLangue();

}