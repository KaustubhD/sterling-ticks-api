package org.ibm.sterling_ticks.services;

import java.util.List;

import org.ibm.sterling_ticks.model.entities.CollectionModel;

public interface CollectionService {
	public List<CollectionModel> getAllCollections();
	public CollectionModel addCollection(CollectionModel collection);
}
