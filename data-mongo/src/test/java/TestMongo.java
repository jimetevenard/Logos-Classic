import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.entity.cours.Cours;

import api.com.logos.data.cours.IDaoCours;
import mongo.com.logos.cours.impl.DaoCours;

public class TestMongo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cours c = new Cours();
		c.setIntroduction("Coucou");
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springMongo.xml");
		DaoCours dao = ctx.getBean("coursDao",DaoCours.class);
		
		dao.addCours(c);
		
		//IDaoCours dao = new DaoCours();
		
		//dao.addCours(c);

	}

}
