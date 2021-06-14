package org.ibm.sterling_ticks.repositories;

import java.util.List;

import org.ibm.sterling_ticks.model.entities.ProductListModel;
import org.ibm.sterling_ticks.model.entities.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer>{
	public List<ProductModel> findAll();
	
	public List<ProductListModel> findAllBy();
}
