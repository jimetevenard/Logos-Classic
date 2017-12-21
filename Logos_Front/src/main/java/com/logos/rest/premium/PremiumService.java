package com.logos.rest.premium;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logos.business.premium.api.IGestionPremium;
import com.logos.rest.premium.PremiumBeans.PremiumRequest;
import com.logos.rest.premium.PremiumBeans.PremiumResponse;

@RestController
public class PremiumService {
	
	@Autowired
	private IGestionPremium premiumBusiness;
	
	@RequestMapping(value="/premium", method=RequestMethod.POST)
	public PremiumResponse restPremium(HttpServletResponse response, @RequestBody PremiumRequest demande){
		
		if(premiumBusiness.changePremiumStatus(demande.getId(), true)){
			return PremiumBeans.positiveResponse();
		} else {
			return  PremiumBeans.nagativeResponse();
		}
		
	}

	public IGestionPremium getPremiumBusiness() {
		return premiumBusiness;
	}

	public void setPremiumBusiness(IGestionPremium premiumBusiness) {
		this.premiumBusiness = premiumBusiness;
	}

}
