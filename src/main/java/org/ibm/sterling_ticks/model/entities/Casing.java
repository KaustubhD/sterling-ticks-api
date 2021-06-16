package org.ibm.sterling_ticks.model.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Casing {
	private String color;
	private String shape;
	private String size;
	
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}
