package mysql.com.logos.data.eleve.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.entity.user.Eleve;

import api.com.logos.data.eleve.IDaoEleve;

@Service
public class DaoEleve implements IDaoEleve {
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public Eleve ajouterEleve(Eleve eleve) {
		Session session = sf.getCurrentSession();
		session.save(eleve);
		return eleve;
	}

	@Override
	@Transactional
	public Eleve getEleveById(Integer id) {
		Session session = sf.getCurrentSession();
		Query query = session.createQuery("select e from Utilisateur e where e.idUtilisateur = :pid").setParameter("pid", id);
		Eleve eleve =(Eleve) query.uniqueResult();
		return eleve;
	}

	@Override
	@Transactional
	public Eleve updateEleve(Eleve eleve) {
		Session session = sf.getCurrentSession();
		session.update(eleve);
		return eleve;
	}

	@Override
	@Transactional
	public boolean deleteEleve(Eleve eleve) {
		Session session = sf.getCurrentSession();
		session.delete(eleve);
		return sf.getCurrentSession().get(Eleve.class, eleve.getIdUtilisateur()) == null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Eleve> getAllEleve() {
		Session session = sf.getCurrentSession();
		List<Eleve> eleves = new ArrayList<>();
		eleves = session.createQuery("select e from Eleve e").list();
		return eleves;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	

}
