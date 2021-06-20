package org.ibm.sterling_ticks.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionModel {

	@Id
	@GeneratedValue
	@Column(name = "transaction_id")
	public Integer transactionId;
}
