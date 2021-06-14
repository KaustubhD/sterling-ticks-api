package org.ibm.sterling_ticks.controllers;

import org.ibm.sterling_ticks.model.entities.CollectionModel;
import org.ibm.sterling_ticks.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("collections")
public class CollectionController {
	
	@Autowired
	private CollectionService collectionService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllCollections() {
		return ResponseEntity.ok(collectionService.getAllCollections());
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addCollection(@RequestBody CollectionModel collection) {
		return ResponseEntity.ok(collectionService.addCollection(collection));
	}
}
