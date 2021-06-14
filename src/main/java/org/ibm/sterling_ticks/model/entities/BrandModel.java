package org.ibm.sterling_ticks.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class BrandModel {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "brand_name", length = 20, nullable = false)
	private String name;
	
	@Column(name = "brand_image", unique = true)
	private String imageUrl;
	
	@Column(name = "short_desc", columnDefinition = "TEXT")
	private String shortDesc;

	public int getBrandId() {
		return id;
	}

	public void setBrandId(int brandId) {
		this.id = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String brandName) {
		this.name = brandName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
}