package front;

import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.front.connexion.LoginMB;

public class TestSpringFront {
	
	
	public void BuBeanIsOk(){
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springFront.xml");
		
		LoginMB frontLogin = bf.getBean(LoginMB.class);
		
		assertNotNull(frontLogin);
		
		assertNotNull(frontLogin.getBu());
		
	}

}
