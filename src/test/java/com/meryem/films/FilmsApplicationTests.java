package com.meryem.films;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.meryem.films.entities.Categorie;
import com.meryem.films.entities.Film;
import com.meryem.films.repos.FilmRepository;
import com.meryem.films.service.FilmService;

@SpringBootTest
class FilmsApplicationTests {
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private FilmService filmService;
	
	@Test
	public void testCreateFilm()
	{
		Film fil= new Film("John Wick",35.500,new Date());
		filmRepository.save(fil);
	}
	
	@Test
	public void testFindFilm()
	{
		Film f= filmRepository.findById(1L).get();
		System.out.println(f);
	}
	
	@Test
	public void testUpdateFilm()
	{
		Film f= filmRepository.findById(1L).get();
		f.setPrixFilm(25.0);
		filmRepository.save(f);
		System.out.println(f);
	}
	
	@Test
	public void testDeleteFilm()
	{
		filmRepository.deleteById(1L);
	}
	
	@Test
	public void testListerTousFilms()
	{
		List<Film> fils = filmRepository.findAll();
		for (Film f : fils)
		{
			System.out.println(f);
		}
	}
	
	@Test
	public void testFindByNomFilmContains()
	{
		Page<Film> fils= filmService.getAllFilmsParPage(0,2);
		System.out.println(fils.getSize());
		System.out.println(fils.getTotalElements());
		System.out.println(fils.getTotalPages());
		fils.getContent().forEach(f -> {System.out.println(f.toString());
		});
		/*ou bien
		for (Film f : fils.getContent())
		{
		System.out.println(p);
		}
		*/
	}
	
	@Test
	public void testFindFilmByNom()
	{
		List<Film> fils= filmRepository.findByNomFilm("Bad Boys");
		for (Film f : fils)
		{
		System.out.println(f);
	}	
	}
	
	
	@Test
	public void testFindFilmByNomContains()
	{
		List<Film> fils= filmRepository.findByNomFilmContains("A");
		for (Film f : fils)
		{
			System.out.println(f);
		}
	}
	@Test
	public void testfindByNomPrix()
	{
		List<Film> fils= filmRepository.findByNomPrix("Bad Boys",0.0);
		for (Film f : fils)
		{
			System.out.println(f);
		}
	}
	
	@Test
	public void testfindByCategorie()
	{
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		List<Film> fils = filmRepository.findByCategorie(cat);
		for (Film f : fils)
		{
			System.out.println(f);
		}

	}
	
	
	@Test
	public void findByCategorieIdCat()
	{
	List<Film> fils = filmRepository.findByCategorieIdCat(1L);
	for (Film f : fils)
	{
	System.out.println(f);
	}

	}
	
	@Test
	public void testfindByOrderByNomFilmAsc()
	{
	List<Film> fils = filmRepository.findByOrderByNomFilmAsc();
	for (Film f : fils)
	{
	System.out.println(f);
	}

	}
	
	@Test
	public void testTrierFilmsNomsPrix()
	{
	List<Film> fils = filmRepository.trierFilmsNomsPrix();
	for (Film f : fils)
	{
	System.out.println(f);
	}

	}
	
	
	
	
	
}