package com.meryem.films.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.meryem.films.entities.Categorie;
import com.meryem.films.entities.Film;

public interface FilmService 
{
	Film saveFilm(Film f);
	Film updateFilm(Film f);
	void deleteFilm(Film f);
	void deleteFilmById(Long id);
	Film getFilm(Long id);
	List<Film> getAllFilms();
	
	List<Film> findByNomFilm(String nom);
	List<Film> findByNomFilmContains(String nom);
	List<Film> findByNomPrix (String nom, Double prix);
	List<Film> findByCategorie (Categorie categorie);
	List<Film> findByCategorieIdCat(Long id);
	List<Film> findByOrderByNomFilmAsc();
	List<Film> trierFilmsNomsPrix();
	
	
	Page<Film> getAllFilmsParPage(int page, int size);
}
