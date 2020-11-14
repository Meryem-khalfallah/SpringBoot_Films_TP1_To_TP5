package com.meryem.films.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomFil", types = { Film.class })
public interface FilmProjection 
{
	public String getNomFilm();
}
