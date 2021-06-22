package org.ibm.sterling_ticks.repositories;

import org.ibm.sterling_ticks.model.entities.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressModel, Integer> {

}
