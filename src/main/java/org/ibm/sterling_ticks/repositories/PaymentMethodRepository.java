package org.ibm.sterling_ticks.repositories;

import org.ibm.sterling_ticks.model.entities.PaymentMethodModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodModel, Integer>{
}
