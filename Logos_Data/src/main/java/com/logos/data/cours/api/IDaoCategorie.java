package com.logos.data.cours.api;

import java.util.*;

import org.springframework.stereotype.Service;

import com.logos.entity.cours.Categorie;

/**
 * 
 */
@Service
public interface IDaoCategorie {

    /**
     * @param Id 
     * @return
     */
    public Categorie getCategoryById(Integer Id);

    /**
     * @return
     */
    public List<Categorie> getAllCategories();

    /**
     * @param category 
     * @return
     */
    public Categorie addCategory(Categorie category);

    /**
     * @param category 
     * @return
     */
    public Categorie updateCategory(Categorie category);

    /**
     * @param category 
     * @return
     */
    public Categorie deleteCategory(Categorie category);

}