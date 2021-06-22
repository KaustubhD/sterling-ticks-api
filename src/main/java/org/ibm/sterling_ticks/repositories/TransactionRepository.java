package org.ibm.sterling_ticks.repositories;

import org.ibm.sterling_ticks.model.entities.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionModel, Integer>{

}
