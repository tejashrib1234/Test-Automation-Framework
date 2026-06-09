package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowerUtility;

public final class LoginPage extends BrowerUtility {

	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	private static final By ERROR_MESSAGE_LOCATOR=By.xpath("//div[@class='alert alert-danger']//ol/li");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWith(String emailAddress, String password) throws InterruptedException {

		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		cilckOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;

	}
	public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password) throws InterruptedException {

		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		cilckOn(SUBMIT_BUTTON_LOCATOR);
		LoginPage loginPage=new LoginPage(getDriver());
		return loginPage;

	}
	public String getErrorMessage() throws InterruptedException {

		return getVisibleText(ERROR_MESSAGE_LOCATOR);

	}

}
