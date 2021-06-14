package org.ibm.sterling_ticks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ibm.sterling_ticks.model.entities.CollectionModel;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionModel, Integer>{
	CollectionModel findByName(String name);
}