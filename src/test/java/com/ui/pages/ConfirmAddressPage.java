package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowerUtility;

public class ConfirmAddressPage extends BrowerUtility{

	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR=By.xpath("//button[@name='processAddress']");
	
	public ConfirmAddressPage(WebDriver driver) {
		super(driver);
	}
	
	public ShippingPage goToShippingPage() throws InterruptedException
	{
		cilckOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShippingPage(getDriver());
	}

}
