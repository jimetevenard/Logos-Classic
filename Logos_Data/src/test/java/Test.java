import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.data.cours.api.IDaoCours;
import com.logos.entity.cours.Cours;

public class Test {
	private static Logger log = Logger.getLogger(Test.class);

	public static void main(String[] args) {

		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springData.xml");

		IDaoCours dao = bf.getBean(IDaoCours.class);
		
		Cours cours = new Cours(null, "IOGENOGRNOIGRNOIGRNI", "cGHRRR", new Date(), new Date(), null, null);
		log.info(dao.getCoursByid(17).getTitre());
	}

}
