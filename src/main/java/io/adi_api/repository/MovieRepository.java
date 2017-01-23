package io.adi_api.repository;

import java.util.List;

import io.adi_api.entity.Movie;

public interface MovieRepository {


	public List<Movie> findAll();
	
	public Movie findOne(String id);
	
	public Movie finallyNoMovie(String NoMovie);
	
	public Movie create(Movie mvi);
	
	public Movie update( Movie mvi);
	
	public void delete(Object existing);

	void delete(Movie mvi);
	
	
}
