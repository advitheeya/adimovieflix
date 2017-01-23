package io.adi_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.adi_api.entity.Movie;
import io.adi_api.service.MovieService;

@RestController
@ResponseBody
@RequestMapping(value="movies")
public class MovieController {
	
	@Autowired
	private MovieService service;

	@RequestMapping(method=RequestMethod.GET)

	public List<Movie> findAll(){
		return service.findAll();
	}
	@RequestMapping(method=RequestMethod.GET, value="/(id)")
	
	public Movie findOne(@PathVariable("id") String mviId){
		return service.findOne(mviId);
		
	}
	@RequestMapping(method=RequestMethod.POST)
	
	public Movie create(@RequestBody Movie mvi){
		return service.create(mvi);
		
	}
	@RequestMapping(method=RequestMethod.PUT,value="/(id)")
	
	public Movie update(String id, Movie mvi) {
		return service.update(id, mvi);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/(id)")
	
	public void delete(String id) {
		service.delete(id);
	}
}
