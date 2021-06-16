package org.ibm.sterling_ticks.model.entities.dto;

import java.util.HashSet;
import java.util.Set;

import org.ibm.sterling_ticks.model.entities.BrandModel;
import org.ibm.sterling_ticks.model.entities.Casing;
import org.ibm.sterling_ticks.model.entities.CollectionModel;
import org.ibm.sterling_ticks.model.entities.Strap;
import org.ibm.sterling_ticks.model.entities.enumerations.DeliverySpeed;
import org.ibm.sterling_ticks.model.entities.enumerations.Gender;

public class ProductDto {
	public Integer productId;
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
}
