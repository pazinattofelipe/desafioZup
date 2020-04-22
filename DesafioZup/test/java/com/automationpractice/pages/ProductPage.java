package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.WebUtilitiesMethods;

public class ProductPage {
	private WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	By addToShoppingCartButton = By.cssSelector("div.wrapper-product__informations.js-block-product > button");

	public void clickAddToShoppingCartButton() {
		WebUtilitiesMethods.clickOnElement(driver, addToShoppingCartButton);
	}
}
