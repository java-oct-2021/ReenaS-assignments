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
		//return AlbumRepo.findAllByOrderByAlbumNameDesc();
		//return AlbumRepo.findDistinctByOrderByLikersDesc();
//		return AlbumRepo.findAllAlbums();
		//return albumRepo.findAllAlbumsNative();
	}

	// Create new Album
	public Album createAlbum(Album Album) {
		System.out.println("Creating a Album");
		return albumRepo.save(Album);
	}

	// Delete a Album
	public void deleteAlbum(Long id) {
		albumRepo.deleteById(id);
	}

	// Get One Album
	public Album getOneAlbum(Long id) {
		return albumRepo.findById(id).orElse(null);
	}

	// Update Album
	public Album updateAlbum(Long id, String name, String description) {
		Album Album = getOneAlbum(id);
		Album.setAlbumName(name);
		Album.setDescription(description);
		return albumRepo.save(Album);
	}
	
	//create a rating 
	public Rating addRating(Rating rating) {
		System.out.println("Creating a rating");
		return ratingRepo.save(rating);
	}

}
