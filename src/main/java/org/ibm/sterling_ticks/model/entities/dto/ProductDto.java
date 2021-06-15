package org.ibm.sterling_ticks.model.entities.dto;

import java.util.HashSet;
import java.util.Set;

import org.ibm.sterling_ticks.model.entities.BrandModel;
import org.ibm.sterling_ticks.model.entities.Casing;
import org.ibm.sterling_ticks.model.entities.CollectionModel;
import org.ibm.sterling_ticks.model.entities.Strap;
import org.ibm.sterling_ticks.model.entities.enumerations.Gender;

public class ProductDto {
	public String name;
	public int price;
	public String series;
	public String modelNo;
	public String movement;
	public Gender gender;
	public float starRating;
	public int discount;
	public Strap strap;
	public Casing casing;
	public String glassMaterial;
	public String dialColor;
	public int waterResistance;
	public int warrantyPeriod;
	public Set<String> features = new HashSet<>();
	public Set<String> images = new HashSet<>();
	public BrandModel brand;
	public CollectionModel collection;
}
