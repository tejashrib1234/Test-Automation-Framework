package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.listeners.TestListener;
import com.ui.pages.HomePage;
import com.utility.BrowerUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(TestListener.class);
	private boolean isLambdaTest;

	@Parameters({ "browser", "isLambdaTest", "isHeadLess" })
	@BeforeMethod(description = "Load the Homepage of the website")
	public void setUp(@Optional("edge") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadLess, ITestResult result) {
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdadriver;
		if (isLambdaTest) {
			lambdadriver = LambdaTestUtility.intializeLambdaTestSession(Browser.valueOf(browser.toUpperCase()),
					result.getMethod().getMethodName());
			homePage = new HomePage(lambdadriver);
		} else {
			logger.info("Load the Homepage of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadLess);
		}
	}

	public BrowerUtility getInstance() {
		return homePage;
	}

//	@AfterMethod(description = "Tear down the browser")
//	public void tearDown() {
//		if (isLambdaTest) {
//			LambdaTestUtility.quitSession();
//		} // quit for lambda
//		else {
//			homePage.quit();
//		} // local
//	}
}
