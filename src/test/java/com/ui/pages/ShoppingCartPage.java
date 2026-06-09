package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowerUtility;

public class ShoppingCartPage extends BrowerUtility {

	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[contains(@title,'shopping')]/preceding-sibling::a");

	public ShoppingCartPage(WebDriver driver) {
		super(driver);

	}

	public ConfirmAddressPage goToConfirmAddressPage() throws InterruptedException {
		cilckOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ConfirmAddressPage(getDriver());
	}

}
