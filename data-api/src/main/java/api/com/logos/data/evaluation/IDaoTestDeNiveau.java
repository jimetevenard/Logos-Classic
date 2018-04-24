package api.com.logos.data.evaluation;

import java.util.List;

import com.logos.entity.cours.Categorie;
import com.logos.entity.cours.Niveau;
import com.logos.entity.evaluation.TestDeNiveau;

public interface IDaoTestDeNiveau {
	TestDeNiveau addTestDeNiveau(TestDeNiveau testNiveau);
	TestDeNiveau updateTestDeNiveau(TestDeNiveau testNiveau);
	boolean deleteTestDeNiveau(TestDeNiveau testNiveau);
	List<TestDeNiveau> getTestNiveauByNiveau(Niveau niveau);
	List<TestDeNiveau> getTestNiveauByCategorie(Categorie categorie);
}
