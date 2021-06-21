package org.ibm.sterling_ticks.services.impl;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.Optional;
import javax.transaction.Transactional;

import org.ibm.sterling_ticks.model.entities.OrderItemModel;
import org.ibm.sterling_ticks.model.entities.OrderModel;
import org.ibm.sterling_ticks.model.entities.ProductModel;
import org.ibm.sterling_ticks.model.entities.UserModel;
import org.ibm.sterling_ticks.model.entities.dto.CartDto;
import org.ibm.sterling_ticks.model.entities.dto.CartRequestDto;
import org.ibm.sterling_ticks.model.entities.enumerations.Status;
import org.ibm.sterling_ticks.repositories.OrderRepository;
import org.ibm.sterling_ticks.repositories.ProductRepository;
import org.ibm.sterling_ticks.repositories.UserRepository;
import org.ibm.sterling_ticks.services.OrderService;
import org.ibm.sterling_ticks.services.common.HelpService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends HelpService implements OrderService {

	@Autowired
	private OrderRepository repo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Transactional
	@Override
	public Integer updateOrderItems(CartRequestDto dto) {
		OrderModel order = repo.findCartByUserName(dto.userName);
		if(order == null) {
			order = createCartOrder(dto);
		}
		if(dto.quantity < 1) {
			return removeItemFromCart(order, dto.productId);
		}
		else {
			return addItemToCart(order, dto.productId, dto.quantity);			
		}
	}
	
	@Override
	public CartDto getUserCart(String userName) {
		OrderModel order = repo.findCartByUserName(userName);
		
		CartDto response = new CartDto();
		response.userName = userName;
		if(order != null) {
			mapper.map(order, response);			
		}
		return response;
	}
	
	@Override
	public Integer getQuantityInCart(String userName, String modelNo) {
		OrderModel order = repo.findCartByUserName(userName);
		OrderItemModel orderItem = getOrderItemByModelNo(order, modelNo).orElse(null);
		
		return (orderItem != null) ? orderItem.getQuantity() : 0;
	}
	
	private OrderModel createCartOrder(CartRequestDto dto) {
		UserModel user = userRepo.findByUserName(dto.userName);
		OrderModel order = new OrderModel();
		order.setUser(user);
		order.setOrderStatus(Status.IN_CART);
		order = repo.save(order);
		return order;
	}
	
	private Integer addItemToCart(OrderModel order, Integer productId, Integer quantity) {
		OrderItemModel cartItem = getOrderItemByProductId(order, productId).orElse(null);
		if(cartItem == null) {
			cartItem = new OrderItemModel();
			Optional<ProductModel> product = productRepo.findById(productId);
			if(product.get() == null) {
				return 0;
			}
			cartItem.setProduct(product.get());
			linkCartWithCartItem(order, cartItem);
		}
		cartItem.setQuantity(quantity);
		return getNumOrderItems(order);
	}
	
	private Integer removeItemFromCart(OrderModel order, Integer productId) {
		OrderItemModel cartItem = getOrderItemByProductId(order, productId).orElse(null);
		unlinkCartWithCartItem(order, cartItem);
		return getNumOrderItems(order);
	}
	
	private void linkCartWithCartItem(OrderModel order, OrderItemModel item) {
		order.getOrderItems().add(item);
		item.setOrder(order);		
	}
	
	private void unlinkCartWithCartItem(OrderModel order, OrderItemModel item) {
		order.getOrderItems().remove(item);
		item.setOrder(null);
	}
	
	private Integer getNumOrderItems(OrderModel order) {
		return order.getOrderItems().stream().mapToInt((item) -> item.getQuantity()).sum();
	}
}
