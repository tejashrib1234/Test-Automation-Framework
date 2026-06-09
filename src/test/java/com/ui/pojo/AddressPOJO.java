package com.ui.pojo;

import org.openqa.selenium.By;

public class AddressPOJO {

	private String company;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String postCode;
	private String homePhoneNumber;
	private String mobileNumber;
	private String othetInformation;
	private String addressAlias;

	public AddressPOJO(String company, String address1, String address2, String city, String state, String postCode,
			String homePhoneNumber, String mobileNumber, String othetInformation, String addressAlias) {
		super();
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobileNumber = mobileNumber;
		this.othetInformation = othetInformation;
		this.addressAlias = addressAlias;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getOthetInformation() {
		return othetInformation;
	}

	public String getAddressAlias() {
		return addressAlias;
	}

	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", state=" + state + ", postCode=" + postCode + ", homePhoneNumber=" + homePhoneNumber
				+ ", mobileNumber=" + mobileNumber + ", othetInformation=" + othetInformation + ", addressAlias="
				+ addressAlias + "]";
	}

}
