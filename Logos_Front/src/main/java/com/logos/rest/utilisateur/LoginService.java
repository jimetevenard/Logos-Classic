package com.logos.rest.utilisateur;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logos.business.connexion.api.IBusinessConnexionPlateforme;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Utilisateur;
import com.logos.rest.RestUtils;



@RestController
public class LoginService {
	
	private static RandomStringGenerator generateur;
	private static final RestLoginBean FAILURE_BEAN;
	
	@Autowired
	private IBusinessConnexionPlateforme businessLginBean;
	
	static {	
		FAILURE_BEAN = new RestLoginBean();
		FAILURE_BEAN.setOk(false);

		
		generateur = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
	}
	

	/**
	 * Se connecter à logos et obtenir un token et les ifos utilisateur
	 * 
	 * @param loginPassword : bean avec login et mot de passe de l'utilisateur
	 * @return le bean de réponse :
	 * <code>
	 * {
	 *	    "ok": true, // false en cas d'echec
	 *	    "token": "le-token", // null en cas d'echec
	 *	    "utilisateur": {
	 *	        "idUtilisateur": 2,
	 *	        "nom": "Péricard",
	 *	        "prenom": "Sebastien",
	 *	        // etc... Null si echec
	 *	    }
     *		}
 	 *	</code>
 	 *
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public RestLoginBean restLogin(HttpServletResponse response,@RequestBody LoginPasswordBean loginPassword){
		
		
		Utilisateur utilisateur = businessLginBean.checkLoginPassword(loginPassword.getLogin(), loginPassword.getPassword());
		if(utilisateur != null){
			String token = generateur.generate(15);
			
			RestLoginBean retour = new RestLoginBean();
			retour.setOk(true);
			retour.setToken( "testa" + token );
			retour.setUtilisateur(utilisateur);
			if(utilisateur instanceof Eleve){
				retour.setEleve(true);
				retour.setPremium(((Eleve)utilisateur).isStatutPremium());
			}
			
			ConnexionsActives.getInstance().put(token, retour);
			
			RestUtils.accessHeader(response);
			return retour;
		} else {
			
			return FAILURE_BEAN;
		}
		

		
	}
	/**
	 * Méthode très unsafe pour vérifier que les tokens sont biens enregistrés.
	 * On ne ferrait jamais ça en prod !!
	 * 
	 * @return collection des tokens actifs
	 */
	@RequestMapping("/test-tokens")
	public Set<String> getTokens(HttpServletResponse response){
		
		RestUtils.accessHeader(response);
		return ConnexionsActives.getInstance().keySet();
	}

	public IBusinessConnexionPlateforme getBusinessLginBean() {
		return businessLginBean;
	}

	public void setBusinessLginBean(IBusinessConnexionPlateforme businessLginBean) {
		this.businessLginBean = businessLginBean;
	}
	
	

}
