package org.ibm.sterling_ticks.repositories;

import org.ibm.sterling_ticks.model.entities.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel, Integer>{
	RoleModel findByRole(String role);
}
