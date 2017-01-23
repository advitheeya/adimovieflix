package io.adi_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.adi_api.entity.Movie;
import io.adi_api.exception.BadRequestExecption;
import io.adi_api.exception.EntityNotFoundException;
import io.adi_api.repository.MovieRepository;

@Component
@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository repository;
	private Object existing;

	@Override
	@Transactional(readOnly = true)
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Movie findOne(String id) {
		Movie mvi = repository.findOne(id);
		if(mvi == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return mvi;
	}

	@Override
	@Transactional
	public Movie create(Movie mvi) {
	     Movie existing = repository.finallyNoMovie(mvi.getNoMovie());
	     if(existing !=null){
	    	 throw new BadRequestExecption("Movie with this name already exists");
	     }
		return repository.create(mvi);
	}

	@Override
	@Transactional
	public Movie update(String id, Movie mvi) {
		Movie existing = repository.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException("Movie not found");
		
		}
		return repository.update(mvi);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movie existing = repository.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException("Movie not found");

	}
		repository.delete(existing);
		

}
}