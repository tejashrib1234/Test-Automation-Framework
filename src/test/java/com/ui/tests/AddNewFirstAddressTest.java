package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddressPOJO address;

	@BeforeMethod(description = "Valid first user logs into the application")
	public void setUp() throws InterruptedException {

		myAccountPage = homePage.goToLoginPage().doLoginWith("frhes88301@minitts.net", "password");

		address = FakeAddressUtility.getFakeAddress();
	}

	@Test
	public void addNewAddress() throws InterruptedException {

		String newAddress = myAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
		// myAccountPage.deleteAddress();

	}

}
