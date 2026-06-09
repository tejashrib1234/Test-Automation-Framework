package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowerUtility;

public class MyAccountPage extends BrowerUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_TEXT_BOX_LOCATOR = By.id("search_query_top");
	private static final By ADD_NEW_ADDRESS_LINK_LOCATOR = By.xpath("//a[@title='Add my first address']");
	private static final By MY_ADDRESS_LINK_LOCATOR=By.xpath("//span[text()='My addresses']");
	private static final By DELETE_EXISTING_ADDRESS_BUTTON_LOCATOR=By.xpath("//a[@title='Delete']");
	

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	public String getUserName() throws InterruptedException {

		return getVisibleText(USER_NAME_LOCATOR);
	}

	public SearchResultPage searchForProduct(String productName) throws InterruptedException {
		enterText(SEARCH_TEXT_BOX_LOCATOR, productName);
		Thread.sleep(2000);
		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());
		return searchResultPage;
	}

	
	public AddressPage goToAddAddressPage() throws InterruptedException {
		Thread.sleep(2000);
		cilckOn(ADD_NEW_ADDRESS_LINK_LOCATOR);
		AddressPage addressPage = new AddressPage(getDriver());
		return addressPage;
	}
	public AddressPage deleteAddress() throws InterruptedException {
		cilckOn(MY_ADDRESS_LINK_LOCATOR);
		Thread.sleep(2000);
		cilckOn(DELETE_EXISTING_ADDRESS_BUTTON_LOCATOR);
		Thread.sleep(1000);
		acceptingAlert();
		AddressPage addressPage = new AddressPage(getDriver());
		return addressPage;
	}
	
	

}
