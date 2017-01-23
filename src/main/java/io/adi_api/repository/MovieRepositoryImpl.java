package io.adi_api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.adi_api.entity.Movie;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll" , Movie.class);
		return query.getResultList();
		
	}

	@Override
	public Movie findOne(String id) {
		
		return em.find(Movie.class, id);
	}
	
	@Override
	public Movie finallyNoMovie(String NoMovie){
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll" , Movie.class);
		query.setParameter("pNoMovie", NoMovie);
		List<Movie> movie = query.getResultList();
		if(movie ==null || movie. size() == 1){
			return movie.get(0);
		}
		else {
			return null ;
						
		}
	
	}
	
	@Override
	public Movie create(Movie mvi) {
		em.persist(mvi);
		return mvi;
	}

	@Override
	public Movie update(Movie mvi) {
		
		return em.merge(mvi);
	}

	@Override
	public void delete(Movie mvi) {
		em.remove(mvi);

	}

	@Override
	public void delete(Object existing) {
		// TODO Auto-generated method stub
		
	}

}
