package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.listeners.TestListener;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({ com.ui.listeners.TestListener.class })
public class LoginTest extends TestBase {
	/*
	 * Test Method!!! 1.Test Script Small!! 2.You cannot have Conditional
	 * statements, loops , try-catch block in Test method TestScripts -------> Test
	 * Steps 3.Reduce the use of local variable 4.You should have at=least one
	 * Asseration!!
	 */

	Logger logger = LoggerUtility.getLogger(TestListener.class);
//
//	@Test(description = "Verifies if the valid user is able to login into the application", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginTest(User user) {
//
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
//				"Tejashri Chavan");
//	}
//
//	@Test(description = "Verifies if the valid user is able to login into the application", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginCSVTest(User user) {
//
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
//				"Tejashri Chavan");
//
//	}

	@Test(description = "Verifies if the valid user is able to login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) throws InterruptedException {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Tejashri Chavan");

	}

}
