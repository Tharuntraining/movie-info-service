package com.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.model.MovieCatalogItem;

@Repository
public interface MovieInfoServiceDao extends JpaRepository<MovieCatalogItem, Integer> {

//	public MovieCatalogItem findByMovie_MovieId(int movieId);
//	public MovieCatalogItem getById(int movieId);

}
