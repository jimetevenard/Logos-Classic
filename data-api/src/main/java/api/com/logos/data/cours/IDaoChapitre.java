package api.com.logos.data.cours;

import java.util.*;

import org.springframework.stereotype.Service;

import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.Cours;

/**
 * 
 */
 @Service
public interface IDaoChapitre {

    /**
     * @param cours 
     * @return
     */
    public Chapitre addChapitre(Cours cours);

    /**
     * @param cours 
     * @return
     */
    public Chapitre updateChapitre(Cours cours);

    /**
     * @param cours 
     * @return
     */
    public Chapitre deleteChapitre(Cours cours);
    
    
    
    public List<Chapitre> getAllChapitresByCours(Cours cours);
    
    

}