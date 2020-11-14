package com.meryem.films.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.meryem.films.entities.Categorie;
import com.meryem.films.entities.Film;
import com.meryem.films.repos.FilmRepository;


@Service
public class FilmServiceImpl implements FilmService{
	
	@Autowired
	FilmRepository filmRepository;
	
	@Override
	public Film saveFilm(Film f) 
	{
		return filmRepository.save(f);
	}

	@Override
	public Film updateFilm(Film f) 
	{
		return filmRepository.save(f);
	}

	@Override
	public void deleteFilm(Film f) 
	{
		filmRepository.delete(f);
	}

	@Override
	public void deleteFilmById(Long id) 
	{
		filmRepository.deleteById(id);

	}

	@Override
	public Film getFilm(Long id) 
	{
		return filmRepository.findById(id).get();
	}

	@Override
	public List<Film> getAllFilms() 
	{
		return filmRepository.findAll();
	}

	@Override
	public Page<Film> getAllFilmsParPage(int page, int size) 
	{
		return filmRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Film> findByNomFilm(String nom) 
	{
		return filmRepository.findByNomFilm(nom);
	}

	@Override
	public List<Film> findByNomFilmContains(String nom) 
	{
		return filmRepository.findByNomFilmContains(nom);
	}

	@Override
	public List<Film> findByNomPrix(String nom, Double prix) 
	{
		return filmRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Film> findByCategorie(Categorie categorie) 
	{
		return filmRepository.findByCategorie(categorie);
	}

	@Override
	public List<Film> findByCategorieIdCat(Long id) 
	{
		return filmRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Film> findByOrderByNomFilmAsc() 
	{
		return filmRepository.findByOrderByNomFilmAsc();
	}

	@Override
	public List<Film> trierFilmsNomsPrix() 
	{
		return filmRepository.trierFilmsNomsPrix();
	}

}
