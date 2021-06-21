package org.ibm.sterling_ticks.controllers;

import org.ibm.sterling_ticks.model.entities.dto.CartRequestDto;
import org.ibm.sterling_ticks.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("orders")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping(value = "cart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateOrderItems(@RequestBody CartRequestDto item) {
		int numCartItems = service.updateOrderItems(item);
		
		return ResponseEntity.ok(new Object() {public int cartItems = numCartItems;});
	}
	
	@GetMapping(value = "cart", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserCart(@RequestParam String userName) {
		
		return ResponseEntity.ok(service.getUserCart(userName));
	}
	@GetMapping(value = "cart/quantity", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserCartQuantity(@RequestParam String userName, @RequestParam String modelNo) {
		Integer quantity = service.getQuantityInCart(userName, modelNo);
		return ResponseEntity.ok(new Object() {public Integer quantityInCart = quantity;});
	}
}
