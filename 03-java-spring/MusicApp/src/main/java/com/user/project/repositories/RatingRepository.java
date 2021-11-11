package com.user.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.user.project.models.Rating;


public interface RatingRepository  extends CrudRepository<Rating, Long> {
	
}
