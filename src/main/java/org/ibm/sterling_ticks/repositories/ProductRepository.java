package org.ibm.sterling_ticks.repositories;

import java.util.List;

import org.ibm.sterling_ticks.model.entities.ProductListModel;
import org.ibm.sterling_ticks.model.entities.ProductModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer>, JpaSpecificationExecutor<ProductModel>{
	public List<ProductModel> findAll();
	
	public List<ProductListModel> findAllBy();
	
	public Long deleteByModelNo(String modelNo);

	public ProductModel findByModelNo(String modelNo);
	
	@Query("SELECT w.starRating FROM ProductModel w WHERE w.modelNo = :modelNo")
	public float getRating(@Param("modelNo") String modelNo);
	
	public List<ProductModel> findByStarRatingBetweenOrderByStarRatingDesc(float lower, float higher, Pageable pager);
}
