package org.ibm.sterling_ticks.services.impl;

import java.util.List;

import org.ibm.sterling_ticks.model.entities.BrandModel;
import org.ibm.sterling_ticks.model.entities.CollectionModel;
import org.ibm.sterling_ticks.model.entities.ProductListModel;
import org.ibm.sterling_ticks.model.entities.ProductModel;
import org.ibm.sterling_ticks.model.entities.dto.ProductDto;
import org.ibm.sterling_ticks.repositories.BrandRepository;
import org.ibm.sterling_ticks.repositories.CollectionRepository;
import org.ibm.sterling_ticks.repositories.ProductRepository;
import org.ibm.sterling_ticks.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	@Autowired
	private BrandRepository brandRepo;
	@Autowired
	private CollectionRepository collectionRepo;
	@Autowired
	private ModelMapper mapper; 
	
	@Override
	public boolean addProduct(ProductDto dto) {
		ProductModel product = mapper.map(dto, ProductModel.class);
		
		if(dto.brand != null) {
			product.setBrand(getOrSaveBrand(dto.brand));
		}
		if(dto.collection != null) {
			product.setCollection(getOrSaveCollection(dto.collection));
		}
		
		repo.save(product);
		return true;
	}
	
	@Override
	public List<ProductModel> getAllWatches() {
		return repo.findAll();
	}
	
	@Override
	public List<ProductListModel> getPartialWatches() {
		return repo.findAllBy();
	}
	
	private BrandModel getOrSaveBrand(BrandModel brand) {
		BrandModel saved = brandRepo.findByName(brand.getName());
		if(saved == null) {
			saved = brandRepo.save(brand);
		}
		return saved;
	}
	
	private CollectionModel getOrSaveCollection(CollectionModel collection) {
		CollectionModel saved = collectionRepo.findByName(collection.getName());
		if(saved == null) {
			saved = collectionRepo.save(collection);
		}
		return saved;
	}
}
