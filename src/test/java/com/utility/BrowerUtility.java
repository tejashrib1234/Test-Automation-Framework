package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;
import com.ui.listeners.TestListener;

public abstract class BrowerUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(TestListener.class);

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowerUtility(WebDriver driver) {
		super();
		this.driver.set(driver);

	}

	public BrowerUtility(Browser browerName) {

		logger.info("Launching browser for" + browerName);
		if (browerName == Browser.CHROME) {

			driver.set(new ChromeDriver());

		} else if (browerName == Browser.EDGE) {

			driver.set(new EdgeDriver());
		} else if (browerName == Browser.FIREFOX) {

			driver.set(new FirefoxDriver());
		} else {
			logger.error("Invalid Browser Name....Please select Chrome or Edge Only");
			System.err.print("Invalid Browser Name....Please select Chrome or Edge Only");
		}

	}

	public BrowerUtility(Browser browerName, boolean isHeadless) {

		logger.info("Launching browser for" + browerName);

		if (browerName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}

		} else if (browerName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}

		} else if (browerName == Browser.FIREFOX) {

			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
			}

		} else {
			logger.error("Invalid Browser Name....Please select Chrome or Edge Only");
			System.err.print("Invalid Browser Name....Please select Chrome or Edge Only");
		}

	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website" + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the brower window");
		driver.get().manage().window().maximize();
	}

	public void cilckOn(By locator) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found now performing click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found now enter text" + textToEnter);
		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) throws InterruptedException {
		logger.info("Finding Element with the locator" + locator);
		Thread.sleep(2000);
		WebElement element = driver.get().findElement(locator);
		Thread.sleep(3000);
		logger.info("Element found now returning the values");
		return element.getText();
	}

	public void quit() {
		driver.get().quit();
	}

	public String takesScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);

		String path = System.getProperty("user.dir") + "//screenshots//" + name + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;
	}
}
