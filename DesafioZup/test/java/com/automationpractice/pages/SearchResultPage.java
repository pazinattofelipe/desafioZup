package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.WebUtilitiesMethods;

public class SearchResultPage {
	private WebDriver driver;
	private String productNameChosen;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public SearchResultPage(WebDriver driver, String productNameChosen) {
		this.driver = driver;
		this.productNameChosen = productNameChosen;
	}
	
	By searchResultMessage = By.cssSelector("div.nm-not-found-message1");
	
	public void clickChosenProduct() {
		By productChosen = By.xpath("//div/h2[contains(text(),'" + productNameChosen + "')]");
		WebUtilitiesMethods.clickOnElement(driver, productChosen);
	}
	
	public String returnSearchResultMessage() {
		return WebUtilitiesMethods.returnTextElement(driver, searchResultMessage);
	}
}
