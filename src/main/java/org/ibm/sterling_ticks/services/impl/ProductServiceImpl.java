package org.ibm.sterling_ticks.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import org.ibm.sterling_ticks.model.entities.BrandModel;
import org.ibm.sterling_ticks.model.entities.CollectionModel;
import org.ibm.sterling_ticks.model.entities.ProductListModel;
import org.ibm.sterling_ticks.model.entities.ProductModel;
import org.ibm.sterling_ticks.model.entities.dto.ProductDto;
import org.ibm.sterling_ticks.model.request.ProductParams;
import org.ibm.sterling_ticks.repositories.BrandRepository;
import org.ibm.sterling_ticks.repositories.CollectionRepository;
import org.ibm.sterling_ticks.repositories.ProductRepository;
import org.ibm.sterling_ticks.services.ProductService;
import org.ibm.sterling_ticks.services.common.HelpService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends HelpService implements ProductService {

	@Autowired
	private ProductRepository repo;
	@Autowired
	private BrandRepository brandRepo;
	@Autowired
	private CollectionRepository collectionRepo;
	@Autowired
	private ModelMapper mapper;
	
	private Pageable first4Products = PageRequest.of(0, 4);
	private static final float MAX_RATING = 5;
	private static final float MIN_RATING = 0;
	
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
	public List<ProductListModel> getPartialWatches(ProductParams query) {
		List<ProductModel> watches = repo.findAll(filterByBrandAndCollection(query.getBrandName(), query.getCollectionName()));
		return watches.stream().map(product -> mapper.map(product, ProductListModel.class))
		  .collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public boolean deleteProduct(String modelNo) {
		return repo.deleteByModelNo(modelNo) > 0;
	}
	
	@Override
	public ProductModel getAllWatchByModel(String modelNo) {
		return repo.findByModelNo(modelNo);
	}
	
	@Override
	public List<ProductModel> getSimilarProducts(String modelNo) {
		float rating = repo.getRating(modelNo);
		float upperLimit = Math.min(MAX_RATING, rating + 1);
		float lowerLimit = Math.max(MIN_RATING, rating - 1);
		
		return repo.findByModelNoNotAndStarRatingBetweenOrderByStarRatingDesc(modelNo, lowerLimit, upperLimit, first4Products);
	}
	
	@Override
	public boolean updateProduct(ProductDto dto) {
		Optional<ProductModel> ref = repo.findById(dto.id);
		if(ref.isPresent()) {
			ProductModel original = ref.get();
			mapper.map(dto, original);
			repo.save(original);
			return true;
		}
		return false;
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
	
	private Specification<ProductModel> filterByBrandName(String brandName){
		  return (root, query, criteriaBuilder)-> criteriaBuilder.equal(root.join("brand").get("name"), brandName);
	}
	
	private Specification<ProductModel> filterByCollectionName(String collectionName){
		return (root, query, criteriaBuilder)-> criteriaBuilder.equal(root.join("collection").get("name"), collectionName);
	}
	
	private Specification<ProductModel> filterByBrandAndCollection(String brandName, String collectionName) {
		return Specification
				.where(brandName == null ? null : filterByBrandName(brandName))
				.and(collectionName == null ? null : filterByCollectionName(collectionName));
	}
}
