package org.ibm.sterling_ticks.services;

import java.util.List;

import org.ibm.sterling_ticks.model.entities.ProductModel;
import org.ibm.sterling_ticks.model.entities.dto.ProductDto;
import org.ibm.sterling_ticks.model.request.ProductParams;
import org.ibm.sterling_ticks.model.entities.ProductListModel;

public interface ProductService {
	public boolean addProduct(ProductDto product);
	public List<ProductModel> getAllWatches();
	public List<ProductListModel> getPartialWatches(ProductParams query);
	public ProductModel getAllWatchByModel(String modelNo);	
	public boolean deleteProduct(String modelNo);
	public List<ProductModel> getSimilarProducts(String modelNo);
}
