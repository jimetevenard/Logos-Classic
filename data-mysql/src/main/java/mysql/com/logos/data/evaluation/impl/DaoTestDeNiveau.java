package mysql.com.logos.data.evaluation.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Cours;
import com.logos.entity.cours.Niveau;
import com.logos.entity.evaluation.Evaluation;
import com.logos.entity.evaluation.TestDeNiveau;

import api.com.logos.data.evaluation.IDaoTestDeNiveau;

@Service
public class DaoTestDeNiveau implements IDaoTestDeNiveau {
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public TestDeNiveau addTestDeNiveau(TestDeNiveau testNiveau) {
		Session session = sf.getCurrentSession();
		session.persist(testNiveau);
		return testNiveau;
	}

	@Override
	@Transactional
	public TestDeNiveau updateTestDeNiveau(TestDeNiveau testNiveau) {
		Session session = sf.getCurrentSession();
		session.update(testNiveau);
		return testNiveau;
	}

	@Override
	@Transactional
	public boolean deleteTestDeNiveau(TestDeNiveau testNiveau) {
		Session session = sf.getCurrentSession();
		session.delete(testNiveau);
		return sf.getCurrentSession().get(TestDeNiveau.class, testNiveau.getIdEvaluation()) == null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TestDeNiveau> getTestNiveauByNiveau(Niveau niveau) {
		Session session = sf.getCurrentSession();
		List<TestDeNiveau> listeTestsNiveau = new ArrayList<>();
		try {
			Query query = session.createQuery("SELECT t FROM TestDeNiveau t where t.niveau.idNiveau = :niveau")
					.setParameter("niveau", niveau.getIdNiveau());
			listeTestsNiveau = (List<TestDeNiveau>) query.list();
			return listeTestsNiveau ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TestDeNiveau> getTestNiveauByCategorie(Categorie categorie) {
		List<TestDeNiveau> listeTestNiveau = new ArrayList<>();
		Session session = sf.getCurrentSession();
		try {
			Query query = session.createQuery("SELECT t FROM TestDeNiveau t "
					+ "inner join t.categories tcatego where :pcategorie = tcatego.idCategorie").setParameter("pcategorie", categorie.getIdCategorie());
			listeTestNiveau = query.list();
			return listeTestNiveau ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	

}
