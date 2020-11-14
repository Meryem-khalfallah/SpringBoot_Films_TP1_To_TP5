package com.meryem.films.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idFilm;
	private String nomFilm;
	private Double prixFilm;
	private Date dateCreation;
	
	@ManyToOne
	private Categorie categorie;
	
	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Film(String nomFilm, Double prixFilm, Date dateCreation) {
		super();
		this.nomFilm = nomFilm;
		this.prixFilm = prixFilm;
		this.dateCreation = dateCreation;
	}


	public Long getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}
	public String getNomFilm() {
		return nomFilm;
	}
	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}
	public Double getPrixFilm() {
		return prixFilm;
	}
	public void setPrixFilm(Double prixFilm) {
		this.prixFilm = prixFilm;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", prixFilm=" + prixFilm + ", dateCreation="
				+ dateCreation + "]";
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
}
