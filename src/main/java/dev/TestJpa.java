package dev;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpa {

	// TODO Créer une instance d’entityManagerFactory
	// TODO Créer une instance d’entityManager
	// TODO Exécuter une requête native qui permet d’extraire la liste de tous les
	// articles
	// TODO Afficher le résultat de la requête
	//

	public TestJpa() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();

		// Check database version
		String sql = "select version()";

		String result = (String) entityManager.createNativeQuery(sql).getSingleResult();
		System.out.println(result);

		entityManager.getTransaction().commit();
		entityManager.close();

		if (factory != null) {
			factory.close();
		}

	}

}
