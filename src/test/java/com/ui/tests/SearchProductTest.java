package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({ com.ui.listeners.TestListener.class })

public class SearchProductTest extends TestBase {

	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed Summer Dress";

	@BeforeMethod(description = "valid user is logs into the application")
	public MyAccountPage setUp() throws InterruptedException {

		return myAccountPage = homePage.goToLoginPage().doLoginWith("frhes88301@minitts.net", "password");


	}

	@Test(description = "Verify if the logged in user is able to search for a product and correct products search result are displayed", groups = {
			"e2e", "sanity" })
	public void verifyProductSearchTest() throws InterruptedException {
		boolean actualResult = myAccountPage.searchForProduct(SEARCH_TERM)
				.isSearchTermPresentinProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);

	}

}
