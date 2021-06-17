package org.ibm.sterling_ticks.model.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Casing {
	private String color;
	private String shape;
	private Float size;
	private String material;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public Float getSize() {
		return size;
	}
	public void setSize(Float size) {
		this.size = size;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
}
