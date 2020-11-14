package com.meryem.films.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.meryem.films.entities.Film;
import com.meryem.films.service.FilmService;

@Controller
public class FilmController 
{
	@Autowired
	FilmService filmService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return"createFilm";
	}
	
	
	
	@RequestMapping("/saveFilm")
	public String saveFilm(@ModelAttribute("film") Film film, 
										@RequestParam("date") String date,
										ModelMap modelMap) throws ParseException
	{
		//conversion de la date 
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		film.setDateCreation(dateCreation);
		
			Film saveFilm = filmService.saveFilm(film);
			String msg="Film enregistré avec Id "+saveFilm.getIdFilm();
			modelMap.addAttribute("msg", msg);
			return"createFilm";
	}
	
	@RequestMapping("/ListeFilms")
	public String listeFilms(ModelMap modelMap,
							@RequestParam (name="page",defaultValue = "0") int page,
							@RequestParam (name="size", defaultValue = "3") int size)
	{
		Page<Film> fils= filmService.getAllFilmsParPage(page, size);
		modelMap.addAttribute("films", fils);
		modelMap.addAttribute("pages", new int[fils.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return"listeFilms";
	}
	
	@RequestMapping("/supprimerFilm")
	public String supprimerFilm(@RequestParam("id") Long id,
								ModelMap modelMap,
								@RequestParam(name="page",defaultValue = "0") int page,
								@RequestParam(name="size", defaultValue = "2") int size)
	{
		filmService.deleteFilmById(id);
		Page<Film> fils= filmService.getAllFilmsParPage(page, size);
		modelMap.addAttribute("films", fils);
		modelMap.addAttribute("pages", new int[fils.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return"listeFilms";
	}
	
	@RequestMapping("/modifierFilm")
	public String editerFilm(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Film f= filmService.getFilm(id);
		modelMap.addAttribute("film", f);
		return "editerFilm";
	}
	

	@RequestMapping("/updateFilm")
	public String updateFilm(@ModelAttribute("film") Film film,
								@RequestParam("date") String date,
								ModelMap modelMap) throws ParseException
		{
			//conversion deladate 
			SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd");
			Date dateCreation= dateformat.parse(String.valueOf(date));
			film.setDateCreation(dateCreation);
			filmService.updateFilm(film);
			List<Film> fils= filmService.getAllFilms();
			modelMap.addAttribute("films", fils);
			return "listeFilms";
		}
}