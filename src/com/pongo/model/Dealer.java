package com.pongo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
@Entity
@Table(name="dealer")
public class Dealer implements Serializable{

	@Id
	@GenericGenerator(name = "sequence_deal_id", strategy = "com.pongo.utility.DealerIdGenerater")
	@GeneratedValue(generator = "sequence_deal_id")  
	@Column(name="dealer_id")
	private String dealerId;
	
	@Column(name ="dealer_name")
	private String dealerName;
	
	@Column(name="address",length=100)
	private String address;
	
	@Column(name="city",length=30)
	private String city;
	
	@Column(name="state",length=30)
	private String state;
	
	@Column(name="adhar_card")
	private String adharCard;
	
	@Column(name="pan_card")
	private String pancard;
	
	@Column(name="electricity_bill")
	private String electricityBill;
	
	@Column(name="dealer_photograph")
	private String dealerPhotograph;
	
	@Column(name="gst_number")
	private String gstNo;
	
	@Transient
	private MultipartFile adharM;
	
	@Transient
	private MultipartFile panM;
	
	@Transient
	private MultipartFile electricityM;
	
	@Transient
	private MultipartFile dealerPM;

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAdharCard() {
		return adharCard;
	}

	public void setAdharCard(String adharCard) {
		this.adharCard = adharCard;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getElectricityBill() {
		return electricityBill;
	}

	public void setElectricityBill(String electricityBill) {
		this.electricityBill = electricityBill;
	}

	public String getDealerPhotograph() {
		return dealerPhotograph;
	}

	public void setDealerPhotograph(String dealerPhotograph) {
		this.dealerPhotograph = dealerPhotograph;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public MultipartFile getAdharM() {
		return adharM;
	}

	public void setAdharM(MultipartFile adharM) {
		this.adharM = adharM;
	}

	public MultipartFile getPanM() {
		return panM;
	}

	public void setPanM(MultipartFile panM) {
		this.panM = panM;
	}

	public MultipartFile getElectricityM() {
		return electricityM;
	}

	public void setElectricityM(MultipartFile electricityM) {
		this.electricityM = electricityM;
	}

	public MultipartFile getDealerPM() {
		return dealerPM;
	}

	public void setDealerPM(MultipartFile dealerPM) {
		this.dealerPM = dealerPM;
	}

	@Override
	public String toString() {
		return "Dealer [dealerId=" + dealerId + ", dealerName=" + dealerName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", adharCard=" + adharCard + ", pancard=" + pancard + ", electricityBill="
				+ electricityBill + ", dealerPhotograph=" + dealerPhotograph + ", gstNo=" + gstNo + ", adharM=" + adharM
				+ ", panM=" + panM + ", electricityM=" + electricityM + ", dealerPM=" + dealerPM + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
