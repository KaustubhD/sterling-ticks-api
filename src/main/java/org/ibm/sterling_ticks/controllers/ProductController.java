package org.ibm.sterling_ticks.controllers;

import java.util.List;

import org.ibm.sterling_ticks.model.entities.ProductListModel;
import org.ibm.sterling_ticks.model.entities.ProductModel;
import org.ibm.sterling_ticks.model.entities.dto.ProductDto;
import org.ibm.sterling_ticks.services.ProductService;
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
@RequestMapping("products")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addProduct(@RequestBody ProductDto product) {
		boolean isSaved = productService.addProduct(product);
		return ResponseEntity.ok(new Object() {boolean result = isSaved;});
	}
	
	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getProducts() {
		List<ProductModel> watches = productService.getAllWatches();
		return ResponseEntity.ok(watches);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPartialProducts() {
		List<ProductListModel> watches = productService.getPartialWatches();
		return ResponseEntity.ok(watches);
	}
}
