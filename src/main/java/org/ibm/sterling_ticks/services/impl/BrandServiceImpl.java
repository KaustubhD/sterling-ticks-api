package org.ibm.sterling_ticks.services.impl;

import java.util.List;

import org.ibm.sterling_ticks.model.entities.BrandModel;
import org.ibm.sterling_ticks.repositories.BrandRepository;
import org.ibm.sterling_ticks.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository repo;
	
	@Override
	public List<BrandModel> getAllBrands() {
		return repo.findAll();
	}

	@Override
	public BrandModel addBrand(BrandModel brand) {
		return this.repo.save(brand);
	}
	
}
