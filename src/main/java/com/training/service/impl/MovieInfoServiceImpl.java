package com.training.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.MovieInfoServiceDao;
import com.training.dto.MovieCatalogItemResponse;
import com.training.exceptions.MovieNotFoundException;
import com.training.model.MovieCatalogItem;
import com.training.service.MovieInfoService;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {

	@Autowired
	private MovieInfoServiceDao movieInfoServiceDao;

	@Override
	public MovieCatalogItemResponse getMovieInfo(int movieId) {
		Optional<MovieCatalogItem> movieCatalogItemOptional = movieInfoServiceDao.findById(movieId);

		MovieCatalogItemResponse response = movieCatalogItemOptional.map(movieCatalogItem -> {
			MovieCatalogItemResponse resp = new MovieCatalogItemResponse();
			resp.setMovieTitle(movieCatalogItem.getMovieTitle());
			resp.setDescription(movieCatalogItem.getDescription());
			resp.setRating(movieCatalogItem.getRating());
			resp.setCreatedBy(movieCatalogItem.getCreatedBy().getUsername());
			resp.setUpdatedBy(movieCatalogItem.getUpdatedBy().getUsername());
			return resp;
		}).orElseThrow(() -> new MovieNotFoundException("Movie with ID " + movieId + " not found"));

		return response;
	}

}
