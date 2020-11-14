package com.meryem.films.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meryem.films.entities.Film;
import com.meryem.films.service.FilmService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class FilmRESTController 
{
	@Autowired
	FilmService filmService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Film> getAllFilms()
	{
		return filmService.getAllFilms();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Film getFilmById(@PathVariable("id") Long id) 
	{
		return filmService.getFilm(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Film createFilm(@RequestBody Film film) 
	{
		return filmService.saveFilm(film);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public Film updateFilm(@RequestBody Film film) 
	{
		return filmService.updateFilm(film);
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteFilm(@PathVariable("id") Long id)
	{
	filmService.deleteFilmById(id);
	}
	
	
	@RequestMapping(value="/filscat/{idCat}",method = RequestMethod.GET)
	public List<Film> getFilmsByCatId(@PathVariable("idCat") Long idCat) {
	return filmService.findByCategorieIdCat(idCat);
	}
	
	
}
