import com.logos.entity.cours.Cours;

import api.com.logos.data.cours.IDaoCours;
import mongo.com.logos.cours.impl.DaoCours;

public class TestMongo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cours c = new Cours();
		c.setIntroduction("Coucou");
		
		IDaoCours dao = new DaoCours();
		
		dao.addCours(c);

	}

}
