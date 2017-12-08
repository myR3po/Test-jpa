package dev;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bon")
public class BonCommande {

	@Id
	private Integer id;

	@Column(name = "NUMERO", nullable = false, unique = true)
	private Integer numero;

	@Column(name = "DATE_CMD", nullable = false, unique = true)
	private LocalDateTime dateCmd;

	@Column(name = "DELAI", nullable = false, unique = true)
	private Integer delai;

	@ManyToOne
	@JoinColumn(name = "fournisseurID", nullable = false)
	private Fournisseur fournisseur;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "compo", 
				joinColumns = {@JoinColumn(name = "bonID", referencedColumnName="id", nullable = false, updatable = false) }, 
				inverseJoinColumns = {@JoinColumn(name = "articleID", referencedColumnName="id", nullable = false, updatable = false) })
	private List<Article> articles;

	public BonCommande() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDateTime getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(LocalDateTime dateCmd) {
		this.dateCmd = dateCmd;
	}

	public Integer getDelai() {
		return delai;
	}

	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "BonCommande [id=" + id + ", numero=" + numero + ", dateCmd=" + dateCmd + ", delai=" + delai + "]";
	}

}
