package com.automationpractice.utilities;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebUtilitiesMethods {
	
	public static void clickOnElement(WebDriver driver, By locator) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(locator)).click().build().perform();
			
		} catch (Exception e) {
			Assert.fail("Failed to find element. Locator '"+ locator +"'. Exception: " + e);
		}
	}
	
	public static void fillElement(WebDriver driver, By locator, String testData) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
			driver.findElement(locator).sendKeys(testData);
			
		} catch (Exception e) {
			Assert.fail("Failed to find element. Locator '"+ locator +"'. Exception: " + e);
		}
	}
	
	public static String returnTextElement(WebDriver driver, By locator) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		String elementText = null;
		
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
			elementText = driver.findElement(locator).getText();
			
		} catch (Exception e) {
			Assert.fail("Failed to find element. Locator '"+ locator +"'. Exception: " + e);
		}
		
		return elementText;
	}
	
	public static Boolean elementIsDisplayed(WebDriver driver, By locator) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		Boolean isElementDisplayed = false;
		
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
			isElementDisplayed = driver.findElement(locator).isEnabled();
			
		} catch (Exception e) {
			Assert.fail("Failed to find element. Locator '"+ locator +"'. Exception: " + e);
		}
		
		return isElementDisplayed;
	}
	
	public static int compareStringAccent(String a, String b) {
	    return StringUtils.stripAccents(a).compareTo(StringUtils.stripAccents(b));
	}

	public static List<WebElement> returnListElements(WebDriver driver, By locator) {
		List<WebElement> listOfElementsFound = null;
		
		try {
			listOfElementsFound = driver.findElements(locator);
			
		} catch (Exception e) {
			Assert.fail("Failed to find element. Locator '"+ locator +"'. Exception: " + e);
		}
		
		return listOfElementsFound;
	}
}
