package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.MovieCatalogItemResponse;
import com.training.service.MovieInfoService;

@RestController
public class MovieInfoServiceController {

	@Autowired
	private MovieInfoService movieInfoService;

	@GetMapping("getmoviedetails/{movieId}")
	public MovieCatalogItemResponse getMovieInfo(@PathVariable("movieId") int movieId) {
		return movieInfoService.getMovieInfo(movieId);

	}

}
