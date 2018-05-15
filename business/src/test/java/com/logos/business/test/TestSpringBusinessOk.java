package com.logos.business.test;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.business.connexion.api.IBusinessConnexionPlateforme;


public class TestSpringBusinessOk {
	
	@Test
	public void dataOk() {
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springBusiness.xml");
		
		IBusinessConnexionPlateforme buLogin = bf.getBean(IBusinessConnexionPlateforme.class);
		
		assertNotNull(buLogin);			
		
	}
}
