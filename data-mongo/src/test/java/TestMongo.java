import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Chapitre;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Langue;
import com.logos.entity.cours.Niveau;
import com.logos.entity.user.Eleve;
import com.logos.entity.user.Professeur;

import api.com.logos.data.cours.IDaoCours;
import mongo.com.logos.cours.impl.DaoCours;
import mongo.com.logos.eleve.impl.DaoEleve;
import mongo.com.logos.professeur.impl.DaoProfesseur;

public class TestMongo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cours c = new Cours();
		Professeur p = new Professeur();
		Categorie c1 = new Categorie();
		c1.setTitre("Cat");
		Categorie c2 = new Categorie();
		c2.setTitre("Cati");
		
		Set<Categorie> cats = new HashSet<>();
		cats.add(c2);
		cats.add(c1);
		
		Chapitre chap = new Chapitre();
		chap.setContenu("Once upon a time ...");
		chap.setTitre("Chap1");
		Chapitre chap2 = new Chapitre();
		chap.setContenu("Once upon a time again ...");
		chap.setTitre("Chap2");
		List<Chapitre> chaps = new ArrayList<>();
		chaps.add(chap2);
		chaps.add(chap);
		
		Langue l = new Langue();
		l.setCodeIso("EN");
		l.setLibelle("English");
		
		
		Niveau niv = new Niveau();
		niv.setLangue(l);
		niv.setLibelle("C1");
		niv.setValeur(2);
		
		p.setNom("Titi");
		c.setIntroduction("Coucou again");
		c.setAuteur(p);
		c.setCategories(cats);
		c.setChapitres(chaps);
		c.setDateCreation(new Date());
		c.setDateMiseAJour(new Date());
		c.setIntroduction("Intro ...");
		c.setNiveau(niv);
		
		Eleve e = new Eleve();
		e.setMail("mailBidon@bip.com");
		e.setNom("Padawan");
		e.setPrenom("Petit");
		
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("springMongo.xml");
		DaoCours dao = ctx.getBean(DaoCours.class);
		DaoProfesseur dapProf = ctx.getBean(DaoProfesseur.class);
		DaoEleve daoEle = ctx.getBean(DaoEleve.class);
		
		/*daoEle.ajouterEleve(e);
		dapProf.ajouterProf(p);
		dao.addCours(c);*/
		
		System.out.println(daoEle.getEleveById("5aef5644f135d89198709864"));
		
		//IDaoCours dao = new DaoCours();
		
		//dao.addCours(c);

	}

}
