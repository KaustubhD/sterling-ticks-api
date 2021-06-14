package org.ibm.sterling_ticks.services.impl;

import java.util.List;

import org.ibm.sterling_ticks.model.entities.CollectionModel;
import org.ibm.sterling_ticks.repositories.CollectionRepository;
import org.ibm.sterling_ticks.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	private CollectionRepository repo;
	
	@Override
	public List<CollectionModel> getAllCollections() {
		return repo.findAll();
	}

	@Override
	public CollectionModel addCollection(CollectionModel collection) {
		return repo.save(collection);
	}
}
