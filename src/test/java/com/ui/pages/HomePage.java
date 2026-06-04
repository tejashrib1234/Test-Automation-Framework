package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.ui.listeners.TestListener;

import static com.constants.Env.*;
import com.utility.BrowerUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowerUtility {

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign')]");
	Logger logger = LoggerUtility.getLogger(TestListener.class);

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless); // To call the parent class constructor in the child class
		goToWebsite(readProperty(QA, "URL"));
		// ============OR=======================//
		// goToWebsite(JSONUtility.readJson(QA).getUrl());

	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(readProperty(QA, "URL"));

	}

	public LoginPage goToLoginPage() { // Page Functions -------------->
		logger.info("Trying to perform click to go on Sign in page");
		cilckOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

}
