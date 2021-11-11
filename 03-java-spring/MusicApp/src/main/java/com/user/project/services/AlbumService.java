package com.user.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.project.models.Album;
import com.user.project.models.Rating;
import com.user.project.repositories.AlbumRepository;
import com.user.project.repositories.RatingRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepo;
	
	@Autowired
	private RatingRepository ratingRepo;

	// List all projects
	public List<Album> allAlbums() {
		return albumRepo.findAll();

	}

	// Create new project
	public Album createAlbum(Album album) {
		System.out.println("Creating a project");
		return albumRepo.save(album);
	}

	// Delete a Project
	public void deleteAlbum(Long id) {
		albumRepo.deleteById(id);
	}

	// Get One project
	public Album getOneAlbum(Long id) {
		return albumRepo.findById(id).orElse(null);
	}

	// Update project
	public Album updateAlbum(Long id, String name, String description) {
		Album project = getOneAlbum(id);
		project.setAlbumName(name);
		project.setDescription(description);
		return albumRepo.save(project);

	}

	//create a rating 
	public Rating addRating(Rating rating) {
		System.out.println("Creating a rating");
		return ratingRepo.save(rating);
	}
	

}
