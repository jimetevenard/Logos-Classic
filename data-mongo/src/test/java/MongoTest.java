import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;

import com.logos.entity.cours.Cours;

import api.com.logos.data.cours.IDaoCours;
import mongo.com.logos.config.MongoConfig;
import mongo.com.logos.data.impl.DaoCours;

//@ContextConfiguration(classes = MongoConfig.class)
public class MongoTest {
	
//@Autowired
private MongoTemplate mongoTemplate;
	
// Les annotation Spring sur les attributs ne fonctionnent qu'avec un objet
// instancié par Spring.

// Elle ne sont d'aucun effet ici.

    @Test
   public void testTAMERE () {
    	
    	BeanFactory bf = new ClassPathXmlApplicationContext("classpath:config.xml");

    	this.mongoTemplate = bf.getBean(MongoTemplate.class);
    	
    	Cours c = new Cours();
		c.setTitre("test MONGO");
		mongoTemplate.insert(c);
		
    }
   

}
