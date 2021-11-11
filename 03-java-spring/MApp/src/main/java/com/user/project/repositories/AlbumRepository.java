package com.user.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.user.project.models.Album;


public interface AlbumRepository  extends CrudRepository<Album, Long> {

	// Create
	// Read
	// Update
	// Delete
	
	List<Album> findAll(); 
//	List<Album> findAllByOrderByAlbumNameDesc();
//	List<Album> findDistinctByOrderByLikersDesc();
//	
//	@Query("SELECT p FROM Album p")
//    List<Album> findAllAlbums();
//	
//	
//	@Query(value="SELECT * from Albums", nativeQuery=true)
//    List<Album> findAllprojectsNative();
//	
	
	
	
	
	
	
	
	
	
	
	


	
}
