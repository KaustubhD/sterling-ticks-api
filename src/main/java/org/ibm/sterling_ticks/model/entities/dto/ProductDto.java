package org.ibm.sterling_ticks.model.entities.dto;

import java.util.HashSet;
import java.util.Set;

import org.ibm.sterling_ticks.model.entities.BrandModel;
import org.ibm.sterling_ticks.model.entities.Casing;
import org.ibm.sterling_ticks.model.entities.CollectionModel;
import org.ibm.sterling_ticks.model.entities.Strap;
import org.ibm.sterling_ticks.model.entities.enumerations.DeliverySpeed;
import org.ibm.sterling_ticks.model.entities.enumerations.Gender;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ProductDto {
	public Integer id;
	public String name;
	public Integer price;
	public String series;
	public String modelNo;
	public String movement;
	public Gender gender;
	public DeliverySpeed deliverySpeed;
	public Float starRating;
	public Integer discount;
	public Strap strap;
	public Casing casing;
	public String glassMaterial;
	public String dialColor;
	public Integer waterResistance;
	public Integer warrantyPeriod;
	public Set<String> features = new HashSet<>();
	public Set<String> images = new HashSet<>();
	public BrandModel brand;
	public CollectionModel collection;
	
	@JsonInclude(Include.NON_NULL)
	public Integer quantity;
}
