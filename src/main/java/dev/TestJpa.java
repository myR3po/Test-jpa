package dev;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		// TypedQuery<BonCommande> com = entityManager.createQuery("SELECT b From
		// BonCommande b WHERE b.numero = 2", BonCommande.class);
		// BonCommande bc = com.getSingleResult();

		// LOGGER.error(bc.toString());
		// bc.getArticles().stream().forEach(a -> {LOGGER.error(a.toString());});

		List<Article> articles = new ArrayList<Article>();
		Article art;

		for (int i = 1; i <= 10; i++) {

			if ((i % 2) == 1) {
				art = entityManager.find(Article.class, i);
				if (art != null) {
					articles.add(art);
					LOGGER.debug("article name : {} prix : {}", art.getDesignation(), art.getPrice());
				}
			}
		}

		Fournisseur fournisseur = entityManager.find(Fournisseur.class, 1012);

		BonCommande bon = new BonCommande();

		bon.setId(2006);
		bon.setNumero(2006);
		bon.setArticles(articles);
		bon.setFournisseur(fournisseur);
		bon.setDelai(20);
		bon.setDateCmd(LocalDateTime.now());

		entityManager.persist(bon);

		entityTransaction.commit();
		entityManager.close();

		if (factory != null) {
			factory.close();
		}

	}

}
