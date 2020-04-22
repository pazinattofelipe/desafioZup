package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.WebUtilitiesMethods;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By leftMenu = By.cssSelector("li.item-of-menu.left-item.item-one.js-item > a > span");
	By searchField = By.id("inpHeaderSearch");
	By searchButton = By.id("btnHeaderSearch");
	
	public void clickLeftMenu() {
		WebUtilitiesMethods.clickOnElement(driver, leftMenu);
	}
	
	public void searchProductByName(String productName) {
		WebUtilitiesMethods.fillElement(driver, searchField, productName);
		WebUtilitiesMethods.clickOnElement(driver, searchButton);
	}
}
