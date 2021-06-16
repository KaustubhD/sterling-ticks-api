package org.ibm.sterling_ticks.repositories;

import org.ibm.sterling_ticks.model.entities.BrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandModel, Integer> {
	BrandModel findByName(String brandName);
}
