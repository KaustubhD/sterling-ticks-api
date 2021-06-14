package org.ibm.sterling_ticks.model.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.ibm.sterling_ticks.model.entities.enumerations.Gender;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class ProductModel {

	@Id
	@GeneratedValue
	@Column(name = "id")
	@JsonIgnore
	private int productId;
	
	@Column(name = "name", length = 30, nullable = false, unique = true)
	private String name;
	
	@Column(name = "price", nullable = false)
	private int price;
	
	@Column(name = "series")
	private String series;
	
	@Column(name = "model_no", nullable = false, unique = true)
	private String modelNo;
	
	@Column(name = "movement")
	private String movement;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;
	
	@Column(name = "star_rating")
	private int starRating;
	
	private int discount;

	@Column(name="strap_material")
	private String strapMaterial;
	
	@Column(name="strap_color")
	private String strapColor;
	
	@Column(name="case_size")
	private int caseSize;
	
	@Column(name="case_shape")
	private String caseShape;
	
	private String glassMaterial;
	
	private String dialColor;
	
	private int waterResistance;
	
	private int warrantyPeriod;
	
	@ElementCollection
	@CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "id"))
	private Set<String> images = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private BrandModel brand;
	
	@ManyToOne
	@JoinColumn(name = "collection_id")
	private CollectionModel collection;
	
	@Column(name = "date_created", nullable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getMovement() {
		return movement;
	}

	public void setMovement(String movement) {
		this.movement = movement;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getStrapMaterial() {
		return strapMaterial;
	}

	public void setStrapMaterial(String strapMaterial) {
		this.strapMaterial = strapMaterial;
	}

	public String getStrapColor() {
		return strapColor;
	}

	public void setStrapColor(String strapColor) {
		this.strapColor = strapColor;
	}

	public int getCaseSize() {
		return caseSize;
	}

	public void setCaseSize(int caseSize) {
		this.caseSize = caseSize;
	}

	public String getCaseShape() {
		return caseShape;
	}

	public void setCaseShape(String caseShape) {
		this.caseShape = caseShape;
	}

	public String getGlassMaterial() {
		return glassMaterial;
	}

	public void setGlassMaterial(String glassMaterial) {
		this.glassMaterial = glassMaterial;
	}

	public String getDialColor() {
		return dialColor;
	}

	public void setDialColor(String dialColor) {
		this.dialColor = dialColor;
	}

	public int getWaterResistance() {
		return waterResistance;
	}

	public void setWaterResistance(int waterResistance) {
		this.waterResistance = waterResistance;
	}

	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}

	public BrandModel getBrand() {
		return brand;
	}

	public void setBrand(BrandModel brand) {
		this.brand = brand;
	}

	public CollectionModel getCollection() {
		return collection;
	}

	public void setCollection(CollectionModel collection) {
		this.collection = collection;
	}
}