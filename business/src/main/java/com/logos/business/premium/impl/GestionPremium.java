package com.logos.business.premium.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logos.business.premium.api.IGestionPremium;
import com.logos.entity.user.Eleve;

import api.com.logos.data.eleve.IDaoEleve;


@Service
public class GestionPremium implements IGestionPremium {

	@Autowired
	private IDaoEleve daoEleve;
	
	@Override
	public boolean changePremiumStatus(int idEleve, boolean premium) {
		
		Eleve eleve = daoEleve.getEleveById(idEleve);
		eleve.setStatutPremium(premium);
		if(daoEleve.updateEleve(eleve).isStatutPremium() == premium){
			return true;
		} else {
			return false;
		}
		
	}

	public IDaoEleve getDaoEleve() {
		return daoEleve;
	}

	public void setDaoEleve(IDaoEleve daoEleve) {
		this.daoEleve = daoEleve;
	}

	
}
