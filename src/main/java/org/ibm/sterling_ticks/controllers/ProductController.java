package org.ibm.sterling_ticks.controllers;

import java.util.List;

import org.ibm.sterling_ticks.model.entities.ProductListModel;
import org.ibm.sterling_ticks.model.entities.ProductModel;
import org.ibm.sterling_ticks.model.entities.dto.ProductDto;
import org.ibm.sterling_ticks.model.request.ProductParams;
import org.ibm.sterling_ticks.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		return ResponseEntity.ok(new Object() {public boolean result = isSaved;});
	}
	
	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getProducts() {
		List<ProductModel> watches = productService.getAllWatches();
		return ResponseEntity.ok(watches);
	}
	
	@GetMapping(value = "{modelNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getProduct(@PathVariable String modelNo) {
		ProductModel watch = productService.getAllWatchByModel(modelNo);
		return ResponseEntity.ok(watch);
	}
	
	@GetMapping(value = "similarProducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getSimilarProducts(@RequestParam String modelNo) {
		List<ProductModel> watches = productService.getSimilarProducts(modelNo);
		return ResponseEntity.ok(watches);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPartialProducts(ProductParams query) {
		List<ProductListModel> watches = productService.getPartialWatches(query);
		return ResponseEntity.ok(watches);
	}
	
	@DeleteMapping(value = "{modelNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteProduct(@PathVariable String modelNo) {
		boolean isDeleted = productService.deleteProduct(modelNo);
		return ResponseEntity.ok(new Object() {public boolean result = isDeleted;});
	}
}
