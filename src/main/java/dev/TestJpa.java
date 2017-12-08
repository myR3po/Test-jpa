package dev;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJpa {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestJpa.class);
	
	public TestJpa() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test-jpa");

		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();

		TypedQuery<BonCommande> com = entityManager.createQuery("SELECT b From BonCommande b WHERE b.numero = 2", BonCommande.class);
		
		BonCommande bc = com.getSingleResult();
		
		LOGGER.error(bc.toString());
		bc.getArticles().stream().forEach(a -> {LOGGER.error(a.toString());});

		entityManager.getTransaction().commit();
		entityManager.close();

		if (factory != null) {
			factory.close();
		}

	}

}
