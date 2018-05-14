package com.logos.data.api.categorie;

import java.util.List;

import com.logos.entity.cours.Categorie;

public interface IDaoCategorie {
    public Categorie getCategorieById(Integer Id);

    
    public List<Categorie> getAllCategorie();
    
    
    public Categorie addCategorie(Categorie categorie);
    
    
    public boolean deleteCategorie(Categorie langue);
    
    
    public Categorie updateCategorie(Categorie langue);

}
