package org.ibm.sterling_ticks.repositories;

import org.ibm.sterling_ticks.model.entities.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemModel, Integer>{
}
