package org.ibm.sterling_ticks.repositories;

import java.util.List;

import org.ibm.sterling_ticks.model.entities.OrderItemModel;
import org.ibm.sterling_ticks.model.entities.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Integer>{
	@Query("SELECT o from OrderModel o WHERE o.user.userName = :username and o.orderStatus = org.ibm.sterling_ticks.model.entities.enumerations.Status.IN_CART")
	public OrderModel findCartByUserName(@Param(value = "username") String userName);
	
	@Query("SELECT oi from OrderItemModel oi WHERE oi.product.productId = :productId")
	public OrderItemModel findOrderItemByProductId(@Param(value = "productId") Integer productId);
	
	@Query("SELECT o from OrderModel o WHERE o.user.userName = :username and o.orderStatus != org.ibm.sterling_ticks.model.entities.enumerations.Status.IN_CART")
	public List<OrderModel> findAllPreviousOrders(@Param(value = "username") String userName);
}
