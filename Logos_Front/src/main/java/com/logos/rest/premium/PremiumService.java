package com.logos.rest.premium;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logos.rest.premium.PremiumBeans.PremiumRequest;
import com.logos.rest.premium.PremiumBeans.PremiumResponse;

@RestController
public class PremiumService {
	
	@RequestMapping(value="/premium", method=RequestMethod.POST)
	public PremiumResponse restPremium(@RequestBody PremiumRequest demande){
		
		return PremiumBeans.positiveResponse(); // Mythooooo !!
		
	}

}
