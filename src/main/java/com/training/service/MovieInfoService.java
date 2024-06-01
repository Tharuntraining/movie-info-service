package com.training.service;

import com.training.dto.MovieCatalogItemResponse;

public interface MovieInfoService {

	public MovieCatalogItemResponse getMovieInfo(int movieId);

}
