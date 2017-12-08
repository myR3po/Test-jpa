package dev;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article {

	@Id
	private Integer id;
	
	@Column(name = "ref", nullable = false, unique = true)
	private String reference;
	
	@Column(name = "designation", nullable = false)
	private String designation;
	
	@Column(name = "prix", nullable = false)
	private Double price;
	
	@ManyToOne
    @JoinColumn(name="fournisseurID", nullable=false)
	private Fournisseur fournisseur;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "articles")
	private Set<BonCommande> commands;
	
	public Article() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Set<BonCommande> getCommands() {
		return commands;
	}

	public void setCommands(Set<BonCommande> commands) {
		this.commands = commands;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", reference=" + reference + ", designation=" + designation + ", price=" + price
				+ "]";
	}
	
	
	
}
