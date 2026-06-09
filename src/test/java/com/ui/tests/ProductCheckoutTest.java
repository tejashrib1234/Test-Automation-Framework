package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer Dress";
	private SearchResultPage searchResultPage;

	@BeforeMethod(description = "User logs into the application and searches for the product")
	public void setup() throws InterruptedException {
		searchResultPage = homePage.goToLoginPage().doLoginWith("frhes88301@minitts.net", "password")
				.searchForProduct(SEARCH_TERM);
	}

	@Test(description = "Verfiy if logged in user is able to buy a dress", groups = { "e2e", "sanity" })
	public void checkoutTest() throws InterruptedException {

		searchResultPage.clickOnTheProductAt(0).changeSize(L).addProductToCart().proceedToCheckout()
				.goToConfirmAddressPage().goToShippingPage().acceptingTermOfService().goToPaymentPage();

	}

}
