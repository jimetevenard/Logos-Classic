package com.logos.data.niveauLangue.api;

import java.util.*;

import org.springframework.stereotype.Service;

import com.logos.entity.cours.Langue;

/**
 * 
 */
 @Service
public interface IDaoLangues {

    /**
     * @param Id 
     * @return
     */
    public Langue getLangueById(Integer Id);

    /**
     * @return
     */
    public List<Langue> getAllLangues();
    
    
    public Langue addLangue(Langue langue);
    
    
    public boolean deleteLangue(Langue langue);
    
    
    public Langue updateLangue(Langue langue);

}