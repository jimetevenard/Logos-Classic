package com.logos.data.niveauLangue.api;

import java.util.*;

import org.springframework.stereotype.Service;

import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Niveau;

/**
 * 
 */
 @Service
public interface IDaoNiveau {

    /**
     * @param Id 
     * @return
     */
    public Niveau getNiveauById(Integer Id);

    /**
     * @return
     */
    public List<Niveau> getAllNiveaux();
    
    
    public Niveau addNiveau(Niveau niveau);
    
    public Niveau updateNiveau(Cours niveau);
    
    public boolean deleteNiveau(Niveau niveau);

}