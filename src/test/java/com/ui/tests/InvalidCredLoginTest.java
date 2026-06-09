package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ com.ui.listeners.TestListener.class })

public class InvalidCredLoginTest extends TestBase {

	private static final String INVALID_EMAIL_ADDRESS = "b.tejashri1995@gmail.co";
	private static final String INVALID_PASSWORD = "pass123";

	@Test(description = "Verifies if the proper error message is shown for the invalid credentials", groups = { "e2e",
			"sanity" })
	public void loginTest() throws InterruptedException {

		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
				.getErrorMessage(), "Authentication failed.");

	}

}
