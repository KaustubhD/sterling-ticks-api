package org.ibm.sterling_ticks.model.entities;

import java.util.List;

public interface ProductListModel {
	public String getName();
    public BrandModel getBrand();
    public float getStarRating();
    public int getPrice();
    public List<String> getImages();
	public String getModelNo();
}
