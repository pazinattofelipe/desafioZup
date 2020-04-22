package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.WebUtilitiesMethods;

public class ShoppingCartPage {
	private WebDriver driver;
	private String productName;
	private String productPrice;

	public ShoppingCartPage(WebDriver driver, String productName, String productPrice) {
		this.driver = driver;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public Boolean returnProductNameDisplayingInShoppingCart() {
		By productPriceLocator = By.xpath("//a/p[contains(text(),'" + productName + "')]");
		return WebUtilitiesMethods.elementIsDisplayed(driver, productPriceLocator);
	}
	
	public Boolean returnProductPriceDisplayinginShoppingCart() {
		By productPriceLocator = By.xpath("//div[1]/div[1]/div/div[contains(text(),'" + productPrice + "')]");
		return WebUtilitiesMethods.elementIsDisplayed(driver, productPriceLocator);
	}
}
