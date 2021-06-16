package org.ibm.sterling_ticks.controllers;

import org.ibm.sterling_ticks.model.entities.BrandModel;
import org.ibm.sterling_ticks.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("brands")
public class BrandsController {
	
	@Autowired
	private BrandService brandService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllBrands() {
		return ResponseEntity.ok(brandService.getAllBrands());
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addBrand(@RequestBody BrandModel brand) {
		return ResponseEntity.ok(brandService.addBrand(brand));
	}
}
