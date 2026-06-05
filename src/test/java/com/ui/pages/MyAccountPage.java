package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowerUtility;

public class MyAccountPage extends BrowerUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	public String getUserName() throws InterruptedException {

		return getVisibleText(USER_NAME_LOCATOR);
	}

}
