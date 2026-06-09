package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowerUtility;

public class ShippingPage extends BrowerUtility {

	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//button[@name='processCarrier']");
	private static final By ACCEPT_TERM_OF_SERVICE_CHECKBOX_LOCATOR = By.id("uniform-cgv");

	public ShippingPage(WebDriver driver) {
		super(driver);

	}

	public ShippingPage acceptingTermOfService() throws InterruptedException {
		cilckOn(ACCEPT_TERM_OF_SERVICE_CHECKBOX_LOCATOR);
		return new ShippingPage(getDriver());

	}

	public PaymentPage goToPaymentPage() throws InterruptedException {
		cilckOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new PaymentPage(getDriver());
	}

}
