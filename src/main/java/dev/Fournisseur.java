package dev;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fournisseur")
public class Fournisseur {

	@Id
	private Integer id;

	@Column(name = "NOM", nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy="fournisseur")
	private List<BonCommande> commandes;
	
	@OneToMany(mappedBy="fournisseur")
	private List<Article> articles;
	
	public Fournisseur() {
		articles = new ArrayList<>();
		commandes = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<BonCommande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<BonCommande> commandes) {
		this.commandes = commandes;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", name=" + name + "]";
	}

	
}
