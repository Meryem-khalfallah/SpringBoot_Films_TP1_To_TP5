package com.meryem.films;

//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.meryem.films.entities.Film;
//import com.meryem.films.entities.Film;
import com.meryem.films.service.FilmService;

@SpringBootApplication
public class FilmsApplication implements CommandLineRunner/*implements CommandLineRunner */
{
	@Autowired
	FilmService filmService; 
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	
	public static void main(String[] args) {
		SpringApplication.run(FilmsApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Film.class);
	}

	/*
	@Override
	public void run(String... args) throws Exception 
	{
		filmService.saveFilm(new Film("Bad Boys",23.500,new Date()));
		filmService.saveFilm(new Film("Tyler Rake",32.250,new Date()));
		filmService.saveFilm(new Film("Project Power",33.0,new Date()));
	}
	*/
}
