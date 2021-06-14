package org.ibm.sterling_ticks.model.entities.dto;

import java.util.HashSet;
import java.util.Set;

import org.ibm.sterling_ticks.model.entities.BrandModel;
import org.ibm.sterling_ticks.model.entities.CollectionModel;
import org.ibm.sterling_ticks.model.entities.enumerations.Gender;

public class ProductDto {
	public String name;
	public int price;
	public String series;
	public String modelNo;
	public String movement;
	public Gender gender;
	public int starRating;
	public int discount;
	public String strapMaterial;
	public String strapColor;
	public int caseSize;
	public String caseShape;
	public String glassMaterial;
	public String dialColor;
	public int waterResistance;
	public int warrantyPeriod;
	public Set<String> images = new HashSet<>();
	public BrandModel brand;
	public CollectionModel collection;
}
