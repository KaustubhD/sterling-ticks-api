package org.ibm.sterling_ticks.model.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
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
import org.ibm.sterling_ticks.model.entities.enumerations.DeliverySpeed;
import org.ibm.sterling_ticks.model.entities.enumerations.Gender;

@Entity
@Table(name = "product")
public class ProductModel {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int productId;
	
	@Column(name = "name", length = 30, nullable = false)
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
	private Gender gender = Gender.unisex;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "delivery_speed", nullable = false)
	private DeliverySpeed deliverySpeed = DeliverySpeed.slow;
	
	@Column(name = "star_rating")
	private float starRating;
	
	private int discount;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "material", column = @Column(name = "strap_material")),
		@AttributeOverride(name = "color", column = @Column(name = "strap_color"))
    })
	private Strap strap;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "shape", column = @Column(name = "case_shape")),
		@AttributeOverride(name = "color", column = @Column(name = "case_color")),
		@AttributeOverride(name = "size", column = @Column(name = "case_size")),
		@AttributeOverride(name = "material", column = @Column(name = "case_material")),
	})
	private Casing casing;
	
	private String glassMaterial;
	
	private String dialColor;
	
	private int waterResistance;
	
	private int warrantyPeriod;
	
	@ElementCollection
	@CollectionTable(name = "product_features", joinColumns = @JoinColumn(name = "id"))
	private Set<String> features = new HashSet<>();
	
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

	public float getStarRating() {
		return starRating;
	}

	public void setStarRating(float starRating) {
		this.starRating = starRating;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Strap getStrap() {
		return strap;
	}

	public void setStrap(Strap strap) {
		this.strap = strap;
	}

	public Casing getCasing() {
		return casing;
	}

	public void setCasing(Casing casing) {
		this.casing = casing;
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

	public Set<String> getFeatures() {
		return features;
	}

	public void setFeatures(Set<String> features) {
		this.features = features;
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