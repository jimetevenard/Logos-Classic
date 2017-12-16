package com.logos.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * Un controlleur REST pour tester :)
 * 
 * @author jetevenard
 *
 */

@RestController
public class TestService {
	
	private TestServiceBean testBean = new TestServiceBean("Bonne nouvelle", "Ce web service fonctionne à merveille :) !");
	
	@RequestMapping("/test")
	public TestServiceBean service(){
		return testBean;
	}
	
	@RequestMapping(value="/toto", method=RequestMethod.POST)
	public String toto(TestServiceBean toto){
		return toto.getMessage();
	}

}
