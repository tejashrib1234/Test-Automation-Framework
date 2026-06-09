package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowerUtility;

public class SearchResultPage extends BrowerUtility {

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
	private static final By ALL_PRODUCT_LISTS_NAME = By.xpath("//h5[@itemprop=\"name\"]/a");

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	public String getSearchResultTitle() throws InterruptedException {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}

	public boolean isSearchTermPresentinProductList(String searchTerm) throws InterruptedException {
		List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNameList = getAllVisibleText(ALL_PRODUCT_LISTS_NAME);
		return productNameList.stream().allMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));

	}

	public ProductDetailPage clickOnTheProductAt(int index) throws InterruptedException {
		cilckOn(getAllElement(ALL_PRODUCT_LISTS_NAME).get(index));
		return new ProductDetailPage(getDriver());

	}

}
