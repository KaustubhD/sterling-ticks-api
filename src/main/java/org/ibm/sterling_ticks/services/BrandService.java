package org.ibm.sterling_ticks.services;

import java.util.List;

import org.ibm.sterling_ticks.model.entities.BrandModel;

public interface BrandService {
	public List<BrandModel> getAllBrands();
	public BrandModel addBrand(BrandModel brand);
}
