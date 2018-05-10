import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;
import com.mongodb.util.JSON;

import mongo.com.logos.cours.impl.DaoCours;
import mongo.com.logos.eleve.impl.DaoEleve;
import mongo.com.logos.professeur.impl.DaoProfesseur;
import mongo.com.logos.question.impl.DaoQuestion;

public class NewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("springMongo.xml");
		DaoCours dao = ctx.getBean(DaoCours.class);
		DaoProfesseur dapProf = ctx.getBean(DaoProfesseur.class);
		DaoEleve daoEle = ctx.getBean(DaoEleve.class);
		DaoQuestion daoQuestion = ctx.getBean(DaoQuestion.class);
		
		List<Cours> cours = dao.getAllCours();
		for (Cours cc : cours) {
			Niveau n = cc.getNiveau();
			System.out.println(n.getIdNiveau() + " - " + n.getLibelle() + " - " + n.getLangue());
		}
		
		Categorie c = new Categorie(1, "Vocabulaire");
		Langue langue = new Langue(2, "Espagnol", "es");
		Niveau niv = new Niveau(3, "A1", 10, langue);
		


	
	System.out.println(dao.getCoursByNiveau(niv));

		
		
		

	}

}
