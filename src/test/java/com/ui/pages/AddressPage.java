package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowerUtility;

public class AddressPage extends BrowerUtility {

	private static final By COMPANY_TEXT_BOX_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXT_BOX_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TEXT_BOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXT_BOX_LOCATOR = By.id("city");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final By POST_CODE_TEXT_BOX_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_TEXT_BOX_LOCATOR = By.id("phone");
	private static final By MOBILE_PHONE_TEXT_BOX_LOCATOR = By.id("phone_mobile");
	private static final By OTHER_INFORMATION_TEXT_BOX_LOCATOR = By.id("other");
	private static final By ADDRESS_ALIAS_TEXT_BOX_LOCATOR = By.id("alias");
	private static final By SAVE_ADDRESS_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_HEADING = By.xpath("//h3[text()='office address']");

	public AddressPage(WebDriver driver) {

		super(driver);

	}

	public String saveAddress(AddressPOJO addressPOJO) throws InterruptedException {
		enterText(COMPANY_TEXT_BOX_LOCATOR, addressPOJO.getCompany());
		Thread.sleep(1000);
		enterText(ADDRESS1_TEXT_BOX_LOCATOR, addressPOJO.getAddress1());
		Thread.sleep(1000);
		enterText(ADDRESS2_TEXT_BOX_LOCATOR, addressPOJO.getAddress2());
		Thread.sleep(1000);
		enterText(CITY_TEXT_BOX_LOCATOR, addressPOJO.getCity());
		Thread.sleep(1000);
		selectFromDropDown(STATE_DROPDOWN_LOCATOR, addressPOJO.getState());
		Thread.sleep(1000);
		enterText(POST_CODE_TEXT_BOX_LOCATOR, addressPOJO.getPostCode());
		Thread.sleep(1000);
		enterText(HOME_PHONE_TEXT_BOX_LOCATOR, addressPOJO.getHomePhoneNumber());
		Thread.sleep(1000);
		enterText(MOBILE_PHONE_TEXT_BOX_LOCATOR, addressPOJO.getMobileNumber());
		Thread.sleep(1000);
		enterText(OTHER_INFORMATION_TEXT_BOX_LOCATOR, addressPOJO.getOthetInformation());
		Thread.sleep(1000);
		clearText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR);
		Thread.sleep(1000);
		enterText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR, addressPOJO.getAddressAlias());
		cilckOn(SAVE_ADDRESS_LOCATOR);
		Thread.sleep(1000);
		String newAddress = getVisibleText(ADDRESS_HEADING);
		return newAddress;

	}

}
