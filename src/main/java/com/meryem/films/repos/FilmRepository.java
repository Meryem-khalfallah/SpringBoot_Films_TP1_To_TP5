package com.meryem.films.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.meryem.films.entities.Categorie;
import com.meryem.films.entities.Film;


@RepositoryRestResource(path = "rest")
public interface FilmRepository extends JpaRepository<Film, Long> 
{
	List<Film> findByNomFilm(String nom);
	List<Film> findByNomFilmContains(String nom);
	
	@Query("select f from Film f where f.nomFilm like %:nom and f.prixFilm > :prix")
	List<Film> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	
	@Query("select f from Film f where f.categorie = ?1")
	List<Film> findByCategorie (Categorie categorie);
	
	List<Film> findByCategorieIdCat(Long id);
	
	List<Film> findByOrderByNomFilmAsc();
	
	@Query("select f from Film f order by f.nomFilm ASC, f.prixFilm DESC")
	List<Film> trierFilmsNomsPrix ();
	
}
