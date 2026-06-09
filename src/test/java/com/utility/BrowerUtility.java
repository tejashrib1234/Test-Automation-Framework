package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;
import com.ui.listeners.TestListener;

public abstract class BrowerUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(TestListener.class);
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowerUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	public BrowerUtility(Browser browerName) {

		logger.info("Launching browser for" + browerName);
		if (browerName == Browser.CHROME) {

			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		} else if (browerName == Browser.EDGE) {

			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		} else if (browerName == Browser.FIREFOX) {

			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
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
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			}

		} else if (browerName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			}

		} else if (browerName == Browser.FIREFOX) {

			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			}

		} else {
			logger.error("Invalid Browser Name....Please select Chrome or Edge Only");
			System.err.print("Invalid Browser Name....Please select Chrome or Edge Only");
		}

	}

	public void goToWebsite(String url) {
		driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		logger.info("Visiting the website" + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the brower window");
		driver.get().manage().window().maximize();
	}

	public void cilckOn(By locator) {
		logger.info("Finding Element with the locator" + locator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Element found now performing click");
		element.click();
	}

	public void cilckOn(WebElement element) {

		logger.info("Performing click on Webelement" + element);
		WebElement elementToBeClickable = wait.until(ExpectedConditions.elementToBeClickable(element));
		elementToBeClickable.click();
	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding Element with the locator" + dropDownLocator);
		WebElement dropDownElement = driver.get().findElement(dropDownLocator);
		//WebElement dropDownElement=wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownLocator));
		logger.info("Element found now selecting value from dropdown");
		Select sel = new Select(dropDownElement);
		logger.info("Element found now selecting value from dropdown" + optionToSelect);
		sel.selectByVisibleText(optionToSelect);

	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator" + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found now enter text" + textToEnter);
		element.sendKeys(textToEnter);
	}

	public void clearText(By locator) {
		logger.info("Finding Element with the locator" + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found now clearing the text");
		element.clear();
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding Element with the locator" + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found now enter text" + keyToEnter);

		element.sendKeys(keyToEnter);
	}

	public String getVisibleText(By locator) throws InterruptedException {
		logger.info("Finding Element with the locator" + locator);
		
		//WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found now returning the values");
		return element.getText();
	}

	public String getVisibleText(WebElement element) throws InterruptedException {

		logger.info("Returning the visible text" + element.getText());
		WebElement elementtToGetText=wait.until(ExpectedConditions.visibilityOf(element));
		return elementtToGetText.getText();
	}

	public void acceptingAlert() throws InterruptedException {

		Alert alt = driver.get().switchTo().alert();
		alt.accept();
	}

	public List<String> getAllVisibleText(By locator) throws InterruptedException {
		logger.info("Finding Element with the locator" + locator);

		//List<WebElement> elementList = driver.get().findElements(locator);
		List<WebElement> elementList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		logger.info("Elements found now printing the List of elements");
		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}

	public List<WebElement> getAllElement(By locator) throws InterruptedException {
		logger.info("Finding Element with the locator" + locator);

		List<WebElement> elementList = driver.get().findElements(locator);
		//List<WebElement> elementList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return elementList;
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

		String path = "./screenshots/" + name + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;
	}
}
