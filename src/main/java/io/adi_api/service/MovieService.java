package io.adi_api.service;

import java.util.List;
import io.adi_api.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();
	public Movie findOne(String id);
	public Movie create(Movie mvi);
	public Movie update(String id, Movie mvi);
	public void delete(String id);
	
	
	
	
}
