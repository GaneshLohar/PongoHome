package com.pongo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="products")
public class Products implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id" , unique=true,nullable=false)
	private Long productId;
	
	@Column(name="product_name",length=30)
	private String productName;
	
	@Column(name="dealer_price",columnDefinition="Double default 0.0")
	private Double dealerPrice;
	
	@Column(name="distributor_price",columnDefinition="Double default 0.0")
	private Double distributorPrice;
	
	@Column(name="mrp",columnDefinition="Double default 0.0")
	private Double mrp;
	
	@Column(name="mrp_with_gst",columnDefinition="Double default 0.0")
	private Double mrpWithGst;
	
	@Column(name="final_price",columnDefinition="Double default 0.0")
	private Double finalPrice;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getDealerPrice() {
		return dealerPrice;
	}

	public void setDealerPrice(Double dealerPrice) {
		this.dealerPrice = dealerPrice;
	}

	public Double getDistributorPrice() {
		return distributorPrice;
	}

	public void setDistributorPrice(Double distributorPrice) {
		this.distributorPrice = distributorPrice;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public Double getMrpWithGst() {
		return mrpWithGst;
	}

	public void setMrpWithGst(Double mrpWithGst) {
		this.mrpWithGst = mrpWithGst;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", dealerPrice=" + dealerPrice
				+ ", distributorPrice=" + distributorPrice + ", mrp=" + mrp + ", mrpWithGst=" + mrpWithGst
				+ ", finalPrice=" + finalPrice + "]";
	}
	

}
